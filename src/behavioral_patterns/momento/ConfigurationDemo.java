package behavioral_patterns.momento;

public class ConfigurationDemo {
  public static void main(String args[]) {
    ConfigurationCareTaker careTaker = new ConfigurationCareTaker();
    ConfigurationOriginator originator = new ConfigurationOriginator("Dark", 12, false, "Java");
    System.out.println("\n===> State 1: ");
    careTaker.save(originator);

    originator.setTheme("Light");
    originator.setFontSize(14);
    originator.setLanguage("Python");
    originator.setNotificationsEnabled(true);
    System.out.println("\n===> State 2: ");
    careTaker.save(originator);

    originator.setTheme("Pink");
    originator.setFontSize(18);
    originator.setLanguage("Nodejs");
    originator.setNotificationsEnabled(true);
    System.out.println("\n===> State 3: ");
    careTaker.save(originator);
    System.out.println("\n===> Undo operations ");
    careTaker.undo(originator);
    careTaker.undo(originator);
    careTaker.undo(originator);
  }
}
