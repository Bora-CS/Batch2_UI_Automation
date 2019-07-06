package APITests;

import java.awt.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterTest {
	public static final String Application_URL = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000";
	

	public static void main(String[] args) {
		
		ArrayList<RegisterTestData> registerTestData = new ArrayList<RegisterTestData>();
//		registerTestData.add(new  RegisterTestData
//				("Happy path-valid data", "Student", "student@gmail.com", "student1234", "student1234", 200, ""));
		registerTestData.add(new  RegisterTestData
				("Invalid name - empty name", "", "student@gmail.com", "student123", "student123", 
						400, "\"name\": \"Name field is required\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid name - one character name", "s", "student@gmail.com", "student123", "student123", 
						400, " \"name\": \"Name must be between 2 and 30 characters\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid name - more than 20 characters name", "ajjhgsjdhgasjkhdgkajhgdjkagsdkjhasgdjkagsjkdsfjgfjsfkdpghori84",
						"student@gmail.com", "student123", "student123", 
						400, "\"name\": \"Name must be between 2 and 30 characters\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid email- empty email, valid password", "Student", "", "student123", "student123", 
						400, "\"email\": \"Email field is required\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid email- without \"@\"", "Student", "studentgmail.com", "student123", "student123", 
						400, "\"email\": \"Email is invalid\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid email - without \".\"", "", "student@gmailcom", "student123", "student123", 
						400, " \"email\": \"Email is invalid\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid email - without \"com\"", "", "student@gmail", "student123", "student123", 
						400, " \"email\": \"Email is invalid\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid password - empty password", "", "student@gmail.com", "", "student123", 
						400, "  \"password\": \"Password field is required\",\r\n" + 
								"    \"password2\": \"Passwords must match\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid password - 2 characters password", "Student", "student@gmail.com", "12", "student123", 
						400, "  \"password\": \"Password field is required\",\r\n" + 
								"    \"password2\": \"Passwords must match\""));
		
		registerTestData.add(new  RegisterTestData
				("Invalid password - 50 characters password", "Student", "student@gmail.com", 
						"123456349875394875934579347958347958379845793847","student123", 
						400, "  \"password\": \"Password field is required\",\r\n" + 
								"    \"password2\": \"Passwords must match\""));
		
		registerTestData.add(new  RegisterTestData
				("Password not match with password2", "Student", "student@gmail.com", "student", "student123", 
						200, "  \"password\": \"Password field is required\",\r\n" + 
								"    \"password2\": \"Passwords must match\""));
		
		int scenarioNo = 1;
		for (RegisterTestData data : registerTestData) {
			System.out.println("Test scenario "+ scenarioNo + ": " + data.scenario);
			
			
			//action register
			Response response = register(data.name, data.email, data.password, data.password2);
			int actaulStatusCode = response.getStatusCode();
			int expectedStatusCode = data.expectedStatusCode;
			String responseBody = response.getBody().asString();
			
			if(actaulStatusCode == expectedStatusCode) {
				System.out.println("Test case passed!");
			} else {
				System.out.println("Test failed");
				System.out.println("Expected status code: " + expectedStatusCode);
				System.out.println("Actaul status code: " + actaulStatusCode);
				System.out.println("Expected body: " + data.expectedBody);
				System.out.println("Actaul body: + " + responseBody);
			}
			scenarioNo++;
			System.out.println();
			
		}
	}

	public static Response register(String name, String email, String password, String password2) {

		String endPoint = "/api/users/register";
		RestAssured.baseURI = Application_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject requestBody = new JSONObject();// hash map
		requestBody.put("name", name);
		requestBody.put("email", email);
		requestBody.put("password", password);
		requestBody.put("password2", password2);

		Response response = request.post(endPoint);

		return response;

	}
}
