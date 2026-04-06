package interview_questions.car_rental.entity;

import interview_questions.car_rental.enums.ReservationStatus;
import interview_questions.car_rental.enums.ReservationType;
import interview_questions.parking_lot.enums.VehicleType;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
  private Integer id;
  private LocalDate bookingDate;
  private LocalDate endDate;
  private LocalDate cancellationDate;
  private ReservationStatus reservationStatus;
  private ReservationType reservationType;
  private VehicleType vehicleType;
  private Integer vehicleId;
  private Integer userId;

  public Reservation(
      int reservationId,
      int vehicleId,
      int userId,
      LocalDate startDate,
      LocalDate endDate,
      ReservationType type) {
    this.vehicleId = vehicleId;
    this.reservationType = type;
    this.bookingDate = startDate;
    this.endDate = endDate;
    this.userId = userId;
    this.id = reservationId;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public ReservationStatus getReservationStatus() {
    return reservationStatus;
  }

  public void setReservationStatus(ReservationStatus reservationStatus) {
    this.reservationStatus = reservationStatus;
  }

  public ReservationType getReservationType() {
    return reservationType;
  }

  public void setReservationType(ReservationType reservationType) {
    this.reservationType = reservationType;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public Integer getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Integer vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;
  }

  public LocalDate getCancellationDate() {
    return cancellationDate;
  }

  public void setCancellationDate(LocalDate cancellationDate) {
    this.cancellationDate = cancellationDate;
  }
}
