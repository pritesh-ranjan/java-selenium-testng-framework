package utils;

import annotations.Author;
import annotations.TestCaseLink;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utils.FrameworkUtilities.LOGGER;


public final class TestLogListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test started: {}\nAuthor: {}\njira id: {}",
                result.getName(),
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Author.class).author(),
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestCaseLink.class).jiraId());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test failed: {}", result.getName(), result.getThrowable());
        FrameworkUtilities.takeScreenShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.warn("Test skipped: {}", result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        LOGGER.error("Test failed with timeout: {}", result.getName());
        FrameworkUtilities.takeScreenShot(result.getName());
    }
}
