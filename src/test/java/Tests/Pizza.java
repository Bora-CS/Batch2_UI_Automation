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
		
		
		
		
		  System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		  
		  WebDriver driver = new ChromeDriver();
		  
		  driver.navigate().to(Constants.APPLICATION_URL);
		  
		  Keywords.waitFor(3);
		  
		  
		  driver.findElement(By.id("firstName")).sendKeys("Nurala");
		  Keywords.waitFor(1);
		  
		  driver.findElement(By.id("lastName")).sendKeys("Abliz"); Keywords.waitFor(1);
		  
		  driver.findElement(By.id("email")).sendKeys("nurala1013@gmail.com");
		  Keywords.waitFor(1);
		  
		  driver.findElement(By.id("phonenumber")).sendKeys("202-469-0636");
		  Keywords.waitFor(1);
		  
		  driver.findElement(By.id("address")).sendKeys("111 main st");
		  Keywords.waitFor(1);
		  
		  WebElement selectCountryElement= driver.findElement(By.id("country")); Select
		  country = new Select (selectCountryElement);
		  country.selectByVisibleText("United States");
		  
		  Keywords.waitFor(1);
		  
		  WebElement selectStateElement = driver.findElement(By.id("state")); Select
		  state = new Select(selectStateElement);
		  
		  state.selectByVisibleText("Virginia");
		  
		  Keywords.waitFor(1);
		  
		  driver.findElement(By.id("zip")).sendKeys("22031"); Keywords.waitFor(1);
		  
		  List<WebElement> addressInfo =
		  driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
		  addressInfo.get(0).findElement(By.tagName("label")).click();
		  
		  addressInfo.get(1).findElement(By.tagName("label")).click();
		  
		  Keywords.waitFor(2);
		  
		  List<WebElement> cashOrCard =
		  driver.findElements(By.cssSelector(".custom-control.custom-radio"));
		  
		  cashOrCard.get(0).findElement(By.tagName("label")).click();
		  cashOrCard.get(1).findElement(By.tagName("label")).click();
		  
		  Keywords.waitFor(2);
		  
		  
		  driver.close();
		  
		  driver.quit();
		 
		 
		
		
		

}
}