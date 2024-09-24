package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NavigationPage;

public class SauceLoginTest {


    private static final Logger log = LoggerFactory.getLogger(SauceLoginTest.class);
    private WebDriver driver;

    private LoginPage loginPage;

    private NavigationPage navigationPage;


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
        navigationPage = new NavigationPage(driver);



    }

    @AfterEach
    public void finish(){
        if(driver !=null)
            driver.quit();
    }

    @Test
    public void testSuccessfullLogin(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }


    @Test
    public void emptyUsername(){
        loginPage.clickLoginButton();
        Assertions.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username is required"));

        loginPage.enterPassword("test");
        loginPage.clickLoginButton();
        Assertions.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username is required"));


        loginPage.enterUsername("test");
        loginPage.removePasswordField();
        loginPage.clickLoginButton();
        Assertions.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Password is required"));

    }

    @Test
    public void invalidCredentials(){
        loginPage.enterUsername("test123");
        loginPage.enterPassword("test123");
        loginPage.clickLoginButton();
        Assertions.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }


    @Test
    public void isLoginSuccessfull(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.waitForPageToLoad();

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));


    }


    @Test
    public void testLogout() {
        // First, log in successfully
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        // Now log out
        navigationPage.openMenu();
        navigationPage.clickLogoutButton();

        // Verify that the user is redirected to the login page after logout
        Assertions.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }




}
