
package Tests;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import BoraTech.Batch2_UI_Automation.Keywords;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumframeworkpractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Waseem\\e" + "clipse-workspace\\Batch2_UI_A"
				+ "utomation\\sr" + "c\\test\\resource\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");

		String mainHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();

		Set<String> handles = driver.getWindowHandles();

		String newWindow = "";

		for (String setHandles : handles) {

			if (!setHandles.equals(handles)) {
				newWindow = setHandles;
			}

			driver.switchTo().window(newWindow);
			
			
			
		}

	}

}