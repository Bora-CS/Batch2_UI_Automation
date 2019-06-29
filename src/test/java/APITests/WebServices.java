package APITests;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebServices {

	public static final String APPLICATION_URL = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000";
	public static final int HTTP_200_OK = 200;
	
	public static void main(String[] args) {
		
		String token = logIn("maro9090@mail.ru", "Marat123");
		
		if (token != null) {
			String profileEndpoint = "/api/profile";
			String requestName = "Get Current User Profile";
			RestAssured.baseURI = APPLICATION_URL;
			
			RequestSpecification request = RestAssured.given();
			request.header("Authorization", token);
			
			Response response = request.get(profileEndpoint); 
			
			if (checkStatus(requestName, response)) {
				
				JsonPath jp = response.jsonPath();
				
//				ArrayList<HashMap<String, String>> experiences = jp.get("experience");
				
				Experience[] experiences = jp.getObject("experience", Experience[].class);
				
				Experience expectedExp = new Experience(
							true,
							"5d1559ffc7e4600ecc629426",
							"senior cashier",
							"McDonalds",
							"Fairfax, VA",
							"2018-07-01T00:00:00.000Z",
							null,
							"Maybe good place to work at");
				
				
				for (Experience experience : experiences) {					
					if (expectedExp.equals(experience)) {
						System.out.println("Experience Found");
					}
				}
				
			}

		}
		
	}

	public static boolean checkStatus(String requestName, Response response) {
		int statusCode = response.getStatusCode();
		if (statusCode == HTTP_200_OK) {
			System.out.println("Request ["+ requestName +"] is successful");
			return true;
		} else {
			System.out.println("Request ["+ requestName +"] is not successful");
			System.out.println("Actual Status Code: " + statusCode);
			System.out.println(response.getBody().asString());
			return false;
		}
	}

	public static String logIn(String email, String password) {
		String endpoint = "/api/users/login";
		String requestName = "Log In";
		RestAssured.baseURI = APPLICATION_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", email);
		requestBody.put("password", password);
		request.body(requestBody);
		
		Response response = request.post(endpoint);
		JsonPath jp = response.jsonPath();
		
		if (checkStatus(requestName, response)) {
			return jp.get("token");
		} else {
			return null;
		}
	}

}
