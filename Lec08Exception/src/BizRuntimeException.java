
public class BizRuntimeException extends Exception {

	private static final long serialVersionUID = 1L;

	public BizRuntimeException() {
		super();
	}

	public BizRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BizRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizRuntimeException(String message) {
		super(message);
	}

	public BizRuntimeException(Throwable cause) {
		super(cause);
	}
	
}
