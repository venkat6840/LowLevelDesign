package interview_questions.elevator;

import interview_questions.elevator.enums.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {

  ElevatorController selectElevator(
      List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction);
}
