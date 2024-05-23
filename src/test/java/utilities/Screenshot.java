/*package utilities;



import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.FileWriter;
import java.io.IOException;



public class Screenshot extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        Response response = null;
        
        if (testClass instanceof YourTestClass1) {
            response = ((YourTestClass1) testClass).getResponse();
        } else if (testClass instanceof YourTestClass2) {
            response = ((YourTestClass2) testClass).getResponse();
        }
        // Add more conditions for other test classes if needed

        if (response != null) {
            String responseBody = response.getBody().asString();
            String fileName = result.getName() + "_failure_response.txt";
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(responseBody);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

*/
