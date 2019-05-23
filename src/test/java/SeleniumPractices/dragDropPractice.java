package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class dragDropPractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement bank = driver.findElement(By.partialLinkText("BANK"));
		WebElement slot1 = driver.findElement(By.id("bank"));
		Keywords.waitFor(3);
		
		WebElement sale = driver.findElement(By.partialLinkText("SALES"));
		WebElement slot2 = driver.findElement(By.id("loan"));
		
		WebElement num = driver.findElement(By.partialLinkText("5000"));
		WebElement slot3 = driver.findElement(By.id("amt8"));
		Actions action = new Actions(driver);
		
		action.dragAndDrop(bank, slot1).build().perform();
		action.dragAndDrop(sale, slot2).build().perform();
		action.dragAndDrop(num, slot3).build().perform();

		Keywords.waitFor(3);
		
		driver.close();
		driver.quit();

	}

}
