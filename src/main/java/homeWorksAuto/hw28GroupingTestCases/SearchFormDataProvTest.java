package testng.hw28GroupingTestCases;

import lesson6.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchFormDataProvTest {

    @DataProvider(name="searchProvider")
    public Object[] searchMethod(){
        return new Object[]{
                "input","смысл","машина"
        };
    }
    private static class Locators {
        private final static By iSearch = By.xpath("//input[@placeholder='Я ищу ...']");
        private final static By buttonSearch = By.xpath("//input[@value='Найти']");
        private final static By titleSearch = By.xpath("//div[@class='search-page__box-title']/label");
        private final static By h1 = By.tagName("h1");

    }

    @Test(dataProvider = "searchProvider")
    public void checkSearchForm(String text) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");

        Waiters waiters = new Waiters(driver);
        WebElement search = waiters.waitForVisabilityOfElementReturn(Locators.iSearch);
        search.sendKeys(text);
        WebElement button = waiters.waitForVisabilityOfElementReturn(Locators.buttonSearch);
        button.click();
        waiters.waitForTitleContains("Найдено по запросу");
        if((driver.findElement(Locators.h1).getText()).contains("Результаты поиска")){
            waiters.waitForVisabilityOfElement(Locators.titleSearch);
            assertEquals((driver.findElement(Locators.titleSearch)
                            .getText()),"«"+text+"»","Actual result = "+ (driver
                    .findElement(Locators.titleSearch).getText())+" Expected "+ text);
        }else {
            waiters.waitForVisabilityOfElement(Locators.h1);
            String result = driver.findElement(Locators.h1).getText()
                    .replace("Найдено по запросу ","");
            assertEquals(result,"«"+text+"»",
                    "Actual result = "+ (driver.findElement(Locators.h1).getText())+
                            " Expected "+text);
        }
        driver.quit();
    }

}
