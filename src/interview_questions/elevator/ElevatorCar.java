package interview_questions.elevator;

import interview_questions.elevator.entity.Door;
import interview_questions.elevator.enums.ElevatorDirection;

public class ElevatorCar {
  int id;
  int currentFloor;
  ElevatorDirection movingDirection;
  int nextFloorStoppage;
  Door door;

  public ElevatorCar(int id) {
    this.id = id;
    this.currentFloor = 0;
    this.movingDirection = ElevatorDirection.IDLE;
    this.door = new Door();
  }

  public void showDisplay() {
    System.out.println(
        "elevator:" + id + " Current floor: " + currentFloor + " going: " + movingDirection);
  }

  public void moveElevator(int destinationFloor) {
    showDisplay();
    nextFloorStoppage = destinationFloor;
    if (currentFloor == nextFloorStoppage) {
      door.openDoor(destinationFloor);
      return;
    }

    int startFloor = this.currentFloor;
    door.closeDoor(id);
    if (startFloor < nextFloorStoppage) {
      movingDirection = ElevatorDirection.UP;
      showDisplay();
      for (int i = startFloor + 1; i <= nextFloorStoppage; i++) {
        try {
          Thread.sleep(5);
        } catch (Exception e) {

        }
        setCurrentFloor(i);
        showDisplay();
      }
    } else {
      movingDirection = ElevatorDirection.DOWN;
      showDisplay();
      for (int i = startFloor - 1; i >= nextFloorStoppage; i--) {
        try {
          Thread.sleep(5);
        } catch (Exception e) {

        }
        setCurrentFloor(i);
        showDisplay();
      }
    }
    door.openDoor(id);
  }

  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }
}
