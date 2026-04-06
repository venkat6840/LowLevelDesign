package creational_patterns.abstract_factory;

public class LuxuryCarFactory implements CarFactory {
  private String brand;

  public LuxuryCarFactory(String brand) {
    this.brand = brand;
  }

  @Override
  public CarInterior createInterior() {
    return new LuxuryCarInterior();
  }

  @Override
  public CarExterior createExterior() {
    return new LuxuryCarExterior();
  }
}
