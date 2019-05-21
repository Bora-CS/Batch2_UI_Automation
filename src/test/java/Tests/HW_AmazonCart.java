package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class HW_AmazonCart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.amazon.com/");
		
//		driver.manage().window().maximize();
		
		getItemNumbersInCart(driver);
		
		searchAndAddToCart(driver, "Pencil", "AmazonBasics Pre-sharpened Wood Cased #2 HB Pencils, 150 Pack");
		
		searchAndAddToCart(driver, "pizza cutter", "Kitchy Pizza Cutter Wheel - Super Sharp and Easy To Clean Slicer, Kitchen Gadget with Protective Blade Guard (Green)");
				
		getItemNumbersInCart(driver);
		
		driver.close();
		
		driver.quit();
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
