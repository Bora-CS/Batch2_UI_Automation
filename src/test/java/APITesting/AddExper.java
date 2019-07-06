package APITesting;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddExper {
	public static final String APPLICATION_URL = "http://ec2-3-86-91-230.compute-1.amazonaws.com:5000";
	public static final int HTTP_200_OK = 200;
	
	public static Response AddExperince(String title, String company, String location, String from, String to, String description) {
		
		String endpoint = "/api/profile/experience";
		RestAssured.baseURI = APPLICATION_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVkMTJhNzhkYzdlNDYwMGVjYzYyOTQxNSIsIm5hbWUiOiJSdXNsYW4gSWJyYWhpbW92IiwiYXZhdGFyIjoiLy93d3cuZ3JhdmF0YXIuY29tL2F2YXRhci8wZjhiZWFkOWRiMjdjNDcwZjFjZDA2MzRlMWI5ZGIyMT9zPTIwMCZyPXBnJmQ9bW0iLCJpYXQiOjE1NjIzNjc5NDQsImV4cCI6MTU2MjM3MTU0NH0.NVtn253D5HP6L5FFbvchjiCGD51fqfhpruyY3JXEv70");
		request.header("Content-Type", "application/json");
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("title", title);
		requestBody.put("company", company);
		requestBody.put("location", location);
		requestBody.put("from", from);
		requestBody.put("to", to);
		requestBody.put("description", description);
		request.body(requestBody);
		
		Response response = request.post(endpoint);
		return response;
	}
}
