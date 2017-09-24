package code;

public class Card {
	private String suit;
	private int rank;
	private String rb; //color Red or Black
	
	public Card(String suit, int rank){
		this.suit = suit;
		this.rank = rank;
		this.rb = rb;
	}
	
	public void Heart(){
		suit = "Heart";
		rb = "red";
	}
	public void Clover(){
		suit = "Clover";
		rb = "black";
	}
	public void Spade(){
		suit = "Spade";
		rb = "black";
	}
	public void Diamond(){
		suit = "Diamond";
		rb = "red";
	}
	
	public void Two(){
		rank = 2;
	}
	public void Three(){
		rank = 3;
	}
	public void Four(){
		rank = 4;
	}
	public void Five(){
		rank = 5;
	}
	public void Six(){
		rank = 6;
	}
	public void Seven(){
		rank = 7;
	}
	public void Eight(){
		rank = 8;
	}
	public void Nine(){
		rank = 9;
	}
	public void Ten(){
		rank = 10;
	}
	public void Jack(){
		rank = 11;
	}
	public void Queen(){
		rank = 12;
	}
	public void King(){
		rank = 13;
	}
	public void Ace(){
		rank = 1;
	}
}
