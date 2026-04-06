package structural_patterns.decorator;

public abstract class ToppingDecorator implements BasePizza {
  BasePizza basePizza;

  public ToppingDecorator(BasePizza basePizza) {
    this.basePizza = basePizza;
  }
}
