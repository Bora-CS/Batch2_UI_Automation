package APITests;

import io.restassured.response.Response;

public class LoginTestData {
	public String scenario;
	public String email;
	public String password;
	public int expectedStatusCode;
	public String expectedBody;

	public LoginTestData(String scenario, String email, String password, int expectedStatusCode, String expectedBody) {
		this.scenario = scenario;
		this.email = email;
		this.password = password;
		this.expectedStatusCode = expectedStatusCode;
		this.expectedBody = expectedBody;
	}
public static void main(String[] args) {
//	Response response = LogInTestScenario.logInTest(email, email);
}
}
