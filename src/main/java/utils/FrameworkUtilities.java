package utils;

import exceptions.FailedScreenshotException;
import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static constants.FrameworkConstants.EVIDENCE_STORAGE;

@UtilityClass
public class FrameworkUtilities {
    public static final Logger LOGGER = LogManager.getLogger();

    public static FrameworkConfig getConfig() {
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }

    public static void takeScreenShot(String saveName) {
        try {
            WebDriver driver = WebDriverFactory.getDriver();
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File tempScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
            File saveScreenshotFile = new File(Paths.get(EVIDENCE_STORAGE, saveName + ".png").toString());
            FileUtils.copyFile(tempScreenshot, saveScreenshotFile);
        } catch (IOException e) {
            throw new FailedScreenshotException(e);
        }
    }
}
