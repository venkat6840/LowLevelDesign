package behavioral_patterns.command;

public class SetTemperatureCommand implements ICommand {
  private final AirConditioner airConditioner;
  private final int newTemperature;
  private int previousTemperature;

  public SetTemperatureCommand(AirConditioner airConditioner, int newTemperature) {
    this.airConditioner = airConditioner;
    this.newTemperature = newTemperature;
  }

  @Override
  public void execute() {
    previousTemperature = airConditioner.getTemperature();
    this.airConditioner.setTemperature(this.newTemperature);
  }

  @Override
  public void undo() {
    System.out.print("Undo: Set Temperature Command. ");
    this.airConditioner.setTemperature(previousTemperature);
  }
}
