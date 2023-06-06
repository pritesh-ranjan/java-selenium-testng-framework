package utils;

import annotations.Author;
import annotations.TestCaseLink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;


public final class TestLogListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestLogListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: {}\nAuthor: {}\njira id: {}",
                result.getName(),
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Author.class).automationAuthor(),
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestCaseLink.class).jiraId());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: {}", result.getName(), result.getThrowable());
        //todo take screenshot
    }

    @Override
    public void onTestSkipped(ITestResult result){
        logger.warn("Test skipped: {}", result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result){
        logger.error("Test failed with timeout: {}", result.getName());
        //todo take screenshot
    }
}
