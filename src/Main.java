import behavioral_patterns.strategyPattern.*;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    //Strategy Design Pattern(Behavioral pattern)
    System.out.println("Strategy Design Pattern");
    Vehicle vehicle = new GoodsVehicle(new SportsDrive());
    vehicle.drive();
    vehicle = new OffroadVehicle(new NormalDrive());
    vehicle.drive();

    //Observer Design Pattern(Behavioral pattern)
  }
}
