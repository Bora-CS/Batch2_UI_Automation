package testPractise;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Practisetest {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(Constants.APPLICATION_URL);
		
		driver.findElement(By.id("firstName")).sendKeys("pizza");
		driver.findElement(By.id("lastName")).sendKeys("lover");
		driver.findElement(By.id("email")).sendKeys("pizzalover25@gmail.com");
		driver.findElement(By.id("phonenumber")).sendKeys("223-128-3422");
		driver.findElement(By.id("address")).sendKeys("4935 wilderness glen");
		driver.findElement(By.id("address2")).sendKeys("  						");
		
		WebElement selectCountryElement = driver.findElement(By.id("country"));
		Select country = new Select(selectCountryElement);
		
		country.selectByVisibleText("United States");
		
		Keywords.waitFor(3);
		
		WebElement selectStateElement = driver.findElement(By.id("state"));
		Select state = new Select(selectStateElement);
		
		state.selectByVisibleText("Virginia");
		
		driver.findElement(By.id("zip")).sendKeys("77203");
		
		Keywords.waitFor(3);
		
		List<WebElement> savedAddress = driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
		savedAddress.get(0).findElement(By.tagName("label")).click();
		
		Keywords.waitFor(3);
		
		List<WebElement> sameAddress = driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
		sameAddress.get(1).findElement(By.tagName("label")).click();
		
		List<WebElement> cashOrcard = driver.findElements(By.cssSelector(".custom-control.custom-radio"));
		cashOrcard.get(1).findElement(By.tagName("label")).click();
		
		Keywords.waitFor(3);
		
		driver.close();
		driver.quit();
		
	}

	
		
	}


