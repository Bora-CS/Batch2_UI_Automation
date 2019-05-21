package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Amazon_Elements {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		
		Keywords.waitFor(1);
		
		WebElement theCartLink = driver.findElement(By.id("nav-cart"));
		
		WebElement cartEle = theCartLink.findElements(By.tagName("span")).get(1);
		
		Keywords.waitFor(3);

		if (!cartEle.isDisplayed()) {
			System.out.println("Error: Cart element is not displayed");
		} else {
			String displayedText = cartEle.getText();
			String expectedText = "Cart";
			
			if (displayedText.equals(expectedText)) {
				System.out.println(" The \"Cart\" text is there");
			} else {
				System.out.println(" The \"Cart\" text is not there");
				System.out.println("What's actually displayed " + displayedText);
			}
		}
		
		// Solution 2:
		
		List<WebElement> spanList = theCartLink.findElements(By.tagName("span"));
		
		String actualText = "Cart";
		
		boolean cartFound = false;
		for (WebElement span : spanList) {
			String spanText = span.getText();
			if (actualText.contentEquals(spanText)) {
				cartFound = true;
				System.out.println(actualText + " is found");
		}
		}
		if (!cartFound) {
			System.out.println("Cart text is not found");
		}

		driver.close();
		driver.quit();
	}

}
