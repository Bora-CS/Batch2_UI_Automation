package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BoraTech.Batch2_UI_Automation.Constants;

public class CostcoWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

	        WebDriver driver = new ChromeDriver();

	        driver.get("https://www.costco.com/");
	        
	       try {
	    	  
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
						("//a[contains(@id,'slick-slide')]/img[contains(@title,'$150 OFF MacBook Pro 13.3-inch.')][1]"))).click();
				
		    	List<WebElement> results = driver.findElements(By.cssSelector(".col-xs-6.col-md-6.col-lg-4.col-xl-3.product"));
				
			 System.out.println(results.size());
				
			 String itemTotal = driver.findElement(By.xpath("//div[@class='table-cell results hidden-xs hidden-sm hidden-md']//span[contains(text(),'Showing 1-')]")).getText();

				
			 String [] name = itemTotal.split(" ");
			 int actualNumber = Integer.parseInt(name[name.length -1]);
				
			 if(actualNumber == results.size()) {
				System.out.println("Number of results matches-" + actualNumber);
			} else {
				System.out.println("Number of results does not matche");
			}
			
			 boolean itemRelated = true;
			 for (WebElement result : results) {
				 if(!result.getText().contains("Apple")) {
					 System.out.println("Test Faild:/n " + result.getText());
				 }
			 }
				
				results.get(0).click();
				driver.findElement(By.id("add-to-cart-btn")).click();
				
				driver.findElement(By.xpath("//button[contains(text(),'View Cart')]")).click();
						
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		driver.close();
		driver.quit();
	}
	}

}
