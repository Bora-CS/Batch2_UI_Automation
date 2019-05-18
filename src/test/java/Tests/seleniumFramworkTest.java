package Tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class seleniumFramworkTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();

		String main = driver.getWindowHandle();
		System.out.println("Handle for main window:" + main);
		System.out.println("Title for main window is" + driver.getTitle());

		driver.findElement(By.id("button1")).click();
		Keywords.waitFor(2);

		Set<String> handles = driver.getWindowHandles();

		String handleForNewWindow = "";
		for (String handle : handles) {
			if (!handle.equals(main)) {
				System.out.println("Handle for new window:" + main);
				handleForNewWindow = handle;
			}

		}
		driver.switchTo().window(handleForNewWindow);
		System.out.println("Title of the new window" + driver.getTitle());

		driver.findElement(By.linkText("How to Choose the Solution")).click();
		Keywords.waitFor(2);
		
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		
		

		driver.close();

		driver.quit();
	}

}
