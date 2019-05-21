package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Windows2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		
		Keywords.waitFor(1);
		
		driver.findElement(By.id("alert")).click();
		
		Keywords.waitFor(1);
		
		driver.switchTo().alert().accept();
		
		Keywords.waitFor(1);
		
		driver.close();
		driver.quit();

	}

}
