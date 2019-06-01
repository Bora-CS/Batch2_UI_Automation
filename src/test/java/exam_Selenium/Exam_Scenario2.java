package exam_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Exam_Scenario2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
	 	List<WebElement> signUp = driver.findElements(By.xpath("//a[contains(text(),'Sign Up')]"));
		
		System.out.println("there are " + signUp.size() + " Sign Up nuttons on the home page");
		Keywords.waitFor(1);
		
		signUp.get(1).click();
		
		String signUpTitle = driver.findElement(By.tagName("h1")).getText();
		
		if (signUpTitle.contains("Sign Up")) {
			
			System.out.println("Validation passed: " + signUpTitle + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page Title \"Sign Up\" is not shown.");
			}
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Marat");
		Keywords.waitFor(1);
		
		driver.findElement(By.id("male")).click();
		Keywords.waitFor(1);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("maro9090@mail.ru");
		Keywords.waitFor(1);
		
		WebElement selectCourse = driver.findElement(By.xpath("//select[@name='Course']"));
		Select course = new Select(selectCourse);
		course.selectByVisibleText("Selenium Automation");
		Keywords.waitFor(1);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Marat123");
		Keywords.waitFor(1);
		
		driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("Marat123");
		Keywords.waitFor(1);
		
		driver.findElement(By.id("notarobot")).click();
		Keywords.waitFor(1);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Keywords.waitFor(1);
		
		String success = driver.findElement(By.tagName("h4")).getText();
		
		if (success.contains("Congratulations!")) {
			
			System.out.println("Validation passed: " + success + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page Title \"Congratulations!\" is not shown.");
		}
		
		WebElement backHome = driver.findElement(By.xpath("//a[contains(text(),'Back to Homepage')]"));
		
		if (backHome.isDisplayed()) {
			System.out.println("Validation passed: 'Back to Homepage' is shown on the this page");
			
		} else {
			System.out.println("Test Failed: This page Title \"Back to Homepage\" is not shown.");
		}
		
		driver.findElement(By.className("alert-link")).click();
		Keywords.waitFor(1);
		String boraCSPage = driver.findElement(By.cssSelector(".m-font-size-36.lh-1.font-size-60")).getText();
		if (boraCSPage.contains("Bora Consulting Solutions")) {
			
			System.out.println("Validation passed: " + boraCSPage + " is shown on the home page");
		} else {
			System.out.println("Test Failed: Homepage Title \"Bora Consulting Solutions\" is not shown.");
		}
		
		
		driver.close();
		driver.quit();
	}

}
