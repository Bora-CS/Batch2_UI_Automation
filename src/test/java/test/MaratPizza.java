package test;

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

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);

		driver.findElement(By.id("firstName")).sendKeys("Mansoor");
		Keywords.WaitFor(1);
		driver.findElement(By.id("lastName")).sendKeys("Ahmed");
		Keywords.WaitFor(1);
		driver.findElement(By.id("email")).sendKeys("mansoor4@me.com");
		Keywords.WaitFor(1);
		driver.findElement(By.id("phonenumber")).sendKeys("7032007045");
		Keywords.WaitFor(1);
		driver.findElement(By.id("address")).sendKeys("4387 taft ct");
		Keywords.WaitFor(1);

		WebElement selectCountryElement = driver.findElement(By.id("country"));
		Select country = new Select(selectCountryElement);

		country.selectByVisibleText("United States");

		Keywords.WaitFor(2);

		WebElement selectStateElement = driver.findElement(By.id("state"));
		Select state = new Select(selectStateElement);

		state.selectByVisibleText("Virginia");

		Keywords.WaitFor(2);

		driver.findElement(By.id("zip")).sendKeys("22193");

		Keywords.WaitFor(2);

		List<WebElement> saveAddressInfo = driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
		saveAddressInfo.get(0).findElement(By.tagName("label")).click();

		Keywords.WaitFor(2);

		saveAddressInfo.get(1).findElement(By.tagName("label")).click();

		Keywords.WaitFor(2);

		List<WebElement> cashOrCard = driver.findElements(By.cssSelector(".custom-control.custom-radio"));

		cashOrCard.get(0).findElement(By.tagName("label")).click();

		Keywords.WaitFor(5);

		driver.close();
		driver.quit();

	}
}