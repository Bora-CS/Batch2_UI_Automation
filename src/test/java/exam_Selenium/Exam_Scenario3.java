package exam_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Exam_Scenario3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
		List<WebElement> login = driver.findElements(By.xpath("//a[contains(text(),'Login')]"));
		
		System.out.println("there are " + login.size() + " Login Buttons on the home page");
		Keywords.waitFor(1);
		
		login.get(0).click();
		
		String loginTitle = driver.findElement(By.tagName("h1")).getText();
		
		if (loginTitle.contains("Log In")) {
			
			System.out.println("Validation passed: " + loginTitle + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page Title \"Log In\" is not shown.");
			}
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("maro9090@mail.ru");
		Keywords.waitFor(1);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Marat123");
		Keywords.waitFor(1);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Keywords.waitFor(1);
		
		String profilePage = driver.findElement(By.tagName("h1")).getText();
		
		if (profilePage.contains("Student Profile")) {
			
			System.out.println("Validation passed: " + profilePage + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page Title \"Student Profile\" is not shown.");
			}
		
		String newStudent = driver.findElement(By.tagName("h3")).getText();
		
		if (newStudent.contains("New Student")) {
			
			System.out.println("Validation passed: " + newStudent + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page has a \"New Student\" is not shown.");
			}
		
		WebElement logOut = driver.findElement(By.xpath("//a[@data-toggle='modal']"));
		
		if (logOut.getText().contains("Logout")) {
			
			System.out.println("Validation passed: " + logOut + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page has a \"Logout\" is not shown.");
			}
		
		logOut.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModalCenterTitle")));
		
		String areYouSure = driver.findElement(By.id("exampleModalCenterTitle")).getText();
		
		if (areYouSure.contains("Are you sure?")) {
			
			System.out.println("Validation passed: " + areYouSure + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page has a \"Are you sure?\" is not shown.");
			}
		
		driver.findElement(By.cssSelector(".btn.btn-secondary")).click();
		Keywords.waitFor(1);
		
		if (profilePage.contains("Student Profile")) {
			
			System.out.println("You are still on the page: " + profilePage + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page Title \"Student Profile\" is not shown.");
			}
		logOut.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModalCenterTitle")));
		
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
		
		
		driver.close();
		driver.quit();
		
		
	}

}
