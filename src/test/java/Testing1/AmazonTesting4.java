package Testing1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;
import net.bytebuddy.implementation.EqualsMethod;

public class AmazonTesting4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		
		driver.findElement(By.className("nav-input")).click();
		
		List<WebElement> elements =
				driver.findElements(By.className(".a-size-medium.a-color-base.a-text-normal"));
		
		System.out.println(((WebElement) elements).getText());
		
		if (((WebElement) elements).getText().contains("iphnoe") ||
				((WebElement) elements).getText().contains("iPhnoe") ||
				((WebElement) elements).getText().contains("IPHONE")) {
			
				List<WebElement> results = 
					driver.findElements(By.cssSelector(".sg-col-20-of-24.s-result-item.sg-col-0-of-12.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-12-of-16.sg-col-24-of-28"));
				
				for (WebElement result : results) {
					
					System.out.println(result.getText());
				}

				List<WebElement> results2 = 
						driver.findElements(By.className("a-price"));
				
				for (WebElement result2 : results2) {
					
					System.out.println(result2.getText());
				}
		}
		else {
			
		}
//		List<WebElement> results = 
//			driver.findElements(By.cssSelector(".sg-col-20-of-24.s-result-item.sg-col-0-of-12.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-12-of-16.sg-col-24-of-28"));
//		
//		for (WebElement result : results) {
//			
//			System.out.println(result.getText());
//		}
//
//		List<WebElement> results2 = 
//				driver.findElements(By.className("a-price"));
//		
//		for (WebElement result2 : results2) {
//			
//			System.out.println(result2.getText());
//		}
		
		Keywords.waitFor(3);
		
		
		driver.close();
		driver.quit();

	}

}
