package code;

//@author Mark
public class Card {
	private String suit;
	private int rank;

	/**
	 * 
	 * @param suit represents the suit of the card (hearts, diamonds, clubs, spades)
	 * @param rank represents the rank of the card (Ace, 2-10, Jack, Queen, King)
	 */
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	/**
	 * 
	 * @return suit of the card
	 */
	public String getSuit(){
		return this.suit;
	}
	/**
	 * 
	 * @return rank of the card
	 */
	public int getRank(){
		return this.rank;
	}

}
