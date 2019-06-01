package automateWebPages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class Sameclass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"src/Resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com");
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com");
		String element = driver.findElement(By.cssSelector(".display-3.mb-4")).getText();
		
		if(element != null){
			System.out.println("Bora UI Automation Test is checked");
		} else {
			System.out.println("Bora UI Automation Test is unchecked");
		}
		driver.findElement(By.xpath("//a[@href=‘students.html’]")).click(); 
        List<WebElement> Studentelements = driver.findElements(By.cssSelector(".table table-hover"));  
        String StudentsInformation= Studentelements.get(0).findElement(By.xpath("//p[@class='Students Information']")).getText();
		System.out.println(StudentsInformation);
		Studentelements.get(0).click();
		
		driver.findElement(By.id("studentInfo")).click();
       
		String Students = driver.findElement(By.className("Students Information")).getText();
		
		if (!StudentsInformation.equalsIgnoreCase(Students)) {
			System.out.println("Students Information all in here");
		}
		if (!driver.findElement(By.id("studentInfo")).isDisplayed()) {
			System.out.println("Students Information is not displayed");
		}

		driver.close();
		driver.quit();
		
		
	}

}

	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"src/Resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://bora-test.s3-website-us-east-1.amazonaws.com");
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com");
		String login1 = driver.findElement(By.xpath("//a[@href=‘login.html’]")).getText();        
		String login2 = driver.findElement(By.cssSelector("btn.btn-lg.btn-info.mr-2")).getText();
		System.out.println(login1.equals(login2));
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		 Keywords.waitFor(2);
		driver.findElement(By.id("email")).sendKeys("Nanfeise@gmail.com");
			Keywords.waitFor(2);
		driver.findElement(By.id("password")).sendKeys("12345678");
			Keywords.waitFor(2);
			
WebElement submit = driver.findElement(By.xpath("./html/body/div/div/div/div/form/input"));
			
			String text = submit.getText();
			
			if (submit.isEnabled() && text.contains("Student Profile"))
			{ 
			    System.out.println("Successfully completed");
			    
			}else{
				
			    System.out.println("Not Successfully ");
			}
			driver.findElement(By.xpath("///*[@id=\"mobile-nav\"]/ul[2]/li]")).click();
			
			Keywords.waitFor(2);
			
			driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")).click();
			
			Keywords.waitFor(2);
			
			WebElement logout = driver.findElement(By.xpath("//*[@id=\"exampleModalCenter\"]/div/div/div[3]/button")); 
					
             String text2 = logout.getText();
			
			if (logout.isEnabled() && text2.contains("Sure, I will stay"))
			{ 
			    System.out.println("Successfully completed");
			    
			}else{
				
			    System.out.println("Not Successfully ");
			}
			String Gotta = driver.findElement(By.xpath("//a[@href=‘landing.html’]")).getText(); 
			
			
			
		driver.close();
		driver.quit();

		


}
}


