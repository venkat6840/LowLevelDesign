package interview_questions.parking_lot;

import interview_questions.parking_lot.entity.ParkingSpot;
import interview_questions.parking_lot.entity.Ticket;
import interview_questions.parking_lot.entity.Vehicle;
import interview_questions.parking_lot.enums.VehicleType;
import interview_questions.parking_lot.manager.FourWheelerSpotManager;
import interview_questions.parking_lot.manager.ParkingSpotManager;
import interview_questions.parking_lot.manager.TwoWheelerSpotManager;
import interview_questions.parking_lot.parkinglot.*;
import interview_questions.parking_lot.payment.CashPayment;
import interview_questions.parking_lot.payment.UPIPayment;
import interview_questions.parking_lot.pricing.CostComputation;
import interview_questions.parking_lot.pricing.FixedPricingStrategy;
import interview_questions.parking_lot.strategy.ParkingLotStrategy;
import interview_questions.parking_lot.strategy.RandomSpotStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {

  public static void main(String[] args) {

    ParkingLotStrategy strategy = new RandomSpotStrategy();

    Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();
    levelOneManagers.put(
        VehicleType.TWO_WHEELER,
        new TwoWheelerSpotManager(
            List.of(new ParkingSpot("L1-S1"), new ParkingSpot("L1-S2")), strategy));

    levelOneManagers.put(
        VehicleType.FOUR_WHEELER,
        new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")), strategy));

    ParkingLevel level1 = new ParkingLevel(1, levelOneManagers);

    Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
    levelTwoManagers.put(
        VehicleType.TWO_WHEELER,
        new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")), strategy));

    levelTwoManagers.put(
        VehicleType.FOUR_WHEELER,
        new FourWheelerSpotManager(
            List.of(new ParkingSpot("L2-S2"), new ParkingSpot("L2-S3")), strategy));

    ParkingLevel level2 = new ParkingLevel(2, levelTwoManagers);

    ParkingBuilding parkingBuilding =
        new ParkingBuilding(
            List.of(level1, level2), new CostComputation(new FixedPricingStrategy()));

    ParkingLot parkingLot =
        new ParkingLot(
            parkingBuilding,
            new EntranceGate(),
            new ExitGate(new CostComputation(new FixedPricingStrategy())));

    Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
    Vehicle car = new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

    Ticket t1 = parkingLot.vehicleArrives(bike);
    Ticket t2 = parkingLot.vehicleArrives(car);

    parkingLot.vehicleExits(t1, new CashPayment());
    parkingLot.vehicleExits(t2, new UPIPayment());
  }
}
