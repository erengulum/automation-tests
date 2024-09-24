// src/main/java/pages/InventoryPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    // Locators using CSS Selectors
    private By firstProductName_CSS = By.cssSelector(".inventory_item:first-child .inventory_item_name");
    private By addToCartButton_CSS = By.cssSelector(".btn_inventory");

    // Locators using XPath
    private By firstProductName_XPath = By.xpath("(//div[contains(@class, 'inventory_item')])[1]//div[contains(@class, 'inventory_item_name')]");
    private By firstAddToCartButton_XPath = By.xpath("(//div[contains(@class, 'inventory_item')])[1]//button[contains(@class, 'btn_inventory')]");

    // Optional: Using data attributes for better specificity
    // Adjust based on actual HTML if data attributes are present

    // Constructor
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Get first product name using CSS Selector
    public String getFirstProductName_CSS() {
        return getText(firstProductName_CSS);
    }

    // Get first product name using XPath
    public String getFirstProductName_XPath() {
        return getText(firstProductName_XPath);
    }

    // Add first product to cart using CSS Selector
    public void addFirstProductToCart_CSS() {
        click(addToCartButton_CSS);
    }

    // Add first product to cart using XPath
    public void addFirstProductToCart_XPath() {
        click(firstAddToCartButton_XPath);
    }

    // Navigate to Cart Page
    private By cartIcon = By.id("shopping_cart_container");

    public CartPage goToCart() {
        click(cartIcon);
        return new CartPage(driver);
    }

    // Additional methods like sorting, filtering can be added here
}
