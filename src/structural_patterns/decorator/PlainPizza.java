package structural_patterns.decorator;

public class PlainPizza implements BasePizza {
  @Override
  public String getDescription() {
    return "It's a plain pizza";
  }

  @Override
  public double getCost() {
    return 100.0;
  }
}
