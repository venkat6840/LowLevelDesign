package behavioral_patterns.strategyPattern;

public class SportsDrive implements DrivingStrategy {
  @Override
  public void drive() {
    System.out.println("Driving capability : Sports");
  }
}
