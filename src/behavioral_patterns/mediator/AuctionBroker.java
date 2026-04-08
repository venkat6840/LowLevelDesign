package behavioral_patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class AuctionBroker implements AuctionMediator {
  private final List<IColleague> bidders;
  private double currentHighestAmountBid;
  private String itemName;

  public AuctionBroker(double currentHighestAmountBid, String itemName) {
    this.currentHighestAmountBid = currentHighestAmountBid;
    this.itemName = itemName;
    bidders = new ArrayList<>();
  }

  @Override
  public void registerBidder(IColleague bidder) {}

  @Override
  public void placeBid(IColleague bidder, double amount) {}

  @Override
  public void closeAuction() {}
}
