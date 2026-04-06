package structural_patterns.decorator;

public class TandooriPaneer implements BasePizza {
  @Override
  public String getDescription() {
    return "It's a Tandoori paneer pizza";
  }

  @Override
  public double getCost() {
    return 300.0;
  }
}
