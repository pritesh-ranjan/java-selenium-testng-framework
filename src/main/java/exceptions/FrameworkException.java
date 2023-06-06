package exceptions;

public class FrameworkException extends RuntimeException{
    public FrameworkException(final Throwable cause){
        super(cause);
    }

    public FrameworkException(String message){
        super(message);
    }
}
