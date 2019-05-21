package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest {

	
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

	WebDriver driver = new ChromeDriver();

	driver.navigate().to("https:/www.amazon.com/");
	Keywords.waitFor(1);
	
	WebElement theCartLink = driver.findElement(By.id("nav-cart"));
	WebElement targetEle = theCartLink.findElements(By.tagName("span")).get(1);
	
	Keywords.waitFor(3);
	
	if(!targetEle.isDisplayed()) {
		System.out.println( "Error: Cart Element is not displayed");
		
	}else {
		String displayedText = targetEle.getText();
		String expectedText = "Cart";
		
		if(displayedText.equals(expectedText)) {
			System.out.println("The \"cart\" text is there");
			
		}else {
			System.out.println("The \"cart\" text is not there");
			System.out.println("what's acctually displayed:" + displayedText);
		}
	}
	
	
	
	
	driver.close();
	driver.quit();
}
}
