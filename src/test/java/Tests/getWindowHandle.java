package Tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class getWindowHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");

		String main = driver.getWindowHandle();

//		System.out.println("Handle for main window: " + main);
//		System.out.println("Title for main window: " + driver.getTitle());
//		
//		Keywords.waitFor(2);
//
//		driver.findElement(By.id("button1")).click();
//
//		Keywords.waitFor(2);
//
//		Set<String> handles = driver.getWindowHandles();
//		
//		String handleForNewWindow = "";
//		for (String handle : handles) {
//			if (!handle.equals(main)) {
//				System.out.println("Handle for new window: " + handle);
//				handleForNewWindow = handle;
//			}
//		}
//		driver.switchTo().window(handleForNewWindow);
//		System.out.println("Title for new window: " + driver.getTitle());
//
//		driver.findElement(By.linkText("How to Choose a Solution")).click();
//		Keywords.waitFor(2);
//		
//		driver.close();
//		
//		driver.switchTo().window(main);
//		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
//		
//		Keywords.waitFor(2);
//		driver.close();
//		driver.quit();
	
		
//		Task:
//			1, Open the page
//			2, Click on "New Message Window"
//			3, Switch to that window and get the text, print it out
//			4, Close that window, come back to main, click on "New Browser Tab"
//			5, Switch onto new tab, get the title, print it out

		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		
		Keywords.waitFor(2);
		
		switchToNewWIndow(driver, main);
		
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		driver.close();
		
		driver.switchTo().window(main);
		
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();

		switchToNewWIndow(driver, main);
		
		System.out.println(driver.getTitle());

		driver.close();

		driver.quit();
	}

	public static void switchToNewWIndow(WebDriver driver, String main) {
		String newWindowHandle = "";
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(main)) newWindowHandle = handle;
		}
		driver.switchTo().window(newWindowHandle);
	}
	}
