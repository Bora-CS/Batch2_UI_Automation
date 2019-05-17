package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTestCart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().maximize();
		String actualCart = driver.findElement(By.id("nav-cart-count")).getText();
		String expectCart = "0";

		if (actualCart.equals(expectCart)) {
			System.out.println("The cart is empty");
		} else {
			System.out.println("The cart is not empty");
		}

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("chimmy bt21");
		Keywords.waitFor(1);

		driver.findElement(By.className("nav-input")).click();
		Keywords.waitFor(1);

		List<WebElement> expectedLink = driver.findElements(By.xpath("//span[3]/div/div"));

		expectedLink.get(4).click();
		Keywords.waitFor(2);

		driver.findElement(By.id("add-to-cart-button")).click();
		Keywords.waitFor(2);

		String itemInCart = driver.findElement(By.id("nav-cart-count")).getText();
		String expectItemInCart = "1";

		if (itemInCart.equals(expectItemInCart)) {
			System.out.println("There is 1 item in cart");
		} else {
			System.out.println("Item in cart does not match");
		}

		driver.close();

		driver.quit();

	}
}
