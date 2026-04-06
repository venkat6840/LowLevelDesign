package creational_patterns.factory;

public class ShapeFactoryDemo {
  public static void main(String args[]) {
    // Simple factory
    // Shape shape = ShapeFactory.createShapeFactoryInstance(ShapeType.SQUARE);

    // Abstract factory
    Shape shape = getShapeInstances(ShapeType.SQUARE);
    shape.computeArea();
    shape.draw();
  }

  private static Shape getShapeInstances(ShapeType shapeType) {
    Shape shape = null;
    if (shapeType == null) return null;
    switch (shapeType) {
      case CIRCLE:
        ShapeFactory circleCreator = new CircleCreator();
        shape = circleCreator.createShape();
        break;
      case SQUARE:
        ShapeFactory squareCreator = new SquareCreator();
        shape = squareCreator.createShape();
        break;
      default:
        throw new IllegalStateException("ShapeType doesn't exist");
    }
    return shape;
  }
}
