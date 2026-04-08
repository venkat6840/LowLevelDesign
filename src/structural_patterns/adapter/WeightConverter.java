package structural_patterns.adapter;

public class WeightConverter implements ImperialWeighingMachine {

  private WeightCalculator weightCalculator;

  WeightConverter(WeightCalculator weightCalculator) {
    this.weightCalculator = weightCalculator;
  }

  @Override
  public double getWeightInKgs(int value) {
    int weightInPounds = this.weightCalculator.calculateWeightInPounds(value);
    System.out.println("your exact weight is now " + Math.round(value / 2) + "Kgs");
    return Math.round(value / 2);
  }
}
