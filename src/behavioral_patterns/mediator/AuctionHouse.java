package behavioral_patterns.mediator;

import java.util.ArrayList;
import java.util.Collection;

public class AuctionHouse implements AuctionMediator {
  private Collection<IColleague> biddersList;
  private String itemName;
  private double currentHighestBid;
  private IColleague currentHighestBidder;

  AuctionHouse(String name, double startingPrice) {
    this.itemName = name;
    this.currentHighestBid = startingPrice;
    this.biddersList = new ArrayList<>();
    System.out.println(
        "[+] Auction House created for item: "
            + itemName
            + " with initial bid of $"
            + startingPrice);
  }

  @Override
  public void registerBidder(IColleague bidder) {
    biddersList.add(bidder);
    System.out.println("[+] " + bidder.getName() + " has joined the auction for " + itemName);
  }

  @Override
  public void placeBid(IColleague bidder, double amount) {
    // Check if the bid is valid
    if (amount <= currentHighestBid) {
      System.out.println(
          bidder.getName()
              + " bid of $"
              + amount
              + " is too low. Current highest bid is $"
              + currentHighestBid);
      return;
    }
    currentHighestBid = amount;
    currentHighestBidder = bidder;
    System.out.println(
        "\n===> [New Bid Accepted]"
            + " Info: {Bidder: "
            + bidder.getName()
            + ", Bid Amount: "
            + amount
            + "}");
    for (IColleague colleague : biddersList) {
      if (!colleague.getName().equalsIgnoreCase(bidder.getName())) {
        colleague.receiveBidNotification(amount);
      }
    }
  }

  @Override
  public void closeAuction() {
    if (currentHighestBidder != null) {
      System.out.println("\n===> [AUCTION UPDATE]");
      System.out.println(
          "[+] Auction closed! Winner is "
              + currentHighestBidder.getName()
              + " with a bid of $"
              + currentHighestBid
              + " for "
              + itemName);
    } else {
      System.out.println("Auction closed with no bids.");
    }
  }
}
