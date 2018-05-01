/**
 * 
 */
package com.barclays.theatre.seating.exceptions;

/**
 * @author Aarthy Rajan
 *
 */
public class SeatingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4553028381620830971L;

	/**
	 * 
	 */
	public SeatingException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SeatingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SeatingException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SeatingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SeatingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}