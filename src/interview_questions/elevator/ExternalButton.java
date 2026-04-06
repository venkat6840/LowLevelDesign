package interview_questions.elevator;

import interview_questions.elevator.enums.ElevatorDirection;

public class ExternalButton {
  ElevatorDispatcher dispatcher;

  public ExternalButton(ElevatorDispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }

  public void pressButton(int floor, ElevatorDirection direction) {
    this.dispatcher.submitRequest(floor, direction);
  }
}
