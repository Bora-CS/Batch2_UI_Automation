package APITests;

import java.awt.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LogInTest {

	public static final String Application_URL = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000";
	public static final int HTTP_200_OK = 200;

	public static void main(String[] args) {
		ArrayList<LoginTestData> logInTestData = new ArrayList<LoginTestData>();
		logInTestData.add(new LoginTestData
				("Happy Path","student@gmail.com","student123",200,"{\"success\":true,\"token\":\"Bearer"));
		logInTestData.add(new LoginTestData
				("Invalid email & valid password","studentgmail.com","student123",404,"{\"email\":\"User not found\"}"));
        logInTestData.add(new LoginTestData
        		("Valid email & invalid password","student@gmail.com","123",400,"{\"password\":\"Password incorrect\"}"));
		
        
        int scenarioNum = 1;
		for (LoginTestData data : logInTestData) {
            System.out.println("Test Scenario " + scenarioNum + ": " + data.scenario);
            
            Response response = logInTest(data.email, data.password);
            int actualStatusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();
            if(actualStatusCode == data.expectedStatusCode) {
                if(responseBody.contains(data.expectedBody)) {
                    System.out.println("Test passed!");
                } else {
                    System.out.println("Expected Body:\t" + data.expectedBody);
                    System.out.println("Actual Body:\t" + responseBody);
                }
            } else {
                System.out.println("Test Failed!");
                System.out.println("Expected Status Code:\t" + data.expectedStatusCode);
                System.out.println("Actual Status Code:\t" + actualStatusCode);
            }
            scenarioNum++;
            System.out.println(response.getBody().asString());
            System.out.println();
        }
		
		

	}


	static Response logInTest(String email, String password) {
		String endpoint = "/api/users/login";
		RestAssured.baseURI = Application_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "Application/json");
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", email);
		requestBody.put("password", password);
		request.body(requestBody);
		
		Response response = request.post(endpoint);
		return response;
		


	}
}
