package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends WaitHelper {

    private final WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }
}
