package creational_patterns.factory;

public class Rectangle implements Shape {
  @Override
  public void computeArea() {
    System.out.println("InsideRectangle::computeArea() method");
  }

  @Override
  public void draw() {
    System.out.println("InsideRectangle::draw() method");
  }
}
