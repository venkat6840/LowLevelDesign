package structural_patterns.bridge;

public class Tree extends LivingThings {
  Tree(BreathingProcess breathingProcess) {
    super(breathingProcess);
  }

  @Override
  public void breathe() {
    System.out.print("Tree: ");
    breathingProcess.breathe();
  }
}
