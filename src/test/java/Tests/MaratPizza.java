package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class MaratPizza {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.Driver_PATH_WINDOWS);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);

		driver.findElement(By.id("firstName")).sendKeys("Waseem");

		driver.findElement(By.id("lastName")).sendKeys("Zeid");

		driver.findElement(By.id("email")).sendKeys("Zeidwaseem@gmail.com");

		driver.findElement(By.id("phonenumber")).sendKeys("703-875-3435");

		driver.findElement(By.id("address")).sendKeys("7930 Tire Swing rd");

		Select country = new Select(driver.findElement(By.id("country")));

		country.selectByVisibleText("United States");

		Select state = new Select(driver.findElement(By.id("state")));

		state.selectByVisibleText("Virginia");

		driver.findElement(By.id("zip")).sendKeys("22027");

		List<WebElement> sameAddress = driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));

		sameAddress.get(0).findElement(By.tagName("label")).click();

		sameAddress.get(1).findElement(By.tagName("label")).click();

		driver.findElement(By.id("cc-name")).sendKeys("Waseem M Zeid");

		driver.findElement(By.id("cc-number")).sendKeys("236456789392");

		driver.findElement(By.id("cc-expiration")).sendKeys("05/22");

		driver.findElement(By.id("cc-cvv")).sendKeys("053");

		Keywords.waitFor(7);

		driver.close();

		driver.quit();

	}
}