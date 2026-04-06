package interview_questions.parking_lot.manager;

import interview_questions.parking_lot.entity.ParkingSpot;
import interview_questions.parking_lot.strategy.ParkingLotStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {
  private final ReentrantLock lock = new ReentrantLock(true);
  protected final ParkingLotStrategy strategy;
  protected final List<ParkingSpot> parkingSpots;

  protected ParkingSpotManager( List<ParkingSpot> parkingSpots,ParkingLotStrategy strategy) {
    this.strategy = strategy;
    this.parkingSpots = parkingSpots;
  }

  public ParkingSpot park() {
    lock.lock();
    try {
      ParkingSpot spot = strategy.selectSpot(parkingSpots);
      if (spot == null) {
        return null;
      }
      spot.occupySpot();
      return spot;
    } finally {
      lock.unlock();
    }
  }

  public void unpark(ParkingSpot spot) {
    lock.lock();
    try {
      spot.releaseSpot();
    } finally {
      lock.unlock();
    }
  }

  public boolean hasFreeSpot() {
    lock.lock();
    try {
      return parkingSpots.stream().anyMatch(ParkingSpot::isSpotFree);
    } finally {
      lock.unlock();
    }
  }
}
