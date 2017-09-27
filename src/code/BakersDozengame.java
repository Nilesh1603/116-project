package code;

import java.util.ArrayList;

//@author Nilesh
//@author Nabeel
//x
public class BakersDozengame {
	private Card[] y;
	private ArrayList<ArrayList<Card>> Tableau;
	private ArrayList<ArrayList<Card>> HomeCell;

	// 13 diff arraylists, decks already shuffled
	// arraylist of card arraylists
	public BakersDozengame() {
		Deck A = new Deck();
		y = A.deck;
		Tableau = new ArrayList<ArrayList<Card>>();
		HomeCell = new ArrayList<ArrayList<Card>>();
	}

	public void dealToTableauPile() {

		int count = 0;
		for (int i = 0; i < 13; i++) {
			ArrayList<Card> a = new ArrayList<Card>();

			for (int j = 0; j < 4; j++) {
				a.add(y[count]);
				count++;
			}

			Card aa = a.get(3);
			if (aa.getRank() == 13 && a.get(0).getRank() != 13) {
				Card temp = a.get(3);
				a.set(3, a.get(0));
				a.set(0, temp);
			} else if (aa.getRank() == 13 && a.get(1).getRank() != 13) {
				Card temp = a.get(3);
				a.set(3, a.get(1));
				a.set(1, temp);
			} else if (aa.getRank() == 13 && a.get(2).getRank() != 13) {
				Card temp = a.get(3);
				a.set(3, a.get(2));
				a.set(2, temp);
			}
			Tableau.add(a);
		}

	}

	public void tabremove(int a, int b, int c) {

		if (b == Tableau.get(a).size()) {
			Card aa = Tableau.get(a).get(b);
			if (addtohom(aa, c))
				Tableau.get(a).remove(b);
		}

	}

	public void tabremove(int a, int b, int c, int d)// d is size-1 of the c tab
														// pile
	{

		if (b == Tableau.get(a).size()) {
			Card aa = Tableau.get(a).get(b);
			if (addtotab(aa, c, d))
				Tableau.get(a).remove(b);
		}

	}

	private boolean addtohom(Card aa, int a) {
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
		if (Tableau.get(c).get(d).getRank() - a.getRank() == 1) {
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

}
