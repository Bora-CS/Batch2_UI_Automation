package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Final3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com");
		
		WebElement login1 = driver.findElement(By.cssSelector(".btn.btn-lg.btn-light"));
		WebElement login2 = driver.findElement(By.xpath("//div//li/a[text()='Login']"));
		
		if (login1.getText().equals(login2.getText())) {
			login1.click();
			Keywords.waitFor(1);
		}else {
			System.out.println("Test Failed!!! \t (1)");
		}
		WebElement loginPage = driver.findElement(By.tagName("h1"));
		if (loginPage.getText().contains("Log In")) {
			driver.findElement(By.name("email")).sendKeys("ruslanibrahimoff@gmail.com");
			driver.findElement(By.name("password")).sendKeys("123456");
			Keywords.waitFor(1);
		}else {
			System.out.println("Test Failed!!! \t (2)");
		}
		
		driver.findElement(By.cssSelector(".btn.btn-info.btn-block.mt-4")).click();
		Keywords.waitFor(1);
		
		WebElement validation1 = driver.findElement(By.tagName("h1"));
		WebElement validation2 = driver.findElement(By.tagName("h3"));
		WebElement logoutButton = driver.findElement(By.partialLinkText("Logout"));
		
		if ((validation1.getText().contains("Student Profile")) &&
			(validation2.getText().contains("New Student"))	&& 
			(logoutButton.getText().contains("Logout"))) {
			
			logoutButton.click();
			Keywords.waitFor(1);
			
		}else {
			System.out.println("Test Failed!!! \t (3)");
		}
		
		WebElement modal = driver.findElement(By.tagName("h5"));
		
		if (modal.getText().contains("Are you sure?")) {
			driver.findElement(By.cssSelector(".btn.btn-secondary")).click();
			Keywords.waitFor(1);
		} else {
			System.out.println("Test Failed!!! \t (4)");
		}
		
		if (logoutButton.getText().contains("Logout")) {
			logoutButton.click();
			Keywords.waitFor(1);
			driver.findElement(By.cssSelector(".btn.btn-info")).click();
			Keywords.waitFor(1);
		}else {
			System.out.println("Test Failed!!! \t (5)");
		}
		
		String homePage = driver.findElement(By.xpath("//div/h1")).getText();
		
		if (homePage.contains("Bora UI Automation Test")) {
		System.out.println("Tested Succesfully!!!");
			
		} else {
			System.out.println("Test Failed!!! \t (6)");
		}
		
		driver.close();
		driver.quit();
	}

}
