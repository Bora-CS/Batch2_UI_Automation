package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Marat_AmazonHomework {

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
		
		List<WebElement> prices = driver.findElements(By.xpath("//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']/span[1]"));
		
		System.out.println("Size of price List: " + prices.size());
		System.out.println("Size of result List: " + results.size());
		System.out.println();
		
		System.out.println("ItemNo:\t" + "Price:\t" + " " + "Title:");
		System.out.println();
		
		int countItem = 0;
		double currentPrice;
		double totalPrice = 0;
		double averagePrice = 0;
		
		for (int i = 0; i < results.size(); i++) {
		     WebElement result = results.get(i);
		     WebElement price = prices.get(i);
		   
		     String priceNumb = price.getText().replace("\n", ".").trim().replace("$", "");
		     if (priceNumb.contains("-")) {
		    	 priceNumb = priceNumb.substring(0, 5);
//		    	 System.out.println(priceNumb);
		     	}
		    currentPrice = Double.parseDouble(priceNumb);
		    totalPrice = totalPrice + currentPrice;
		    averagePrice = totalPrice/prices.size();
		    countItem++;
		    
//		    System.out.println(countItem + "  " + priceNumb);
		    System.out.println(countItem + ".\t" + priceNumb + "\t " + result.getText());
		}
		totalPrice = Math.round(totalPrice*100.0)/100.0;
		averagePrice = Math.round(averagePrice*100.0)/100.0;
		
		System.out.println();
		System.out.println("Total Sum of prices: " + totalPrice);
		System.out.println("The Average price is: " + averagePrice);
		
		driver.close();
		driver.quit();
	}
}
