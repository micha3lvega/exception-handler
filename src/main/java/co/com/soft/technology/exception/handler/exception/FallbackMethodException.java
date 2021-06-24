package co.com.soft.technology.exception.handler.exception;

public class FallbackMethodException extends RuntimeException {

	private static final long serialVersionUID = -408817517886901384L;

	public FallbackMethodException(String message) {
		super(message);
	}

	public FallbackMethodException(String message, Throwable cause) {
		super(message, cause);
	}

	public FallbackMethodException(Throwable cause) {
		super(cause);
	}

}
