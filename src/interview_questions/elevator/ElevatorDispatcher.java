package interview_questions.elevator;

import interview_questions.elevator.enums.ElevatorDirection;

public class ElevatorDispatcher {

  ElevatorScheduler elevatorScheduler;

  public ElevatorDispatcher(ElevatorScheduler elevatorScheduler) {
    this.elevatorScheduler = elevatorScheduler;
  }

  public void submitRequest(int floor, ElevatorDirection direction) {
    ElevatorController controller = this.elevatorScheduler.assignElevator(floor, direction);
    controller.submitRequest(floor);
  }
}
