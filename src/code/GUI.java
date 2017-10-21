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

	
	private JFrame _frame;

	private ArrayList<JLabel> _viewBoard;

	private ArrayList<String> file;

	public GUI() {
		_frame = new JFrame("Game");
		file = new ArrayList<String>();
		_viewBoard = new ArrayList<JLabel>();
	}

	public void run() {

		for (int i = 0; i < 52; i++) {
			_viewBoard.add(new JLabel());
			loadAndSetImage(file.get(i), i);
		}
		update();
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	}

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
