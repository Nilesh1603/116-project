package code;

import java.util.ArrayList;
//@author Nilesh
//@author Nabeel
public class BakersDozengame {
	private Card[] y;
	//13 diff arraylists, decks already shuffled
	//arraylist of card arraylists
	public void newShuffleDeck(){
		Deck A= new Deck();
		y= A.deck;
		
	}
	public void dealToTableauPile(){
		ArrayList<ArrayList<Card>> Tableau = new ArrayList<ArrayList<Card>>();
		int count= 0;
		for(int i=0;i<13;i++){
			ArrayList<Card>a = new ArrayList<Card>();
			
			for(int j=0;j<4;j++){
				a.add(y[count]);
				count++;
				
			}
			
			for(int j=1;j<4;j++){
				Card aa = a.get(j);
				if(aa.getRank()==13){
					Card temp = a.get(j);
					a.set(j, a.get(0));
					a.set(0, temp);
				}
			}
			Tableau.add(a);
		}
		
	}	
	public void wholeSale(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
