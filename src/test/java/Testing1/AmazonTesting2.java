package Testing1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTesting2 {

		public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		WebElement cartLink = driver.findElement(By.id("nav-cart"));
		List<WebElement> spanList = cartLink.findElements(By.tagName("span"));
		
		String actualText = "Cart";
		boolean cartFound = false;
		for (WebElement span : spanList) {
			String spanText = span.getText();
			
			if(actualText.equals(spanText)) {
				cartFound = true;
			}
		}
		if (!cartFound) {
			System.out.println("Cart text is not found");
		}
	
		driver.close();
		driver.quit();
		

	}

}
