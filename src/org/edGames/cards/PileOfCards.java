package org.edGames.cards;

import java.util.ArrayList;

/**
 * An ArrayList Implementation of a Pile of Cards <br>
 * Most card games are loosely based around the concept of shifting cards
 * between multiple piles. Games are defined by specify the specific rules for
 * how the piles can be reorganized. This class serves as a base class that will
 * allow the creation of multiple card games
 */

public class PileOfCards
   {

      // Instance data for the pile
      protected ArrayList<Card> pile;

      /**
       * Creates a new empty pile of cards
       */

      public PileOfCards()
         {
            pile = new ArrayList<Card>();
         }

      /**
       * Generates a string that represents the entire contents of the pile <br>
       * No additional labels are desired.
       * 
       * @return the string representation of the pile
       */
      public String toString()
         {
            String theString = "";
            for (int i = 0; i < pile.size(); i++)
               {
                  theString += pile.get(i).toString() + "\t";
               }

            return theString;
         }

      /**
       * Adds a card to the pile <br>
       * The method ensures that null cards cannot be added. (What happens if
       * you try?) Then it will return false. It will only return true if a card
       * is added
       * 
       * @param c
       *           the card object to be added to the pile
       * @return a boolean value indicated whether or not the card was
       *         successfully added.
       */

      public boolean addCard(Card c)
         {
            boolean added = false;
            if (c != null)
               {
                  added = true;
                  pile.add(c);
               }

            return added;
         }

      /**
       * Removes the last card from the pile. 
       * 
       * @return the last card in the pile or null if there are no cards left in
       *         the pile.
       */

      public Card removeCard()
         {
            Card c = pile.remove(pile.size() - 1);
            return c;
         }

      /**
       * Indicates if the pile is empty.
       * 
       * @return true if the pile is empty, false if the pile has cards.
       */

      public boolean isEmpty()
         {
            boolean empty = pile.isEmpty();
            return empty;
         }

      /**
       * Allows the viewer to see the last card in the pile, without removing
       * it.  
       * 
       * @return the last card in the pile or null if there are no cards left in
       *         the pile.
       */

      public Card getTopCard()
         {
            Card c = pile.get(pile.size() - 1);

            return c;
         }
      
      public Card getCardAt(int index)
         {
            Card cardAt = pile.get(index);
            
            return cardAt;
         }
   }
