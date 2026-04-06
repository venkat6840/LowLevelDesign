package creational_patterns.factory;

public class SquareCreator extends ShapeFactory {
  @Override
  public Shape createShape() {
    return new Square();
  }
}
