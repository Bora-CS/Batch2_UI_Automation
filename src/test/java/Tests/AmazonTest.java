package Tests;


import org.openqa.selenium.By;
<<<<<<< HEAD
=======
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
>>>>>>> master
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest {

<<<<<<< HEAD
	
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
=======
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
>>>>>>> master
		}
	}
<<<<<<< HEAD
	
	
	
	
	driver.close();
	driver.quit();
}
=======

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

>>>>>>> master
}
