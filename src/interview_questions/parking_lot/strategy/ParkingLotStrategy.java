package interview_questions.parking_lot.strategy;

import interview_questions.parking_lot.entity.ParkingSpot;

import java.util.List;

public interface ParkingLotStrategy {
  ParkingSpot selectSpot(List<ParkingSpot> spots);
}
