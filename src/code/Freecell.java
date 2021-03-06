package code;

import java.util.ArrayList;

public class Freecell {
	/**
	 * This class Defines the Freecell portion
	 */
	public Card[] y;
	public ArrayList<ArrayList<Card>> Tableau;
	public ArrayList<ArrayList<Card>> HomeCell;
	public ArrayList<ArrayList<Card>> FreeCell;

	/**
	 * Creates and adds deck of cards
	 */
	public Freecell() {
		Deck A = new Deck();
		y = A.getDeck();
		Tableau = new ArrayList<ArrayList<Card>>();
		HomeCell = new ArrayList<ArrayList<Card>>();
		FreeCell = new ArrayList<ArrayList<Card>>();
		TableauPile();
		FreeCell();
		Homecell();

	}

	/**
	 * Creates homecell and free cell piles
	 */

	public void TableauPile() {

		int count = 0;
		for (int i = 0; i < 4; i++) {
			ArrayList<Card> a = new ArrayList<Card>();

			for (int j = 0; j < 7; j++) {
				a.add(y[count]);
				count++;
			}
			Tableau.add(a);
		}
		for (int i = 4; i < 8; i++) {
			ArrayList<Card> a = new ArrayList<Card>();

			for (int j = 0; j < 6; j++) {
				a.add(y[count]);
				count++;
			}
			Tableau.add(a);
		}

	}

	/**
	 * Sets rules for removing a card from a Tableau
	 * 
	 * @param a
	 *            Card rank
	 * @param b
	 *            Card suit
	 * @return true if Card can be removed
	 */

	public boolean tabremove(int a, int b) {

		if (Tableau.get(a).get(b) != null
				&& Tableau.get(a).get(b).equals(Tableau.get(a).get(Tableau.get(a).size() - 1))) {
			if (b == Tableau.get(a).size() - 1) {
				Tableau.get(a).remove(b);
				return true;
			}
		}
		return false;

	}

	/*
	 * public boolean tabremovetoFree(int a, int b, int c) { if
	 * (Tableau.get(a).get(b) != null &&
	 * Tableau.get(a).get(b).equals(Tableau.get(a).get(Tableau.get(a).size() -
	 * 1))) { if (b == Tableau.get(a).size() - 1) { Card aa =
	 * Tableau.get(a).get(b); if (addtofree(aa, c)) { Tableau.get(a).remove(b);
	 * 
	 * } }
	 * 
	 * return true; } return false;
	 * 
	 * }
	 * 
	 * public boolean tabremovetoTab(int a, int b, int c, int d)// d is size-1
	 * of // the // c tab // pile {
	 * 
	 * if (Tableau.get(a).get(b) != null &&
	 * Tableau.get(a).get(b).equals(Tableau.get(a).get(Tableau.get(a).size() -
	 * 1))) { if (b == Tableau.get(a).size() - 1) { Card aa =
	 * Tableau.get(a).get(b); if (addtotab(aa, c, d)) {
	 * Tableau.get(a).remove(b); } } return true; } return false;
	 * 
	 * }
	 */
	/**
	 * Allows for a card to be removed from a pile and stored outside of any
	 * pile
	 * 
	 * @param aa
	 * @param i
	 * @return true if Card can be added to free
	 */
	public boolean addtofree(Card aa, int i) {

		if (FreeCell.get(i).isEmpty()) {
			FreeCell.get(i).add(aa);
			return true;
		} else
			return false;

	}

	public boolean freeremove(int a) {

		if (FreeCell.get(a) != null && !FreeCell.get(a).isEmpty()) {

			FreeCell.get(a).remove(0);
			return true;
		}
		return false;
	}

	/*
	 * public void freeremove(int a, int b) {
	 * 
	 * if (FreeCell.get(a) != null && !FreeCell.get(a).isEmpty()) { Card aa =
	 * FreeCell.get(a).get(0); if (addtohom(aa, b)) FreeCell.get(a).remove(0); }
	 * 
	 * }
	 */
	public boolean addtohom(Card aa, int a) {
		if (HomeCell.get(a).isEmpty()) {
			if (aa.getRank() == 0) {
				HomeCell.get(a).add(aa);
				return true;
			} else
				return false;
		} else {
			if (aa.getSuit().equals(HomeCell.get(a).get((HomeCell.get(a).size()) - 1).getSuit())
					&& aa.getRank() - HomeCell.get(a).get((HomeCell.get(a).size()) - 1).getRank() == 1) {
				HomeCell.get(a).add(aa);
				return true;
			} else
				return false;
		}

		// TODO Auto-generated method stub

	}

	public boolean addtotab(Card a, int c, int d) {

		if (((Tableau.get(c).get(d).getSuit().equals("Spade") || Tableau.get(c).get(d).getSuit().equals("Club"))
				&& (a.getSuit().equals("Diamond") || a.getSuit().equals("Heart")))
				|| (((Tableau.get(c).get(d).getSuit().equals("Heart")
						|| Tableau.get(c).get(d).getSuit().equals("Diamond"))
						&& (a.getSuit().equals("Spade") || a.getSuit().equals("Club"))))) {
			if (Tableau.get(c).get(d).getRank() - a.getRank() == 1) {
				Tableau.get(c).add(a);
				return true;
			}
		} else if (Tableau.get(c).isEmpty()) {// if tab is empty any card added
			Tableau.get(c).add(a);
			return true;
		}

		return false;

	}

	public void Homecell() {
		for (int j = 0; j < 4; j++) {
			ArrayList<Card> a = new ArrayList<Card>();
			HomeCell.add(a);
		}

	}

	public boolean removeHomecell(int a) {
		return false;

	}

	public void FreeCell() {
		for (int j = 0; j < 4; j++) {
			ArrayList<Card> a = new ArrayList<Card>();
			FreeCell.add(a);
		}

	}

	public Card GetTopCardTab(int a) {

		return Tableau.get(a).get(Tableau.get(a).size() - 1);

	}

	public Card GetTopCardHome(int a) {
		return HomeCell.get(a).get(HomeCell.get(a).size() - 1);
	}

	public Card GetCardTab(int a, int b) {
		if (Tableau.get(a).get(b) != null && !Tableau.isEmpty())
			return Tableau.get(a).get(b);
		return null;
	}

	public Card GetCardHome(int a, int b) {
		if (HomeCell.get(a).get(b) != null)
			return HomeCell.get(a).get(b);

		return null;
	}

	public Card GetCardFree(int a, int b) {
		if (FreeCell.get(a).get(b) != null)
			return FreeCell.get(a).get(b);

		return null;
	}

}
