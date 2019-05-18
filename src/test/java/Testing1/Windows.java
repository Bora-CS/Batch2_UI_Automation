package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Windows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
		
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		
		String main = driver.getWindowHandle();
		
		
		System.out.println(main);
		
		Keywords.waitFor(2);
		
		driver.close();
		
		driver.quit();

	}

}
