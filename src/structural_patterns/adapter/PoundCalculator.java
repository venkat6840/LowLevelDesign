package structural_patterns.adapter;

public class PoundCalculator implements WeightCalculator {
  @Override
  public int calculateWeightInPounds(int value) {
    System.out.println("your weight in pounds " + value);
    return value;
  }
}
