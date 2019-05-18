package Tests;

<<<<<<< HEAD
import org.openqa.selenium.By;
=======
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
>>>>>>> master
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		}
	}
	
	
	
	
	driver.close();
	driver.quit();
}
=======

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");

		String main = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		
		Keywords.waitFor(2);
		
		switchToNewWIndow(driver, main);
		
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		driver.close();
		
		driver.switchTo().window(main);
		
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();

		switchToNewWIndow(driver, main);
		
		System.out.println(driver.getTitle());

		driver.close();

		driver.quit();
	}

	public static void switchToNewWIndow(WebDriver driver, String main) {
		String newWindowHandle = "";
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(main)) newWindowHandle = handle;
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

>>>>>>> master
}
