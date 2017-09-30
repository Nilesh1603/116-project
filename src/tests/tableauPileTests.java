package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Freecell;
//@author Nabeel
public class tableauPileTests {

	public void checkTableauPilesInFreeCell(){
		Freecell a= new Freecell();
		assertEquals("CheckTableauPile.size()", 6, a.Tableau.size());
	
		
	}

}
