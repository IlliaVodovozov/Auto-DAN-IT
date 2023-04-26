package testng.hw27TestingOpenPages;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

public class OplataDostavkaPageTest {
    @Test
    public void checkOpenWebPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://uhomki.com.ua/ru/");
        Actions actions = new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//span/a[text()='Оплата и доставка']")));
        actions.moveToElement(element).click().build().perform();
        /*System.out.println(driver.getTitle());*/
        Waiters waiters = new Waiters(driver);
        waiters.waitForTitleContains("Оплата и доставка - \"У Хомки\"");
        assertEquals(driver.getTitle(), "Оплата и доставка - \"У Хомки\" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка \"Медтехника\")", "Названия страниц не совпадают");
//
//Оплата и доставка - "У Хомки" Интернет-зоомагазин | Днепр, пр. А. Поля, 59. (остановка "Медтехника")
    }
}
