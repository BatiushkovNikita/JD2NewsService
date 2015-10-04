package by.news.service.web.exception;

public class MvcException extends Exception {

    public MvcException(String message) {
        super(message);
    }

    public MvcException(String message, Throwable cause) {
        super(message, cause);
    }
}
