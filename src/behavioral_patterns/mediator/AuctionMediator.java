package behavioral_patterns.mediator;

public interface AuctionMediator {

  void registerBidder(IColleague bidder);

  void placeBid(IColleague bidder, double amount);

  void closeAuction();
}
