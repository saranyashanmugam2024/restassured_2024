package response;


import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import utilities.BaseClass;

import utilities.LoggerClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsers extends Login {

    @Test
    public void testGetUsers() {
        //login();

        // Get the endpoint for getting all users from the configuration
        String getAllUsersEndpoint = BaseClass.getAllUsersEndpoint();

        // Perform GET request to retrieve all user details using given-when-then
        Response getAllUsersResponse = 
            given()
                .when()
                .get(getAllUsersEndpoint)
                .then()
                .log().all()
                .statusCode(200) // Assert the status code
                .extract().response();

        // Log the response body
        String responseBody = getAllUsersResponse.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        //LoggerClass.logResponse(responseBody);

        // Validate the response body or specific fields as needed
        // Example: Check if the response contains a list of users
        Assert.assertTrue(responseBody != null && !responseBody.isEmpty(), "Response body is empty");
        

        Assert.assertTrue(getAllUsersResponse.getBody().jsonPath().getList("$").size() > 0, "User list is empty");
       getAllUsersResponse
       .then()
       .assertThat()
       .body("userAddress", everyItem(hasKey("plotNumber"))) // Assert that every userAddress object has a plotNumber key
       .body("userAddress", everyItem(hasKey("street"))) // Assert that every userAddress object has a street key
       .body("userAddress", everyItem(hasKey("state"))) // Assert that every userAddress object has a state key
       .body("userAddress", everyItem(hasKey("country"))) // Assert that every userAddress object has a country key
       .body("userAddress", everyItem(hasKey("zipCode"))) // Assert that every userAddress object has a zipCode key
       .body("user_id", everyItem(notNullValue())) // Assert that every user has an id
       .body("user_first_name", everyItem(notNullValue())) // Assert that every user has a first name
       .body("user_last_name", everyItem(notNullValue())) // Assert that every user has a last name
       .body("user_contact_number", everyItem(notNullValue())) // Assert that every user has a contact number
       .body("user_email_id", everyItem(notNullValue())); // Assert that every user has an email id
       // Add more assertions as needed for other common user properties
System.out.println(getAllUsersResponse.getCookie("JSESSIONID"));


    }
    @Test(dataProvider = "updatePayloadProvider", dataProviderClass = Postpayload.class)
    public void testGetUserscookies() {
 // Get the endpoint for getting all users from the configuration
    String getAllUsersEndpoint = BaseClass.getAllUsersEndpoint();

    // Perform GET request to retrieve all user details using given-when-then
    Response getAllUsersResponse = 
        given()
            .when()
            .get(getAllUsersEndpoint)
            .then()
            .log().all()
            .statusCode(200) // Assert the status code
            .extract().response();
    System.out.println("Response Body: " + getAllUsersResponse.getBody().asString());
          
    //String setCookieHeader = getAllUsersResponse.getHeader("Set-Cookie");

    // Print the Set-Cookie header
    //System.out.println("Set-Cookie Header: " + setCookieHeader);
    
    
    }
    
    
    
    @Test
    public void testGetUsersWithoutAuth() {
        // Get the endpoint for getting all users from the configuration
        String getAllUsersEndpoint = BaseClass.getAllUsersEndpoint();

        // Performing GET request without authentication
        given()
            .auth().none() // specifying no authentication
            .when()
            .get(getAllUsersEndpoint)
            .then()
            .log().all()
            .statusCode(401) // Assertion status code is 401 for  Unauthorized
            .body("error", equalTo("Unauthorized")); 
    }
    
    
}


