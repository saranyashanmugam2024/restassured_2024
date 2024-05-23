package response;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.BaseClass;
import utilities.LoggerClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserByUserId extends Login {

    @Test
    public void testGetUserById() {
        int userId = PostResponse.userId;
        Assert.assertNotEquals(userId, 0, "User ID is not set");

        String getUserEndpoint = BaseClass.getUserEndpoint(userId);

        Response getUserResponse = RestAssured.get(getUserEndpoint)
                .then()
                .log().all() // Log response details
                .extract().response();

        System.out.println("Response Body: " + getUserResponse.getBody().asString());
        LoggerClass.logResponse("Response body ");

        // Assert the status code
        Assert.assertEquals(getUserResponse.getStatusCode(), 200, "Get user details request failed");
        LoggerClass.logError("assertion errormessage");
    }
}
