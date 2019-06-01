package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Windows3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		
		WebElement bank = driver.findElement(By.partialLinkText("BANK"));
		
		WebElement box1 = driver.findElement(By.xpath("//*[@id='bank']/li"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(bank, box1).build().perform();
		Keywords.waitFor(2);
		
		WebElement cash = driver.findElement(By.partialLinkText("5000"));

		WebElement box2 = driver.findElement(By.xpath("//*[@id='amt7']/li"));

		Actions act2 = new Actions(driver);
		
		act2.dragAndDrop(cash, box2).build().perform();
		Keywords.waitFor(2);

		
		driver.close();
		driver.quit();
	}

}
