package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends WaitHelper {

    private WebDriver driver;

    private final By cartItemName = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstCartItemName() {
        return waitForElementToBeVisible(cartItemName).getText();
    }

    public void clickCheckoutButton() {
        waitForElementToBeClickable(checkoutButton).click();
    }
}
