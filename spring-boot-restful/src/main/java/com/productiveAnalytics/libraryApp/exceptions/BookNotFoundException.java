package com.productiveAnalytics.libraryApp.exceptions;

public class BookNotFoundException extends RuntimeException {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4089360954012886778L;

	public BookNotFoundException(String message) {
		super(message);
	}
}