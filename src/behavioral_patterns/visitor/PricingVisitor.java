package behavioral_patterns.visitor;

public class PricingVisitor implements IVisitor {
  private double totalRevenue = 0;

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  @Override
  public void visit(StandardBedroom room) {
    double price = 1000.0;
    totalRevenue += price;
    System.out.println(
        "Pricing: Standard room " + room.getRoomNumber() + " - Rs." + price + "/night");
  }

  @Override
  public void visit(DeluxeRoom room) {
    double price = 2000.0;
    totalRevenue += price;
    System.out.println(
        "Pricing: Standard room " + room.getRoomNumber() + " - Rs." + price + "/night");
  }

  @Override
  public void visit(SuiteRoom room) {
    double price = 5000.0;
    totalRevenue += price;
    System.out.println(
        "Pricing: Standard room " + room.getRoomNumber() + " - Rs." + price + "/night");
  }
}
