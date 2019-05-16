package Testing1;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTesting3 {

		
		public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
			
			WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("https://www.amazon.com/");
			
			WebElement cartLink = driver.findElement(By.id("nav-cart"));
			
			String ariaLableOfCartLink = cartLink.getAttribute("aria-label");
			
			String text = "0 items in cart";
			
			if (ariaLableOfCartLink.equals(text)) {
				
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nike air max 270 men");
				
			} else {
				System.out.println("Error!");
			}
			
			
			driver.findElement(By.className("nav-input")).click();
			
			WebElement link = driver.findElement(By.linkText("Nike Air Max 270 Flyknit"
					+ " - Men's Chili Red/Black/Challenge Red/White "
					+ "Nylon Training Shoes"));
			link.click();
			driver.findElement(By.className("a-dropdown-prompt")).click();
			Keywords.waitFor(1);
			driver.findElement(By.id("native_dropdown_selected_size_name_1")).click();
			Keywords.waitFor(1);
			driver.findElement(By.id("add-to-cart-button")).click();
			
			Keywords.waitFor(3);
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("kia accessories");
			driver.findElement(By.className("nav-input")).click();
			WebElement link2 = driver.findElement(By.linkText("Amooca Car Smart "
					+ "Key Chain Leather Holder "
					+ "Cover Case Fob Remote For Kia"));
			link2.click();
			driver.findElement(By.id("add-to-cart-button")).click();
			
			WebElement cartLink2 = driver.findElement(By.id("nav-cart"));
			
			String ariaLableOfCartLink2 = cartLink2.getAttribute("aria-label");
			
			String text2 = "2 items in cart";
			
			if (ariaLableOfCartLink2.equals(text2)) {
				System.out.println("Proceed to checkout");
				
			} else {
				System.out.println("Error!");
			}
			
			Keywords.waitFor(3);
			
			
			driver.close();
			driver.quit();
			
	}

}
