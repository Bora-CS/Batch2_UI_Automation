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

	

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		
		Actions action = new Actions(driver);
		
		WebElement Bank = driver.findElement(By.partialLinkText(" BANK "));
				
	    WebElement number = driver.findElement(By.partialLinkText(" 5000"));	
	    
	    WebElement slot = driver.findElement(By.xpath("//ol[@id= 'bank']/li"));
		
		action.dragAndDrop(Bank,slot ).build().perform();
		
		action.dragAndDrop(number,slot ).build().perform();
		
        Keywords.waitFor(2);
		
		driver.close();
		
		driver.quit();


		
		
		
		
		
		
		
		/*driver.switchTo().frame(driver.findElement(By.id("frame1")));
		
		WebElement doubleClickButton = driver.findElement(By.id("doubleClick"));
		
		System.out.println(doubleClickButton.getAttribute("style"));
		
		Actions action0 = new Actions(driver);
		
		action0.doubleClick(doubleClickButton).perform();
		
		Keywords.waitFor(2);
		
		System.out.println(doubleClickButton.getAttribute("style"));
		
         driver.switchTo().frame(driver.findElement(By.xpath("//frame[2]")));
		
		WebElement doubleClickButton1 = driver.findElement(By.id("doubleClick"));
		
		System.out.println(doubleClickButton.getAttribute("style"));
		
		Actions action1 = new Actions(driver);
		
		action1.doubleClick(doubleClickButton1).perform();
		
		Keywords.waitFor(2);
		
		System.out.println(doubleClickButton1.getAttribute("style"));
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("firstName")).sendKeys("Hello");
		*/
		
		
		
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
