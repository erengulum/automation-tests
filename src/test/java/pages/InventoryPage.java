package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends WaitHelper {


    private final WebDriver driver;

    private final By firstProduct = By.cssSelector(".inventory-item:first-child .inventory_item_name");
    private final By addToCartButton = By.cssSelector(".btn_inventory");



    public InventoryPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public String getFirstProductName(){
        return driver.findElement(firstProduct).getText();
    }

    public void addFirstProductToCart(){
        driver.findElement(addToCartButton).click();
    }

}
