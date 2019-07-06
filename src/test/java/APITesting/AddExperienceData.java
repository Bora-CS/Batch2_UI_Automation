package APITesting;

public class AddExperienceData {

	public String title;
	public String company;
	public String location;
	public String from;
	public String to;
	public String description;
	
	public AddExperienceData(String title, String company, String location, String from, String to, String description) {
		
		this.title = title;
		this.company = company;
		this.location = location;
		this.from = from;
		this.to = to;
		this.description = description;
	}
	public AddExperienceData() {
		
	}
}
