package APITests;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;

public class LogInTests {

	public static void main(String[] args) {
		// Generate input data
		List<LogInTestData> logInTestData = new ArrayList<LogInTestData>();
		logInTestData.add(new LogInTestData("Happy Path","maro9090@mail.ru","Marat123",200,"{\"success\":true,\"token\":\"Bearer"));
		logInTestData.add(new LogInTestData("Invalid email & valid password","maro@mail.ru","Marat123",404,"{\"email\":\"User not found\"}"));
		logInTestData.add(new LogInTestData("Valid email & invalid password","maro9090@mail.ru","Mar222",400,"{\"password\":\"Password incorrect\"}"));
		logInTestData.add(new LogInTestData("Invalid email format","maro9090mail.ru","Marat123",400,"{\"email\":\"Email is invalid\"}"));
		logInTestData.add(new LogInTestData("Empty email","","Marat123",400,"{\"email\":\"Email field is required\"}"));
		logInTestData.add(new LogInTestData("Empty password","maro9090@mail.ru","",400,"{\"password\":\"Password field is required\"}"));
		logInTestData.add(new LogInTestData("No body at all","","",400,"{\"email\":\"Email field is required\",\"password\":\"Password field is required\"}"));
				
		int scenarioNumber = 1;
		for (LogInTestData data : logInTestData) {
			System.out.println("Test Scenario "+ scenarioNumber +": " + data.scenario);
		
			// action - log in 
			Response response = WebServices.logInTest(data.email, data.password);
			int actualStatusCode = response.getStatusCode();
			String responseBody = response.getBody().asString();
			
			// validate the response
			if (actualStatusCode == data.expectStatusCode) {
				if (responseBody.contains(data.expectedBody)) {
					System.out.println("Test result: passed!");
				} else {
					System.out.println("Test result: failed.");
					System.out.println("Expected body:\t" + data.expectedBody);
					System.out.println("Actual body:\t" + responseBody);
				}
			} else {
				System.out.println("Test result: failed.");
				System.out.println("Expected status code:\t" + data.expectStatusCode);
				System.out.println("Actual status code:\t" + actualStatusCode);
			}
			scenarioNumber++;
			System.out.println();
		}

	}

}
