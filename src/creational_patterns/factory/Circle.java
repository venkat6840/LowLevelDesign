package creational_patterns.factory;

public class Circle implements Shape {
  @Override
  public void computeArea() {
    System.out.println("Inside circle::compute area() method");
  }

  @Override
  public void draw() {
    System.out.println("Inside circle::draw() method");
  }
}
