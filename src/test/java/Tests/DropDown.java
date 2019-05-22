package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		
		WebElement bank = driver.findElement(By.partialLinkText("Bank"));
		WebElement slot = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		Actions action = new Actions(driver);
		
		action.dragAndDrop(bank, slot).build().perform();
		Keywords.waitFor(3);
		
		
		driver.close();
		driver.quit();
	}

}
