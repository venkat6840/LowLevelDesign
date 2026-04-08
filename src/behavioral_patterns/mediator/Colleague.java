package behavioral_patterns.mediator;

public class Colleague implements IColleague {

  AuctionMediator auctionMediator;
  String name;

  Colleague(AuctionMediator auctionMediator, String name) {
    this.auctionMediator = auctionMediator;
    this.name = name;
    auctionMediator.registerBidder(this);
  }

  @Override
  public void placeBid(double amount) {
    System.out.println("\n===> [Placing Bid] " + name + " is attempting to bid $" + amount);
    this.auctionMediator.placeBid(this, amount);
  }

  @Override
  public void receiveBidNotification(double bidAmount) {
    System.out.println(
        "[+] Bidder " + name + " has received a new bid notification of: " + bidAmount);
  }

  @Override
  public String getName() {
    return name;
  }
}
