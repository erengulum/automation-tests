package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();
        // Implicit wait (optional, since we're using explicit waits)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to Swag Labs
        driver.get("https://www.saucedemo.com/");
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
