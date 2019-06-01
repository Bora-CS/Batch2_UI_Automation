package Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class AmazonTest {
		public static void main(String[] args) {
//			System.out.println(System.getProperty("user.dir"));
			// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

			System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.amazon.com/");
			
			int page = 1;
			List<TempAmazon> finalResults = new ArrayList<TempAmazon>();

			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nike");
			driver.findElement(By.id("twotabsearchtextbox")).submit();
			
			while (finalResults.size() < 100) {
				// Repeat from here *********************************
				List<WebElement> results = driver.findElements(By.xpath("//span[@data-component-type='s-search-results']/div/div[starts-with(@data-asin, 'B')]"));
						
				for (int i = 1; i <= results.size(); i++) {
					String parentXpath = "//span[@data-component-type='s-search-results']/div/div[" + i + "]";			
					String title;
					String price;
					
					try {
						title = driver.findElement(By.xpath(parentXpath + "//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
					} catch (Exception e) {
						title = "Title not available";
					}
					
					try {
						price = driver.findElement(By.xpath(parentXpath + "//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']//span[@data-a-size='l']")).getText();
					} catch (Exception e) {
						price = "Price not available";
					}
					
					price = getPrice(price);
								
					if (!price.contains("FREE") && !price.equals("Price not available")) {
//						System.out.println("Item "+ itemNumber + " $" + price + "\t" + title);
						finalResults.add(new TempAmazon(title, Double.parseDouble(price)));
						if (finalResults.size() == 100) break;
					}
				}
				// to here *********************************
				if (finalResults.size() == 100) break;
				driver.findElement(By.xpath("//a[text()='Next']")).click();
			}
			
			System.out.println("Item Number\tPrice\tItem Name");
			
			double sum = 0.0;
			for (int i = 0; i < finalResults.size(); i++) {
				System.out.println((i+1) + "\t\t$" + finalResults.get(i).price + "\t" + finalResults.get(i).title);
				sum = sum + finalResults.get(i).price;
			}
			
			System.out.println();
			System.out.println("The average price for Nike is " + sum/100);
			
			Keywords.waitFor(2);

			driver.close();

			driver.quit();

		}
		
		public static String getPrice (String a) {
			a = a.replace("\n", ".").replace("-.", "-").replace(".-", "-").replace("$", "");
			
			if (!a.contains("-")) {
				return a;
			}
			
			String[] prices = a.split("-");
			
			double[] pricesInDouble = new double[prices.length];
			for (int i = 0; i < prices.length; i++) {
				pricesInDouble[i] = Double.parseDouble(prices[i]);
			}
			
			double average = (pricesInDouble[0] + pricesInDouble[1]) / 2;
			
			return (Math.round(average * 100.0) / 100.0) + "";
		}
}