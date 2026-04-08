package behavioral_patterns.command;

public class TurnOnCommand implements ICommand {
  private final AirConditioner airConditioner;
  private boolean previousState;

  public TurnOnCommand(AirConditioner airConditioner) {
    this.airConditioner = airConditioner;
  }

  @Override
  public void execute() {
    previousState = this.airConditioner.isOn();
    this.airConditioner.turnOn();
  }

  @Override
  public void undo() {
    System.out.print("Undo: Turn On command. ");
    if (!previousState) {
      this.airConditioner.turnOff();
    }
  }
}
