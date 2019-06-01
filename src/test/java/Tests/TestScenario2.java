package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class TestScenario2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOWS);

		WebDriver driver = new ChromeDriver();

		driver.get(Constants.Test_Case_URL);

		WebElement signUpValidation1 = driver.findElement(By.cssSelector(".btn.btn-lg.btn-info.mr-2"));

		WebElement signUpValidation2 = driver.findElement(By.xpath("//li/a[text()='Sign Up']"));

		if (signUpValidation1.getText().equals(signUpValidation2.getText())) {
			signUpValidation1.click();
			Keywords.waitFor(5);
		} else {
			System.out.println("validation failed for the sign up buttons !");
		}

		String signupValidation3 = driver.findElement(By.cssSelector(".col-md-8.m-auto")).getText();

		if (!signupValidation3.contains("Create your Bora student account")) {
			System.out.println("validation failed for the validation of the sign up page");
		}

		driver.findElement(By.xpath("//div//input[@class = \"form-control form-control-lg\"][@type= \"text\"]"))
				.sendKeys("Waseem");

		driver.findElement(By.id("male")).click();

		driver.findElement(By.xpath("//div//input[@class = \"form-control form-control-lg\"][@name= \"email\"]"))
				.sendKeys("zeidwaseem@gmail.com");

		driver.findElement(By.xpath("//select/option[@value= \"selenium\"]")).click();

		driver.findElement(By.xpath("//div//input[@class = \"form-control form-control-lg\"][@name= \"password\"]"))
				.sendKeys("iLoveBananas");

		driver.findElement(By.xpath("//div//input[@class = \"form-control form-control-lg\"][@name= \"password2\"]"))
				.sendKeys("iLoveBananas");

		driver.findElement(By.id("notarobot")).click();

		driver.findElement(By.cssSelector(".btn.btn-info.btn-block.mt-4")).click();

		String finalPage = driver.findElement(By.cssSelector(".alert.alert-success")).getText();

		if (!finalPage.contains("Congratulations")) {
			System.out.println("Validation failed");
		}

		String backToHomepage = driver.findElement(By.cssSelector(".btn.btn-primary.btn-info.btn-block")).getText();

		if (!backToHomepage.contains("Back to Homepage")) {
			System.out.println("validation failed !");

		}

		driver.findElement(By.className("alert-link")).click();

		String finalHomePage = driver.findElement(By.id("Home")).getText();

		if (!finalHomePage.contains("Bora Consulting Solutions")) {
			System.out.println("validation failed !");
		}
		Keywords.waitFor(2);
		driver.close();
		driver.quit();

	}

}
