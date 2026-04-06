package interview_questions.elevator.entity;

import interview_questions.elevator.ElevatorDispatcher;
import interview_questions.elevator.Floor;

import java.util.ArrayList;
import java.util.List;

public class Building {
  List<Floor> floors = new ArrayList<>();

  public Building(int totalFloors, ElevatorDispatcher dispatcher) {
    for (int i = 1; i <= totalFloors; i++) {
      floors.add(new Floor(i, dispatcher));
    }
  }

  public Floor getFloor(int floor) {
    return floors.get(floor - 1);
  }
}
