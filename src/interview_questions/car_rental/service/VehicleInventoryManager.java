package interview_questions.car_rental.service;

import interview_questions.car_rental.entity.Reservation;
import interview_questions.car_rental.entity.Vehicle;
import interview_questions.car_rental.enums.VehicleStatus;
import interview_questions.car_rental.enums.VehicleType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {

  private final ConcurrentMap<Integer, Vehicle> listOfVehicles = new ConcurrentHashMap<>();
  private final ConcurrentMap<Integer, List<Integer>> reservedVehicles = new ConcurrentHashMap<>();
  private final ConcurrentMap<Integer, ReentrantLock> vehicleLocks = new ConcurrentHashMap<>();
  private ReservationRepository reservationRepository;

  public void addVehicle(Vehicle vehicle) {
    listOfVehicles.put(vehicle.getId(), vehicle);
  }

  public void removeVehicle(int id) {
    listOfVehicles.remove(id);
  }

  public List<Vehicle> getAvailableVehicles(VehicleType type, LocalDate from, LocalDate to) {
    return listOfVehicles.values().stream()
        .filter(vehicle -> vehicle.getVehicleType().equals(type))
        .filter(vehicle -> isAvailable(vehicle.getId(), from, to))
        .collect(Collectors.toUnmodifiableList());
  }

  public boolean reserveVehicle(int vehicleId, int reservationId, LocalDate from, LocalDate to) {
    ReentrantLock lock = lockForVehicle(vehicleId);
    lock.lock();
    // check availability
    try {
      if (!isAvailable(vehicleId, from, to)) {
        return false;
      }
      reservedVehicles.putIfAbsent(vehicleId, List.of(reservationId));
      listOfVehicles.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
      return false;
    } finally {
      lock.unlock();
    }
  }

  private ReentrantLock lockForVehicle(int vehicleId) {
    vehicleLocks.putIfAbsent(vehicleId, new ReentrantLock());
    return vehicleLocks.get(vehicleId);
  }

  // ---------------- Availability Check ------------
  public boolean isAvailable(int vehicleId, LocalDate from, LocalDate to) {
    DateInterval requested = new DateInterval(from, to);
    // get the vehicle first
    Vehicle vehicle = listOfVehicles.get(vehicleId);
    if (vehicle == null) return false;
    if (vehicle.getVehicleStatus() == VehicleStatus.MAINTENANCE) return false;
    // get the reservations of the vehicle
    List<Reservation> reservationList = reservationRepository.getAllByVehicleId(vehicleId);

    if (reservationList.isEmpty()) {
      return true;
    }

    for (Reservation reservation : reservationList) {
      LocalDate bookedFrom = reservation.getBookingDate();
      LocalDate bookedTo = reservation.getEndDate();
      DateInterval alreadyBooked = new DateInterval(bookedFrom, bookedTo);
      if (requested.overlaps(alreadyBooked)) {
        return false;
      }
    }
    return true;
  }

  // --------------- Atomic Release -----------------

  public void release(int vehicleId, int reservationId) {
    ReentrantLock lock = lockForVehicle(vehicleId);
    lock.lock();
    try {
      // remove the reservation id from the reservation list
      reservedVehicles.entrySet().removeIf(entry -> entry.getValue().contains(reservationId));

    } finally {
      lock.unlock();
    }
  }
}
