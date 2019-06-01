package Testing1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Final2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com");
		
		WebElement singUp1 = driver.findElement(By.cssSelector(".btn.btn-lg.btn-info.mr-2"));
		
		WebElement singUp2 = driver.findElement(By.xpath("//li/a[text()='Sign Up']"));
		
		if (singUp1.getText().equals(singUp2.getText())) {
			singUp1.click();
			Keywords.waitFor(1);
		}else {
			System.out.println("Test Failed!!! \t (1)");
		}
		
		WebElement singUpPage = driver.findElement(By.cssSelector(".display-4.text-center"));
		
		if (singUpPage.getText().contains("Sign Up")) {
			
			driver.findElement(By.name("name")).sendKeys("Ruslan");
			driver.findElement(By.id("male")).click();
			driver.findElement(By.name("email")).sendKeys("ruslanibrahimoff@gmail.com");
			Select course = new Select(driver.findElement(By.name("Course")));
			course.selectByVisibleText("Java Spring Full Stack Development");
			driver.findElement(By.name("password")).sendKeys("123456");
			driver.findElement(By.name("password2")).sendKeys("123456");
			driver.findElement(By.id("notarobot")).click();
			driver.findElement(By.cssSelector(".btn.btn-info.btn-block.mt-4")).click();
			
			Keywords.waitFor(1);
			
			WebElement congratulationsPage = driver.findElement(By.tagName("h4"));
			
			if (congratulationsPage.getText().contains("Congratulations!")) {
				driver.findElement(By.className("alert-link")).click();
				Keywords.waitFor(1);
			}else {
				System.out.println("Test Failed!!! \t (2)");
			}
			
			WebElement bootcampPage = driver.findElement(By.cssSelector(".m-font-size-36.lh-1.font-size-60"));
			
			if (bootcampPage.getText().contains("Bora Consulting Solutions")) {
				System.out.println("Tested Succesfully!!!");
			}else
				System.out.println("Test Failed!!! \t (3)");
			Keywords.waitFor(2);
			
			
		}
		driver.close();
		driver.quit();
	}

}
