package structural_patterns.decorator;

public class FarmHouse implements BasePizza {
  @Override
  public String getDescription() {
    return "It's a Farm house pizza";
  }

  @Override
  public double getCost() {
    return 250.0;
  }
}
