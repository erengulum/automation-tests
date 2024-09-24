package pages;


import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends WaitHelper {

    private WebDriver driver;

    // Locators for the burger menu and the logout button
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Open the menu
    public void openMenu() {
        waitForElementToBeClickable(burgerMenu).click();
    }

    // Click the logout button
    public void clickLogoutButton() {
        waitForElementToBeClickable(logoutButton).click();
    }
}
