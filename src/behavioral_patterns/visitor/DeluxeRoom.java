package behavioral_patterns.visitor;

public class DeluxeRoom implements IRoom {

  private final int roomNumber;
  private final boolean hasJacuzzi;

  public DeluxeRoom(int roomNumber, boolean hasJacuzzi) {
    this.roomNumber = roomNumber;
    this.hasJacuzzi = hasJacuzzi;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }

  public boolean hasJacuzzi() {
    return hasJacuzzi;
    }
}
