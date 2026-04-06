package structural_patterns.decorator;

public class ExtraCheeseTopping extends ToppingDecorator {
  public ExtraCheeseTopping(BasePizza basePizza) {
    super(basePizza);
  }

  @Override
  public String getDescription() {
    return basePizza.getDescription() + " " + " + Extra cheeze";
  }

  @Override
  public double getCost() {
    return basePizza.getCost() + 20.0;
  }
}
