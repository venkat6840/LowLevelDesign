package behavioral_patterns.strategyPattern;

public class OffroadVehicle extends Vehicle {
  public OffroadVehicle(DrivingStrategy drivingStrategy) {
    super(drivingStrategy);
  }
}
