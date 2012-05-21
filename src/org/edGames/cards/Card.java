package org.edGames.cards;




/*******************************************************************************
 * 
 * Represents a Playing Card for edGames: <br>
 * Each card has a value (1 through 5) and a suit (asterisk, circle, pentagon,
 * square, triangle, x) <br>
 * Invalid ranks and suits are treated as jokers.
 * 
 * @author Stephen Hughes
 */

public class Card {
	private static String valSymbols = "012345";
	private static String[] valNames = { "0","1", "2", "3", "4", "5" };

	private static String suitSymbols = "nacpstx";
	private static String[] suitNames = { "None", "Asterisk", "Circle", "Pentagon",
			"Square", "Triangle", "X" };

	private int suit;
	private int value;
	private boolean isShowing;

	private String imgFileName;
	private String resourceTag;
	

	/**
	 * Creates a card - Invalid cards are treated as noCard (n0). Use this
	 * constructor to create an individual card based on characters
	 * 
	 * @param v
	 *            the value of the card - expressed as a character 1,2,3,4,5
	 * @param s
	 *            the suit of the card - expressed as a character a,c,p,s,t,x
	 */

	public Card(char v, char s) {
		suit = suitSymbols.indexOf(s);
		value = valSymbols.indexOf(v) + 1;

		if ((suit == -1) || (value == -1) || value == 0) {
			suit = 0;
			value = 0;
			s = 'n';
			v = '0';
		}

		imgFileName = s + v + ".png";
		resourceTag = s+v+"";
		isShowing = true;
	}

	/**
	 * Creates a card - Invalid cards are treated as noCard (n0). Use this
	 * constructor to create an block of cards using integers from a loop.
	 * 
	 * @param v
	 *            the value of the card - expressed as a character 1,2,3,4,5
	 * @param s
	 *            the suit of the card - expressed as a character a,c,p,s,t,x
	 * 
	 */

	public Card(int v, int s) {
		char val;
		char su;

		suit = s;
		value = v;

		if ((suit < 1) || (suit >= suitSymbols.length()) || (value < 1)
				|| (value >= valSymbols.length())) {
			suit = 0;
			value = 0;
			su = 'n';
			val = '0';
		} else {
			val = valSymbols.charAt(v);
			su = suitSymbols.charAt(s);
		}
		imgFileName = ""+su  + val + ".png";
		resourceTag = ""+su+val;
		isShowing = true;
	}

	/**
	 * Returns a text version of the card.
	 * 
	 * @return the text version of the card
	 */
	public String toString() {
		String theCard = "";
		if ((suit == 0) || (value == 0))
			theCard = "no Card";
		else
			theCard = valNames[value] + suitNames[suit];

		return theCard;
	}

	/**
	 * Returns a graphic version of the card. ImageIcons can be applied to a
	 * JLabel
	 * 
	 * @return the image version of the card
	 */

	public String getResourceTag() {
		
		return resourceTag;

	}

	public boolean Flip(){
		isShowing = !isShowing;
		return isShowing;
	}
	
	public boolean isShowing(){
		return isShowing;
	}
	
	public boolean faceDown(){
		isShowing = false;
		return isShowing;
	}
	public boolean faceUp(){
		isShowing = true;
		return isShowing;
	}
	
	/**
	 * Gets the value of the suit
	 * 
	 * @return the appropriate value for a specific suit
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * gets the numeric value of the card
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * returns true if the cards have the same value. Suit is not checked
	 * 
	 * @param c
	 *            the card being checked if it equals
	 * @return
	 */
	public boolean equals(Card c) {
		return value == c.value;
	}

	public static int indexOfSuit(String target) {
		int index = 0;
		for (int i = 0; i < suitNames.length; i++) {
			if (target.equals(suitNames[i]))
				index = i;
		}
		return index;
	}
}
