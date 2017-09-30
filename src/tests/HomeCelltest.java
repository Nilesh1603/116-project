package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.BakersDozengame;
import code.Freecell;

public class HomeCelltest {

	@Test
	public void checkTableauPilesInFreeCell() {
		Freecell a = new Freecell();
		Boolean check = false;
		for (int i = 0; i < 4; i++) {

			if (a.HomeCell.get(i).size() == 0)
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
		for (int i = 0; i < 4; i++) {

			if (a.HomeCell.get(i).size() == 0)
				check = true;
			else {
				check = false;
				break;
			}
		}
		assertTrue(check);
	}
}
