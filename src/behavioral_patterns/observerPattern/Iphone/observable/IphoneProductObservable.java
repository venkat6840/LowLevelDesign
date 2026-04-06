package behavioral_patterns.observerPattern.Iphone.observable;

import behavioral_patterns.observerPattern.Iphone.observer.StockNotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneProductObservable implements StockAvailabilityObservable {
  private final String productId;
  private final String productName;
  private final double price;
  private final List<StockNotificationObserver> stockObservers;
  private int stockQuantity;

  public IphoneProductObservable(
      String productId, String productName, double price, int stockQuantity) {
    this.productId = productId;
    this.productName = productName;
    this.price = price;
    this.stockObservers = new ArrayList<>();
    this.stockQuantity = stockQuantity;
  }

  @Override
  public void addStockObserver(StockNotificationObserver observer) {
    this.stockObservers.add(observer);
    System.out.println(
        "[+]" + observer.userId() + " subscribed for notifications on " + productName);
  }

  @Override
  public void removeStockObserver(StockNotificationObserver observer) {
    this.stockObservers.remove(observer);
    System.out.println("[-]" + observer.userId() + " removed from notifications " + productName);
  }

  @Override
  public void notifyStockObservers() {
    if (this.stockQuantity > 0 && !this.stockObservers.isEmpty()) {
      System.out.println("Notifying " + stockObservers.size() + " subscribers... ");
      List<StockNotificationObserver> observersToNotify = new ArrayList<>(stockObservers);

      for (StockNotificationObserver observer : observersToNotify) {
        observer.update();
      }
    }
  }

  @Override
  public boolean purchase(int quantity) {
    if (stockQuantity >= quantity) {
      stockQuantity -= quantity;
      System.out.println(
          "PURCHASE SUCCESS: "
              + quantity
              + " units of "
              + productName
              + " | "
              + "Remaining stock: "
              + stockQuantity);
      return true;
    } else {
      System.out.println(
          "PURCHASE FAILED: "
              + productName
              + " is out of stock! | "
              + "Available Quantity: "
              + stockQuantity);
      return false;
    }
  }

  public String getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public double getPrice() {
    return price;
  }

  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

  @Override
  public void restock(int quantity) {
    boolean wasOutOfStock = (stockQuantity == 0);
    stockQuantity += quantity;
    System.out.println(
        "RESTOCKED: "
            + productName
            + " - Added "
            + quantity
            + " items "
            + " | "
            + "Current stock: "
            + stockQuantity);
    // Only notify if product was previously out of stock
    if (wasOutOfStock && stockQuantity > 0) {
      notifyStockObservers();
    }
  }
}
