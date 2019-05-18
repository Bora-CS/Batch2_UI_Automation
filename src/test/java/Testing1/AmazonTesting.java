package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTesting {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		WebElement link = driver.findElement(By.id("nav-cart"));
		WebElement cart = link.findElements(By.className("nav-line-2")).get(0);
		
		Keywords.waitFor(2);
		
		if(!cart.isDisplayed()) {
			System.out.println("Error!");
		} else {
			String text = cart.getText();
			String expectedText = "Cart";
			
			if (text.equals(expectedText)) {
				System.out.println("Text is there");
			} else {
				System.out.println("Text is NOT there");
			}
		}
		
		driver.close();
		driver.quit();

	}

}
