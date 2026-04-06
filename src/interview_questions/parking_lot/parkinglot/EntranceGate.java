package interview_questions.parking_lot.parkinglot;

import interview_questions.parking_lot.entity.Ticket;
import interview_questions.parking_lot.entity.Vehicle;

public class EntranceGate {

  public Ticket enter(ParkingBuilding building, Vehicle vehicle) {
    return building.allocate(vehicle);
  }
}
