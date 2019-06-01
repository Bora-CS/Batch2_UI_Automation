package SeleniumPractices;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;

public class WaitCommands {

	public static void main(String[] args) {

//	    an element is not present in DOM(Document Object Model: HTML)
//		an element is present but not visible
//		an element is present but not enabled
		
		
//***************************Implicit Wait***************************************
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//don't wait too long
		
//***************************Explicit Wait***************************************
		WebDriverWait waitFor = new WebDriverWait(driver, 15);//polling every 500 ms
		waitFor.until(ExpectedConditions.alertIsPresent());//waited until alert show up
		
//***************************Fluent Wait***************************************
//		A WebDriverWait is a fluent wait
//		configure the timeout, polling time
		FluentWait<WebDriver> advancedWait = new FluentWait<WebDriver>(driver)
												.withTimeout(Duration.ofSeconds(30))
												.pollingEvery(Duration.ofSeconds(2))
												.ignoring(NoSuchElementException.class);
		
		//advancedWait.until();
		
	}

}
