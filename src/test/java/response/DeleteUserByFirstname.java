/*package response;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utilities.BaseClass;
import utilities.LoggerClass;

import static io.restassured.RestAssured.given;

public class DeleteUserByFirstname {

    @Test
    public void testDeleteUser() {
        Assert.assertNotEquals(PostResponse.userId, 0, "User ID is not set");

        String deleteUserEndpoint = BaseClass.deleteUserEndpoint(PostResponse.userId);

        // Perform DELETE request to delete the user
        Response deleteUserResponse = 
            given()
                .when()
                .delete(deleteUserEndpoint)
                .then()
                .log().all()  // Log the request and response details
                .statusCode(200)  // Assert the status code
                .extract().response();

        // Log the response body
        String responseBody = deleteUserResponse.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        LoggerClass.logResponse(responseBody);

        // Assert the response body contains the success message
        Assert.assertTrue(responseBody.contains("User deleted successfully"), "Success message not found in response");

        // Verify the user no longer exists by attempting to get the user
        Response getUserResponse = 
            given()
                .when()
                .get("/users/" + PostResponse.userId)
                .then()
                .log().all()  // Log the request and response details
                .statusCode(404)  // Assert the status code
                .extract().response();

        LoggerClass.logError("User no longer exists after deletion");
    }
}


*/
