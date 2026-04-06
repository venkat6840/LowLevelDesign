package creational_patterns.factory;

public abstract class ShapeFactory {
  /*
   Simple factory method
  */
  //  public static Shape createShapeFactoryInstance(ShapeType shapeType) {
  //    if (shapeType == null) return null;
  //    return switch (shapeType) {
  //      case CIRCLE -> new Circle();
  //      case SQUARE -> new Square();
  //      case RECTANGLE -> new Rectangle();
  //      default -> throw new IllegalStateException("Shape type doesn't exist");
  //    };
  /*
   Abstract factory method
  */
  public abstract Shape createShape();
}
