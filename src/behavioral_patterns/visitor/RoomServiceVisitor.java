package behavioral_patterns.visitor;

public class RoomServiceVisitor implements IVisitor {
  private final String orderDetails;

  public RoomServiceVisitor(String orderDetails) {
    this.orderDetails = orderDetails;
  }

  @Override
  public void visit(StandardBedroom room) {
    System.out.println(
        "Room Service: Delivering " + orderDetails + "to standard room " + room.getRoomNumber());
  }

  @Override
  public void visit(DeluxeRoom room) {
    System.out.println(
        "Room Service: Premium delivery of "
            + orderDetails
            + " to deluxe room "
            + room.getRoomNumber()
            + " with complimentary champagne");
  }

  @Override
  public void visit(SuiteRoom room) {
    System.out.println(
        "Room Service: VIP delivery of "
            + orderDetails
            + " to suite "
            + room.getRoomNumber()
            + " with full dining setup");
  }
}
