package SeleniumPractices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//***************************Explicit Wait***************************************
		WebDriverWait waitFor = new WebDriverWait(driver, 15);
		waitFor.until(ExpectedConditions.alertIsPresent());//waited until alert show up
		
		
		
		
	}

}
