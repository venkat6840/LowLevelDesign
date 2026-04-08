package behavioral_patterns.mediator;

public class AuctionDemo {
  public static void main(String args[]) {
      System.out.println("\n###### Mediator Design Pattern ######");
      System.out.println("\n===> Welcome to the Auction House!\n");
      // Create a Mediator
      AuctionMediator auctionHouse = new AuctionHouse("Vintage Guitar", 100.0);

      IColleague raki = new Bidder(auctionHouse,"Rakesh");
      IColleague sudheer = new Bidder(auctionHouse,"Sudheer");
      IColleague mahi = new Bidder(auctionHouse,"Mahesh");

      raki.placeBid(200);
      sudheer.placeBid(500);
      mahi.placeBid(1000);
      raki.placeBid(1200);
      mahi.placeBid(1250);
      sudheer.placeBid(2000);

      auctionHouse.closeAuction();

  }
}
