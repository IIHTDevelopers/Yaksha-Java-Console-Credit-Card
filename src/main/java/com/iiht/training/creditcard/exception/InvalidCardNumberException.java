package com.iiht.training.creditcard.exception;

public class InvalidCardNumberException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCardNumberException() {
		super();
	}

	public InvalidCardNumberException(String message) {
		super(message);
	}

}
