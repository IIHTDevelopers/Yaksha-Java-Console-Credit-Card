package com.iiht.training.creditcard.boundary;

import static com.iiht.training.creditcard.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.creditcard.testutils.TestUtils.currentTest;
import static com.iiht.training.creditcard.testutils.TestUtils.testReport;
import static com.iiht.training.creditcard.testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.creditcard.exception.CardNumberAlreadyExistsException;
import com.iiht.training.creditcard.exception.InvalidCardNumberException;
import com.iiht.training.creditcard.inventory.CardInventory;
import com.iiht.training.creditcard.model.Card;
import com.iiht.training.creditcard.testutils.MasterData;

public class BoundaryTest {

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
	public void testCardNumberIsUnique() throws Exception {
		Card card = MasterData.getCardData();
		try {
			cardInventory.saveCard(card);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (CardNumberAlreadyExistsException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}

	}

	@Test
	public void testCardNumberShouldBeSixteenDigits() throws Exception {
		Card card = MasterData.getCardData();
		card.setCardNumber(1234567890L);
		try {
			cardInventory.saveCard(card);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (InvalidCardNumberException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}

	}


}
