package behavioral_patterns.visitor;

public class StandardBedroom implements IRoom {

  private final int roomNumber;

  public StandardBedroom(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
}
