package structural_patterns.decorator;

public class ChickenDominator implements BasePizza {
  @Override
  public String getDescription() {
    return "It's a Chicken pizza";
  }

  @Override
  public double getCost() {
    return 400.0;
  }
}
