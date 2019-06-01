package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;


public class selenumlast {

		public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver",
					"src/Resources/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com");
			driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com");

			String signup1 = driver.findElement(By.xpath("//a[@href=‘register.html’]")).getText();        
			String signup2 = driver.findElement(By.cssSelector("btn.btn-lg.btn-info.mr-2")).getText();
			System.out.println(signup1.equals(signup2));
		
			driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
			driver.findElement(By.id("name")).sendKeys("Nafisa");
			
			Keywords.waitFor(2);
			
			List<WebElement> maleorfemale = driver.findElements(By.cssSelector(".form-check-input"));

			maleorfemale.get(1).findElement(By.id("female")).click();

			Keywords.waitFor(2);
			
			driver.findElement(By.id("email")).sendKeys("Nanfeise@gmail.com");
			Keywords.waitFor(2);
			
			WebElement selectStateElement = driver.findElement(By.id("Course"));
			Select state = new Select(selectStateElement);
			state.selectByVisibleText("Java Spring Full Stack Development");
			
			Keywords.waitFor(2);

			driver.findElement(By.id("password")).sendKeys("12345678");
			Keywords.waitFor(2);
			
			driver.findElement(By.id("password2")).sendKeys("12345678");
			Keywords.waitFor(2);
			
			driver.findElement(By.xpath("//*[@id=\"notarobot\"]")).click();
			
			Keywords.waitFor(2);
			
			driver.findElement(By.xpath("/html/body/div/div/div/div/form/input")).click();
			Keywords.waitFor(2);
			
			
			WebElement submit = driver.findElement(By.xpath("./html/body/div/div/div/div/form/input"));
			
			String text = submit.getText();
			
			if (submit.isEnabled() && text.contains("Congratulations!"))
			{ 
			    System.out.println("Successfully completed");
			    
			}else{
				
			    System.out.println("Not Successfully ");
			}
			
		     driver.findElement(By.xpath("//a[@href=‘landing.html’]")).click(); 
			

	
			
			driver.close();
			driver.quit();

			
	

	}
}


