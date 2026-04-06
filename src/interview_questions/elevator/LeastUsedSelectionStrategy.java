package interview_questions.elevator;

import interview_questions.elevator.enums.ElevatorDirection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastUsedSelectionStrategy implements ElevatorSelectionStrategy {
  @Override
  public ElevatorController selectElevator(
      List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction) {
    ElevatorController best = null;
    int minLoad = Integer.MAX_VALUE;
    Map<ElevatorController, Integer> controllerLoads = new HashMap<>();

    for (ElevatorController controller : controllers) {
      int load = controller.upMinPQ.size() + controller.downMaxPQ.size();
      controllerLoads.put(controller, load);
    }

    ElevatorController finalSelection =
        controllerLoads.entrySet().stream()
            .min(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    return finalSelection;
  }
}
