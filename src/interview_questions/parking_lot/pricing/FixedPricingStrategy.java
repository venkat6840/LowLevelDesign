package interview_questions.parking_lot.pricing;

import interview_questions.parking_lot.entity.Ticket;

public class FixedPricingStrategy implements PricingStrategy {
  @Override
  public double calculate(Ticket ticket) {
    return 100;
  }
}
