package seleniuM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class pizzaS {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_MAC);
        
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to(Constants.APPLICATION_URL);
        
        driver.findElement(By.id("firstName")).sendKeys("Saiyara");
        driver.findElement(By.id("lastName")).sendKeys("Parhat");
        driver.findElement(By.id("email")).sendKeys("saiyaraparhat@gmail.com");
        driver.findElement(By.id("phonenumber")).sendKeys("882-002-9876");
        driver.findElement(By.id("address")).sendKeys("4935 wilderness glen");
        
        Keywords.waitFor(2);
        
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("United States");
        
        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByVisibleText("Virginia");
        
        driver.findElement(By.id("zip")).sendKeys("22031");
        
        Keywords.waitFor(2);
        
        List<WebElement> checkBox =
                driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
        checkBox.get(0).findElement(By.tagName("label")).click();
        checkBox.get(1).findElement(By.tagName("label")).click();
        
        List<WebElement> cashOrCard =
                driver.findElements(By.cssSelector(".custom-control.custom-radio"));
        cashOrCard.get(0).findElement(By.tagName("label")).click();
        
        Keywords.waitFor(2);
        
        driver.findElement(By.id("cc-name")).sendKeys("saiyara Parhat");
        driver.findElement(By.id("cc-number")).sendKeys("123-345-678-9999");
        driver.findElement(By.id("cc-expiration")).sendKeys("03/22");
        driver.findElement(By.id("cc-cvv")).sendKeys("112");
        
        Keywords.waitFor(5);
        
        driver.close();
        driver.quit();
        
    }

}
