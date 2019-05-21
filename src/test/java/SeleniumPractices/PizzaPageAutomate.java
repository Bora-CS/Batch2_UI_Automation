package SeleniumPractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class PizzaPageAutomate {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOWS);
		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);

		Keywords.waitFor(2);

		
		driver.findElement(By.id("firstName")).sendKeys("Shirinay");
		driver.findElement(By.id("lastName")).sendKeys("Kurban");
		driver.findElement(By.id("email")).sendKeys("kxirnay@gmail.com");
		driver.findElement(By.id("phonenumber")).sendKeys("571-666-8888");
		driver.findElement(By.id("address")).sendKeys("134 Main St");
		
		
		Select countryOptions = new Select(driver.findElement(By.id("country")));
		countryOptions.selectByVisibleText("United States");
		
		
		Select stateOptions = new Select(driver.findElement(By.id("state")));
		stateOptions.selectByVisibleText("Virginia");
		
		driver.findElement(By.id("zip")).sendKeys("22031");
		Keywords.waitFor(2);

		
//		for the two check boxes
		driver.findElement(By.className("custom-control-label")).click();
		Keywords.waitFor(2);
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[7]/label")).click();
		
		
		List<WebElement> paymentType = driver.findElements(By.cssSelector(".custom-control.custom-radio"));
//	    for credit card payment option
		paymentType.get(0).findElement(By.tagName("label")).click();
		driver.findElement(By.id("cc-name")).sendKeys("Shirinay Kurban");
		driver.findElement(By.id("cc-number")).sendKeys("1234567887654321");
		driver.findElement(By.id("cc-expiration")).sendKeys("07/22");
		driver.findElement(By.id("cc-cvv")).sendKeys("639");
		Keywords.waitFor(2);

		
//		for cash options
//		paymentType.get(1).findElement(By.tagName("label")).click();
		
//      for checking out
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/button")).click();
		
		Keywords.waitFor(3);
		
		driver.close();
		driver.quit();
	}

}
