package behavioral_patterns.chainOfResponsibilities;

public abstract class LogProcessor {
  public static int DEBUG = 1;
  public static int INFO = 2;
  public static int ERROR = 3;
  int level;
  protected LogProcessor nextLoggerProcessor;

  public void setNextLogger(LogProcessor nextLogger) {
    this.nextLoggerProcessor = nextLogger;
  }

  public void logMessage(int level, String message) {
    if (this.level <= level) {
      write(level, message);
    }
    if (this.nextLoggerProcessor != null) {
      this.nextLoggerProcessor.logMessage(level, message);
    }
  }

  public abstract void write(int level, String message);
}
