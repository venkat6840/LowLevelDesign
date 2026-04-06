package behavioral_patterns.strategyPattern;

public class NormalDrive implements DrivingStrategy {
  @Override
  public void drive() {
    System.out.println("Driving capability : Normal");
  }
}
