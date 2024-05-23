package response;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.BaseClass;
import utilities.LoggerClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserByFristname extends Login {

    @Test
    public void testGetUserByFirstname() {
        String userfirstname = PostResponse.userfirstname;
        Assert.assertNotEquals(userfirstname, "User firstname is not set");

        String getUserFristnameEndpoint = BaseClass.getUserFristnameEndpoint(userfirstname);

        Response getUserFirstnameResponse = RestAssured.get(getUserFristnameEndpoint)
                .then()
                .log().all() // Log response details
                .extract().response();

        System.out.println("Response Body: " + getUserFirstnameResponse.getBody().asString());

        // assertion status code
        Assert.assertEquals(getUserFirstnameResponse.getStatusCode(), 200, "Get user details request failed");
        LoggerClass.logError("assertion errormessage");
    }
}
