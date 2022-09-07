package game;

import javax.swing.JOptionPane;

public class HumanPlayer extends Player {

	public HumanPlayer(String id) {
		super(id);
		
	}

	public int takePins(Board b) {
		
		String sticks = "Det är " + b.getNoPins() + " stickor på bordet\nHur många stickor vill du ta?";
		
		int n = UserInterface.askForInt(JOptionPane.showInputDialog(sticks), 2);
		
		while (!(n == 1 || n == 2)) {
			JOptionPane.showMessageDialog(null, "Du måste välja 1 eller 2", "Error", JOptionPane.ERROR_MESSAGE);
			n = UserInterface.askForInt(JOptionPane.showInputDialog(sticks), 2);
		}
		
		if (b.getNoPins() - n < 0) {
			n = 1;
		}
		
		b.takePins(n);
		return n;
		
	}
}
