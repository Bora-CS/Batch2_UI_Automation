package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonActionTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.com/");
		
		WebElement account = driver.findElement(By.id("nav-link-accountList"));
		WebElement tryPrime = driver.findElement(By.id("nav-link-prime"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(account).build().perform();
		
		Keywords.waitFor(3);
		
		act.moveToElement(tryPrime).build().perform();
		
		Keywords.waitFor(3);
		
		driver.close();
		driver.quit();
		
		


	}

}
