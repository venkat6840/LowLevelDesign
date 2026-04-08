package behavioral_patterns.templateMethod;

public abstract class PaymentFlow {

  public abstract void validateRequest();

  public abstract void debitAmount();

  public abstract void calculateFees();

  public abstract void creditAmount();

  public final void sendMoney() {
    validateRequest();
    debitAmount();
    calculateFees();
    creditAmount();
  }
}
