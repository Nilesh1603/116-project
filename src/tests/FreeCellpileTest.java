package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Freecell;

public class FreeCellpileTest {

	@Test
	public void checkFreeCellPilesInFreeCell() {
		Freecell a = new Freecell();
		Boolean check = false;
		for (int i = 0; i < 4; i++) {

			if (a.FreeCell.get(i).size() == 0)
				check = true;
			else {
				check = false;
				break;
			}
		}
		assertTrue(check);
	}

	@Test
	public void checkFreeAddInFreeCell() {
		Freecell a = new Freecell();
		if (a.FreeCell.get(1).isEmpty()) {
			assertTrue(a.addtofree(a.GetTopCardTab(2), 1));
		} else
			assertFalse(a.addtofree(a.GetTopCardTab(2), 1));
	}

	@Test
	public void checkFreeRemoveInFreeCell() {
		Freecell a = new Freecell();
		if (a.FreeCell.get(0).isEmpty()) {
			assertFalse(a.freeremove(0));
		} else
			assertTrue(a.freeremove(0));
	}

	@Test
	public void checkFreeAddIncNOFreeCell() {
		Freecell a = new Freecell();
		if (a.FreeCell.get(1).isEmpty()) {
			assertTrue(a.addtofree(a.GetTopCardTab(2), 1));
			assertEquals(1, a.FreeCell.get(1).size());
		}

	}
}
