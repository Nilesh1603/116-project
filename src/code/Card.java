package code;

//@author Mark
//@author Nabeel

/**
 * 
 * Defines a specific card
 *
 */
public class Card {
	private String suit;
	private int rank;

	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;

	}
	public String getSuit(){
		return this.suit;
	}
	public int getRank(){
		return this.rank;
	}

}
