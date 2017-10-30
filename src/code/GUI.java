package code;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GUI implements ActionListener {
	/**
	 * creates the JFrame creates viewable arraylist with a list of Jlabels
	 */
	public JFrame _frame;

	public ArrayList<JButton> _viewBoard;

	public ArrayList<String> file;

	public JMenuItem FreeCell;
	public Freecell g1;
	public BakersDozengame g2;
	public JMenuItem BakersDozen;
	public int game;
	public JMenuItem Quit;
	public Integer swap1;
	public Integer swap2;
	public Integer swapcount;
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);

	public void select(Integer x) {
		_viewBoard.get(x).setBorder(SELECTED_BORDER);
		// repaint();
	}

	public void unselect(int x) {
		_viewBoard.get(x).setBorder(UNSELECTED_BORDER);
		// repaint();
	}

	public GUI() {
		_frame = null;
		swapcount = 0;
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
		_viewBoard = new ArrayList<JButton>();

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
				_viewBoard.add(new JButton());
				loadAndSetImage(file.get(i), i);
			}

			int c = 0;
			JPanel a = new JPanel();
			a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
			for (int i = 0; i < 13; i++) {
				JPanel a1 = new JPanel();
				a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS));
				for (int j = 0; j < 4; j++) {
					a1.add(_viewBoard.get(c++));
				}
				a.add(a1);
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

	public Freecell FreeCell() {
		// TODO Auto-generated method stub

		// System.exit(0);
		run();

		Freecell game1 = new Freecell();

		game1.TableauPile();
		JPanel freecellgame = new JPanel();
		freecellgame.setLayout(new BoxLayout(freecellgame, BoxLayout.Y_AXIS));
		JPanel freehomecell = new JPanel();
		freehomecell.setLayout(new BoxLayout(freehomecell, BoxLayout.X_AXIS));
		JPanel freecell = new JPanel();
		freecell.setLayout(new BoxLayout(freecell, BoxLayout.X_AXIS));
		JPanel Homecell = new JPanel();
		Homecell.setLayout(new BoxLayout(Homecell, BoxLayout.X_AXIS));
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
		ActionListener x;
		file = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 7; j++) {

				file.add("/images/" + game1.Tableau.get(i).get(j).getRank() + game1.Tableau.get(i).get(j).getSuit()
						+ ".gif");
			}
		}
		for (int i = 4; i < 8; i++) {

			for (int j = 0; j < 6; j++) {

				file.add("/images/" + game1.Tableau.get(i).get(j).getRank() + game1.Tableau.get(i).get(j).getSuit()
						+ ".gif");
			}
		}

		_viewBoard = new ArrayList<JButton>();
		for (int i = 0; i < 52; i++) {
			_viewBoard.add(new JButton());
			loadAndSetImage(file.get(i), i);

			x = new EventHandler(i, this);
			_viewBoard.get(i).addActionListener(x);
		}
		int count = 0;
		for (int i = 0; i < 4; i++) {
			JPanel a1 = new JPanel();
			a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS));
			// a1.setLayout(new OverlayLayout());
			for (int j = 0; j < 7; j++) {
				a1.add(_viewBoard.get(count));
				count++;
			}
			a1.setAlignmentY(10);
			a.add(a1);

		}
		for (int i = 0; i < 4; i++) {
			JPanel a2 = new JPanel();
			a2.setLayout(new BoxLayout(a2, BoxLayout.Y_AXIS));
			for (int j = 0; j < 6; j++) {

				a2.add(_viewBoard.get(count));
				count++;
			}
			a2.setAlignmentY(40);
			a.add(a2);

		}

		for (int i = 0; i < 4; i++) {
			_viewBoard.add(new JButton());
			loadAndSetImage("/images/" + "green" + ".gif", count);

			x = new EventHandler(count, this);
			_viewBoard.get(count).addActionListener(x);
			count++;
		}
		int h = count - 4;
		for (int i = 0; i < 4; i++) {
			JPanel x1 = new JPanel();
			x1.add(_viewBoard.get(h));
			Homecell.add(x1);
			h++;
		}
		for (int i = 0; i < 4; i++) {
			_viewBoard.add(new JButton());
			loadAndSetImage("/images/" + "gold" + ".gif", count);

			x = new EventHandler(count, this);
			_viewBoard.get(count).addActionListener(x);
			count++;
		}
		int h1 = count - 4;
		for (int i = 0; i < 4; i++) {
			JPanel x1 = new JPanel();
			x1.add(_viewBoard.get(h1));
			freecell.add(x1);
			h1++;
		}

		freehomecell.add(freecell);
		freehomecell.add(Homecell);

		freecellgame.add(freehomecell);
		freecellgame.add(a);

		_frame.add(freecellgame);
		_frame.setLayout(new CardLayout());
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		return game1;

	}

	public BakersDozengame BakersDozen() {
		// TODO Auto-generated method stub

		run();
		BakersDozengame game1 = new BakersDozengame();

		// game1.dealToTableauPile();
		JPanel baker = new JPanel();
		baker.setLayout(new BoxLayout(baker, BoxLayout.Y_AXIS));
		JPanel Homecell = new JPanel();
		Homecell.setLayout(new BoxLayout(Homecell, BoxLayout.X_AXIS));
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
		ActionListener x;
		file = new ArrayList<String>();
		for (int i = 0; i < 13; i++) {

			for (int j = 0; j < 4; j++) {

				file.add("/images/" + game1.Tableau.get(i).get(j).getRank() + game1.Tableau.get(i).get(j).getSuit()
						+ ".gif");

			}
			System.out.println(game1.Tableau.get(i).get(3).getRank() + " 	" + game1.Tableau.get(i).get(3).getSuit());
		}
		_viewBoard = new ArrayList<JButton>();
		int c = 0;

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				_viewBoard.add(new JButton());
				loadAndSetImage(file.get(c), c);

				x = new EventHandler(c, this);
				_viewBoard.get(c).addActionListener(x);
				c++;
			}
		}
		int count = 0;
		for (int i = 0; i < 13; i++) {
			JPanel x1 = new JPanel();
			x1.setLayout(new BoxLayout(x1, BoxLayout.Y_AXIS));
			for (int j = 0; j < 4; j++) {
				x1.add(_viewBoard.get(count));
				count++;
			}
			a.add(x1);
		}
		for (int i = 0; i < 4; i++) {
			_viewBoard.add(new JButton());
			loadAndSetImage("/images/" + "green" + ".gif", count);
			x = new EventHandler(count, this);
			_viewBoard.get(count).addActionListener(x);
			count++;
		}
		int h = count - 4;
		for (int i = 0; i < 4; i++) {
			Homecell.add(_viewBoard.get(h));
			h++;
		}

		baker.add(Homecell);
		baker.add(a);
		_frame.add(baker);

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		return game1;

	}

	/**
	 * loadAndSetImage method directly taken from assignment site, displays each
	 * of the 52 cards in the deck
	 * 
	 * @param fileNameRelativeToClassFile
	 * @param i
	 *            being the number of the card
	 */

	public void loadAndSetImage(String fileNameRelativeToClassFile, int i) {
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

	public void drag(int x) {
		if (game == 1) {
			if (x < 52) {
				if (swapcount % 2 == 0) {

					swap1 = null;
					swap2 = null;

				}
				if (swap1 == null) {
					swap1 = x;
					if (swap1 < 28) {
						int a = swap1 / 7;
						int b = swap1 % 7;
						System.out.println(a + "   " + b);
						if (g1.GetTopCardTab(a).equals(g1.GetCardTab(a, b)))
							select(swap1);
					} else {
						int a = swap1 / 7;
						int b = (swap1 - 28) % 6;
						System.out.println(a + "   " + b);
						if (g1.GetTopCardTab(a).equals(g1.GetCardTab(a, b)))
							select(swap1);
					}

				} else {
					unselect(swap1);
					swap2 = x;

				}

			} else if (x > 51 && x < 56) {
				swap1 = x;
				System.out.println("Cannot select Homecell" + x);
			} else {
				if (swapcount % 2 == 0) {

					swap1 = null;
					swap2 = null;

				}
				if (swap1 == null) {
					swap1 = x;

					select(x);

				} else
					unselect(swap1);
			}

		}

		swapcount++;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (e.getSource() == FreeCell) {
			game = 1;
			g1 = FreeCell();
		}
		if (e.getSource() == BakersDozen) {
			game = 2;
			g2 = BakersDozen();
		}
		if (e.getSource() == Quit) {
			System.exit(0);
		}
	}

}
