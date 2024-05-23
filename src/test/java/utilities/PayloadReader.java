
package utilities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class PayloadReader {

    public static String getPayloadFromJson(String filePath) {
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





