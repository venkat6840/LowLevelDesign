package interview_questions.parking_lot.pricing;

import interview_questions.parking_lot.entity.Ticket;

public class CostComputation {

  private final PricingStrategy pricingStrategy;

  public CostComputation(PricingStrategy pricingStrategy) {
    this.pricingStrategy = pricingStrategy;
  }

  public double compute(Ticket ticket) {
    return pricingStrategy.calculate(ticket);
  }
}
