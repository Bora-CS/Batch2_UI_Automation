package Tests;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;

public class amazonPractice {

	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOWS);

		WebDriver driver = new ChromeDriver();

	
		
		driver.close();
		
		driver.quit();
	}

}
