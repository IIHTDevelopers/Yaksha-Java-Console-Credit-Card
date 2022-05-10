package com.iiht.training.creditcard.exception;

public class AmountNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AmountNotAvailableException() {
		super();
	}

	public AmountNotAvailableException(String message) {
		super(message);
	}

}
