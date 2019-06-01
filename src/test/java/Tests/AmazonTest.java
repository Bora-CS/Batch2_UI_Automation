package Tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest {

	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("user.dir"));
		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
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

	public static void switchToNewWIndow(WebDriver driver, String main) {
		String newWindowHandle = "";
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(main))
				newWindowHandle = handle;
		}
		driver.switchTo().window(newWindowHandle);
	}

	public static void searchAndAddToCart(WebDriver driver, String itemName, String itemLinktext) {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys(itemName);
		searchBox.submit();
		List<WebElement> results = driver.findElements(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal"));
		for (WebElement result : results) {
			if (result.getText().equals(itemLinktext)) {
				result.click();
				break;
			}
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		Keywords.waitFor(2);
		try {
			driver.findElement(By.id("attach-close_sideSheet-link")).click();
			Keywords.waitFor(1);
		} catch (NoSuchElementException e) {
		} catch (ElementNotVisibleException e) {
		}
		driver.navigate().refresh();
	}

	public static void getItemNumbersInCart(WebDriver driver) {
		int a = Integer.valueOf(driver.findElement(By.id("nav-cart")).getAttribute("aria-label").split(" ")[0]);
		System.out.println("We currently have " + a + " items in cart.");


	}
}
