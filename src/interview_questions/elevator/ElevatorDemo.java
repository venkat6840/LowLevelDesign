package interview_questions.elevator;

import interview_questions.elevator.entity.Building;

import java.util.List;

public class ElevatorDemo {
  public static void main(String args[]) throws InterruptedException {

    ElevatorCar elevatorCar1 = new ElevatorCar(1);
    ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);

    ElevatorCar elevatorCar2 = new ElevatorCar(2);
    ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);

    InternalButton internalButton1 = new InternalButton(elevatorController1);
    InternalButton internalButton2 = new InternalButton(elevatorController2);

    ElevatorScheduler scheduler =
        new ElevatorScheduler(
            List.of(elevatorController1, elevatorController2), new NearestSelectionStrategy());

    ElevatorDispatcher externalDispatcher = new ElevatorDispatcher(scheduler);

    Building building = new Building(5, externalDispatcher);

    // 6. Start both the elevator controllers threads
    new Thread(elevatorController1, "Elevator-1").start();
    new Thread(elevatorController2, "Elevator-2").start();

    ///
    building.getFloor(3).moveUp();
    Thread.sleep(5);

    building.getFloor(5).moveDown();
    Thread.sleep(5);

    internalButton1.pressButton(4);
    Thread.sleep(5);

    internalButton2.pressButton(5);
    Thread.sleep(5);

    building.getFloor(1).moveDown();
    Thread.sleep(5);

    building.getFloor(2).moveUp();
    Thread.sleep(5);

    internalButton1.pressButton(2);
  }
}
