package code;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	Card[] deck;

	public Deck() {
		deck = new Card[52];
	}
	// @ co-author Mark & Nilesh

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
		return "Heart";

	}

	public String Club() {
		return "Club";

	}

	public String Spade() {
		return "Spade";

	}

	public String Diamond() {
		return "Diamond";
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
