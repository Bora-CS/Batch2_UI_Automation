package APITests;

public class RegisterTestData {
	public String scenario;
	public String name;
	public String email;
	public String password;
	public String password2;
	public int expectedStatusCode;
	public String expectedBody;

	public RegisterTestData(String scenario, String name, String email, String password, 
			String password2,int expectedStatusCode, String expectedBody) {
		
		this.scenario = scenario;
		this.name = name;
		
		
		
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.expectedStatusCode = expectedStatusCode;
		this.expectedBody = expectedBody;
	}
	public RegisterTestData() {}
}
