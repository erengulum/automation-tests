// src/test/java/tests/InventoryPageTest.java
package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;
import pages.CartPage;

import java.time.Duration;

public class InventoryPageTest extends BaseTest {

    private LoginPage loginPage;

    private InventoryPage inventoryPage;



    @BeforeEach
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);


        // Login to access the inventory page
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }


    @Test
    public void verifyFirstProductName_CSS() {


        // Get first product name using CSS
        String actualProductName = inventoryPage.getFirstProductName_CSS();
        String expectedProductName = "Sauce Labs Backpack"; // Update based on actual site

        Assertions.assertEquals(actualProductName, expectedProductName, "First product name mismatch using CSS Selector.");
    }

    @Test
    public void addFirstProductToCart_CSS() {

        // Add first product to cart using CSS
        inventoryPage.addFirstProductToCart_CSS();

        // Navigate to cart
        CartPage cartPage = inventoryPage.goToCart();

        // Verify the cart contains the product
        java.util.List<String> cartItems = cartPage.getCartItems();
        Assertions.assertTrue(cartItems.contains("Sauce Labs Backpack"), "Cart does not contain the added product.");
    }

    @Test
    public void verifyFirstProductName_XPath() {

        // Get first product name using XPath
        String actualProductName = inventoryPage.getFirstProductName_XPath();
        String expectedProductName = "Sauce Labs Backpack"; // Update based on actual site

        Assertions.assertEquals(actualProductName, expectedProductName, "First product name mismatch using XPath Selector.");
    }

    @Test
    public void addFirstProductToCart_XPath() {

        // Add first product to cart using XPath
        inventoryPage.addFirstProductToCart_XPath();

        // Navigate to cart
        CartPage cartPage = inventoryPage.goToCart();

        // Verify the cart contains the product
        java.util.List<String> cartItems = cartPage.getCartItems();
        Assertions.assertTrue(cartItems.contains("Sauce Labs Backpack"), "Cart does not contain the added product.");
    }

    // Additional tests can be added here, such as:
    // - Verify all products are displayed
    // - Verify sorting functionality
    // - Verify removing a product from the cart
}
