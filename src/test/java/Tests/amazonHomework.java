package Tests;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import BoraTech.Batch2_UI_Automation.Keywords;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonHomework {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Waseem\\e" + "clipse-workspace\\Batch2_UI_A"
				+ "utomation\\sr" + "c\\test\\resource\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://amazon.com");

		int a = Integer.valueOf(driver.findElement(By.id("nav-cart")).getAttribute("aria-label").split(" ")[0]);

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchBox.sendKeys("pencil");

		searchBox.submit();

		List<WebElement> results = driver.findElements(By.cssSelector("a-size-base-plus.a-color"));

		System.out.println(results.size());

		for (WebElement results : results) {

			if (results.getText().equals("AmazonBasics Pre-Sharepened Wood Cased #2 HB Pencils, 150 Pack")) {
				results.click();
				break;

			}

		}

		
		
		
		
		
		driver.findElement(By.id("size_name_0")).click();
		
		
		
		driver.findElement(By.id("add-to-cart-button"));
		
		try {
			
			
			
		 try {
			
			driver.findElement(By.id("attach-close_sideSheet-link")).click();

		} catch (NoSuchElementException e) {
			
			
		}
		 
		} 
		
	a = Integer.valueOf(driver.findElement(By.id("nav-cart")).getAttribute("aria-label").split(" ")[0]);
	
		
		
		
	}
	
	
}
		
		
		
	
