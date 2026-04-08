package structural_patterns.bridge;

public class Fish extends LivingThings {

  Fish(BreathingProcess breathingProcess) {
    super(breathingProcess);
  }

  @Override
  public void breathe() {
    System.out.print("Fish: ");
    breathingProcess.breathe();
  }
}
