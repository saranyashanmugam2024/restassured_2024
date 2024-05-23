package utilities;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestUtils {
    protected static ResourceBundle config;

    static {
        try {
            config = ResourceBundle.getBundle("config");
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Configuration properties could not be loaded.");
        }
    }

    public static Logger log = LogManager.getLogger();

    // Configuration properties
    public static String base_url = config.getString("base_url");
    public static String postFilePath = config.getString("post_file_path");
    public static String updateFilePath = config.getString("update_file_path");

    
     public static String get_all_users_endpoint = config.getString("get_all_users_endpoint");
     public static String create_user_endpoint = config.getString("create_user_endpoint");
    // ...

    // JSON file paths (if applicable)
    // public static String userPayloadPath = config.getString("user_payload_path");
    // public static String updatePayloadPath = config.getString("update_payload_path");
    // ...
}
