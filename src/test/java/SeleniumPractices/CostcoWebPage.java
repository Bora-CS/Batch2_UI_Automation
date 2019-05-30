package SeleniumPractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class CostcoWebPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.costco.com/");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement macPage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@id,'slick-slide')]//img[contains(@title,'$150 OFF MacBook Pro 13.3-inch.')][1])")));
		macPage.click();
		Keywords.waitFor(1);

		List<WebElement> resultSearch = driver.findElements(By.className("product-tile-set"));
		System.out.println(resultSearch.size());
		resultSearch.get(0).click();
		driver.findElement(By.id("add-to-cart-btn")).click();
		WebDriverWait waitFor = new WebDriverWait(driver, 30);
		waitFor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'View Cart')]")))
				.click();

		String itemText = driver.findElement(By.className("product-title")).getText();
		WebElement checkOut = driver.findElement(By.id("shopCartCheckoutSubmitButton"));
		if (itemText.equals("Apple MacBook Pro 13.3\" - Intel Core i5 - 8GB Memory - 256GB SSD - Silver")
				&& checkOut.isDisplayed()) {
			System.out.println("Test passed: item added to cart successfully.");

		}

		driver.close();
		driver.quit();

	}

}
