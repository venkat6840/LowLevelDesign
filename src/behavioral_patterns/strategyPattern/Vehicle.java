package behavioral_patterns.strategyPattern;

public class Vehicle {
  DrivingStrategy drivingStrategy;

  public Vehicle(DrivingStrategy drivingStrategy) {
    this.drivingStrategy = drivingStrategy;
  }

  public void drive() {
    System.out.println("\n" + this.getClass().getSimpleName() + " : ");
    drivingStrategy.drive();
  }
}
