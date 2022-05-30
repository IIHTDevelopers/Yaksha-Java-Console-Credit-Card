package com.iiht.training.creditcard.exception;

public class CardBlockedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardBlockedException() {
		super();
	}

	public CardBlockedException(String message) {
		super(message);
	}

}
