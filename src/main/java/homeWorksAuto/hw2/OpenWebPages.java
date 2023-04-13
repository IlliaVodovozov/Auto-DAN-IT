package homeWorksAuto.hw2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpenWebPages {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        List<String> urls = new ArrayList<>();
        urls.add("https://uhomki.com.ua/ru/koshki/1074/");
        urls.add("https://zoo.kiev.ua/");
        urls.add("https://www.w3schools.com/");
        urls.add("https://taxi838.ua/ru/dnepr/");
        urls.add("https://klopotenko.com/");

        for (String url : urls) {
            jsExecutor.executeScript("window.open('" + url + "','_blank');");
        }

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            String url = driver.getCurrentUrl();
            System.out.println("Title: " + title);
            System.out.println("URL: " + url);

            if (title.toLowerCase().contains("зоопарк")) {
                driver.close();
            }
        }

        driver.quit();
    }
}