package behavioral_patterns.visitor;

public class MaintenanceVisitor implements IVisitor {
  @Override
  public void visit(StandardBedroom room) {
    System.out.println(
        "Housekeeping: Cleaning standard room " + room.getRoomNumber() + " (30 minutes)");
  }

  @Override
  public void visit(DeluxeRoom room) {
    System.out.println("Housekeeping: Cleaning deluxe room " +
            room.getRoomNumber() + (room.hasJacuzzi() ? " including jacuzzi" : "") +
            " (45 minutes)");
  }

  @Override
  public void visit(SuiteRoom room) {}
}
