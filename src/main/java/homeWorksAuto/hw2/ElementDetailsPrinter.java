package homeWorksAuto.hw2;

    import org.openqa.selenium.*;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;

    import java.util.concurrent.TimeUnit;

public class ElementDetailsPrinter {

        public static void printElementDetails(WebElement element) throws CustomException {
            try {
                String id = element.getAttribute("id");
                System.out.println("ID: " + id);

                String tag = element.getTagName();
                System.out.println("Tag name: " + tag);

                String className = element.getAttribute("class");
                System.out.println("Class name: " + className);

                String name = element.getAttribute("name");
                System.out.println("Атрибут name: " + name);

                String text = element.getText();
                System.out.println("Text: " + text);

                Point location = element.getLocation();
                Dimension size = element.getSize();
                int centerX = location.getX() + size.getWidth() / 2;
                int centerY = location.getY() + size.getHeight() / 2;
                System.out.println("Координати центра контейнера: (" + centerX + ", " + centerY + ")");

                String missingAttribute = element.getAttribute("nonexistent_attribute");
                if (missingAttribute != null) {
                    System.out.println("Отсутствует атрибут элемента: " + missingAttribute);
                } else {
                    throw new CustomException("Запрошенный атрибут не существует для этого элемента");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Элемент не найден на странице");
            }
        }

        public static class CustomException extends Exception {
            public CustomException(String errorMessage) {
                super(errorMessage);
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
//        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Знайти')]"));
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Каталог']"));
        try {
            ElementDetailsPrinter.printElementDetails(element);
        } catch (ElementDetailsPrinter.CustomException e) {
            System.out.println(e.getMessage());
        }
    }
    }
