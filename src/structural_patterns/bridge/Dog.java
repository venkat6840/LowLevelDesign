package structural_patterns.bridge;

public class Dog extends LivingThings {
  Dog(BreathingProcess breathingProcess) {
    super(breathingProcess);
  }

  @Override
  public void breathe() {
    System.out.print("Dog: ");
    breathingProcess.breathe();
  }
}
