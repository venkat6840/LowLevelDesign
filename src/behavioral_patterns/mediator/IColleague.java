package behavioral_patterns.mediator;

public interface IColleague {
  void placeBid(double amount);

  void receiveBidNotification(double bidAmount);

  String getName();
}
