package game;


import javax.swing.JOptionPane;

public class TakePinsGame {

	public static void main(String[] args) {
		Board b = new Board();
		HumanPlayer hp = new HumanPlayer(JOptionPane.showInputDialog("Ditt namn:")); 
		
		ComputerPlayer cp = new ComputerPlayer(JOptionPane.showInputDialog("Computerns namn:"));

		b.setUp(UserInterface.askForInt(JOptionPane.showInputDialog("Hur många stickor vill du spela med?"), 1));
		UserInterface.printMessage(hp.userId + " vs. " + cp.userId + "\nSpelet börjar med " + Integer.toString(b.getNoPins()) + " stickor på bordet");
		
		
		while (b.getNoPins() > 0) {
			
			if (b.getNoPins() > 0) {
				UserInterface.printMessage(hp.getUserId() + " tog " + hp.takePins(b));
				if (b.getNoPins() == 0) {
					UserInterface.printMessage(hp.getUserId() + " vann");
				}
			}
			
			if (b.getNoPins() > 0) {
				UserInterface.printMessage(cp.getUserId() + " tog " + cp.takePins(b));
				if (b.getNoPins() == 0) {
					UserInterface.printMessage(cp.getUserId() + " vann");
				}
			}
		}
		


	}

}