package response;


import utilities.BaseClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeSuite;

public class Login extends BaseClass{


	 
/*
	        public static RequestSpecification reqSpec;

	        @BeforeSuite
	        public static void login() {
	            String baseUrl = BaseClass.getBaseUrl();
	            String username = BaseClass.getUsername();
	            String password = BaseClass.getPassword();

	            reqSpec = new RequestSpecBuilder()
	                    .setBaseUri(baseUrl)
	                    .setAuth(RestAssured.basic(username, password))
	                    .build();
	       // RestAssured.baseURI = baseUrl;
	        //RestAssured.authentication = RestAssured.basic(username, password);
	    }
}*/
    @BeforeSuite
    public static void login() {
        String baseUrl = BaseClass.getBaseUrl();// Update with your base URL
        String username = BaseClass.getUsername(); // Update with your username
        String password = BaseClass.getPassword(); // Update with your password

        // Set base URI for RestAssured
        RestAssured.baseURI = baseUrl;

        // Set preemptive basic authentication for RestAssured
        RestAssured.authentication = RestAssured.basic(username, password);
    }
}

