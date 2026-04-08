package behavioral_patterns.command;

import java.util.Stack;

public class Invoker {
  ICommand iCommand;
  Stack<ICommand> commandHistory = new Stack<>();

  public void setCommand(ICommand command) {
    this.iCommand = command;
  }

  public void pressButton() {
    this.iCommand.execute();
    commandHistory.push(iCommand);
  }

  public void undo() {
    if (!commandHistory.empty()) {
      ICommand lastCommand = commandHistory.pop();
      lastCommand.undo();
    }
  }
}
