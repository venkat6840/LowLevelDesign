package interview_questions.elevator;

public class InternalButton {
  private final ElevatorController controller;

  public InternalButton(ElevatorController controller) {
    this.controller = controller;
  }

  public void pressButton(int floor) {
    this.controller.submitRequest(floor);
  }
}
