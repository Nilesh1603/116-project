package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Card;
import code.Deck;

public class deckAndCardClassTest {

	@Test
	public void definesDeckClass() {
		boolean check = false;
		Deck a = new Deck();
		Card[] ch = a.getDeck();
		for (int i = 0; i < 52; i++) {
			Card b = ch[i];
			for (int j = 1; j < 52; j++) {
				Card c = ch[j];
				if (b.getRank() != c.getRank() || !b.getSuit().equals(c.getSuit())) {
					check = true;
					assertTrue(check);

				}
			}

		}
		assertTrue(ch.length == 52);

	}
}
