package code;

import java.util.ArrayList;

//@author Nilesh
//@author Nabeel
//x
public class BakersDozengame {
	public Card[] y;
	public ArrayList<ArrayList<Card>> Tableau;
	public ArrayList<ArrayList<Card>> HomeCell;

	// 13 diff arraylists, decks already shuffled
	// arraylist of card arraylists
	/**
	 * creates the bakers dozen game
	 */
	public BakersDozengame() {
		Deck A = new Deck();
		y = A.getDeck();
		Tableau = new ArrayList<ArrayList<Card>>();
		HomeCell = new ArrayList<ArrayList<Card>>();
		dealToTableauPile();
		Homecell();
	}

	/**
	 * deals cards to Tableau Pile
	 */
	public void dealToTableauPile() {

		int count = 0;
		for (int i = 0; i < 13; i++) {
			ArrayList<Card> a = new ArrayList<Card>();

			for (int j = 0; j < 4; j++) {
				a.add(y[count]);
				count++;
			}

			Card aa = a.get(3);
			if (aa.getRank() == 13) {
				if (aa.getRank() == 13 && a.get(0).getRank() != 13) {
					Card temp = a.get(3);
					a.set(3, a.get(0));
					a.set(0, temp);
				}

				else if (aa.getRank() == 13 && a.get(1).getRank() != 13) {
					Card temp = a.get(3);
					a.set(3, a.get(1));
					a.set(1, temp);
				} else if (aa.getRank() == 13 && a.get(2).getRank() != 13) {
					Card temp = a.get(3);
					a.set(3, a.get(2));
					a.set(2, temp);
				}
			}
			aa = a.get(2);
			if (aa.getRank() == 13) {
				if (aa.getRank() == 13 && a.get(0).getRank() != 13) {
					Card temp = a.get(2);
					a.set(2, a.get(0));
					a.set(0, temp);
				}

				else if (aa.getRank() == 13 && a.get(1).getRank() != 13) {
					Card temp = a.get(2);
					a.set(2, a.get(1));
					a.set(1, temp);
				}
			}
			aa = a.get(1);
			if (aa.getRank() == 13) {
				if (aa.getRank() == 13 && a.get(0).getRank() != 13) {
					Card temp = a.get(1);
					a.set(1, a.get(0));
					a.set(0, temp);
				}
			}

			Tableau.add(a);
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if the card is removed
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
	 * 
	 * @param aa
	 * @param a
	 * @return true if specific card is added to home
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

	/**
	 * 
	 * @param a
	 * @param c
	 * @param d
	 * @return true if specific card is added to tableau
	 */

	public boolean addtotab(Card a, int c, int d) {
		if (Tableau.get(c).get(d).getRank() - a.getRank() == 1) {
			Tableau.get(c).add(a);
			return true;
		}
		if (Tableau.get(c).isEmpty())
			return true;
		return false;

	}

	/**
	 * Creates Homecell
	 * 
	 */

	public void Homecell() {
		for (int j = 0; j < 4; j++) {
			ArrayList<Card> a = new ArrayList<Card>();
			HomeCell.add(a);
		}

	}

	/**
	 * 
	 * @param a
	 *            specific Homecell
	 * @return true of Homecell is removed
	 */

	public boolean removeHomecell(int a) {
		return false;

	}

	/**
	 * gets the card at the top of the Tableau pile
	 * 
	 * @param a
	 *            Rank of the card to be returned
	 * @return the top card in a Tableau
	 */
	public Card GetTopCardTab(int a) {

		return Tableau.get(a).get(Tableau.get(a).size() - 1);

	}

	/**
	 * @param a
	 * @return the top Card in a HomeCell
	 */

	public Card GetTopCardHome(int a) {
		return HomeCell.get(a).get(HomeCell.get(a).size() - 1);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return get card from Tableau?
	 */

	public Card GetCardTab(int a, int b) {
		if (Tableau.get(a).get(b) != null && !Tableau.isEmpty())
			return Tableau.get(a).get(b);
		return null;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return get Card from Homecell
	 */
	public Card GetCardHome(int a, int b) {
		if (HomeCell.get(a).get(b) != null && !HomeCell.isEmpty())
			return HomeCell.get(a).get(b);
		return null;
	}

}
