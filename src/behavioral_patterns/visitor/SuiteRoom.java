package behavioral_patterns.visitor;

public class SuiteRoom implements IRoom {

  private final int roomNumber;
  private final int numberOfRooms;

  public SuiteRoom(int roomNumber, int numberOfRooms) {
    this.roomNumber = roomNumber;
    this.numberOfRooms = numberOfRooms;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
}
