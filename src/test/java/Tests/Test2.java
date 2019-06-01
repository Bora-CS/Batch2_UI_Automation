package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

	        WebDriver driver = new ChromeDriver();

	        driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com/");
	        
	        try {
	        	String signupButton = driver.findElement(By.linkText("Sign Up")).getText();
	        	
	        	WebElement signupButton2 = driver.findElement(By.cssSelector(".btn.btn-lg.btn-info.mr-2"));
	        	signupButton2.click();
	        	String signupTitle = driver.findElement(By.tagName("h1")).getText();
	        	if(!signupTitle.contains("Sign Up")) {
	        		System.out.println("your on the wrong page!");
	        	}
	        	driver.findElement(By.name("name")).sendKeys("Kadriya");
	        	driver.findElement(By.id("female")).click();
	        	driver.findElement(By.name("email")).sendKeys("Kadriya@bora-cs.com");	        	
	        	WebElement selectcourseElement = driver.findElement(By.name("Course"));
	    		Select course = new Select(selectcourseElement);
	    		course.selectByVisibleText("Selenium Automation");
	        	driver.findElement(By.name("password")).sendKeys("kk1234");
	        	driver.findElement(By.name("password2")).sendKeys("kk1234");
	        	driver.findElement(By.id("notarobot")).click();	        	
	        	driver.findElement(By.cssSelector(".btn.btn-info.btn-block.mt-4")).click();
	        	
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("alert-heading")));
						
				driver.findElement(By.cssSelector(".btn.btn-primary.btn-info.btn-block")).getText();
				driver.findElement(By.linkText("Bora Coding Bootcamnp")).click();
				String homePage = driver.findElement(By.cssSelector(".m-font-size-36.lh-1.font-size-60")).getText();

	        	if(homePage.contains("Bora Consulting Solutions")) {
	        		System.out.println("Test passed");
	        	}
	        	else {
	        		System.out.println("Test Failed");
	        	}
	        	
	        
	     }catch (Exception e) {
	 		e.printStackTrace();
	 	} finally {
	 		driver.close();
	 		driver.quit();
	 	}      
	}

}
