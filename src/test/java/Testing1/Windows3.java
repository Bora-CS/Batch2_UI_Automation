package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;

public class Windows3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		
		
		
		
		
//		for (int i = 0; i < 200; i++) {
//			System.out.println(driver.findElement(By.id("clock")).getText());
//		}
		
		driver.close();
		driver.quit();
	}

}
