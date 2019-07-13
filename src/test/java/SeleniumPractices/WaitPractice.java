package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class WaitPractice {

	public static void main(String[] args) {

//		Task:
//		    1, Go to https://tympanus.net/Development/PageLoadingEffects/index.html
//		    2, Validate that you see the "Page Loading Effects" text
//		    3, Click on "SHOW PAGE LOADER"
//		    4, Wait
//		    5, Validate "This is an example for a new page." text
//		    6, Click on "GO BACK"
//		    7, Wait
//		    8, Validate that you see the "Page Loading Effects" text again```

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://tympanus.net/Development/PageLoadingEffects/");

		WebElement textOnFirstPage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/h1[1]"));
		if (textOnFirstPage.isDisplayed()) {
			driver.findElement(By.xpath("//a[contains(text(),'Show Page Loader')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//h2[contains(text(),'This is an example for a new page.')]")));
			WebElement textOnSecondPage = driver
					.findElement(By.xpath("//h2[contains(text(),'This is an example for a new page.')]"));
			if (textOnSecondPage.isDisplayed()) {
				Keywords.waitFor(2);
				driver.findElement(By.xpath("//a[contains(text(),'Go back')]")).click();
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/h1[1]")));
				if (textOnFirstPage.isDisplayed()) {
					System.out.println("We are on the right page");
				}

			}

		}

		driver.close();
		driver.quit();

		
// Teacher's Way
		
		try {
			String homePageTitle = driver.findElement(By.tagName("h1")).getText();
			if (homePageTitle.contains("Page Loading Effects")) {
				driver.findElement(By.xpath("//a[contains(text(),'Show Page Loader')]")).click();
				WebDriverWait waitFor = new WebDriverWait(driver, 10);
				waitFor.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
				String secondPageText = driver.findElement(By.tagName("h2")).getText();
				if (secondPageText.contains("This is an example for a new page")) {
					driver.findElement(By.xpath("//a[contains(text(),'Go back')]")).click();
					waitFor.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
					homePageTitle = driver.findElement(By.tagName("h1")).getText();
					if (homePageTitle.contains("Page Loading Effects")) {
						System.out.println("Test Passed!");
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();

		}

	}

}
