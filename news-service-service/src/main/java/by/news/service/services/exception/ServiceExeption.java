package by.news.service.services.exception;

public class ServiceExeption extends Exception {

	public ServiceExeption() {

	}

	public ServiceExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceExeption(String message) {
		super(message);
	}

	public ServiceExeption(Throwable cause) {
		super(cause);
	}

}
