package task;

public class FilterException extends RuntimeException {

	/** シリアル */
	private static final long serialVersionUID = 1L;

	private final String message;
	
	public FilterException(final String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
