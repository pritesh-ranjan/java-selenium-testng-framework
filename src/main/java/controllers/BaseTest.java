package controllers;

import annotations.Browser;
import constants.Browsers;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigFactory;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;

import static constants.FrameworkConstants.EVIDENCE_STORAGE;

public class BaseTest {

    protected BaseTest() {

    }

    @BeforeSuite
    public void createDirectories() throws IOException {
        FileUtils.forceMkdir(new File(EVIDENCE_STORAGE));
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result) {
        Browsers testBrowser;
        if (result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(Browser.class))
            testBrowser = Browsers.valueOf(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Browser.class).name());
        else testBrowser = Browsers.valueOf(ConfigFactory.getConfig().browser());
        WebDriverFactory.createDriver(testBrowser);
        WebDriverFactory.getDriver().get(ConfigFactory.getConfig().url());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.closeDriver();
    }
}
