package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class iFrame_Practice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		
		WebElement doubleClickButton = driver.findElement(By.id("doubleClick"));
		
		Actions action = new Actions(driver);
		
		action.doubleClick(doubleClickButton).perform(); //perform method from Actions class
		
		Keywords.waitFor(2);
		
		System.out.println(doubleClickButton.getAttribute("style"));
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("firstName")).sendKeys("Hello!");
		
		Keywords.waitFor(2);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		
		action.doubleClick(doubleClickButton).perform();
		
		Keywords.waitFor(2);
		
		System.out.println(doubleClickButton.getAttribute("style"));
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("firstName")).sendKeys("How are you?");
		
		Keywords.waitFor(2);
		
		driver.close();

		driver.quit();
	}

}
