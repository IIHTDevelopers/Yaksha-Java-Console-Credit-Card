package com.iiht.training.creditcard.inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.iiht.training.creditcard.exception.AmountNotAvailableException;
import com.iiht.training.creditcard.exception.CardBlockedException;
import com.iiht.training.creditcard.exception.CardNumberAlreadyExistsException;
import com.iiht.training.creditcard.exception.CardNumberDoesNotExistsException;
import com.iiht.training.creditcard.exception.InsufficientBalanceException;
import com.iiht.training.creditcard.exception.InvalidAmountException;
import com.iiht.training.creditcard.exception.InvalidCardNumberException;
import com.iiht.training.creditcard.model.Card;
import com.iiht.training.creditcard.model.Transactions;

public class CardInventory {

	public List<Card> cards = new ArrayList<>();
	public List<Transactions> transactions = new ArrayList<>();

	public boolean saveCard(Card card) {
		if (card.getCardNumber() == null) {
			throw new CardNumberDoesNotExistsException("The Card number does not exists");
		} else if (cardExists(card)) {
			throw new CardNumberAlreadyExistsException("The Card is Already Exists");
		} else if (String.valueOf(card.getCardNumber()).length() != 16) {
			throw new InvalidCardNumberException("Card Number is not valid");
		} else {
			cards.add(card);
			return true;
		}
	}

	public Double doTransaction(Long cardNumber, double amount) {
		if (amount < 100) {
			throw new InvalidAmountException("The amount is less than 100");
		}
		Card card = getCard(cardNumber);
		if (card.getStatus() == false) {
			throw new CardBlockedException("The Card is Blocked");
		}
		if (card.getBalance() <= 100) {
			throw new AmountNotAvailableException("Account Balance is not sufficient");
		}
		if (amount > card.getBalance()) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		Transactions transaction = new Transactions(transactions.size() + 1L, card.getCardNumber(), LocalDateTime.now(),
				amount);
		transactions.add(transaction);
		card.setBalance(card.getBalance() - amount);
		return card.getBalance();
	}

	public String showCardStatus(Long cardNumber) {
		Card card = getCard(cardNumber);
		if (card.getStatus() == true) {
			return "Active";
		} else {
			return "Inactive";
		}
	}

	public Double showBalance(Long cardNumber) {
		Card card = getCard(cardNumber);
		if (card.getStatus() == false) {
			throw new CardBlockedException("The card is Blocked");
		}
		return card.getBalance();
	}

	public List<Transactions> getAllTransactions() {
		return transactions;
	}

	private boolean cardExists(Card card) {
		for (Card c : cards) {
			if (c.getCardNumber().equals(card.getCardNumber())) {
				return true;
			}
		}
		return false;
	}

	private Card getCard(Long cardNumber) {
		for (Card card : cards) {
			if (card.getCardNumber().equals(cardNumber)) {
				return card;
			}
		}
		throw new CardNumberDoesNotExistsException("Card Number does not exists");
	}
}
