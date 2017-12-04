package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import code.*;

public class AceUpTest {

	private AceUp ace;

	@Before
	public void Ace() {
		ace = new AceUp();
		TabHold2Initially();
		HomeHold0Initially();
	}

	// Tableau pile tests:
	// Tableau piles in Ace's Up initially hold 1 card [2 points]
	// Ace's Up tableau pile method correctly determines if adding a specific
	// card is legal or illegal. To receive points, your test cannot call two
	// separate methods (e.g., one for when the card comes from the stock pile
	// and one for when the card comes from another tableau) to perform this
	// check. [4 points]
	// Ace's Up tableau pile method correctly determines if removing a specific
	// card is legal or illegal. To receive points, your test cannot call two
	// separate methods (e.g., one for when the card is being moved to the
	// homecell pile and one for when the card is moved to another tableau pile)
	// to perform this check. [4 points]
	// Adding card to Ace's Up tableau pile increases its number of cards and
	// results in that card being the tableau pile's new top card [4 points]
	// Removing card from Ace's Up tableau pile decreases its number of cards
	// and results in following card being the new top card [4 points]
	// Homecell pile tests:
	// Homecell pile in Ace's Up initially holds 0 cards [2 points]
	// Ace's Up homecell pile correctly determines if adding a specific card is
	// legal or illegal (e.g., always legal) [2 points]
	// Ace's Up homecell pile correctly returns if removing top card is legal or
	// illegal (e.g., always illegal) [2 points]
	// Adding card to Ace's Up homecell pile increases its number of cards and
	// results in that card being the homecell pile's new top card [2 points]
	// Stock pile tests:
	// Ace's Up stock pile initially holds 48 cards [2 points]
	// Ace's Up stock pile correctly returns if adding a specific card is legal
	// or illegal (e.g., always illegal) [2 points]
	// Ace's Up stock pile correctly returns if removing a specific card is
	// legal or illegal (e.g., legal if the stock pile is not empty) [2 points]
	// Dealing cards from Ace's Up stock pile removes the top 4 cards, adds the
	// removed cards to the tableau piles, and results in the 5th card being the
	// new top card [2 points]
	@Test
	public void TabHold2Initially() {

		for (int i = 0; i < 4; i++) {

			assertTrue(ace.Tableau.get(i).size() == 1);
		}

	}

	@Test
	public void TabAdd() {

		assertTrue(ace.TableauPileadd(4, 1));

		assertFalse(ace.TableauPileadd(0, 1));

		ace.Tableau.set(0, new ArrayList<Card>());

		assertTrue(ace.TableauPileadd(0, 1));
	}

	@Test
	public void TabRemove() {
		boolean x = false;

		Card aa = ace.GetTopCardTab(1);
		for (int i = 0; i < 4; i++) {
			if (i != 1) {
				if ((ace.GetTopCardTab(i).getSuit().equals(aa.getSuit()))
						&& (ace.GetTopCardTab(i).getRank() > aa.getRank())) {
					x = true;
				}
			}
		}

		if (x)
			assertTrue(ace.tabremove(4, 1));
		else
			assertFalse(ace.tabremove(4, 1));

		assertFalse(ace.tabremove(2, 3));

		ace.Tableau.set(2, new ArrayList<Card>());

		assertTrue(ace.tabremove(2, 3));
	}

	@Test
	public void TabAddincrease() {
		int size = ace.Tableau.get(1).size();
		assertTrue(ace.TableauPileadd(4, 1));
		assertSame(size + 1, ace.Tableau.get(1).size());

		ace.Tableau.set(0, new ArrayList<Card>());
		int size2 = ace.Tableau.get(0).size();
		assertTrue(ace.TableauPileadd(0, 2));
		assertSame(size2 + 1, ace.Tableau.get(0).size());

	}

	@Test
	public void TabRemDecrease() {

		boolean x = false;

		Card aa = ace.GetTopCardTab(1);
		for (int i = 0; i < 4; i++) {
			if (i != 1) {
				if ((ace.GetTopCardTab(i).getSuit().equals(aa.getSuit()))
						&& (ace.GetTopCardTab(i).getRank() > aa.getRank())) {
					x = true;
				}
			}
		}

		if (x) {
			int size = ace.Tableau.get(1).size();
			assertTrue(ace.tabremove(4, 1));
			assertSame(size - 1, ace.Tableau.get(1).size());
		} else {
			int size = ace.Tableau.get(1).size();
			assertFalse(ace.tabremove(4, 1));
			assertSame(size, ace.Tableau.get(1).size());
		}

		int size1 = ace.Tableau.get(3).size();
		assertFalse(ace.tabremove(2, 3));
		assertSame(size1, ace.Tableau.get(3).size());

		ace.Tableau.set(2, new ArrayList<Card>());

		int size2 = ace.Tableau.get(3).size();
		assertTrue(ace.tabremove(2, 3));
		assertSame(size2 - 1, ace.Tableau.get(3).size());
	}

	@Test
	public void HomeHold0Initially() {

		assertTrue(ace.HomeCell.size() == 0);

	}

	@Test
	public void Homeadd() {

		assertTrue(ace.addtohom(ace.GetTopCardTab(1)));

	}

	@Test
	public void Homeremove() {

		assertFalse(ace.removeHomecell());

	}

	@Test
	public void HomeaddIncrease() {
		int size = ace.HomeCell.size();
		assertTrue(ace.addtohom(ace.GetTopCardTab(1)));
		assertSame(ace.HomeCell.get(ace.HomeCell.size() - 1), ace.GetTopCardTab(1));
		assertSame(size + 1, ace.HomeCell.size());

	}

	@Test
	public void StockHold48Initially() {

		assertTrue(ace.Stockpile.size() == 48);

	}

	@Test
	public void Stockadd() {

		assertFalse(ace.addStock(0));

	}

	@Test
	public void Stockremove() {
		if (ace.Stockpile.isEmpty())
			;
		else {
			assertTrue(ace.removeStock());
			assertTrue(ace.TableauPileadd(4, 1));
		}
	}

	@Test
	public void StockremoveDecrease() {
		if (ace.Stockpile.isEmpty())
			;
		else {
			Card a = null;
			int size = ace.Stockpile.size();

			if (size > 7) {
				a = ace.Stockpile.get(size - 5);
			}
			assertTrue(ace.removeStock());
			assertTrue(ace.TableauPileadd(4, 1));
			assertSame(size - 4, ace.Stockpile.size());
			if (a != null)
				assertSame(a, ace.Stockpile.get(ace.Stockpile.size() - 1));
		}
	}

}
