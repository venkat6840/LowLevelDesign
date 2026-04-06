package interview_questions.car_rental.entity;

import interview_questions.car_rental.enums.VehicleStatus;
import interview_questions.parking_lot.enums.VehicleType;

public class Vehicle {
  private Integer id;
  private VehicleType vehicleType;
  private VehicleStatus vehicleStatus;
  private String vehicleNumber;
  private float dailyRent;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public VehicleStatus getVehicleStatus() {
    return vehicleStatus;
  }

  public void setVehicleStatus(VehicleStatus vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public float getDailyRent() {
    return dailyRent;
  }

  public void setDailyRent(float dailyRent) {
    this.dailyRent = dailyRent;
  }
}
