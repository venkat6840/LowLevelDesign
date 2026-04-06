package behavioral_patterns.chainOfResponsibilities;

public class ErrorProcessor extends LogProcessor {
  public ErrorProcessor(int level) {
    this.level = level;
  }

  @Override
  public void write(int level, String message) {
    if (level == ERROR) System.out.println("ERROR:" + message);
    else nextLoggerProcessor.write(level, message);
  }
}
