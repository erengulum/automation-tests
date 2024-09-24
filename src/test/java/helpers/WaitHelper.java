package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private WebDriver driver;
    private final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);  // Default timeout of 10 seconds

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public WebElement waitForElementToBeClickable(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return waitForElementToBeClickable(locator, DEFAULT_TIMEOUT);
    }

    public WebElement waitForElementToBeVisible(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return waitForElementToBeVisible(locator, DEFAULT_TIMEOUT);
    }
}
