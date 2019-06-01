package Testing1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Final {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com");
		
		String homePage = driver.findElement(By.xpath("//div/h1")).getText();
		
		if (homePage.contains("Bora UI Automation Test")) {
			driver.findElement(By.partialLinkText("Students")).click();
			
		} else {
			System.out.println("Test Failed!!!");
		}
		
		String studentPage = driver.findElement(By.xpath("//div/h1")).getText();
		
		if (studentPage.contains("Students Information")) {
			List<WebElement> studentInfo = driver.findElements(By.xpath("//div//tr"));
			if ((studentInfo.size()-1) == 12) {

			List<WebElement> name = driver.findElements(By.xpath("//div//tr/th[1]"));
				
				for (WebElement name1 : name) {
					System.out.println(name1.getText());
				}
				
				
				
				
				
//			List<Data> TableData = new ArrayList<Data>();
//			
//			List<WebElement> table = driver.findElements(By.xpath("//div/table//tr"));
			
			}
		}
		driver.close();
		driver.quit();

	}

}
