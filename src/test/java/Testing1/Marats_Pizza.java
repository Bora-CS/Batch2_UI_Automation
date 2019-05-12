package Testing1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Marats_Pizza {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(Constants.APPLICATION_URL);
		
		driver.findElement(By.id("firstName")).sendKeys("Ruslan");
		driver.findElement(By.id("lastName")).sendKeys("Ibrahimov");
		driver.findElement(By.id("email")).sendKeys("ruslanibrahimoff@gmail.com");
		driver.findElement(By.id("phonenumber")).sendKeys("516-800-1752");
		driver.findElement(By.id("address")).sendKeys("6615 Comet Circle");
		
		Keywords.waitFor(2);
		
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("United States");
		
		Select state = new Select(driver.findElement(By.id("state")));
		state.selectByVisibleText("Virginia");
		
		driver.findElement(By.id("zip")).sendKeys("22150");
		
		Keywords.waitFor(2);
		
		List<WebElement> checkBox =
				driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
		checkBox.get(0).findElement(By.tagName("label")).click();
		checkBox.get(1).findElement(By.tagName("label")).click();
		
		List<WebElement> cashOrCard =
				driver.findElements(By.cssSelector(".custom-control.custom-radio"));
		cashOrCard.get(0).findElement(By.tagName("label")).click();
		
		Keywords.waitFor(2);
		
		driver.findElement(By.id("cc-name")).sendKeys("Ruslan Ibrahimov");
		driver.findElement(By.id("cc-number")).sendKeys("123-345-678-9999");
		driver.findElement(By.id("cc-expiration")).sendKeys("09/23");
		driver.findElement(By.id("cc-cvv")).sendKeys("345");
		
		Keywords.waitFor(5);
		
		driver.close();
		driver.quit();
		
	}

}
