package creational_patterns.abstract_factory;

public class EconomyCarInterior implements CarInterior {
  @Override
  public void addInteriorComponents() {
    System.out.println("Adding basic interior components for Economy Car.");
  }
}
