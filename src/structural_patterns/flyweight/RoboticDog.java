package structural_patterns.flyweight;

public class RoboticDog implements IRobot {

  private final String type;
  private final Sprites sprites;

  public RoboticDog(String type, Sprites sprites) {
    this.type = type;
    this.sprites = sprites;
  }

  public String getType() {
    return type;
  }

  public Sprites getSprites() {
    return sprites;
  }

  @Override
  public void display(int xCoordinate, int yCoordinate) {
    System.out.println("Displaying " + type + " at " + xCoordinate + ", " + yCoordinate);
  }
}
