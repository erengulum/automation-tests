package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.InventoryPage;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NavigationPage;

public class ProductsTest {


    private static final Logger log = LoggerFactory.getLogger(SauceLoginTest.class);
    private WebDriver driver;

    private LoginPage loginPage;

    private InventoryPage inventoryPage;





    //Junit 4deki karsiligi da @Before . Her testten once calistirilir
    @BeforeEach
    public void setup(){

        // Step 1: If you use Mac, Initialize the SafariDriver (no need to download a driver)
        // WebDriver driver = new SafariDriver();

        // Step 1: Use WebDriverManager to automatically download and setup the correct ChromeDriver version
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        //maximize the screen
        driver.manage().window().maximize();

        // Navigate to the SauceDemo login page
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);


        // Login to access the inventory page
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();


    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testAddProductToCart() {
        inventoryPage.addFirstProductToCart();
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void testProductName() {
        String productName = inventoryPage.getFirstProductName();
        Assertions.assertEquals("Sauce Labs Backpack", productName);
    }




}
