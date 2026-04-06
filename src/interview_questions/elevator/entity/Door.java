package interview_questions.elevator.entity;

import interview_questions.elevator.enums.DoorState;

public class Door {
  private DoorState doorState;

  public void openDoor(int id) {
    doorState = DoorState.DOOR_OPEN;
    System.out.println("Opening the elevator door ... " + id);
  }

  public void closeDoor(int id) {
    doorState = DoorState.DOOR_CLOSED;
    System.out.println("Closing the elevator door ... " + id);
  }
}
