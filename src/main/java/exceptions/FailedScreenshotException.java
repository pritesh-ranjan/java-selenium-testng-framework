package exceptions;

public class FailedScreenshotException extends FrameworkException {
    public FailedScreenshotException(Throwable cause) {
        super(cause);
    }

    public FailedScreenshotException(String message) {
        super(message);
    }
}
