package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BakersDozengame;
import code.Card;
import code.Freecell;

public class HomeCelltest {

	@Test
	public void checkHomeCellPilesInFreeCell() {
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
	public void checkHomeCellPilesInBakers() {
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

	@Test
	public void HomecellAddCheckFreeCell() {
		Freecell a = new Freecell();

		Card second = a.GetTopCardTab(2);

		a.addtohom(second, 2);

		if (a.HomeCell.get(0).isEmpty()) {
			if (second.getRank() == 0) {
				assertEquals(second, a.GetTopCardHome(2));
			}
		} else if (a.GetCardHome(2, a.HomeCell.size() - 2).getSuit().equals(second.getSuit())
				&& second.getRank() - a.GetCardHome(2, a.HomeCell.size() - 2).getRank() == 1) {
			assertEquals(second, a.GetTopCardHome(2));
		}
	}

	@Test
	public void HomecellAddCheckBakers() {
		BakersDozengame a = new BakersDozengame();

		Card second = a.GetTopCardTab(2);

		a.addtohom(second, 2);

		if (a.HomeCell.get(0).isEmpty()) {
			if (second.getRank() == 0) {
				assertEquals(second, a.GetTopCardHome(2));
			}
		} else if (a.GetCardHome(2, a.HomeCell.size() - 2).getSuit().equals(second.getSuit())
				&& second.getRank() - a.GetCardHome(2, a.HomeCell.size() - 2).getRank() == 1) {
			assertEquals(second, a.GetTopCardHome(2));
		}
	}

	@Test
	public void HomecellremoveFreecell() {
		Freecell a = new Freecell();

		assertFalse(a.removeHomecell(1));
	}

	@Test
	public void HomecellremoveBakers() {
		BakersDozengame a = new BakersDozengame();

		assertFalse(a.removeHomecell(1));
	}

	@Test
	public void HomeCellAddIncreaseInNOCheckBakers() {
		BakersDozengame a = new BakersDozengame();

		Card first = a.GetCardTab(2, 3);
		Card second = a.GetCardTab(1, 3);

		if ((first.getRank() - second.getRank() == 1 && first.getRank() > second.getRank())
				&& first.getSuit().equals(second.getSuit())) {
			assertTrue(a.addtohom(first, 1));
		} else
			assertFalse(a.addtohom(first, 1));

	}

	@Test
	public void HomeCellAddIncreaseInNOCheckHomecell() {
		Freecell a = new Freecell();

		Card first = a.GetCardTab(2, 3);
		Card second = a.GetCardTab(1, 3);

		if ((first.getRank() - second.getRank() == 1 && first.getRank() > second.getRank())
				&& first.getSuit().equals(second.getSuit())) {
			assertTrue(a.addtohom(first, 1));
		} else
			assertFalse(a.addtohom(first, 1));

	}

}
