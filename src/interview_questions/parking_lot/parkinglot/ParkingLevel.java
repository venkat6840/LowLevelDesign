package interview_questions.parking_lot.parkinglot;

import interview_questions.parking_lot.entity.ParkingSpot;
import interview_questions.parking_lot.enums.VehicleType;
import interview_questions.parking_lot.manager.ParkingSpotManager;

import java.util.Map;

public class ParkingLevel {
  private final int level;
  private final Map<VehicleType, ParkingSpotManager> managers;

  public ParkingLevel(int level, Map<VehicleType, ParkingSpotManager> managers) {
    this.level = level;
    this.managers = managers;
  }

  public int getLevel() {
    return level;
  }

  public boolean hasAvailability(VehicleType type) {
    ParkingSpotManager manager = managers.get(type);
    return manager != null && manager.hasFreeSpot();
  }

  public ParkingSpot park(VehicleType type) {
    ParkingSpotManager manager = managers.get(type);
    if (manager == null) {
      throw new IllegalArgumentException("No parking manager for vehicle type" + type);
    }
    return manager.park();
  }

  public void unPark(VehicleType type, ParkingSpot spot) {
    ParkingSpotManager manager = managers.get(type);
    if (manager == null) {
      throw new IllegalArgumentException("No parking manager for vehicle type" + type);
    }
    manager.unpark(spot);
  }
}
