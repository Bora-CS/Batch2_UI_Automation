package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;

public class WaitCommandTask {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://tympanus.net/Development/PageLoadingEffects/index.html");
		
		try {
			String homepageTitle = driver.findElement(By.tagName("h1")).getText();
			if(homepageTitle.contains("Page Loading Effects ")) {
				System.out.println();
				
				
				driver.findElement(By.xpath("//a[contains(text(),'Go back')]"));
				
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
			homepageTitle = driver.findElement(By.tagName("h1")).getText();
			
			
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
		
		
		
		
		
		

	}

}
