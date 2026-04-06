package creational_patterns.abstract_factory;

public class EconomyCarFactory implements CarFactory {
  private String brand;

  public EconomyCarFactory(String brand) {
    this.brand = brand;
  }

  @Override
  public CarInterior createInterior() {
    return new EconomyCarInterior();
  }

  @Override
  public CarExterior createExterior() {
    return new EconomyCarExterior();
  }
}
