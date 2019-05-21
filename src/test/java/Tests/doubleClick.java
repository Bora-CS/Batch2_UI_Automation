package Tests;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class doubleClick {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
		
		 WebElement doubleClickButton = driver.findElement(By.id("doubleClick"));
	
		
		System.out.println(doubleClickButton.getAttribute("style"));
		Actions action = new Actions(driver);
		
		action.doubleClick().perform();
		Keywords.waitFor(2);
		System.out.println(doubleClickButton.getAttribute("style"));
		
		
		driver.close();
		
		driver.quit();
	}

}
