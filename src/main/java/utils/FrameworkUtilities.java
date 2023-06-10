package utils;

import exceptions.FailedScreenshotException;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static constants.FrameworkConstants.SCREENSHOT_SAVE_PATH;

@UtilityClass
public class FrameworkUtilities {
    public static final Logger logger = LogManager.getLogger(FrameworkUtilities.class); // todo fix logging
    public static void takeScreenShot(String methodName) {
        try {
            WebDriver driver = WebDriverFactory.getDriver();
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File tempScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
            File saveScreenshotFile = new File(Paths.get(SCREENSHOT_SAVE_PATH, methodName+".png").toString());
            FileUtils.copyFile(tempScreenshot, saveScreenshotFile);
        } catch (IOException e) {
            throw new FailedScreenshotException(e);
        }
    }
}
