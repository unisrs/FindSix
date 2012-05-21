package org.edGames.cards;

/**
 * Creates a randomly shuffled pile of cards that player draws from
 * 
 * @author Stephen Hughes
 *
 */

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards extends PileOfCards {
	Random generator = new Random();

	// ArrayList<Card> deck;

	public DeckOfCards() {
		super();
		for (int i = 1; i <= 5; i++)
			for (int j = 1; j <= 6; j++){
				this.addCard(new Card(i, j));
				}
	}

	public void shuffle() {
		// Create a temporary Card ArrayList to hold the rearranged cards.
		ArrayList<Card> tempPile = new ArrayList<Card>();

		// Remove a random card from the DeckOfCards and place it into the
		// temporary list until the initial list is empty.
		while (pile.size() > 0)
			tempPile.add(pile.remove((int) (Math.random() * pile.size())));

		pile = tempPile; // Replace the pile 

	}

}
