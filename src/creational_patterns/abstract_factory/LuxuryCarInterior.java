package creational_patterns.abstract_factory;

public class LuxuryCarInterior implements CarInterior {
  @Override
  public void addInteriorComponents() {
    System.out.println("Adding luxurious interior components for Luxury Car.");
  }
}
