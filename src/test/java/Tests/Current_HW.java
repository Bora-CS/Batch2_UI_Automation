package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Current_HW {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();
	
		driver.navigate().to("https://www.amazon.com/");
		
		Keywords.waitFor(1);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Pizza cutter");
		Keywords.waitFor(1);
		driver.findElement(By.id("twotabsearchtextbox")).submit();
		Keywords.waitFor(1);
		
		List<WebElement> results = driver.findElements(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal"));
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price'][1]/span"));
		
		for (int i = 0; i < prices.size(); i++) {
		     WebElement result = prices.get(i);
		     WebElement price = results.get(i);

		     System.out.println(price.getText().replace("\n", ".").trim() + "\t:" + result.getText());
		 }
		
		driver.close();
		driver.quit();
	}
	
}

