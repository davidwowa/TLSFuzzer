package util;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

    public static Logger getLogger(String className) {

        Date date = new Date();

        Logger logger = Logger.getLogger(className);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(consoleHandler);
        try {
            FileHandler fileHandler = new FileHandler(className + ".TLSFuzzer_" + date.toString() + ".log", 1024 * 1024,
                    5, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred in setting up the logger", e);
            e.printStackTrace();
        }

        logger.setLevel(Level.ALL);

        logger.setUseParentHandlers(false);

        return logger;
    }
}