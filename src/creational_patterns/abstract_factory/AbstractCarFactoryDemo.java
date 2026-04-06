package creational_patterns.abstract_factory;

public class AbstractCarFactoryDemo {
  public static void main(String args[]) {
    System.out.println("=====Abstract Factory Design Pattern=====");

    CarFactoryProvider carFactoryProvider = new CarFactoryProvider();

    CarFactory economyCarFactory = carFactoryProvider.getFactory(CarType.ECONOMY, "Maruthi");
    economyCarFactory.produceCompleteVehicle();

    CarFactory luxuryCarFactory = carFactoryProvider.getFactory(CarType.LUXURY, "Audi");
    luxuryCarFactory.produceCompleteVehicle();
  }
}
