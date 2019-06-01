package Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

	        WebDriver driver = new ChromeDriver();

	        driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com/");
	        try {
	        	String homePageTitle = driver.findElement(By.tagName("h1")).getText();
	        	if (homePageTitle.contains("Bora UI Automation Test")) {
	        		driver.findElement(By.linkText("Students")).click();
	        	}
	        	String studentPage = driver.findElement(By.tagName("h1")).getText();
	        	if(!studentPage.contains("Students Information")) {
	        		System.out.println("Your on the wrong page");
	        	}
	        	
	        	List<WebElement> numberOfStudent =driver.findElements(By.tagName("tr"));
	        		
				System.out.println(numberOfStudent.size());
				
				 WebElement myName = driver.findElement(By.xpath("//tr/td[contains(text(),'Kadriya')]"));
				 

				
		
	        	
	        	
	        	
	        	
	        	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		driver.close();
		driver.quit();
	}
	}

}
