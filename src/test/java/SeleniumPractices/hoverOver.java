package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Keywords;

public class hoverOver {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "src/Resources/chromedriver");
		WebDriver myDriver = new ChromeDriver();

		myDriver.navigate().to("https://www.amazon.com/");
		
		WebElement account = myDriver.findElement(By.id("nav-link-account"));
		
		Actions act = new Actions(myDriver);
		
		act.moveToElement(account).build().perform();
		
		Keywords.waitFor(3);
		
		myDriver.close();
		myDriver.quit();
		
		
	}

}
