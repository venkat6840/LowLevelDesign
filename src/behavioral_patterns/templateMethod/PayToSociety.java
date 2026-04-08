package behavioral_patterns.templateMethod;

public class PayToSociety extends PaymentFlow {
  @Override
  public void validateRequest() {
    System.out.println("Validated request to send money to society");
  }

  @Override
  public void debitAmount() {
    System.out.println("Debited amount from my pocket to society");
  }

  @Override
  public void calculateFees() {
    System.out.println("Calculated fees based on the debit amount to send to society ");
  }

  @Override
  public void creditAmount() {
    System.out.println("Credited to society account");
  }
}
