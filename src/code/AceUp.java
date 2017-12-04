package code;

import java.util.ArrayList;

public class AceUp {

	public Card[] y;
	public ArrayList<ArrayList<Card>> Tableau;
	public ArrayList<Card> HomeCell;
	public ArrayList<Card> Stockpile;
	private int count;
	private int Stockcount;

	/**
	 * creates the aceup game
	 */
	public AceUp() {
		Deck A = new Deck();
		y = A.getDeck();
		Tableau = new ArrayList<ArrayList<Card>>();
		HomeCell = new ArrayList<Card>();
		Stockpile = new ArrayList<Card>();
		Stockcount = 0;
		count = 0;
		dealToTableauPile();

		StockPile();

	}

	private void StockPile() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 48; i++) {
			Stockpile.add(y[count]);
			count++;
			Stockcount++;
		}

	}

	/**
	 * deals cards to Tableau Pile
	 */
	public void dealToTableauPile() {

		for (int i = 0; i < 4; i++) {
			ArrayList<Card> a = new ArrayList<Card>();

			a.add(y[count]);
			count++;
			Tableau.add(a);
		}

	}

	public boolean TableauPileadd(int a, int b) {

		if (a == 4) {
			if (Stockcount > 3) {
				for (int i = 0; i < 4; i++) {

					Card x = Stockpile.get(Stockcount - 1);
					Stockcount--;
					Stockpile.remove(x);
					Tableau.get(i).add(x);

				}
				return true;
			}
			return false;
		} else {
			return AddtoTab(a, b);

		}

	}

	private boolean AddtoTab(int a, int b) {
		// TODO Auto-generated method stub
		if (Tableau.get(a).isEmpty()) {
			Tableau.get(a).add(GetTopCardTab(b));
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return true if the card is removed
	 */
	public boolean tabremove(int a, int b) {

		if (a == 4) {

			Card aa = GetTopCardTab(b);
			for (int i = 0; i < 4; i++) {
				if (i != b) {
					if ((GetTopCardTab(i).getSuit().equals(aa.getSuit()))
							&& (GetTopCardTab(i).getRank() > aa.getRank())) {
						Tableau.get(b).remove(aa);
						addtohom(aa);
						return true;
					}
				}

			}
			return false;
		} else {

			boolean x = removetoTab(a, b);
			if (x) {
				Tableau.get(b).remove(Tableau.get(b).size() - 1);
			}
			return x;
		}
	}

	private boolean removetoTab(int a, int b) {
		// TODO Auto-generated method stub
		if (Tableau.get(a).isEmpty()) {
			Tableau.get(a).add(GetTopCardTab(b));

			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param aa
	 * @param a
	 * @return true always
	 */

	public boolean addtohom(Card aa) {
		HomeCell.add(aa);
		return true;
	}

	/**
	 * homecell remove
	 * 
	 * @return always false
	 */
	public boolean removeHomecell() {
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

	public boolean addStock(int a) {
		// cannot add to Stock always false
		return false;
	}

	public boolean removeStock() {
		// TODO Auto-generated method stub
		if (Stockpile.isEmpty())
			return false;
		else
			return true;
	}

}
