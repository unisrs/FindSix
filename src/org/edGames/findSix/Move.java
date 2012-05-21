package org.edGames.findSix;

import org.edGames.cards.*;

public class Move {
	private Card card1;
	private Card card2;
	private long timeToMove;
	
	public Move(Card c1, Card c2, long t){
		card1 = c1;
		card2 = c2;
		timeToMove = t;
	}

	public String toString(){
		String m = "";
		
		if ((card1 == null) || (card2 == null))
			m = "No Move";
		else
			m=  card1.getResourceTag() + "," + card2.getResourceTag() + "," + timeToMove;
		return m;
	}
}
