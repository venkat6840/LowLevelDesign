package behavioral_patterns.momento;

import java.util.Stack;

public class ConfigurationCareTaker {
  private Stack<ConfigurationMemento> historyOfConfiguration = new Stack<>();

  public void save(ConfigurationOriginator configurationOriginator) {
    ConfigurationMemento configurationMemento = configurationOriginator.save();
    historyOfConfiguration.push(configurationMemento);
    System.out.println("[+] State saved. History size: " + historyOfConfiguration.size());
    System.out.println(
        historyOfConfiguration.size() == 1
            ? "[+] Default State: " + configurationMemento
            : "[+] Current State: " + configurationMemento);
  }

  public void undo(ConfigurationOriginator configurationOriginator) {
    if (historyOfConfiguration.size() > 1) {
      historyOfConfiguration.pop();
      ConfigurationMemento configurationMemento = historyOfConfiguration.peek();
      configurationOriginator.restoreConfigurationMomento(configurationMemento);
      System.out.println("[+] Undo performed. History size: " + historyOfConfiguration.size());
      System.out.println(
          historyOfConfiguration.size() == 1
              ? "[+] Default State: " + configurationMemento
              : "[+] Current State: " + configurationMemento);
    } else {
      System.out.println("[+] No more states to undo!");
      System.out.println("[+] Default State: " + historyOfConfiguration.peek());
    }
  }
}
