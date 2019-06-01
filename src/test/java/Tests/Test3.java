package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

	        WebDriver driver = new ChromeDriver();

	        driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com/");
	        
	        try {
	        	String loginButton = driver.findElement(By.linkText("Login")).getText();
	        	WebElement loginButton2 = driver.findElement(By.cssSelector(".btn.btn-lg.btn-light"));
	        	loginButton2.click();
	        	String loginTitle = driver.findElement(By.tagName("h1")).getText();
	        	if(!loginTitle.contains("Log In")) {
	        		System.out.println("your on the wrong page!");
	        	}
	        	driver.findElement(By.name("email")).sendKeys("Kadriya@bora-cs.com");
	        	driver.findElement(By.name("password")).sendKeys("kk1234");
	        	driver.findElement(By.cssSelector(".btn.btn-info.btn-block.mt-4")).click();
	        	
	        	WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".display-4.text-center")));
	        	
	        	String loginSeccess = driver.findElement(By.cssSelector(".display-4.text-center")).getText();
	        	String loginSeccess2 = driver.findElement(By.cssSelector(".col-lg-6.col-md-4.col-8")).getText();
	        	
	        	
	        	
	        	if(loginSeccess.contains("Student Profile")) {
	        		if(loginSeccess2.contains("New Student")) {
	        			System.out.println("your now on the right page");
	        		}
	        	} else {
	        		System.out.println("your on the wrong page");
	        	}
	        	driver.findElement(By.linkText("Logout" )).click();
	        	
	        	driver.findElement(By.className("modal-header"));
	        	
	        	driver.findElement(By.cssSelector(".btn.btn-secondary")).click();
	        	
	        	String loginSeccess3 = driver.findElement(By.cssSelector(".display-4.text-center")).getText();
	        	String loginSeccess4 = driver.findElement(By.cssSelector(".col-lg-6.col-md-4.col-8")).getText();
	        	
	        	driver.findElement(By.linkText("Logout" )).click();

	        	driver.findElement(By.linkText("Gotta go!")).click();

	
	        }catch (Exception e) {
		 		e.printStackTrace();
		 	} finally {
		 		driver.close();
		 		driver.quit();
		 	}      
	        }
	}