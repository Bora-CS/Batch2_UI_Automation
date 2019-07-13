package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class dragAndDropPizzaPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);

		WebElement box = driver.findElement(By.id("div1"));
		WebElement pizza2 = driver.findElement(By.id("drag1"));
		WebElement pizza3 = driver.findElement(By.id("drag2"));
		WebElement pizza1 = driver.findElement(By.id("drag3"));
		
		Actions action = new Actions(driver);

//		action.dragAndDrop(pizza1, box).build().perform();
//		Keywords.waitFor(2);
		
		action.clickAndHold(pizza1).moveToElement(box).release().perform();;
		Keywords.waitFor(2);
		
		driver.close();
		driver.quit();
	}
}
