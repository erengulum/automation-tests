package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WaitHelper {

    //we first need a webdriver
    private WebDriver driver;


    // By is locator mechanism to interact with elements. It uses attribute of elements
    private final By usernameField = By.id("user-name");

    private final By passwordField = By.id("password");

    private final By loginButton = By.id("login-button");

    // Using data-test attribute for error message
    private final By errorMessage = By.cssSelector("[data-test='error']");
    //alternative:
    //By errorMessage = By.xpath("//*[@data-test='error']");



    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
      driver.findElement(loginButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public void removeUsername(){
        driver.findElement(usernameField).clear();
    }

    public void removePasswordField(){
        driver.findElement(passwordField).clear();
    }




}
