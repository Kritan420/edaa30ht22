package game;

import javax.swing.JOptionPane;

public class UserInterface {

	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static int askForInt(String msg, int id) {
		
		while (!(msg == null) && !(msg.matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(null, "Endast positiva heltal", "Error", JOptionPane.ERROR_MESSAGE);
			
			if (id == 1) {
				msg = JOptionPane.showInputDialog("Hur många stickor?");
			}
			if (id == 2) {
				msg = JOptionPane.showInputDialog("Hur många stickor vill du ta?");
			}
			
		}
		
		if (msg == null) {
			exitGame();
		}
		
		return Integer.parseInt(msg);
	}
	
	public static void exitGame() {
		JOptionPane.showMessageDialog(null, "Spelet avslutas", "Cancel", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
}
