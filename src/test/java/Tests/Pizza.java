package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Pizza {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_WINDOWS);

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(Constants.APPLICATION_URL);
		Keywords.waitFor(1);

//		driver.findElement(By.id("firstName")).sendKeys("Kamontip");
//		Keywords.waitFor(1);
//
//		driver.findElement(By.id("lastName")).sendKeys("Wu");
//		Keywords.waitFor(1);
//
//		driver.findElement(By.id("email")).sendKeys("kamontip_rose@hotmail.com");
//		Keywords.waitFor(1);
//
//		driver.findElement(By.id("phonenumber")).sendKeys("571-241-1952");
//		Keywords.waitFor(1);
//
//		driver.findElement(By.id("address")).sendKeys("2218 Cheverly Ave");
//		Keywords.waitFor(1);
//
//		WebElement selectCountryElement = driver.findElement(By.id("country"));
//		Select country = new Select(selectCountryElement);
//		country.selectByVisibleText("United States");
//		Keywords.waitFor(2);
//
//		WebElement selectStateElement = driver.findElement(By.id("state"));
//		Select state = new Select(selectStateElement);
//		state.selectByVisibleText("Maryland");
//		Keywords.waitFor(2);
//
//		driver.findElement(By.id("zip")).sendKeys("20785");
//		Keywords.waitFor(2);
//		
//		List<WebElement> saveAddressInfo = driver.findElements(By.cssSelector
//						(".custom-control.custom-checkbox"));
//		saveAddressInfo.get(0).findElement(By.tagName("label")).click();
//		Keywords.waitFor(2);
//
//		saveAddressInfo.get(1).findElement(By.tagName("label")).click();
//		Keywords.waitFor(2);
//
//		List<WebElement> cashOrCard = driver.findElements(By.cssSelector(".custom-control.custom-radio"));
//		cashOrCard.get(1).findElement(By.tagName("label")).click();
//		Keywords.waitFor(2);
//
//		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/button")).click();
//		Keywords.waitFor(2);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox'][1]/label")).getAttribute("for"));
		System.out.println(driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox'][2]/label")).getAttribute("for"));
		System.out.println(driver.findElement(By.xpath("//p[starts-with(@id, '0.')]")).getText());

		System.out.println(driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='save-info']")).getText());

		driver.close();
		driver.quit();

	}

}
