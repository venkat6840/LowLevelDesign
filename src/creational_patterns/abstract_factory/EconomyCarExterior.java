package creational_patterns.abstract_factory;

public class EconomyCarExterior implements CarExterior {
  @Override
  public void addExteriorComponents() {
    System.out.println("Adding basic exterior components for Economy Car.");
  }
}
