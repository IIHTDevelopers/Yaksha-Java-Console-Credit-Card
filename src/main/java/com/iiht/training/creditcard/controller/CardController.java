package com.iiht.training.creditcard.controller;

import com.iiht.training.creditcard.inventory.CardInventory;
import com.iiht.training.creditcard.model.Card;

public class CardController {

	public static void main(String[] args) {

		CardInventory inventory = new CardInventory();
//		Double balance = inventory.showBalance(1234_5678_9012_3456L);
//		System.out.println(balance);
		
//		Double transaction = inventory.doTransaction(1234_5678_9012_3456L, 30000);
//		System.out.println(transaction);
//		System.out.println(inventory.getAllTransactions());
		
		Card card = new Card(3L, "Navin", 9012_3123_6790_8000L, "Shopping Card", "Shopping Card with Perks", 100000.00, false);
		inventory.saveCard(card);
//		Double balance = inventory.showBalance(6321908723156780L);
//		System.out.println(balance);
		
//		Double transaction = inventory.doTransaction(6321908723156780L, 30000);
//		System.out.println(transaction);
//		

	}

}
