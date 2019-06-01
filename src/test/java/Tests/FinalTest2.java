package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;

public class FinalTest2 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
	    
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
		String sign1 = driver.findElement(By.xpath("//a[@href='register.html']")).getText();
		 
		String  sign2 = driver.findElement(By.xpath("//a[@class='nav-link']")).getText();
		 
		if(sign1.contains("Sign Up") && sign2.contains("Sign Up")) {
			
		System.out.println("There are 2 sign up button");
		}
         
		driver.findElement(By.cssSelector("btn.btn-lg.btn-info.mr-2")).click();
		
		driver.findElement(By.xpath("//input[@type ='text']")).sendKeys("Nurala");
		driver.findElement(By.id("female")).click();
		driver.findElement(By.xpath("//input[@type ='email']")).sendKeys("Nurala1013@gmail.com");
		
		WebElement selectSeleniumAutomation = driver.findElement(By.cssSelector(".form-control.form-control-lg"));
		Select Course = new Select(selectSeleniumAutomation);

		Course.selectByVisibleText("Java Spring Full Stack Development");
		
		
		driver.findElement(By.xpath("//input[@type ='password']")).sendKeys("1234567");
		
		driver.findElement(By.xpath("//input[@type ='password']/[@for='password2']")).sendKeys("1234567");
		
		driver.findElement(By.id("notarobot")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		String submition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/h4)")).getText();
		if(submition.contains("Congratulations!")) {
			System.out.println("Successed");
		}
		String BackHomePage = driver.findElement(By.xpath("//a[@href ='landing.html']")).getText();
		
		if(BackHomePage.contains("Back to Homepage")) {
			System.out.println("There is a button that takes you back to the homepage");
		}
		driver.findElement(By.xpath("//a[@href ='https://www.bora-cs.com']")).click();
		
		String homePage1 =  driver.findElement(By.xpath("//*[@id=\"1919496777\"]/h3")).getText();
		 if(homePage1.contains("Business Hours")) {
			 System.out.println("you're on the Bora-cs.com home page");
		 }
		
	}

}
