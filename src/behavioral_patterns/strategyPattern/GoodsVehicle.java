package behavioral_patterns.strategyPattern;

public class GoodsVehicle extends Vehicle {

  public GoodsVehicle(DrivingStrategy drivingStrategy) {
    super(drivingStrategy);
  }
}
