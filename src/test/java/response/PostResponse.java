package response;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseClass;
import payload.Postpayload;
import utilities.LoggerClass;

import static io.restassured.RestAssured.given;

public class PostResponse extends Login {
    public static int userId;
    public static String userfirstname;
    public static String userlastname;

    @Test
    public void testCreateUser() {
        String createUserEndpoint = BaseClass.createUserEndpoint();
        String requestBody = Postpayload.getUserPayload();

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .post(createUserEndpoint)
            .then()
                .statusCode(201)
                .log().all() // Log response details
                .extract().response();

        // Extract user details from the response
        userId = response.jsonPath().getInt("user_id");
        userfirstname = response.jsonPath().getString("user_first_name");
        userlastname = response.jsonPath().getString("user_last_name");

        // Log user details
        System.out.println("user_id: " + userId + ".");
        System.out.println("user_first_name: " + userfirstname + ".");
        System.out.println("user_last_name: " + userlastname + ".");

      
    

        // Validate response fields
        Assert.assertNotNull(response.jsonPath().getString("user_id"));
        Assert.assertEquals(response.jsonPath().getString("user_first_name"), "sara");
        Assert.assertEquals(response.jsonPath().getString("user_last_name"), "kumar");
        Assert.assertEquals(response.jsonPath().getLong("user_contact_number"), 6478645661L);
        Assert.assertEquals(response.jsonPath().getString("user_email_id"), "sar.kumar@example.com");
        Assert.assertEquals(response.jsonPath().getString("userAddress.plotNumber"), "14-B");
        Assert.assertEquals(response.jsonPath().getString("userAddress.state"), "illinois");
        Assert.assertEquals(response.jsonPath().getInt("userAddress.zipCode"), 621704);
        Assert.assertNotNull(response.jsonPath().getString("creation_time"));
        Assert.assertNotNull(response.jsonPath().getString("last_mod_time"));
     
       
}
}