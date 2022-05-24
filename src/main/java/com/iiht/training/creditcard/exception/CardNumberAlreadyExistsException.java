package com.iiht.training.creditcard.exception;

public class CardNumberAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardNumberAlreadyExistsException() {
		super();
	}

	public CardNumberAlreadyExistsException(String message) {
		super(message);
	}

}
