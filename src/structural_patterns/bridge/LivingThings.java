package structural_patterns.bridge;

public abstract class LivingThings {
  BreathingProcess breathingProcess;

  LivingThings(BreathingProcess breathingProcess) {
    this.breathingProcess = breathingProcess;
  }

  public abstract void breathe();
}
