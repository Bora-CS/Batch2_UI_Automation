package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class FinalSeleniumTest1 {
	

		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

			WebDriver driver = new ChromeDriver();

			driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com/");
			
			try {
			
				WebElement signupHomepage1 = driver.findElement(By.xpath("//*[@id=\"mobile-nav\"]/ul[2]/li[1]/a"));
				WebElement signupHompage2 = driver.findElement(By.cssSelector(".btn.btn-lg.btn-info.mr-2"));
				
				System.out.println(signupHomepage1.getText());
				System.out.println(signupHompage2.getText());
				
				signupHompage2.click();
				Keywords.waitFor(2);
				
				//Validate that you're on the sign up page
				String validate = driver.findElement(By.cssSelector(".lead.text-center")).getText();
				if (validate.contains("Create your Bora student account")) {
					System.out.println("You are on sign up page");
					
				}else {
					System.out.println("You are not on sign up page");
				}
				
				//Fill out the form and submit the form
				driver.findElement(By.name("name")).sendKeys("Rose");
				
				
			
				
				
				
				
					
				

	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
			driver.close();
			driver.quit();
			
		
		
		 }
		}
	}

