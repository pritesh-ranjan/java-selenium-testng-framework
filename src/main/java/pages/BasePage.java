package pages;

import exceptions.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static utils.FrameworkUtilities.LOGGER;

public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage() {
        driver = WebDriverFactory.getDriver();
    }

    protected boolean isClickable(By locator) {
        throw new FrameworkException("working on it");
    }

    protected void click(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        LOGGER.info("clicked on {}", locator);
    }

    protected void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        LOGGER.info("searched with {} on {}", text, locator);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected String getText(By pageHeading) {
        LOGGER.info("extracting text of {}", pageHeading);
        return driver.findElement(pageHeading).getText();
    }
}
