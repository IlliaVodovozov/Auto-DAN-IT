package homeWorksAuto.hw3;

        import java.util.List;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.Select;

public class SelectCarAndCountries {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");

        Select selectBox = new Select(driver.findElement(By.id("Carlist")));
        selectBox.selectByVisibleText("Renault");

        Select fromListBox = new Select(driver.findElement(By.name("FromLB")));
        fromListBox.selectByVisibleText("France");
        fromListBox.selectByVisibleText("India");
        fromListBox.deselectByVisibleText("India");
        fromListBox.selectByVisibleText("Germany");
        fromListBox.selectByVisibleText("Italy");
        fromListBox.selectByVisibleText("Malaysia");
        fromListBox.deselectByVisibleText("Malaysia");
        fromListBox.selectByVisibleText("Spain");

        WebElement moveButton = driver.findElement(By.xpath("//input[@value='->']"));
        moveButton.click();

        List<WebElement> elements =  selectBox.getOptions();
        System.out.println("Автомобілі доступні для вибору:");
        for (WebElement element:elements){
            System.out.println(element.getText());
        }

        List<WebElement> elements1 = fromListBox.getOptions();
        System.out.println("Країни з першої таблиці:");
        for (WebElement option : elements1) {
            System.out.println(option.getText());
        }

        Select toListBox = new Select(driver.findElement(By.name("ToLB")));
        List<WebElement> elements2 = toListBox.getOptions();
        System.out.println("Країни з другої таблиці:");
        for (WebElement option : elements2) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}