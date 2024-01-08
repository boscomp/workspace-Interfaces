package examen.services;

public class AccesoDenegadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1098823505429786580L;

	public AccesoDenegadoException() {
	} 

	public AccesoDenegadoException(String message) {
		super(message);
	}

	public AccesoDenegadoException(Throwable cause) {
		super(cause);
	}

	public AccesoDenegadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDenegadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
