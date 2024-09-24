package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);  // Default timeout of 10 seconds


    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Explicit wait
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    // Wait for element to be visible
    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click method
    protected void click(By locator) {
        waitForVisibility(locator);
        driver.findElement(locator).click();
    }

    // Send keys method
    protected void sendKeys(By locator, String text) {
        waitForVisibility(locator);
        driver.findElement(locator).sendKeys(text);
    }

    // Get text method
    protected String getText(By locator) {
        waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public WebElement waitForElementToBeClickable(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Additional common methods can be added here
}
