package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class EventHandler implements ActionListener {
	GUI a;
	Integer x;

	public EventHandler(int i, GUI gui) {
		// TODO Auto-generated constructor stub

		x = i;

		a = gui;
	}

	/**
	 * Sends the index of the selected card back to the GUI.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// FreeCell game.
		if (a.game == 1) {
			if (x < 52) {
				System.out.println(a.file.get(x) + " 	" + x);
				a.drag(x);
			} else {

				a.drag(x);
			}
		}
		// BakersDozen game.
		if (a.game == 2) {
			if (x < 52) {
				System.out.println(a.file.get(x) + " 	" + x);
				a.drag2(x);
			} else {

				a.drag2(x);
			}
		}

		if (a.game == 3) {
			if (x == 52) {
				a.home();
			}
			if (x == 53) {
				a.stocktotab();
			}
			if(x<52)
			{
				a.Aceselect(x);
			}
		}

	}
	// this is the real easter egg ;))))
}
