package testng.hw27TestingOpenPages;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SearchPageTest {
    @Test(dataProvider = "searchProvider")
    public void checkSearch(String input) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);;
        driver.manage().window().maximize();

        driver.get("https://uhomki.com.ua/ru/");
        Waiters waiters = new Waiters(driver);
        new Waiters(driver).waitForVisabilityOfElement(By.xpath("//input[@name='q']"));
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(input);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        new Waiters(driver).waitForTitleContains("Результаты поиска");
        waiters.waitForVisabilityOfElement(By.tagName("h1"));
        String result = driver.findElement(By.tagName("h1")).getText().replace("Результаты поиска ","");
        assertEquals(result,"«"+input+"»",
                "Actual result = "+ (driver.findElement(By.tagName("h1")).getText())+
                        " Expected "+input);
        driver.quit();
        }

    @DataProvider(name = "searchProvider")
    public Object[] search(){
        return new Object[]{
                "смесь","спесь","ересь"
        };
    }
}
