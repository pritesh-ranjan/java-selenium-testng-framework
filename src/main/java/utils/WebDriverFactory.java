package utils;

import constants.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;

import static utils.FrameworkUtilities.logger;

@UtilityClass
public class WebDriverFactory {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void createDriver(Browsers testBrowser) {
        if (driver.get() == null) {
            WebDriver webDriver = switch (testBrowser) {
                case EDGE -> WebDriverManager.edgedriver().create();
                case CHROME -> WebDriverManager.chromedriver().create();
                default -> throw new IllegalArgumentException("No such browser: " + testBrowser);
            };
            webDriver.manage().window().maximize();
            driver.set(webDriver);
            logger.info("browser created: " + testBrowser);
        }
    }

    public static void closeDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
            logger.info("closing browser");
        }
    }


}
