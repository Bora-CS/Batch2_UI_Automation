package automateWebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonWebPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.APPLICATION_URL);
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("https://www.amazon.com");
		Keywords.waitFor(1);

		String amzonTitle = myDriver.getCurrentUrl();
		String currentTitle = "https://www.amazon.com/";
		if (amzonTitle.equals(currentTitle)) {
			System.out.println("I am on the Amazon HomePage!");
		}

		String emptyCart = myDriver.findElement(By.id("nav-cart-count")).getText();
		Keywords.waitFor(1);
		String expectedNum = "0";
		if (emptyCart.equals(expectedNum)) {
			System.out.println("There are 0 item in the cart!");
		} else {
			System.out.println("Cart is not empty!");
		}
		Keywords.waitFor(1);

		myDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Japanese hair mask");
		Keywords.waitFor(1);
		myDriver.findElement(By.className("nav-input")).click();
		Keywords.waitFor(1);
		List<WebElement> expectedLink = myDriver.findElements(By.xpath("//span[3]/div/div"));
		expectedLink.get(3).click();
		Keywords.waitFor(1);
		Boolean isAddToCartButtonDisplayed = myDriver.findElement(By.id("add-to-cart-button")).isDisplayed();

		if (isAddToCartButtonDisplayed) {
			myDriver.findElement(By.id("add-to-cart-button")).click();
			Keywords.waitFor(1);

		}

		Boolean isContinueToCartDisplayed = myDriver.findElement(By.id("smartShelfAddToCartContinue")).isDisplayed();
		if (isContinueToCartDisplayed) {
			myDriver.findElement(By.id("smartShelfAddToCartContinue")).click();
			Keywords.waitFor(1);
		}

		myDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("gti keychain");
		Keywords.waitFor(1);
		myDriver.findElement(By.className("nav-input")).click();
		Keywords.waitFor(1);

		List<WebElement> expectedLink2 = myDriver.findElements(By.xpath("//span[3]/div/div"));
		expectedLink2.get(3).click();
		Keywords.waitFor(1);
		Boolean isAddToCartButton2Displayed = myDriver.findElement(By.id("add-to-cart-button")).isDisplayed();
		if (isAddToCartButton2Displayed) {
			myDriver.findElement(By.id("add-to-cart-button")).click();
			Keywords.waitFor(1);

		}

		String cartWithItems = myDriver.findElement(By.id("nav-cart-count")).getText();
		Keywords.waitFor(1);

		String expectedItems = "2";
		if (cartWithItems.equals(expectedItems)) {
			System.out.println("There are " + expectedItems + " items in the cart!");
		} else {
			System.out.println("Item numbers don't match!");
		}
		Keywords.waitFor(1);

		myDriver.close();
		myDriver.quit();
	}

}
