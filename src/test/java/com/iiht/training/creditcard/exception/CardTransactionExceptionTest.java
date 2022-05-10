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

class CardTransactionExceptionTest {

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
	public void testCardTransactionAmountNotAvailableException() throws IOException {
		Card card = cardInventory.cards.get(0);
		card.setBalance(50.00);
		AmountNotAvailableException thrown = Assertions.assertThrows(AmountNotAvailableException.class,
				() -> {
					cardInventory.doTransaction(card.getCardNumber(), 2000.00);
				});
		String message = "Account Balance is not sufficient";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);

	}
	@Test
	public void testCardTransactionInsuffecientBalanceException() throws IOException {
		Card card = cardInventory.cards.get(0);
		card.setBalance(100000.00);
		InsufficientBalanceException thrown = Assertions.assertThrows(InsufficientBalanceException.class,
				() -> {
					cardInventory.doTransaction(card.getCardNumber(), 200000.00);
				});
		String message = "Insufficient Balance";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);
		
	}
	@Test
	public void testCardTransactionInvalidAmountException() throws IOException {
		Card card = cardInventory.cards.get(0);
		card.setBalance(100000.00);
		InvalidAmountException thrown = Assertions.assertThrows(InvalidAmountException.class,
				() -> {
					cardInventory.doTransaction(card.getCardNumber(), 50.00);
				});
		String message = "The amount is less than 100";
		yakshaAssert(currentTest(), message.contentEquals(thrown.getMessage()) ? true : false, exceptionTestFile);
		
	}

}
