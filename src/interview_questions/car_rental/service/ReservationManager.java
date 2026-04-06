package interview_questions.car_rental.service;

import interview_questions.car_rental.entity.Reservation;
import interview_questions.car_rental.entity.User;
import interview_questions.car_rental.entity.Vehicle;
import interview_questions.car_rental.enums.ReservationStatus;
import interview_questions.car_rental.enums.ReservationType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
  private final ReservationRepository reservationRepository;
  private final VehicleInventoryManager vehicleInventoryManager;
  private final AtomicInteger reservationIdGenerator = new AtomicInteger(20000);

  public ReservationManager(VehicleInventoryManager vehicleInventoryManager) {
    this.vehicleInventoryManager = vehicleInventoryManager;
    this.reservationRepository = new ReservationRepository();
  }

  // ----------------- Get Reservation -----------------
  public Optional<Reservation> findByID(int reservationId) {
    return reservationRepository.findById(reservationId);
  }

  public List<Reservation> getReservationsByVehicleId(Integer vehicleId) {
    return reservationRepository.getAllByVehicleId(vehicleId);
  }

  // Create reservation
  public Reservation createReservation(
      int vehicleId, User user, LocalDate startDate, LocalDate endDate, ReservationType type) {
    int reservationId = reservationIdGenerator.getAndIncrement();
    boolean reserved =
        this.vehicleInventoryManager.reserveVehicle(vehicleId, reservationId, startDate, endDate);
    if (!reserved) {
      throw new RuntimeException("Vehicle not available for selected dates");
    }
    Reservation reservation =
        new Reservation(reservationId, vehicleId, user.getId(), startDate, endDate, type);
    reservationRepository.save(reservation);
    return reservation;
  }

  // ----------------- Cancel -----------------------------
  public void cancelReservation(int reservationId) {
    Reservation reservation =
        findByID(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found"));
    this.vehicleInventoryManager.release(reservation.getVehicleId(), reservationId);
    reservationRepository.remove(reservationId);
  }

  // Start the trip
  public void startTrip(int reservationId) {
    Reservation r =
        reservationRepository
            .findById(reservationId)
            .orElseThrow(() -> new RuntimeException("Reservation not found"));

    r.setReservationStatus(ReservationStatus.IN_PROGRESS);
    reservationRepository.save(r);
  }

  // ----------------- Submit Vehicle ---------------------

  public void submitVehicle(int reservationId) {
    Reservation r =
        reservationRepository
            .findById(reservationId)
            .orElseThrow(() -> new RuntimeException("Reservation not found"));
    r.setReservationStatus(ReservationStatus.COMPLETED);
    this.vehicleInventoryManager.release(r.getVehicleId(), reservationId);
  }

  // ----------------- remove reservation ---------------------
  public void remove(int reservationId) {
    reservationRepository.remove(reservationId);
  }
}
