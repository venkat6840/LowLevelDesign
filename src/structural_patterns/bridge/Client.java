package structural_patterns.bridge;

public class Client {
  public static void main(String args[]) {
    System.out.println("======= Bridge Design Pattern - Solution Demo ======");
    LivingThings fish = new Fish(new GillBreathing());
    fish.breathe();

    LivingThings dog = new Dog(new LungBreathing());
    dog.breathe();

    LivingThings tree = new Tree(new Photosynthesis());
    tree.breathe();
  }
}
