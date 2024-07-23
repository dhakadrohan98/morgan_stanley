package com.wissen.ooad;

import java.util.*;

public class DeckOfCardsClientClass
{
	public static void main(String[] args) {
	    DeckOfCards deck = new DeckOfCards();
	    //System.out.println(deck.toString());
	    
	    System.out.println(sortCards(deck.cards).toString());
	    
	    Card first = deck.cards.get(2);
	    Card second =  deck.cards.get(10);
	    System.out.println("first - " + first + " second - " + second + " bigger - " + findBiggerCard(first, second).toString());
	}
	
	public static ArrayList<Card> sortCards(ArrayList<Card> cards){
      //TODO logic 
      return cards;
    }
    
    public static Card findBiggerCard(Card first, Card second){
      //TODO logic 
      return first;
    }
}

class DeckOfCards {
    
  protected final ArrayList<Card> cards;
  public DeckOfCards() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        cards = new ArrayList<Card>();
        for (int i = 0; i<suits.length; i++) {
            for(int j=0; j<ranks.length; j++){
                this.cards.add(new Card(suits[i], ranks[j]));
            }
        }   
        //Shuffle after the creation
        Collections.shuffle(this.cards);
  }
  
  public String toString(){
      return cards.toString();
  }
}

enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;
}

class Card {

  private Suit suit;
  private Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }
  
  public String toString(){
      return "card " + suit + " " + rank;
  }
  
}

enum Rank {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;
}
