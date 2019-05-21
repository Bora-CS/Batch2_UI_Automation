package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;

public class TestAgain {

	
		
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);

			WebDriver driver = new ChromeDriver();

			driver.navigate().to("http://www.seleniumframework.com/Practiceform/");
			driver.manage().window().maximize();
			
			String target = "Buzz Buss";
			
			String currentText = driver.findElement(By.id("clock")).getText();
			
			String previousText = "";
			
			while(!currentText.equals(target)) {
				if(!currentText.equals(previousText))
					System.out.println(currentText);
				previousText = currentText;
				currentText = driver.findElement(By.id("clock")).getText();
			}
			
			System.out.println(currentText);
			
			driver.close();
			
			driver.quit();
			
				
			}
	}


