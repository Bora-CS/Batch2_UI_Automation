package Tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class FinalTest1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
		String title = driver.findElement(By.cssSelector(".display-3.mb-4")).getText();
		
		if (title.contains("Bora UI Automation Test")) {
			 System.out.println("You are in the homepage");
		}

		driver.findElement(By.xpath("//a[@href='students.html']")).click();
		  Keywords.waitFor(2);
		  
		String studenPage = driver.findElement(By.cssSelector(".display-4.text-center")).getText();
		
	    if(studenPage.contains("Students Information")) {
	    	System.out.println("you are in the student page");
	    }
	   
	    
	    List<WebElement> results = driver.findElements(By.xpath("//*[@id='studentInfo']/tbody/tr"));
	    
	    if(results.size()==12) {
	    	System.out.println("There are 12 students");
	    }else{
	    	System.out.println(results.size());
	    };
	    
	    List<Result> Results = new ArrayList<Result>();
	    
	    for (int i = 1; i < Results.size(); i++) {
	    	String xpath = ("//*[@id='studentInfo']/tbody/tr[i]/th[i]");
	    	String name;
	    	String phoneNumber;
			
		}
//	    int result =  Integer.parseInt(actualNumber);
	   
//	    int totallNumber = 12;
//	    
//	    if(actualNumber.size()== totallNumber) {
//	    	
//	    }
//	    
	  
	     
	     
	     
		driver.close();
		driver.quit();
	}

	private static void findElements(By xpath) {
		// TODO Auto-generated method stub
		
	}

}
