package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.BakersDozengame;
import code.Card;
import code.Freecell;

public class tableauPileTests {

	// @author Nabeel and Nilesh
	@Test
	public void checkTableauPilesInFreeCell() {
		Freecell a = new Freecell();
		Boolean check = false;
		for (int i = 0; i < 8; i++) {

			if (a.Tableau.get(i).size() == 6 || a.Tableau.get(i).size() == 7)
				check = true;
			else {
				check = false;
				break;
			}
		}
		assertTrue(check);
	}

	@Test
	public void checkTableauPilesInBakers() {
		BakersDozengame a = new BakersDozengame();
		Boolean check = false;
		for (int i = 0; i < 13; i++) {

			if (a.Tableau.get(i).size() == 4)
				check = true;
			else {
				check = false;
				break;
			}
		}
		assertTrue(check);
	}

	@Test
	public void TableauAddCheckBakers() {
		BakersDozengame a = new BakersDozengame();

		Card first = a.GetCardTab(2, 3);
		Card second = a.GetCardTab(1, 3);
		Boolean check = false;
		if (second.getRank() - first.getRank() == 1 && first.getRank() < second.getRank()) {
			check = true;
		}

		if ((check && a.addtotab(first, 1, 3))) {
			assertTrue(true);
		} else if (check)
			assertTrue(false);
		else if (a.addtotab(first, 1, 3))
			assertTrue(false);
		else
			assertTrue(true);
	}

	@Test
	public void TableauAddCheckFreeCell() {
		Freecell a = new Freecell();

		Card first = a.GetCardTab(2, 3);
		Card second = a.GetCardTab(1, 3);
		Boolean check = false;
		if (second.getRank() - first.getRank() == 1 && first.getRank() < second.getRank()) {
			if ((first.getSuit().equals("Spade") || first.getSuit().equals("Club") && second.getSuit().equals("Diamond")
					|| second.getSuit().equals("Heart"))
					|| (first.getSuit().equals("Heart")
							|| first.getSuit().equals("Diamond") && second.getSuit().equals("Spade")
							|| second.getSuit().equals("Club")))
				check = true;
		}
		System.out.println(first.getRank() + first.getSuit());
		System.out.println(second.getRank() + second.getSuit() + " " + check + " " + a.addtotab(first, 1, 3));
		if ((check && a.addtotab(first, 1, 3))) {
			assertTrue(true);
		} else if (check)
			assertTrue(false);
		else if (a.addtotab(first, 1, 3))
			assertTrue(false);
		else
			assertTrue(true);
	}
}
