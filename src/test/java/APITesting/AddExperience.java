package APITesting;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddExperience {
	
	public static void main(String[] args) {
		
		List<AddExperienceData> AddExperienceData = new ArrayList<AddExperienceData>();
		AddExperienceData.add(new AddExperienceData("Java Developer", "Amazon", "Arlington, VA", "01-01-2010", "01-01-2018", "Have had an amazing experience"));

		for (AddExperienceData data : AddExperienceData) {
			System.out.println("happy");
				
		Response response = AddExper.AddExperince(data.title, data.company, data.location, data.from, data.to, data.description);
		String responseBody = response.getBody().asString().replace("\",\"", "\",\n\"").replace("},{", "},\n{");
		System.out.println(responseBody);
	}
	}

}
