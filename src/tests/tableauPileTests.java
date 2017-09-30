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
			if (((first.getSuit().equals("Spade") || first.getSuit().equals("Club"))
					&& (second.getSuit().equals("Diamond") || second.getSuit().equals("Heart")))
					|| (((first.getSuit().equals("Heart") || first.getSuit().equals("Diamond"))
							&& (second.getSuit().equals("Spade") || second.getSuit().equals("Club")))))
				check = true;
		} else if (a.Tableau.get(1).isEmpty())
			check = true;

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

	@Test
	public void TableauRemovetofreeCheckFreeCell() {
		Freecell a = new Freecell();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoFree(i, b - 1, 2)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoFree(i, j, 2)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemovetohomeCheckFreeCell() {
		Freecell a = new Freecell();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoHome(i, b - 1, 2)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoHome(i, j, 2)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemovetotabCheckFreeCell() {
		Freecell a = new Freecell();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoTab(i, b - 1, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoTab(i, j, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemovetohomeCheckBakersCell() {
		BakersDozengame a = new BakersDozengame();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoHome(i, b - 1, 2)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoHome(i, j, 2)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemovetotabCheckBakersCell() {
		BakersDozengame a = new BakersDozengame();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoTab(i, b - 1, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoTab(i, j, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauAddIncreaseInNOCheckBakers() {
		BakersDozengame a = new BakersDozengame();

		Card first = a.GetCardTab(2, 3);
		Card second = a.GetCardTab(1, 3);
		int size = a.Tableau.get(1).size();
		Boolean check = false;
		if (second.getRank() - first.getRank() == 1 && first.getRank() < second.getRank()) {
			check = true;
		}

		if ((check && a.addtotab(first, 1, 3))) {
			assertTrue(true);
			if (size + 1 == a.Tableau.get(1).size())
				assertTrue(true);
			else
				assert (false);
		} else if (check)
			assertTrue(false);
		else if (a.addtotab(first, 1, 3))
			assertTrue(false);
		else
			assertTrue(true);
	}

	@Test
	public void TableauAddIncreaseInNOCheckFreeCell() {
		Freecell a = new Freecell();

		Card first = a.GetCardTab(2, 3);
		Card second = a.GetCardTab(1, 3);
		int size = a.Tableau.get(1).size();
		Boolean check = false;
		if (second.getRank() - first.getRank() == 1 && first.getRank() < second.getRank()) {
			if (((first.getSuit().equals("Spade") || first.getSuit().equals("Club"))
					&& (second.getSuit().equals("Diamond") || second.getSuit().equals("Heart")))
					|| (((first.getSuit().equals("Heart") || first.getSuit().equals("Diamond"))
							&& (second.getSuit().equals("Spade") || second.getSuit().equals("Club")))))
				check = true;
		} else if (a.Tableau.get(1).isEmpty())
			check = true;

		System.out.println(first.getRank() + first.getSuit());
		System.out.println(second.getRank() + second.getSuit() + " " + check + " " + a.addtotab(first, 1, 3));
		if ((check && a.addtotab(first, 1, 3))) {
			assertTrue(true);
			if (size + 1 == a.Tableau.get(1).size())
				assertTrue(true);
			else
				assert (false);
		} else if (check)
			assertTrue(false);
		else if (a.addtotab(first, 1, 3))
			assertTrue(false);
		else
			assertTrue(true);
	}

	@Test
	public void TableauRemoveDecreaseInNotofreeCheckFreeCell() {
		Freecell a = new Freecell();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.FreeCell.get(2).isEmpty() && a.tabremovetoFree(i, b - 1, 2)) {
					assertTrue(true);

					if (b - 1 == a.Tableau.get(i).size())
						assertTrue(true);
					else
						assertTrue(false);
				}

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoFree(i, j, 2)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemoveDecreaseInNotohomeCheckFreeCell() {
		Freecell a = new Freecell();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoHome(i, b - 1, 3) && !a.HomeCell.get(3).isEmpty()) {
					assertTrue(true);

					if (a.Tableau.get(i).get(b - 1).getSuit()
							.equals(a.HomeCell.get(3).get((a.HomeCell.get(3).size()) - 1).getSuit())
							&& a.Tableau.get(i).get(b - 1).getRank()
									- a.HomeCell.get(3).get((a.HomeCell.get(3).size()) - 1).getRank() == 1) {
						if (b - 1 == a.Tableau.get(i).size())
							assertTrue(true);
						else
							assertTrue(false);
					}
				}

			}

		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoHome(i, j, 2)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemoveDecreaseInNototabCheckFreeCell() {
		Freecell a = new Freecell();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoTab(i, b - 1, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoTab(i, j, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemoveDecreaseInNotohomeCheckBakersCell() {
		BakersDozengame a = new BakersDozengame();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoHome(i, b - 1, 2)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoHome(i, j, 2)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}

	@Test
	public void TableauRemoveDecreaseInNototabCheckBakersCell() {
		BakersDozengame a = new BakersDozengame();
		for (int i = 0; i < 8; i++) {
			int b = a.Tableau.get(i).size();
			if (!a.Tableau.get(i).isEmpty()) {
				if (a.tabremovetoTab(i, b - 1, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(true);
				} else
					assertTrue(false);

			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < a.Tableau.get(i).size() - 1; j++) {
				if (a.tabremovetoTab(i, j, 2, a.Tableau.get(2).size() - 1)) {
					assertTrue(false);
				} else
					assertTrue(true);

			}
		}
	}
}
