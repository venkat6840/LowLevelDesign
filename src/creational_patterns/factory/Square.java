package creational_patterns.factory;

public class Square implements Shape {
  @Override
  public void computeArea() {
    System.out.println("InsideSquare::ComputeArea() method");
  }

  @Override
  public void draw() {
    System.out.println("InsideSquare::draw() method");
  }
}
