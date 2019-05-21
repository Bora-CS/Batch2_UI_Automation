package SeleniumPractices;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOWS);
		WebDriver driver = new ChromeDriver();	
		
		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");

		String target = "Buzz Buzz";
		
		String currentText = driver.findElement(By.id("clock")).getText();
		
		String priviousText = "";
		
		while (!currentText.equals(target)) {
			if(!currentText.equals(priviousText)) System.out.println(currentText);
			priviousText = currentText;
			currentText = driver.findElement(By.id("clock")).getText();
			}
		
		System.out.println(currentText);
				
		driver.close();
		
		driver.quit();
		
	}

	
	public static void switchToNewWindow(WebDriver driver, String main) {
		String newWindowHandle = "";
		for (String handle : driver.getWindowHandles()) {
			if(!handle.equals(main)) newWindowHandle = handle;	
		}
		driver.switchTo().window(newWindowHandle);

	}

}
