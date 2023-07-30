import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    private static WebDriver driver;

    public static void main(String[] args) {
        setUp();
        test1();
    }

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.get("C:\\Users\\virgi\\Automation\\resolver\\prop\\QE-index.html");
        driver.manage().window().maximize();
        // driver.findElement(By.id("inputEmail")).sendKeys("abc@gmail.com");
        // password
        // driver.findElement(By.id("inputPassword")).sendKeys("abc");
    }

    public static void test1() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("inputEmail")).sendKeys("abc@gmail.com");
        // password
        driver.findElement(By.id("inputPassword")).sendKeys("abc");
    }
}



