package exam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class TestScenario2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		Thread.sleep(1000);
		WebElement signUp1 = myDriver.findElement(By.xpath("//ul/li/a[1]"));
		Thread.sleep(1000);
		WebElement signUp2 = myDriver.findElement(By.xpath("//a[@class='btn btn-lg btn-info mr-2']"));
		if (signUp1.isDisplayed() && signUp2.isDisplayed()) {
			signUp2.click();
		}
		if (myDriver.findElement(By.xpath("//h1[@class='display-4 text-center']")).isDisplayed()) {
			myDriver.findElement(By.name("name")).sendKeys("Shirinay");
			Thread.sleep(1000);
			List<WebElement> gender = myDriver.findElements(By.cssSelector(".form-check.form-check-inline"));
			gender.get(1).findElement(By.id("female")).click();
			Thread.sleep(1000);
			myDriver.findElement(By.name("email")).sendKeys("Shirinay@bora-cs.com");
			Thread.sleep(1000);
			WebElement aCourse = myDriver.findElement(By.xpath("//select[@name='Course']"));
			Select selectACourse = new Select(aCourse);
			selectACourse.selectByVisibleText("Selenium Automation");
			Thread.sleep(1000);
			myDriver.findElement(By.name("password")).sendKeys("1234567");
			Thread.sleep(1000);
			myDriver.findElement(By.name("password2")).sendKeys("1234567");
			Thread.sleep(1000);
			myDriver.findElement(By.id("notarobot")).click();
			Thread.sleep(1000);
			myDriver.findElement(By.xpath("//input[@class='btn btn-info btn-block mt-4']")).click();
		}
		WebElement alertText = myDriver.findElement(By.xpath("//h4[@class='alert-heading']"));
		String expectedText = "Congratulations!";
		if (alertText.getText().equals(expectedText)) {
			System.out.println("Sign up successful!");
		}
		WebElement backToHomepage = myDriver.findElement(By.xpath("//a[@class='btn btn-primary btn-info btn-block']"));
		if (backToHomepage.isDisplayed()) {
			myDriver.findElement(By.className("alert-link")).click();
			String webPage = myDriver.getCurrentUrl();
			String expectedURL = "https://www.bora-cs.com/";
			if (webPage.equals(expectedURL)) {
				System.out.println("We are on " + webPage + " home page!");
			}
		}

		myDriver.close();
		myDriver.quit();
	}

}
