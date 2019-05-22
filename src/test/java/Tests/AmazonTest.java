package Tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest {

	public static void main(String[] args) {

		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();
		driver.get(Constants.APPLICATION_URL);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[2]")));

		WebElement doubleClickButton = driver.findElement(By.id("doubleClick"));

		System.out.println(doubleClickButton.getAttribute("style"));

		Actions action = new Actions(driver);

		action.doubleClick(doubleClickButton).perform();

		Keywords.waitFor(2);

		System.out.println(doubleClickButton.getAttribute("style"));
		driver.switchTo().defaultContent();

		driver.findElement(By.id("firstName")).sendKeys("Hello");

		Keywords.waitFor(2);

		driver.close();

		driver.quit();

	}

}
