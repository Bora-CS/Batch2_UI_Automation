package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class TestSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();

		String main = driver.getWindowHandle();

		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		Keywords.waitFor(2);
		switchToNewWindow(driver, main);

		System.out.println(driver.findElement(By.tagName("body")).getText());
		driver.close();
		driver.switchTo().window(main);
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();

		switchToNewWindow(driver, main);

		System.out.println(driver.getTitle());

		driver.close();

		driver.quit();
		
	}

	public static void switchToNewWindow(WebDriver driver, String main) {
		String newWindowHandle = "";
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(main))
				newWindowHandle = handle;

		}
		driver.switchTo().window(newWindowHandle);
	}

}