package creational_patterns.abstract_factory;

public class LuxuryCarExterior implements CarExterior {
  @Override
  public void addExteriorComponents() {
    System.out.println("Adding luxurious exterior components for Luxury Car.");
  }
}
