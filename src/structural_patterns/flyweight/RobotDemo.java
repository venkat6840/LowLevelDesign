package structural_patterns.flyweight;

public class RobotDemo {
  public static void main(String args[]) {
    System.out.println("====== Flyweight Design Pattern ======");

    IRobot humanoidRobot1 = RoboticFactory.createRobot("Humanoid");
    humanoidRobot1.display(10, 5);
    IRobot humanoidRobot2 = RoboticFactory.createRobot("Humanoid");
    humanoidRobot2.display(6, 4);

    IRobot dogBot1 = RoboticFactory.createRobot("RoboticDog");
    dogBot1.display(8, 4);
    IRobot dogBot2 = RoboticFactory.createRobot("RoboticDog");
    dogBot2.display(8, 4);

    System.out.println("Total robots created: " + RoboticFactory.getTotalRobots());
  }
}
