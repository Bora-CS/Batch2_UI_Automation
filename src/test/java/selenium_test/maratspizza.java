package selenium_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class maratspizza {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(Constants.APPLICATION_URL);
		
		driver.findElement(By.id("firstName")).sendKeys("Amir");
		driver.findElement(By.id("lastName")).sendKeys("Zia");
		driver.findElement(By.id("email")).sendKeys("imapizzalover@yahoo.com");
		driver.findElement(By.id("phonenumber")).sendKeys("1234567890");
		driver.findElement(By.id("address")).sendKeys("123 main st");
		driver.findElement(By.id("address2")).sendKeys(" ");
		
		
Keywords.waitfor(2);
        
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("United States");
        
        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByVisibleText("Virginia");
        
        driver.findElement(By.id("zip")).sendKeys("22150");
        
        Keywords.waitfor(2);
        
        List<WebElement> checkBox =
                driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
        checkBox.get(0).findElement(By.tagName("label")).click();
        checkBox.get(1).findElement(By.tagName("label")).click();
        
        List<WebElement> cashOrCard =
                driver.findElements(By.cssSelector(".custom-control.custom-radio"));
        cashOrCard.get(0).findElement(By.tagName("label")).click();
        
        Keywords.waitfor(2);
        
        driver.findElement(By.id("cc-name")).sendKeys("Amir Zia");
        driver.findElement(By.id("cc-number")).sendKeys("123-349999");
        driver.findElement(By.id("cc-expiration")).sendKeys("09/23");
        driver.findElement(By.id("cc-cvv")).sendKeys("345");
        
        Keywords.waitfor(5);
        
        driver.close();
        driver.quit();
        
	}

}
