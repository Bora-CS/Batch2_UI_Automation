package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
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
		
		driver.get("https://www.amazon.com/");
		
		int page = 1;
		List<Result> finalResults = new ArrayList<Result>();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nike");
		driver.findElement(By.id("twotabsearchtextbox")).submit();
		
		while (finalResults.size() < 100) {
			// Repeat from here *********************************
			List<WebElement> results = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']/div/div[starts-with(@data-asin, 'B')]"));
					
			for (int i = 1; i <= results.size(); i++) {
				String parentXpath = "//span[@data-component-type='s-search-results']/div/div[" + i + "]";			
				String title;
				String price;
				
				try {
					title = driver.findElement(By.xpath(parentXpath + "//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
				} catch (Exception e) {
					title = "Title not available";
				}
				
				try {
					price = driver.findElement(By.xpath(parentXpath + "//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']//span[@data-a-size='l']")).getText();
				} catch (Exception e) {
					price = "Price not available";
				}
				
				price = getPrice(price);
							
				if (!price.contains("FREE") && !price.equals("Price not available")) {
//					System.out.println("Item "+ itemNumber + " $" + price + "\t" + title);
					finalResults.add(new Result(title, Double.parseDouble(price)));
					if (finalResults.size() == 100) break;
				}
			}
			// to here *********************************
			if (finalResults.size() == 100) break;
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		
		System.out.println("Item Number\tPrice\tItem Name");
		
		double sum = 0.0;
		for (int i = 0; i < finalResults.size(); i++) {
			System.out.println((i+1) + "\t\t$" + finalResults.get(i).price + "\t" + finalResults.get(i).title);
			sum = sum + finalResults.get(i).price;
		}
		
		System.out.println();
		System.out.println("The average price for Nike is " + sum/100);
		
		Keywords.waitFor(2);

		driver.close();

		driver.quit();

	}
	
	public static String getPrice (String a) {
		a = a.replace("\n", ".").replace("-.", "-").replace(".-", "-").replace("$", "");
		
		if (!a.contains("-")) {
			return a;
		}
		
		String[] prices = a.split("-");
		
		double[] pricesInDouble = new double[prices.length];
		for (int i = 0; i < prices.length; i++) {
			pricesInDouble[i] = Double.parseDouble(prices[i]);
		}
		
		double average = (pricesInDouble[0] + pricesInDouble[1]) / 2;
		
		return (Math.round(average * 100.0) / 100.0) + "";
	}
	
	public static void highlightElement (By locator, WebDriver driver) {
		WebElement elementToHighlight = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elementToHighlight);		
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
