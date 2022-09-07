package game;

import javax.swing.JOptionPane;

public class Board {
	private static int noPins = 0;
	
	
	public void setUp(int n) {
		while (n < 4) {
			JOptionPane.showMessageDialog(null, "Du behöver minst 4 stickor för att spela", "Error", JOptionPane.ERROR_MESSAGE);
			n = UserInterface.askForInt(JOptionPane.showInputDialog("Hur många stickor?"), 2);
		}
		noPins = n;
	}
	
	public void takePins(int n) {
		noPins -= n;

	}
	
	public int getNoPins() {
		return noPins;
	}
}