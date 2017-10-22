package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
/**
 * creates the JFrame 
 * creates viewable arraylist with a list of Jlabels
 */
	private JFrame _frame;

	private ArrayList<JLabel> _viewBoard;

	private ArrayList<String> file;

	public GUI() {
		_frame = new JFrame("Game");

	}
	/** Run method that 
	 * assigns file to a new arraylist of type String
	 * assigns _viewBoard to a new arraylist of type JLabel
	 * creates a deck by calling the deck class
	 * first for loop iterates through each card in the deck and assigns a image based on rank and suit
	 * second for loop interates through each card and assigns it to a JLabel
	 * then said panels are added to JFrame
	 */
	public void run() {
		file = new ArrayList<String>();
		_viewBoard = new ArrayList<JLabel>();

		Deck cards = new Deck();
		Card[] deck = cards.getDeck();
		for (int i = 0; i < 52; i++) {
			file.add("/images/" + deck[i].getRank() + deck[i].getSuit() + ".gif");
		}

		for (int i = 0; i < 52; i++) {
			_viewBoard.add(new JLabel());
			loadAndSetImage(file.get(i), i);
		}
		JPanel a = new JPanel();
		for (int i = 0; i < 52; i++) {
			a.add(_viewBoard.get(i));
		}
		_frame.add(a);
		update();
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	}

	/**
	 * loadAndSetImage method directly taken from assignment site, displays each of the 52 cards in the deck
	 * @param fileNameRelativeToClassFile
	 * @param i being the number of the card
	 */
	
	private void loadAndSetImage(String fileNameRelativeToClassFile, int i) {
		ImageIcon cardImage;
		java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
		if (imgURL != null) {
			cardImage = new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + fileNameRelativeToClassFile);
			cardImage = null;
		}
		_viewBoard.get(i).setIcon(cardImage);
		Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
		_viewBoard.get(i).setSize(d);
		_viewBoard.get(i).setPreferredSize(d);
		_viewBoard.get(i).setMaximumSize(d);
		_viewBoard.get(i).setMinimumSize(d);
	}

	public void update() {

	}

}
