package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.BakersDozengame;
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

}
