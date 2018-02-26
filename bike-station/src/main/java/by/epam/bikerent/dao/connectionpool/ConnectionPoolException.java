package by.epam.bikerent.dao.connectionpool;

public class ConnectionPoolException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2511394099122587222L;

	private ConnectionPoolException() {
		super();
	}

	private ConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
	}

	private ConnectionPoolException(String message) {
		super(message);
	}

	private ConnectionPoolException(Throwable cause) {
		super(cause);
	}

}
