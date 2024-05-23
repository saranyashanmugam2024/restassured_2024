package utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {
    private static final Logger logger = LogManager.getLogger(LoggerClass.class);

    public static void logResponse(String response) {
        logger.info("Response Body: {}", response);
    }

    public static void logRequest(String requestBody) {
        logger.info("Request Body: {}", requestBody);
    }
    public static void logError(String errorMessage) {
        logger.error("Error: {}", errorMessage);
    }
    public static void logInfo(String infoMessage) {
        logger.info("Info: {}", infoMessage);
    }
    public static void logDebug(String debugMessage) {
        logger.debug("Debug: {}", debugMessage);
    }
    public static void logEnvironment(String environmentInfo) {
        logger.info("Environment: {}", environmentInfo);
    }
    public static void logPerformance(String performanceMetric) {
        logger.info("Performance: {}", performanceMetric);
    }

}




