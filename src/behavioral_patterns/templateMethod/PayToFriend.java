package behavioral_patterns.templateMethod;

public class PayToFriend extends PaymentFlow {
  @Override
  public void validateRequest() {
    System.out.println("Validated request to send money to friend");
  }

  @Override
  public void debitAmount() {
    System.out.println("Debited amount from my pocket");
  }

  @Override
  public void calculateFees() {
    System.out.println("Calculated fees based on the debit amount ");
  }

  @Override
  public void creditAmount() {
    System.out.println("Credited to my friend account");
  }
}
