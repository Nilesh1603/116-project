package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Freecell;

public class FreecellTest {
	//Each game instance has 8 tableau piles, 4 homecell piles, and 4 freecell piles 
	
	
	@Test
	public void checkTableauPiles(){
		Freecell a= new Freecell();
		assertEquals("CheckTableauPile.size()", 8, a.Tableau.size());
		
	}
	

}
