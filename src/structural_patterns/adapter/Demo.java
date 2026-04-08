package structural_patterns.adapter;

public class Demo {
  public static void main(String args[]) {
    WeightCalculator weightCalculator = new PoundCalculator();
    //int weight = weightCalculator.calculateWeightInPounds(30);

    ImperialWeighingMachine imperialWeighingMachine = new WeightConverter(weightCalculator);
    imperialWeighingMachine.getWeightInKgs(30);
  }
}
