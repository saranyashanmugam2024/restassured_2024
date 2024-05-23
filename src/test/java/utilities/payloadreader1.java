package utilities;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class payloadreader1 {

    @DataProvider(name = "userData")
    public static Object[][] getUserData() {
        // Specify the path to your JSON file containing user data
        String filePath = "path/to/userdata.json";

        // Read JSON data from file
        String jsonData = getPayloadFromJson(filePath);

        // Convert JSON data to an array of user objects
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonData);
            int size = jsonNode.size();
            Object[][] userData = new Object[size][1]; // 1 column for each user object
            for (int i = 0; i < size; i++) {
                userData[i][0] = jsonNode.get(i); // Each row contains a user object
            }
            return userData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getPayloadFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            return jsonNode.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
