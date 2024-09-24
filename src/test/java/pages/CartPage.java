package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends WaitHelper {

    private WebDriver driver;

    private By cartItemNames = By.cssSelector(".cart_item .inventory_item_name");
    private By firstCartItemName_CSS = By.cssSelector(".cart_item:first-child .inventory_item_name");
    private By firstCartItemName_XPath = By.xpath("(//div[contains(@class, 'cart_item')])[1]//div[contains(@class, 'inventory_item_name')]");

    private final By checkoutButton = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstCartItemName() {
        return waitForElementToBeVisible(firstCartItemName_CSS).getText();

    }

    // Get list of items in the cart
    public java.util.List<String> getCartItems() {
        java.util.List<org.openqa.selenium.WebElement> elements = driver.findElements(cartItemNames);
        java.util.List<String> itemNames = new java.util.ArrayList<>();
        for (org.openqa.selenium.WebElement element : elements) {
            itemNames.add(element.getText());
        }
        return itemNames;
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
