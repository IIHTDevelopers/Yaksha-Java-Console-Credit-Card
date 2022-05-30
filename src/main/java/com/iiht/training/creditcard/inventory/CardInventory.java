package com.iiht.training.creditcard.inventory;

import java.util.ArrayList;
import java.util.List;

import com.iiht.training.creditcard.exception.CardNumberDoesNotExistsException;
import com.iiht.training.creditcard.model.Card;
import com.iiht.training.creditcard.model.Transactions;

public class CardInventory {

	public List<Card> cards = new ArrayList<>();
	public List<Transactions> transactions = new ArrayList<>();

	public boolean saveCard(Card card) {
		return false;
	}

	public Double doTransaction(Long cardNumber, double amount) {

		return 0.0;
	}

	public String showCardStatus(Long cardNumber) {
		// The method will return Active or Inactive 
		return "";
	}

	public Double showBalance(Long cardNumber) {
		return 0.0;
	}

	public List<Transactions> getAllTransactions() {
		return null;
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
