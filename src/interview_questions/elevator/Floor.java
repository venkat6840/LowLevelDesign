package interview_questions.elevator;

import interview_questions.elevator.enums.ElevatorDirection;

public class Floor {
  ExternalButton upButton;
  ExternalButton downButton;
  int floorNumber;

  public Floor(int floorNumber, ElevatorDispatcher dispatcher) {
    this.floorNumber = floorNumber;
    this.upButton = new ExternalButton(dispatcher);
    this.downButton = new ExternalButton(dispatcher);
  }

  public void moveUp() {
    upButton.pressButton(floorNumber, ElevatorDirection.UP);
  }

  public void moveDown() {
    downButton.pressButton(floorNumber, ElevatorDirection.DOWN);
  }
}
