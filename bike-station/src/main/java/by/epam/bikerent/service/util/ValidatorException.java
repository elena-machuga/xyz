package by.epam.bikerent.service.util;

public class ValidatorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7896718398924815077L;

	public ValidatorException() {
		super();
	}

	public ValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidatorException(String message) {
		super(message);
	}

	public ValidatorException(Throwable cause) {
		super(cause);
	}

}
