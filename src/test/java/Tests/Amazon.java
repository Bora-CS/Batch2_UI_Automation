package Tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com");
		Keywords.waitFor(1);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("MacBook air case");
		
		driver.findElement(By.className("nav-input")).click();
		Keywords.waitFor(2);
		
		
		driver.findElement(By.xpath("//span[@class=a-size-base-plus a-color-base a-text-normal]/span[@class= a-price-whole)]")).getText();
		ArrayList<String> myList = new ArrayList<String>();
		
		
		    
		for (int i = 0; i < myList.size(); i++) {
			driver.findElement(By.xpath("//span[@class=a-size-base-plus a-color-base a-text-normal]/span[@class= a-price-whole)]")).getText();
			
		}

		System.out.println(myList.size());
		
		
		
		
		driver.close();
		driver.quit();
		
		
		

	}


public static void switchToNewWIndow(WebDriver driver, String main) {
	String newWindowHandle = "";
	for (String handle : driver.getWindowHandles()) {
		if (!handle.equals(main))
			newWindowHandle = handle;
	}
	driver.switchTo().window(newWindowHandle);
}

}
