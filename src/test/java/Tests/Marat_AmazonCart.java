package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Marat_AmazonCart {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		
		Keywords.waitFor(1);
		
		String itemsInCart = driver.findElement(By.id("nav-cart-count")).getText();
		
		String numbOfItems = "0";
		
		if (!itemsInCart.equals(numbOfItems)) {
			
			System.out.println("Please checkout first or empty the Cart");
			
		} else {
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Pizza boxes");
			Keywords.waitFor(1);
			driver.findElement(By.id("twotabsearchtextbox")).submit();
			Keywords.waitFor(1);
			driver.findElement(By.linkText("W PACKAGING WPPB8KP 8\" Kraft/Kraft Plain Pizza Box, 1-5/8\" Deep, "
					+ "B-Flute (Pack of 50)")).click();
			Keywords.waitFor(1);
			driver.findElement(By.id("size_name_3")).click();
			
			Keywords.waitFor(1);
			driver.findElement(By.id("add-to-cart-button")).click();
			Keywords.waitFor(1);
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Pizza cutter");
			Keywords.waitFor(1);
			driver.findElement(By.id("twotabsearchtextbox")).submit();
			Keywords.waitFor(1);
			driver.findElement(By.linkText("Kitchy Pizza Cutter Wheel - Super Sharp and Easy To Clean Slicer, "
					+ "Kitchen Gadget with Protective Blade Guard (Green)")).click();
			Keywords.waitFor(1);
			driver.findElement(By.id("color_name_2")).click();;
			Keywords.waitFor(1);
			
			WebElement selectQuantity = driver.findElement(By.id("quantity"));
			Keywords.waitFor(1);
			
			Select quantity = new Select(selectQuantity);
			
			quantity.selectByVisibleText("4");
			Keywords.waitFor(2);
		
			driver.findElement(By.id("add-to-cart-button")).click();
			Keywords.waitFor(3);
			
			String fiveItemsInCart = driver.findElement(By.id("nav-cart-count")).getText();
			String numbOfItems2 = "5";
			
			if (fiveItemsInCart.equals(numbOfItems2)) {
				
				System.out.println("There are " + numbOfItems2 + " items in cart. Ready for checkout!");
				driver.findElement(By.cssSelector(".checkout-form.a-spacing-none input")).click();
		}
		driver.close();
		driver.quit();
		
	}
	}
}
