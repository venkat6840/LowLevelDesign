package interview_questions.car_rental.service;

import interview_questions.car_rental.entity.Reservation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ReservationRepository {
  // reservationId → Reservation
  private final Map<Integer, Reservation> reservations;

  public ReservationRepository() {
    this.reservations = new ConcurrentHashMap<>();
  }

  // Save or update reservation
  public void save(Reservation reservation) {
    reservations.put(reservation.getId(), reservation);
  }

  // Lookup reservation by ID
  public Optional<Reservation> findById(int reservationId) {
    return Optional.ofNullable(reservations.get(reservationId));
  }

  // Delete reservation from repository
  public void remove(int reservationId) {
    reservations.remove(reservationId);
  }

  // Return all reservations (for reporting/debug)
  public Map<Integer, Reservation> getAll() {
    return reservations;
  }

  // get reservations by Vehicle id
  public List<Reservation> getAllByVehicleId(Integer vehicleId) {
    return reservations.values().stream()
        .filter(reservation -> reservation.getVehicleId() == vehicleId)
        .collect(Collectors.toUnmodifiableList());
  }
}
