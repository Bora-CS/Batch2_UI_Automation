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
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(Constants.APPLICATION_URL);
		
		Keywords.waitFor(2);

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("United States");
		
		Keywords.waitFor(2);
		
		List<WebElement> cashOrCard = 
				driver.findElements(By.cssSelector(".custom-control.custom-radio"));
		cashOrCard.get(1).findElement(By.tagName("label")).click();
		
		Keywords.waitFor(2);
		
		driver.close();
		
		driver.quit();
		
	}
	
}
