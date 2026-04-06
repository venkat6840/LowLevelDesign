package interview_questions.elevator;

import interview_questions.elevator.enums.ElevatorDirection;

import java.util.List;

public class NearestSelectionStrategy implements ElevatorSelectionStrategy {
  @Override
  public ElevatorController selectElevator(
      List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction) {
    ElevatorController best = null;
    int minDistance = Integer.MAX_VALUE;

    for (ElevatorController controller : controllers) {
      int nextFloorStoppage = controller.elevatorCar.nextFloorStoppage;
      boolean isSameDirectionBestCandidate =
          controller.elevatorCar.movingDirection == direction
              && ((controller.elevatorCar.movingDirection == direction.UP
                      && nextFloorStoppage <= requestFloor)
                  || (controller.elevatorCar.movingDirection == direction.DOWN
                      && nextFloorStoppage >= requestFloor));
      int dist = Math.abs(nextFloorStoppage - requestFloor);

      if (isSameDirectionBestCandidate && dist < minDistance) {
        minDistance = dist;
        best = controller;
      }
    }

    // if not able to choose pick the idle one
    if (best == null) {
      for (ElevatorController controller : controllers) {
        if (controller.elevatorCar.movingDirection == ElevatorDirection.IDLE) {
          minDistance = requestFloor;
          best = controller;
          break;
        }
      }
    }
    if (best == null) {
      best = controllers.get(0);
    }
    return best;
  }
}
