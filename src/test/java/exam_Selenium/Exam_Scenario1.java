package exam_Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;
import exam_Selenium.StudentsTable;

public class Exam_Scenario1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_MAC);

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://bora-test.s3-website-us-east-1.amazonaws.com/");
		
		String homePageTitle = driver.findElement(By.tagName("h1")).getText();
		
		if (homePageTitle.contains("Bora UI Automation Test")) {
			
			System.out.println("Validation passed: " + homePageTitle + " is shown on the home page");
		} else {
			System.out.println("Test Failed: Homepage Title \"Bora UI Automation Test\" is not shown.");
			System.out.println("Actual Text: " + homePageTitle);
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Students')]")).click();
		Keywords.waitFor(1);
		
		String studentsPage = driver.findElement(By.tagName("h1")).getText();
		
		if (studentsPage.contains("Students Information")) {
			
			System.out.println("Validation passed: " + studentsPage + " is shown on the this page");
		} else {
			System.out.println("Test Failed: This page Title \"Students Information\" is not shown.");
			System.out.println("Actual Text: " + studentsPage);
		}
		
		List<WebElement> numberOfStudents = driver.findElements(By.xpath("//td[contains(text(),'202-202')]"));
		
		System.out.println("There are " + numberOfStudents.size() + " students information");
		
		List<WebElement> studentInfo = driver.findElements(By.xpath("//table[@id='studentInfo']//tr")); 
		
//		System.out.println(studentInfo.size());
		
		List<StudentsTable> table = new ArrayList<StudentsTable>();
		
		for (int i = 1; i <= studentInfo.size(); i++) {
			String parentXpath = "//table[@id='studentInfo']/tbody/tr[" + i + "]";	
			String name;
			String email;
			String phoneNo;
			
				try {
					name = driver.findElement(By.xpath(parentXpath + "//td[1]")).getText();
				
					email = driver.findElement(By.xpath(parentXpath + "//td[2]")).getText();
			
					phoneNo = driver.findElement(By.xpath(parentXpath + "//td[3]")).getText();
			
					table.add(new StudentsTable(name, email, phoneNo));
			} catch (Exception e) {
				
				}
			}
		
		for (int i = 0; i < table.size(); i++) {
			System.out.println((table.get(i).name + "\t" + table.get(i).email + "\t" + table.get(i).phoneNo));
		}
		
		Keywords.waitFor(1);
		
		driver.close();
		driver.quit();
	}
		
}
