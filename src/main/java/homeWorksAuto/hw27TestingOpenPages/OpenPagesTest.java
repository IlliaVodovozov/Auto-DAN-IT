package testng.hw27TestingOpenPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import static org.testng.Assert.*;


public class OpenPagesTest {
    @Test
    public void checkWebPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://dan-it.com.ua/uk/");
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//a[text()='Для дорослих']")));
        actions.moveToElement(element).build().perform();
        WebElement element1 = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//a[text()='FrontEnd']")));
        actions.moveToElement(element1).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        WebElement element2 = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//a[text()='Java']")));
        actions.moveToElement(element2).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        WebElement element3 = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//a[text()='Quality Assurance (QA)']")));
        actions.moveToElement(element3).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();


        Set<String> handles = driver.getWindowHandles();
        assertTrue(handles.size() == 4, "Тест провален. Количество открьітьіх окон не равно 4.");
        driver.quit();


    }


    }

