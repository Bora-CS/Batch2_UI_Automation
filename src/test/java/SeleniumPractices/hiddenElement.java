package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;

public class hiddenElement {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);
		
		WebElement continueButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.btn-block"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click()", continueButton);
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		//try to send keys to a disabled text box
		js.executeScript("arguments[0].value = 'Shirin'", firstName);

		
		driver.close();
		driver.quit();
		

	}

}
