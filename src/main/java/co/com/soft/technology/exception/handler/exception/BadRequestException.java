package co.com.soft.technology.exception.handler.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -5422262285468487438L;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}

}
