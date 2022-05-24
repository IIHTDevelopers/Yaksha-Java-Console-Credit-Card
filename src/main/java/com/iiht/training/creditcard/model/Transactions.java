package com.iiht.training.creditcard.model;

import java.time.LocalDateTime;

public class Transactions {

	private Long id;
	private Long cardNumber;
	private LocalDateTime dateTime; // 2007-12-03T10:15:30
	private Double transactionAmount;

	public Transactions() {
	}

	public Transactions(Long id, Long cardNumber, LocalDateTime dateTime, Double transactionAmount) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.dateTime = dateTime;
		this.transactionAmount = transactionAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", cardNumber=" + cardNumber + ", dateTime=" + dateTime
				+ ", transactionAmount=" + transactionAmount + "]";
	}
	
	

}
