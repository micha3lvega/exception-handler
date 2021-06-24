package co.com.soft.technology.exception.handler.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 3831624553507661438L;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}