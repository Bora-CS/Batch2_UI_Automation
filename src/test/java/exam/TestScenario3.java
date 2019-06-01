package exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class TestScenario3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		Keywords.waitFor(1);

		WebElement logIn1 = myDriver.findElement(By.xpath("//ul[2]/li[2]/a"));
		Keywords.waitFor(1);
		WebElement logIn2 = myDriver.findElement(By.xpath("//a[@class='btn btn-lg btn-light']"));

		if (logIn1.isDisplayed() && logIn2.isDisplayed()) {
			System.out.println("There are two log in buttons.");
		}
		logIn2.click();
		WebElement logInText = myDriver.findElement(By.xpath("//h1[@class='display-4 text-center']"));
		String expectedLogInText = "Log In";
		if (logInText.getText().equals(expectedLogInText)) {
			Keywords.waitFor(1);
			myDriver.findElement(By.name("email")).sendKeys("Shirinay@bora-cs.com");
			Keywords.waitFor(1);
			myDriver.findElement(By.name("password")).sendKeys("1234567");
			Keywords.waitFor(1);
			myDriver.findElement(By.xpath("//input[@class='btn btn-info btn-block mt-4']")).click();
		}

		WebElement studentProfile = myDriver.findElement(By.xpath("//h1[@class='display-4 text-center']"));
		String expectedProfileText = "Student Profile";
		WebElement newStudent = myDriver.findElement(By.xpath("//h3[contains(text(),'New Student')]"));
		if (studentProfile.isDisplayed() && studentProfile.getText().equals(expectedProfileText)
				&& newStudent.isDisplayed()) {
			System.out.println("Log in successful!");
		}
		Keywords.waitFor(1);
		WebElement logOutButton = myDriver.findElement(By.xpath("//ul[@class='navbar-nav ml-auto']//a[1]"));
		if (logOutButton.isDisplayed()) {
			logOutButton.click();
		}
		Keywords.waitFor(1);
		WebElement alert = myDriver.findElement(By.xpath("//div[@class='modal-content']"));
		if (alert.isDisplayed()) {
			System.out.println("Alert dispaled");
			WebElement confirmText = myDriver.findElement(By.xpath("//h5[@id='exampleModalCenterTitle']"));
			String expectedText = "Are you sure?";
			if (confirmText.getText().equals(expectedText)) {
				Keywords.waitFor(1);
				myDriver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
				Keywords.waitFor(1);
			}
		}

		if (studentProfile.isDisplayed()) {
			System.out.println("We are still on the student profile page.");
			Keywords.waitFor(1);
		}

		myDriver.findElement(By.xpath("//ul[@class='navbar-nav ml-auto']//a[1]")).click();
		Keywords.waitFor(1);
		myDriver.findElement(By.xpath("//a[@class='btn btn-info']")).click();

		Keywords.waitFor(1);
		WebElement bigText = myDriver.findElement(By.xpath("//h1[@class='display-3 mb-4']"));
		if (bigText.isDisplayed()) {
			System.out.println("We are back on the home page.");
			Keywords.waitFor(1);
		}

		myDriver.close();
		myDriver.quit();
	}

}
