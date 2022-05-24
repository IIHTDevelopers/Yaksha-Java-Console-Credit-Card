package com.iiht.training.creditcard.model;

import java.util.Objects;

public class Card {
	private Long id;
	private String holderName;
	private Long cardNumber;
	private String cardType;
	private String cardDetails;
	private Double balance;
	private Boolean status;

	public Card() {

	}

	public Card(Long id, String holderName, Long cardNumber, String cardType, String cardDetails, Double balance,
			Boolean status) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cardDetails = cardDetails;
		this.balance = balance;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", holderName=" + holderName + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", cardDetails=" + cardDetails + ", balance=" + balance + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, cardDetails, cardNumber, cardType, holderName, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(cardDetails, other.cardDetails)
				&& Objects.equals(cardNumber, other.cardNumber) && Objects.equals(cardType, other.cardType)
				&& Objects.equals(holderName, other.holderName) && Objects.equals(id, other.id)
				&& Objects.equals(status, other.status);
	}

}
