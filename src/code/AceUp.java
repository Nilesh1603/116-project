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
/**
 * When the game begins the stock pile will contain the entire deck except those cards dealt to the tableau piles.
Removing Cards
 */
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
	/**
	 * The system will add a card to the top of the tableau whenever the stock pile is clicked. 
	 * A card can be added to an empty tableau pile at any time. 
	 * Either way, the added card becomes the tableau's new top card.
	 * @param a
	 * @param b
	 * @return
	 */
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
/**
 * When the game begins each tableau pile is dealt 1 card; more cards will be added as the game is played. 
 * @param a
 * @param b
 * @return
 */
	private boolean AddtoTab(int a, int b) {
		// TODO Auto-generated method stub
		if (Tableau.get(a).isEmpty()) {
			Tableau.get(a).add(GetTopCardTab(b));
			return true;
		}
		return false;
	}

	/**
	 * The top card of a tableau can be removed and added to the homecell pile 
	 * whenever another tableau's top card has the same suit, but with a higher rank. 
	 * A top card can be removed and added to an empty tableau at any time.
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
/**
 * Removing Cards. When the stock pile is selected, remove the 4 top cards and deal 1 card to each tableau pile.
 * @param a
 * @param b
 * @return
 */
	private boolean removetoTab(int a, int b) {
		// TODO Auto-generated method stub
		if (Tableau.get(a).isEmpty()) {
			Tableau.get(a).add(GetTopCardTab(b));

			return true;
		}
		return false;
	}

	/**
	 * Assuming it was legally removed from a tableau pile, a card can be added to the homecell pile at any time.
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
/**
 * Cards cannot be added to the stock pile.
 * @param a
 * @return
 */
	public boolean addStock(int a) {
		// cannot add to Stock always false
		return false;
	}
/**Removing Cards
	 *Checks if it's possible to return or not.
	 * @return false if empty, true if not empty.
	 */
	public boolean removeStock() {
		// TODO Auto-generated method stub
		if (Stockpile.isEmpty())
			return false;
		else
			return true;
	}

}
