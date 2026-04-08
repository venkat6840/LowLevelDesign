package behavioral_patterns.templateMethod;

public class TemplateDemo {
  public static void main(String args[]) {
    PaymentFlow paymentFlow = new PayToFriend();
    paymentFlow.sendMoney();

    PaymentFlow paymentFlow1 = new PayToSociety();
    paymentFlow1.sendMoney();
  }
}
