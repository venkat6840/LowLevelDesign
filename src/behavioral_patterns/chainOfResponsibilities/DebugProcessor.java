package behavioral_patterns.chainOfResponsibilities;

public class DebugProcessor extends LogProcessor {
  public DebugProcessor(int level) {
    this.level = level;
  }

  @Override
  public void write(int level, String message) {
    if (level == DEBUG) System.out.println("DEBUG:" + message);
    else nextLoggerProcessor.write(level, message);
  }
}
