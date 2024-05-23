package response;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utilities.BaseClass;

import payload.Postpayload;
import utilities.LoggerClass;

import static io.restassured.RestAssured.given;

public class UpdateUser  {
    

    @Test
    public void testUpdateUser() {
        int userId = PostResponse.userId;
        Assert.assertNotEquals(userId, 0, "User ID is not set");

        String updateUser = BaseClass.updateUserEndpoint(userId);
        String requestBody = Postpayload.updatePayload();

        Response updateUserResponse = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .put(updateUser)
            .then()
                .statusCode(200)
                .log().all() // Log response details
                .extract().response();


        Assert.assertEquals(updateUserResponse.jsonPath().getString("user_first_name"), "saranya");
        Assert.assertEquals(updateUserResponse.jsonPath().getString("user_last_name"), "kumar");
        Assert.assertEquals(updateUserResponse.jsonPath().getString("user_contact_number"), "6478645661");
        Assert.assertEquals(updateUserResponse.jsonPath().getString("user_email_id"), "sar.kumar@example.com");
        Assert.assertEquals(updateUserResponse.jsonPath().getString("userAddress.plotNumber"), "14-B");

        // Additional assertions for userAddress fields
        Assert.assertEquals(updateUserResponse.jsonPath().getString("userAddress.Street"), null);
        Assert.assertEquals(updateUserResponse.jsonPath().getString("userAddress.state"), "illinois");
        Assert.assertEquals(updateUserResponse.jsonPath().getString("userAddress.Country"), null);
        Assert.assertEquals(updateUserResponse.jsonPath().getString("userAddress.zipCode"), "621704");
    }
}
