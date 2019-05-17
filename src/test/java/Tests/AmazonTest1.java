package Tests;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https:/www.amazon.com/");
		Keywords.waitFor(1);
		
		WebElement theCartLink = driver.findElement(By.id("nav-cart"));
		List<WebElement> spanList = theCartLink.findElements(By.tagName("span"));
		
		String actualCartText = "Cart";
		boolean cartFound = false;
		for (WebElement span : spanList) {
			String spanText = span.getText();
			if(actualCartText.equals(spanText)) {
				cartFound = true;
			}
			
			
		}
		if(!cartFound) {
			System.out.println("Cart Text is not found");
		}
		Keywords.waitFor(3);

	}

}
