package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;

public class WaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

        WebDriver driver = new ChromeDriver();

        driver.get("https://tympanus.net/Development/PageLoadingEffects/index.html");
        
      
        try {
        	String homePageTitle = driver.findElement(By.tagName("h1")).getText();
			if (homePageTitle.contains("Page Loading Effects")) {
				driver.findElement(By.xpath("//a[contains(text(),'Show Page Loader')]")).click();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
				String secondPageText = driver.findElement(By.tagName("h2")).getText();
				if (secondPageText.contains("This is an example for a new page.")) {
					driver.findElement(By.xpath("//a[contains(text(),'Go back')]")).click();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
					homePageTitle = driver.findElement(By.tagName("h1")).getText();
					if (homePageTitle.contains("Page Loading Effects")) {
						System.out.println("Test Passed");
					} else {
						System.out.println("Test Failed: Homepage Title \"Page Loading Effects\" is not shown.");
						System.out.println("Actual Text: " + homePageTitle);
					}
				} else {
					System.out.println("Test Failed: Second Page Title \"This is an example for a new page.\" is not shown.");
					System.out.println("Actual Text: " + secondPageText);
				}
			} else {
				System.out.println("Test Failed: Homepage Title \"Page Loading Effects\" is not shown.");
				System.out.println("Actual Text: " + homePageTitle);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}}
