package com.iiht.training.creditcard.exception;

import static com.iiht.training.creditcard.testutils.TestUtils.currentTest;
import static com.iiht.training.creditcard.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.creditcard.testutils.TestUtils.testReport;
import static com.iiht.training.creditcard.testutils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.creditcard.inventory.CardInventory;
import com.iiht.training.creditcard.model.Card;
import com.iiht.training.creditcard.testutils.MasterData;

class CardExceptionTest {

	static CardInventory cardInventory = null;

	@BeforeAll
	public static void setUp() {
		cardInventory = new CardInventory();
		cardInventory.cards = MasterData.getCardList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCardNumberAlreadyExistsException() throws IOException {
		Card card = MasterData.getCardData();
		CardNumberAlreadyExistsException thrown = Assertions.assertThrows(CardNumberAlreadyExistsException.class,
				() -> {
					cardInventory.saveCard(card);
				});
		String message = "The Card is Already Exists";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);

	}
	
	@Test
	public void testCardBlockedException() throws IOException {
		Card card =cardInventory.cards.get(0);
		card.setStatus(false);
		CardBlockedException thrown = Assertions.assertThrows(CardBlockedException.class,
				() -> {
					cardInventory.showBalance(card.getCardNumber());
				});
		String message = "The card is Blocked";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);
		
	}
	@Test
	public void testCardNumberDoesNotExistsException() throws IOException {
		Card card =MasterData.getCardList().get(1);
		card.setCardNumber(null);
		CardNumberDoesNotExistsException thrown = Assertions.assertThrows(CardNumberDoesNotExistsException.class,
				() -> {
					cardInventory.saveCard(card);
				});
		String message = "The Card number does not exists";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);
		
	}
	@Test
	public void testInvalidCardNumberException() throws IOException {
		Card card =MasterData.getCardList().get(1);
		card.setCardNumber(1234567891L);
		InvalidCardNumberException thrown = Assertions.assertThrows(InvalidCardNumberException.class,
				() -> {
					cardInventory.saveCard(card);
				});
		String message = "Card Number is not valid";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);
		
	}

}
