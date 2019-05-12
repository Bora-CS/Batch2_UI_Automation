package TestFinish;

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
		
		
		String URL = "file:///Users/nanfeisexiaokaiti/eclipse-workspace/Batch2_UI_Automation/src/test/resource/index.html";
				
		driver.navigate().to(URL);
		
        WebElement firstName = driver.findElement(By.id("firstName"));

		firstName.sendKeys("Nafisa");
		
		driver.findElement(By.id("lastName")).sendKeys("Xiaokat");
		driver.findElement(By.id("email")).sendKeys("nanfeise@gmail.com");
		driver.findElement(By.id("phonenumber")).sendKeys("270-438-0603");
		driver.findElement(By.id("address")).sendKeys("704 northfiled ct");
		driver.findElement(By.id("zip")).sendKeys("22802");
		
		WebElement selectCountryElemnt = driver.findElement(By.id("country"));
		
		Select country = new Select(selectCountryElemnt);
		
		country.selectByVisibleText("United States");
		
		Keywords.waitFor(2);
		
        WebElement selectStateElemnt = driver.findElement(By.id("state"));
		
		Select state = new Select(selectStateElemnt);
		
		state.selectByVisibleText("Virginia");
		
		Keywords.waitFor(2);
		
		
		List<WebElement>cashOrCard = driver.findElements(By.cssSelector(".custom-control custom-radio"));
			
		System.out.println(cashOrCard.size());
		cashOrCard.get(1).findElement(By.tagName("label")).click();
		
		Keywords.waitFor(2);
		
		List<WebElement> saved_Address = driver.findElements(By.cssSelector(".custom-control custom-checkbox"));
		saved_Address.get(0).findElement(By.tagName("label")).click();

		Keywords.waitFor(2);

		List<WebElement> same_Address = driver.findElements(By.cssSelector(".custom-control custom-checkbox"));
		same_Address.get(1).findElement(By.tagName("label")).click();
		
		Keywords.waitFor(2);
		
	
		
		driver.close();
		driver.quit();
		
		
		
