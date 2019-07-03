package APITests;

public class LogInTestData {
	
	public String scenario;
	public String email;
	public String password;
	
	public int expectStatusCode;
	public String expectedBody;
	
	public LogInTestData(String scenario, String email, String password, int expectStatusCode, String expectedBody) {
		this.scenario = scenario;
		this.email = email;
		this.password = password;
		this.expectStatusCode = expectStatusCode;
		this.expectedBody = expectedBody;
	}
	
	public LogInTestData() {}
	
}
