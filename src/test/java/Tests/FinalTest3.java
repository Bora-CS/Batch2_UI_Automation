package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;

public class FinalTest3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
	    
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
		String Login1 = driver.findElement(By.xpath("//a[@href='login.html']")).getText();
		 
		String  Login2 = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li[2]/a")).getText();
		 
		if(Login1 .contains("Login") && Login2 .contains("Login")) {
			
			System.out.println("There are 2 Login button");
			}
	}
	
}
