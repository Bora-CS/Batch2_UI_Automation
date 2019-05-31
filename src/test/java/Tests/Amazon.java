package Tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.costco.com/");
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("slick-slide04")));
		
		driver.findElement(By.xpath("//img[contains(@title,'Apple Watch Series 4 GPS Only']")).click();
	   			
		driver.close();
		driver.quit();
		
	
		

	}


public static void switchToNewWIndow(WebDriver driver, String main) {
	String newWindowHandle = "";
	for (String handle : driver.getWindowHandles()) {
		if (!handle.equals(main))
			newWindowHandle = handle;
	}
	driver.switchTo().window(newWindowHandle);
}

}
