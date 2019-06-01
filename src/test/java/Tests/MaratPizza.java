package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import BoraTech.Batch2_UI_Automation.Constants;
import BoraTech.Batch2_UI_Automation.Keywords;

public class MaratPizza {
    
    public static void main(String[] args) {
        

        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH_WINDOW);
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(Constants.APPLICATION_URL);

        driver.findElement(By.id("firstName")).sendKeys("Marat");
        Keywords.waitFor(1);
        driver.findElement(By.id("lastName")).sendKeys("Talantov");
        Keywords.waitFor(1);
        driver.findElement(By.id("email")).sendKeys("maro9090@mail.ru");
        Keywords.waitFor(1);
        driver.findElement(By.id("phonenumber")).sendKeys("410-739-2203");
        Keywords.waitFor(1);
        driver.findElement(By.id("address")).sendKeys("8301 Hope Point Ct");
        Keywords.waitFor(1);

        WebElement selectCountryElement = driver.findElement(By.id("country"));
        Select country = new Select(selectCountryElement);

        country.selectByVisibleText("United States");

        Keywords.waitFor(2);

        WebElement selectStateElement = driver.findElement(By.id("state"));
        Select state = new Select(selectStateElement);

        state.selectByVisibleText("Maryland");

        Keywords.waitFor(2);

        driver.findElement(By.id("zip")).sendKeys("21108");

        Keywords.waitFor(2);

        List<WebElement> saveAddressInfo = driver.findElements(By.cssSelector(".custom-control.custom-checkbox"));
        saveAddressInfo.get(0).findElement(By.tagName("label")).click();

        Keywords.waitFor(2);

        saveAddressInfo.get(1).findElement(By.tagName("label")).click();

        Keywords.waitFor(2);

        List<WebElement> cashOrCard = driver.findElements(By.cssSelector(".custom-control.custom-radio"));

        cashOrCard.get(1).findElement(By.tagName("label")).click();

        Keywords.waitFor(5);

        driver.close();
        driver.quit();
        
    }
    
}