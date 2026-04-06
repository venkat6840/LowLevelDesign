package structural_patterns.decorator;

public class PizzaMain {
  public static void main(String args[]) {
    // plain pizza
    BasePizza pizza = new PlainPizza();
    System.out.println(pizza.getDescription() + " " + pizza.getCost());

    //Tandoori paneer
    BasePizza tandooriPaneer = new TandooriPaneer();
    System.out.println();

    // Pepperoni topping
    BasePizza pepperoniTop = new PepperoniTopping(new ExtraCheeseTopping(new TandooriPaneer()));
    System.out.println(pepperoniTop.getDescription() + " " + pepperoniTop.getCost());
  }
}
