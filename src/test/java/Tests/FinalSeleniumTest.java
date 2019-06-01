package Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class FinalSeleniumTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
//		driver.manage().window().maximize();

		try {
			
			String homepage = driver.findElement(By.tagName("h1")).getText();
			
			if(homepage.contains("Bora UI Automation Test")) {
				System.out.println("Homepage Test Validation Passed");
			} else {
				System.out.println("Homepage Test Validation Failed");
			}
			
			
			Keywords.waitFor(2);
			driver.findElement(By.linkText("Students")).click();
			Keywords.waitFor(2);
			
			String studentHomepage = driver.findElement(By.tagName("h1")).getText();
			if(studentHomepage.contains("Students Information")) {
				System.out.println("Student Test Validation Passed");
			} else {
				System.out.println("Student page Test Validation Failed");
			}
			Keywords.waitFor(2);
			
			WebElement studentCheck = driver.findElement(By.id("studentInfo"));
			System.out.println(studentCheck.getText());
			
//			List<WebElement> numberOfStudent = driver.findElements(By.cssSelector(".table.table-hover"));
			List<WebElement> numberOfStudent = driver.findElements(By.tagName("tr"));
			
			
			System.out.println(numberOfStudent.size()-1);
			
			
			//Search for yourself from the data structure by name, 
			//and then validate that your email address is in the "xxxxx@bora-cs.com" format,
			WebElement searchMyself = driver.findElement(By.xpath("//td[contains(text(),'Rose')]"));
			System.out.println(searchMyself.getText());
			
			WebElement validateEmail = driver.findElement(By.xpath("//td[contains(text(),'Rose@bora-cs.com')]"));
			System.out.println(validateEmail.getText());
			
			
			
	
	
				
	
			
			
				
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
	}
	public static void testCase() {
		
	}
}

