package testng.hw27TestingOpenPages;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class CheckBoxTest {
    @Test
    public void checkBoxCheck() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        //input[@id='RememberMe']
        WebElement checkBox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//input[@id='RememberMe']")));
        assertFalse(checkBox.isSelected(), "1. Чекбокс уже нажат");
        checkBox.click();
        WebElement newCheckBox = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//input[@id='RememberMe']")));
        (new Waiters(driver)).waitForVisabilityOfElement(driver.findElement(By.xpath("//input[@id='RememberMe']")));
        assertTrue(newCheckBox.isSelected(), "2. Чекбокс не нажат");
        newCheckBox.click();
        assertFalse(checkBox.isSelected(), "3. Чекбокс нажат");
        driver.quit();
    }
}
