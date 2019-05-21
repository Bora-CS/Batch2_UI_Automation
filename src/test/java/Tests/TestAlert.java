package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class TestAlert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();

		driver.findElement(By.id("alert")).click();
		Keywords.waitFor(2);

		driver.switchTo().alert().accept();
		
		
		
		driver.close();

		driver.quit();
	}

}
