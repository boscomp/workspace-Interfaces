package app.gui.service;

public class AnimalesNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnimalesNotFoundException() {
	}

	public AnimalesNotFoundException(String message) {
		super(message);
	}

	public AnimalesNotFoundException(Throwable cause) {
		super(cause);
	}

	public AnimalesNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnimalesNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
