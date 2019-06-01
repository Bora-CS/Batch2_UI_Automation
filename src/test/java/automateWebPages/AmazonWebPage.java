package automateWebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonWebPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
		
		WebDriver myDriver = new ChromeDriver();
		
		myDriver.get("https://www.amazon.com/");
		myDriver.navigate().to("https://www.google.com/");
		myDriver.close();
		myDriver.quit();
	}

}
