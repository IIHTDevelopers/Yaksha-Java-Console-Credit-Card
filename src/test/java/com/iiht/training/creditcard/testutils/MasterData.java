package com.iiht.training.creditcard.testutils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iiht.training.creditcard.model.Card;
import com.iiht.training.creditcard.model.Transactions;

public class MasterData {

	public static Card getCardData() {
		Card card = new Card();
		card.setId(1L);
		card.setHolderName("Mayara");
		card.setCardNumber(1122334455667788L);
		card.setCardType("Shopping Card");
		card.setCardDetails("Shopping with additional 5% Discount");
		card.setBalance(100000.00);
		card.setStatus(true);
		return card;

	}

	public static List<Card> getCardList() {
		List<Card> cards = new ArrayList<>();
		Card card = new Card();
		card.setId(1L);
		card.setHolderName("Mayara");
		card.setCardNumber(1122334455667788L);
		card.setCardType("Shopping Card");
		card.setCardDetails("Shopping with additional 5% Discount");
		card.setBalance(100000.00);
		card.setStatus(true);
		cards.add(card);
		card = new Card();
		card.setId(2L);
		card.setHolderName("Peter");
		card.setCardNumber(3124900040003000L);
		card.setCardType("Visa Card");
		card.setCardDetails("Visa Card with Benifits");
		card.setBalance(200000.00);
		card.setStatus(false);
		cards.add(card);
		return cards;
	}

	public static Transactions getTransactionsData() {
		Transactions transaction = new Transactions();
		transaction.setId(1L);
		transaction.setCardNumber(1122334455667788L);
		transaction.setDateTime(LocalDateTime.now());
		transaction.setTransactionAmount(3000.00);
		return transaction;
	}

	public static List<Transactions> getTransactionsList() {
		List<Transactions> transactions = new ArrayList<>();
		Transactions transaction = new Transactions();
		transaction.setId(1L);
		transaction.setCardNumber(1122334455667788L);
		transaction.setDateTime(LocalDateTime.now());
		transaction.setTransactionAmount(3000.00);
		transactions.add(transaction);
		transaction = new Transactions();
		transaction.setId(2L);
		transaction.setCardNumber(3124900040003000L);
		transaction.setDateTime(LocalDateTime.now());
		transaction.setTransactionAmount(45000.00);
		return transactions;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);

			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
