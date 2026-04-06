package interview_questions.parking_lot.manager;

import interview_questions.parking_lot.entity.ParkingSpot;
import interview_questions.parking_lot.strategy.ParkingLotStrategy;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {
  public TwoWheelerSpotManager(List<ParkingSpot> parkingSpots, ParkingLotStrategy strategy) {
    super(parkingSpots,strategy);
  }
}
