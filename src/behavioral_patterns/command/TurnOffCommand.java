package behavioral_patterns.command;

public class TurnOffCommand implements ICommand {
  private final AirConditioner airConditioner;
  private boolean previousState;

  public TurnOffCommand(AirConditioner airConditioner) {
    this.airConditioner = airConditioner;
  }

  @Override
  public void execute() {
    previousState = this.airConditioner.isOn();
    this.airConditioner.turnOff();
  }

  @Override
  public void undo() {
    System.out.print("Undo: Turn Off command. ");
    if (previousState) {
      this.airConditioner.turnOn();
    }
  }
}
