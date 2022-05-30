package com.iiht.training.creditcard.exception;

public class CardNumberDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardNumberDoesNotExistsException() {
		super();
	}

	public CardNumberDoesNotExistsException(String message) {
		super(message);
	}

}
