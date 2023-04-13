package homeWorksAuto.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CompareElements {
           public static void compareElements(WebElement element1, WebElement element2) {
            // Отримуємо координати та розміри елементів
            int x1 = element1.getLocation().getX();
            int y1 = element1.getLocation().getY();
            int x2 = element2.getLocation().getX();
            int y2 = element2.getLocation().getY();
            int width1 = element1.getSize().getWidth();
            int height1 = element1.getSize().getHeight();
            int width2 = element2.getSize().getWidth();
            int height2 = element2.getSize().getHeight();

            // Який елемент вище
            if (y1 < y2) {
                System.out.println("Перший елемент розташований вище.");
            } else if (y1 > y2) {
                System.out.println("Другий елемент розташований вище.");
            } else {
                System.out.println("Елементи розташовані на однаковій висоті.");
            }

            // Який елемент лівіше
            if (x1 < x2) {
                System.out.println("Перший елемент розташований лівіше.");
            } else if (x1 > x2) {
                System.out.println("Другий елемент розташований лівіше.");
            } else {
                System.out.println("Елементи розташовані на однаковій ширині.");
            }

            // Який елемент більше
            int area1 = width1 * height1;
            int area2 = width2 * height2;
            if (area1 > area2) {
                System.out.println("Перший елемент займає більше місця.");
            } else if (area1 < area2) {
                System.out.println("Другий елемент займає більше місця.");
            } else {
                System.out.println("Елементи займають однакову площу.");
            }
        }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://rozetka.com.ua/");
        WebElement input = driver.findElement(By.xpath("//button[contains(text(),'Знайти')]"));
        WebElement catalog = driver.findElement(By.xpath("//button[@aria-label='Каталог']"));

        CompareElements ce = new CompareElements();
        ce.compareElements(input, catalog);


    }
    }

