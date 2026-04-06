package interview_questions.parking_lot.manager;

import interview_questions.parking_lot.entity.ParkingSpot;
import interview_questions.parking_lot.strategy.ParkingLotStrategy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {
  public FourWheelerSpotManager(List<ParkingSpot> parkingSpots,ParkingLotStrategy strategy) {
    super(parkingSpots, strategy);
  }
}
