package code;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	Card[] deck;

	/**
	 * creates a new deck with 52 cards by calling the Card.java
	 */
	public Deck() {
		deck = new Card[52];
	}

	// @ co-author Mark & Nilesh
	/**
	 * 
	 * @return adds suits to the deck with 14 cards each
	 */
	public Card[] getDeck() {

		int j = 0;
		for (int i = 1; i < 14; i++) {
			deck[j] = new Card(Spade(), i);
			j++;
		}
		for (int i = 1; i < 14; i++) {
			deck[j] = new Card(Heart(), i);
			j++;
		}
		for (int i = 1; i < 14; i++) {
			deck[j] = new Card(Club(), i);
			j++;
		}
		for (int i = 1; i < 14; i++) {
			deck[j] = new Card(Diamond(), i);
			j++;
		}

		unique();
		return deck;
	}

	// @Mark
	public String Heart() {
		return "h";

	}

	public String Club() {
		return "c";

	}

	public String Spade() {
		return "s";

	}

	public String Diamond() {
		return "d";
	}

	// @Nilesh
	public void unique() {
		ArrayList<Card> a = new ArrayList<Card>();

		for (int i = 0; i < 52; i++) {
			a.add(deck[i]);
		}
		Collections.shuffle(a);
		for (int i = 0; i < 52; i++) {
			deck[i] = a.get(i);
		}

	}
}
