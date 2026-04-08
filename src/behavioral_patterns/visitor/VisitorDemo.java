package behavioral_patterns.visitor;

public class VisitorDemo {
  public static void main(String args[]) {
    System.out.println("\n###### Visitor Design Pattern Demo######");

    // Create different room types(elements) - Standard, Deluxe, Suite
    IRoom[] rooms = {
      new StandardBedroom(310),
      new DeluxeRoom(105, true),
      new SuiteRoom(201, 3),
      new StandardBedroom(102),
      new DeluxeRoom(202, false)
    };

    IVisitor roomService = new RoomServiceVisitor("food order");
    for (IRoom room : rooms) {
      room.accept(roomService);
    }

    IVisitor maintenanceService = new MaintenanceVisitor();
    rooms[0].accept(maintenanceService);
    rooms[1].accept(maintenanceService);
    rooms[2].accept(maintenanceService);

    System.out.println("\n==> Revenue Calculation");
    IVisitor pricingService = new PricingVisitor();
    rooms[1].accept(pricingService);
    rooms[2].accept(pricingService);
  }
}
