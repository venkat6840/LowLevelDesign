package behavioral_patterns.chainOfResponsibilities;

public class InfoProcessor extends LogProcessor {
  public InfoProcessor(int level) {
    this.level = level;
  }

  @Override
  public void write(int level, String message) {
    if (level == INFO) System.out.println("INFO:" + message);
    else nextLoggerProcessor.write(level, message);
  }
}
