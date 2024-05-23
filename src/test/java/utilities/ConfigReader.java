package utilities;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    // Method to load properties from config file
    public static void loadProperties() {
        prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("C:\\Users\\eeera\\eclipse-workspace\\usertestngframe\\src\\test\\resources\\properties\\config.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to get a property value by key
    public static String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }

    // Method to get an endpoint value by key
    public static String getEndpoint(String key) {
        return getProperty(key);
    }
}





