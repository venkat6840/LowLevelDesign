package interview_questions.parking_lot.pricing;

import interview_questions.parking_lot.entity.Ticket;

public interface PricingStrategy {
    double calculate(Ticket ticket);
}
