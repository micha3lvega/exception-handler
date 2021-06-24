package co.com.soft.technology.exception.handler.exception;

public class CallLegacyException extends RuntimeException {

	private static final long serialVersionUID = -3419707188883490631L;

	public CallLegacyException(String message) {
		super(message);
	}

	public CallLegacyException(String message, Throwable cause) {
		super(message, cause);
	}

	public CallLegacyException(Throwable cause) {
		super(cause);
	}
}
