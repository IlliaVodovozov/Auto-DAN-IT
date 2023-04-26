package testng.hw27TestingOpenPages;

import lesson6.Waiters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ChekingAlertTest {
    @Test
    public void chekingAlert(){
        //input[@value='Show Me Alert']
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[@value='Show Me Alert']")));
        actions.moveToElement(element).click().build().perform();
        Alert alert = driver.switchTo().alert();
        /*System.out.println(alert.getText());*/
//        Hi.. This is alert message!
        assertEquals("Hi.. This is alert message!", alert.getText(),
                "Модальное окно не содержит текст: Hi.. This is alert message!");
        driver.quit();

    }
}
