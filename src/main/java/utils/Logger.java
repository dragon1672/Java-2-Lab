package utils;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 4/20/2015.
 */
public class Logger {

    public static class LoggerBuilder {
        final Logger logger = new Logger();

        public LoggerBuilder add(OutputStream stream) {
            logger.addOutput(stream);
            return this;
        }

        public LoggerBuilder setLevel(PrintLevel level) {
            logger.setCurrentLevel(level.Level);
            return this;
        }

        public Logger build() {
            return logger;
        }
    }

    public enum PrintLevel {
        ERROR,
        WARNING(ERROR),
        DEBUG(WARNING),
        MESSAGE(DEBUG),
        TRACE(MESSAGE),;

        public final int Level;

        PrintLevel() {
            this.Level = 0;
        }

        PrintLevel(PrintLevel previous) {
            this.Level = previous.Level + 100;
        }

    }

    private final Map<OutputStream, PrintWriter> pws = new HashMap<>();
    private int currentLevel = PrintLevel.TRACE.Level;


    public void addOutput(OutputStream out) {
        pws.put(out, new PrintWriter(out, true));
    }

    public void removeOutput(OutputStream toRemove) {
        if (pws.containsKey(toRemove)) {
            pws.remove(toRemove);
        }
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void RawLog(int level, String message, Object... args) {
        RawLog(level, String.format(message, args));
    }

    public void RawLog(int level, String message) {
        if (level > currentLevel) return;
        for (PrintWriter pw : pws.values()) {
            pw.println(level + ": " + message);
        }
    }

    public void Log(PrintLevel level, String message, Object... args) {
        RawLog(level.Level, message, args);
    }

    public void Log(PrintLevel level, String message) {
        RawLog(level.Level, message);
    }

    public void LogError(String message, Object... args) {
        Log(PrintLevel.ERROR, message, args);
    }

    public void LogError(String message) {
        Log(PrintLevel.ERROR, message);
    }

    public void LogWarning(String message, Object... args) {
        Log(PrintLevel.WARNING, message, args);
    }

    public void LogWarning(String message) {
        Log(PrintLevel.WARNING, message);
    }

    public void LogDebug(String message, Object... args) {
        Log(PrintLevel.DEBUG, message, args);
    }

    public void LogDebug(String message) {
        Log(PrintLevel.DEBUG, message);
    }

    public void LogMessage(String message, Object... args) {
        Log(PrintLevel.MESSAGE, message, args);
    }

    public void LogMessage(String message) {
        Log(PrintLevel.MESSAGE, message);
    }

    public void LogTrace(String message, Object... args) {
        Log(PrintLevel.TRACE, message, args);
    }

    public void LogTrace(String message) {
        Log(PrintLevel.TRACE, message);
    }
}
