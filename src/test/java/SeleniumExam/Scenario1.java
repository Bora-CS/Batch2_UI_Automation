package SeleniumExam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;

public class Scenario1 {

	public static boolean testPassed = true;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		Thread.sleep(1000);

		WebElement bigText = myDriver.findElement(By.xpath("//h1[@class='display-3 mb-4']"));
		WebElement longText = myDriver.findElement(By.className("lead"));
		if (bigText.isDisplayed() && longText.isDisplayed()) {
			System.out.println("We are on the main page");
		}

		myDriver.findElement(By.xpath("//a[contains(text(),'Students')]")).click();
		Thread.sleep(1000);
		WebElement tableName = myDriver.findElement(By.xpath("//h1[@class='display-4 text-center']"));
		if (tableName.isDisplayed()) {
			System.out.println("We are on student information page");
		}
		Thread.sleep(1000);
		List<WebElement> studentCount = myDriver.findElements(By.xpath("//body//tr"));
		int numOfStudents = studentCount.size() - 1;
		if (numOfStudents != 12) {
			System.out.println("The number of students is not 12");
			testPassed = false;
		}

		List<WebElement> allName = myDriver.findElements(By.xpath("//tr/td[1]"));

		String studentNameToFind1 = "Shirinay";
		boolean foundStudent = false;
		for (int i = 0; i < allName.size(); i++) {
			if (allName.get(i).getText().equals(studentNameToFind1)) {
				String email = myDriver.findElement(By.xpath("//tr[" + (i + 2) + "]/td[2]")).getText();
				String phoneNumber = myDriver.findElement(By.xpath("//tr[" + (i + 2) + "]/td[3]")).getText();

				if (email.contains(studentNameToFind1 + "@bora-cs.com")) {
					System.out.println("The email is in correct format: \t" + email);

				}

				if (phoneNumber.contains("202-202-20")) {
					System.out.println("The phone number is in correct format: \t" + phoneNumber);

				}
				foundStudent = true;
			}

		}
		if (!foundStudent) {
			System.out.println("Student not found, please try again");
			testPassed = false;
		}

		myDriver.close();
		myDriver.quit();

	}

}
