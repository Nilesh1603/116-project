package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BakersDozengame;
import code.Freecell;

public class BakersDozenTest {
	//@Nabeel
	//Each game instance has
	//13 tableau piles, 4 homecell piles, and 0 freecell piles [6 points]
	@Test
	public void checkTableauPiles(){
		BakersDozengame a= new BakersDozengame();
		assertEquals("CheckTableauPile.size()", 13, a.Tableau.size());
	}
	
	@Test 
	public void checkHomeCell(){
		BakersDozengame a= new BakersDozengame();
			assertEquals("CheckHomeCell.size()", 4, a.HomeCell.size());
	}
}
