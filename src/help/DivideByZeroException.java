package help;

public class DivideByZeroException extends Exception {

	public DivideByZeroException() {
		super();
	}

	public DivideByZeroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DivideByZeroException(String message, Throwable cause) {
		super(message, cause);
	}

	public DivideByZeroException(String message) {
		super(message);
	}

	public DivideByZeroException(Throwable cause) {
		super(cause);
	}
}
