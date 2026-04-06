package interview_questions.parking_lot.strategy;

import interview_questions.parking_lot.entity.ParkingSpot;

import java.util.List;

public class RandomSpotStrategy implements ParkingLotStrategy {
  @Override
  public ParkingSpot selectSpot(List<ParkingSpot> spots) {
    return spots.stream().filter(ParkingSpot::isSpotFree).findFirst().orElse(null);
  }
}
