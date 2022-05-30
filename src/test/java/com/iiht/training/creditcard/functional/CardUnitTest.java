package com.iiht.training.creditcard.functional;

import static com.iiht.training.creditcard.testutils.TestUtils.businessTestFile;
import static com.iiht.training.creditcard.testutils.TestUtils.currentTest;
import static com.iiht.training.creditcard.testutils.TestUtils.testReport;
import static com.iiht.training.creditcard.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.creditcard.inventory.CardInventory;
import com.iiht.training.creditcard.model.Card;
import com.iiht.training.creditcard.model.Transactions;
import com.iiht.training.creditcard.testutils.MasterData;

class CardUnitTest {

	static CardInventory cardInventory = null;

	@BeforeAll
	public static void setUp() {
		cardInventory = new CardInventory();
		cardInventory.cards = MasterData.getCardList();
		cardInventory.transactions = MasterData.getTransactionsList();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testSaveCard() throws IOException {
		Card card = MasterData.getCardData();
		card.setCardNumber(9000800070006000L);
		yakshaAssert(currentTest(), cardInventory.saveCard(card) ? true : false, businessTestFile);
	}

	@Test
	public void testShowCardStatus() throws IOException {
		Card card = cardInventory.cards.get(0);;
		yakshaAssert(currentTest(), cardInventory.showCardStatus(card.getCardNumber()).equals("Active") ? true : false, businessTestFile);
	}
	@Test
	public void testShowCardBalance() throws IOException {
		Card card = cardInventory.cards.get(0);
		yakshaAssert(currentTest(), cardInventory.showBalance(card.getCardNumber()).equals(100000.00) ? true : false, businessTestFile);
	}
	@Test
	public void testCardDoTransaction() throws IOException {
		Card card = cardInventory.cards.get(0);
		yakshaAssert(currentTest(), cardInventory.doTransaction(card.getCardNumber(), 30000.00).equals(70000.00) ? true : false, businessTestFile);
	}
	@Test
	public void testGetAllTransactions() throws IOException {
		List<Transactions> transactions = cardInventory.transactions;
		yakshaAssert(currentTest(), cardInventory.getAllTransactions().size() == transactions.size() ? true : false, businessTestFile);
	}
}
