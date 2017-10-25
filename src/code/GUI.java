package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	/**
	 * creates the JFrame creates viewable arraylist with a list of Jlabels
	 */
	private JFrame _frame;

	private ArrayList<JLabel> _viewBoard;

	private ArrayList<String> file;

	private JMenuItem FreeCell;

	private JMenuItem BakersDozen;

	private JMenuItem Quit;

	public GUI() {
		_frame = null;

	}

	/**
	 * Run method that assigns file to a new arraylist of type String assigns
	 * _viewBoard to a new arraylist of type JLabel creates a deck by calling
	 * the deck class first for loop iterates through each card in the deck and
	 * assigns a image based on rank and suit second for loop interates through
	 * each card and assigns it to a JLabel then said panels are added to JFrame
	 */
	public void run() {

		file = new ArrayList<String>();
		_viewBoard = new ArrayList<JLabel>();

		JMenu Menu = new JMenu("New Game"); // Create a menu with name
		// "New
		// Game"

		JMenuBar m = new JMenuBar();

		FreeCell = new JMenuItem("FreeCell");
		FreeCell.addActionListener(this);
		Menu.add(FreeCell);
		BakersDozen = new JMenuItem("BakersDozen");
		BakersDozen.addActionListener(this);
		Menu.add(BakersDozen);
		Quit = new JMenuItem("Quit");
		Quit.addActionListener(this);
		Menu.add(Quit);
		if (_frame == null) {
			_frame = new JFrame("Game");
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

			m.add(Menu);
			_frame.setJMenuBar(m);
			_frame.add(new JPanel());
			_frame.add(a);

			_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			_frame.pack();
			_frame.setVisible(true);
		} else {
			_frame = new JFrame("Game");
			m.add(Menu);
			_frame.setJMenuBar(m);
			_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			_frame.pack();
			_frame.setVisible(true);
		}
	}

	private void FreeCell() {
		// TODO Auto-generated method stub

		run();

		Freecell game1 = new Freecell();

		game1.TableauPile();
		JPanel a = new JPanel(new GridLayout(1, 2));
		JPanel a1 = new JPanel(new GridLayout(6, 4));
		JPanel a2 = new JPanel(new GridLayout(7, 4));
		file = new ArrayList<String>();
		for (int i = 0; i < 13; i++) {

			for (int j = 0; j < 4; j++) {

				file.add("/images/" + game1.Tableau.get(i).get(j).getRank() + game1.Tableau.get(i).get(j).getSuit()
						+ ".gif");
			}
		}
		_viewBoard = new ArrayList<JLabel>();
		for (int i = 0; i < 52; i++) {
			_viewBoard.add(new JLabel());
			loadAndSetImage(file.get(i), i);
		}
		int count = 0;
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 6; j++) {
				a1.add(_viewBoard.get(count));
				count++;
			}

		}
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 7; j++) {
				a2.add(_viewBoard.get(count));
				count++;
			}

		}

		a.add(a1);
		a.add(a2);
		_frame.add(a);

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);

	}

	private void BakersDozen() {
		// TODO Auto-generated method stub
		run();
		BakersDozengame game1 = new BakersDozengame();

		game1.dealToTableauPile();
		JPanel a = new JPanel(new GridLayout(4, 13));
		file = new ArrayList<String>();
		for (int i = 0; i < 13; i++) {

			for (int j = 0; j < 4; j++) {
				if (j == 3) {
					if (game1.Tableau.get(i).get(3).getRank() != 13)
						file.add("/images/" + game1.Tableau.get(i).get(j).getRank()
								+ game1.Tableau.get(i).get(j).getSuit() + ".gif");
				} else
					file.add("/images/" + game1.Tableau.get(i).get(j).getRank() + game1.Tableau.get(i).get(j).getSuit()
							+ ".gif");

			}

		}
		_viewBoard = new ArrayList<JLabel>();
		int c = 0;

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				_viewBoard.add(new JLabel());
				loadAndSetImage(file.get(c), c);
				c++;
			}
		}
		int count = 0;
		for (int i = 0; i < 13; i++) {

			for (int j = 0; j < 4; j++) {
				a.add(_viewBoard.get(count));
				count++;
			}
		}

		_frame.add(a);

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);

	}

	/**
	 * loadAndSetImage method directly taken from assignment site, displays each
	 * of the 52 cards in the deck
	 * 
	 * @param fileNameRelativeToClassFile
	 * @param i
	 *            being the number of the card
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (e.getSource() == FreeCell) {
			FreeCell();
		}
		if (e.getSource() == BakersDozen) {
			BakersDozen();
		}
		if (e.getSource() == Quit) {
			System.exit(0);

		}
	}

}
