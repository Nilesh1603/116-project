package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class EventHandler implements ActionListener {
	GUI a;
	int x;

	public EventHandler(int i, GUI gui) {
		// TODO Auto-generated constructor stub
		x = i;
		a = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(a.file.get(x)+" 	"+x);
	}

}
