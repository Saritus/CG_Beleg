package help;

public class OutOfBoundsException extends Exception{

	public OutOfBoundsException() {
		super();
	}

	public OutOfBoundsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfBoundsException(String message) {
		super(message);
	}

	public OutOfBoundsException(Throwable cause) {
		super(cause);
	}

}
