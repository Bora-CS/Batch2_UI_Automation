package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class dragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement money = driver.findElement(By.id("fourth"));
		
		WebElement account = driver.findElement(By.id("amt7"));
		
//		WebElement loan = driver.findElement(By.id("amt7"));
		
		Actions drag = new Actions(driver);
		
		drag.dragAndDrop(money, account).build().perform();
		
		Keywords.waitFor(5);
		
		driver.close();

		driver.quit();
		
	}

}
