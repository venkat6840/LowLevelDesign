package behavioral_patterns.observerPattern.Iphone.observer;

public interface StockNotificationObserver {
  void update();

  String getNotificationMethod();

  String userId();
}
