package homeWorksAuto.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchByLocators {
    private static class Urls {
        private static final String koshki1 = "https://uhomki.com.ua/koshki/1074/";
        private static final String jetbrains = "https://www.jetbrains.com/idea/";
        private static final String danIt = "https://dan-it.com.ua/";
        private static final String w3Schools = "https://www.w3schools.com/";

    }
    private static class Locators {
        /*koshki*/
        private static final By catClassName = By.className("userbar__button-text");
        private static final By linkAndClass = By.xpath("//a[@class='userbar__button __active']");
        private static final By textOfLink = By.linkText("Вход");
        private static final By divAndClass = By.xpath("//div[@data-skin='header_top']");
        private static final By catsAndDogsLink = By.xpath("//div[contains(text(),'Каталог')]/following-sibling::ul//a[contains(text(),'Собаки/кошки общее')]");
        private static final By menuFindAqua = By.xpath("/html/body/div[2]/div[1]/div/div[3]/div/div/div/div/div/ul/li[8]/div[2]/ul/li[2]/a/span");
//        private static final By menuFindAqua = By.cssSelector(".__visible .productsMenu-submenu-i:nth-child(2) .productsMenu-submenu-t");
        private static final By closePopUpBlock = By.xpath("//*[@id=\"sign-in\"]/div/a");
        /*Dan IT*/
        private static final By acceptLang = By.linkText("Українська");
        private static final By textFindIt = By.xpath("//h1[contains(text(), ' IT-освіта')]/following-sibling::div/a");
        private static final By phoneNumber = By.xpath("//a[@class='page-header__phone']");
        private static final By findOffline = By.xpath("//li[2]/p[@class='banner-meta__name']");
        private static final By findOneByOne = By.xpath("//p[contains(text(), 'Український центр')]/../../../div[1]/ul/li[3]");

        /*jetbrains*/
        private static final By jetClassName = By.className("menu-second__download-button");
        private static final By leftDownload = By.xpath("//div[1]/div/div[2]/span/a");
        private static final By rightDownload = By.xpath("//div[2]/div/div[2]/span/a");

        /*w3schools*/
        private static final By w3sId1 = By.id("navbtn_tutorials");
        private static final By w3sId2 = By.id("navbtn_references");
        private static final By w3sId3 = By.id("navbtn_exercises");
        private static final By w3sId4 = By.id("w3loginbtn");
        private static final By w3sId5 = By.id("cert_navbtn");
        private static final By w3sId6 = By.id("navbtn_exercises");
        private static final By w3sId7 = By.id("signupbtn_topnav");
        private static final By w3sId8 = By.id("myLearningFromDefault");
        private static final By w3sId9 = By.id("proFromDefault");
        private static final By w3sId10 = By.id("spacesbtn_topnav");

    }

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.koshki1);

//      Завдання 1
        driver.findElement(Locators.catClassName).click();
        Thread.sleep(1000);
        driver.findElement(Locators.closePopUpBlock).click();
        /*Второй способ закриття ПОпАпБлока:*/
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
        driver.findElement(Locators.linkAndClass).click();
        Thread.sleep(1000);
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);

        driver.findElement(Locators.textOfLink).click();
        Thread.sleep(1000);
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);

        driver.findElement(Locators.divAndClass).click();
        Thread.sleep(1000);
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);

//        Завдання 2
        driver.findElement(Locators.catsAndDogsLink).click();
        Thread.sleep(1000);

//        Завдання 4 - Не можу совладати з цім завданням
        /*driver.findElement(Locators.menuFindAqua).click();*/
        /*System.out.println(driver.findElement(Locators.menuFindAqua).getText());
        Thread.sleep(2000);*/
//        driver.moveToElement.findElement(By.xpath( "/html/body/div[2]/div[1]/div/div[3]/div/div/div/div/div")).perform();
        driver.close();

//        Завдання 3
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.danIt);
        driver.findElement(Locators.acceptLang).click();
        driver.findElement(Locators.textFindIt).click();

//        Завдання 6
        System.out.println(driver.findElement(Locators.findOffline).getText());

//        Завдання 5
        driver.findElement(Locators.phoneNumber).click();

        //        Завдання 8
        System.out.println(driver.findElement(Locators.findOneByOne).getText());
        driver.close();

//        Завдання 7
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.w3Schools);
        System.out.println(driver.findElement(Locators.w3sId1).getText());
        System.out.println(driver.findElement(Locators.w3sId2).getText());
        System.out.println(driver.findElement(Locators.w3sId3).getText());
        System.out.println(driver.findElement(Locators.w3sId4).getText());
        System.out.println(driver.findElement(Locators.w3sId5).getText());
        System.out.println(driver.findElement(Locators.w3sId6).getText());
        System.out.println(driver.findElement(Locators.w3sId7).getText());
        System.out.println(driver.findElement(Locators.w3sId8).getText());
        System.out.println(driver.findElement(Locators.w3sId9).getText());
        System.out.println(driver.findElement(Locators.w3sId10).getText());

        driver.close();

//      Завдання  9
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.jetbrains);
        driver.findElement(Locators.jetClassName).click();

//        Завдання 10
        System.out.println("The Leading Java and Kotlin IDE: "+driver.findElement(Locators.leftDownload).getText());
        System.out.println("The IDE for pure Java and Kotlin development: "+driver.findElement(Locators.rightDownload).getText());
        driver.close();

    }
}
