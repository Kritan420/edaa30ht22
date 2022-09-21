package game;


import javax.swing.JOptionPane;

public class TakePinsGame {

	public static void main(String[] args) {
		Board b = new Board();

		String[] options = {"ComputerPlayer", "ModuloComputerPlayer"};
		int x = JOptionPane.showOptionDialog(null, "Välj din motspelare",
		"Välj",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		HumanPlayer hp = new HumanPlayer(JOptionPane.showInputDialog("Ditt namn:")); 
		
		if (x == 0) {
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
		else if (x == 1) {

			ModComputerPlayer cp = new ModComputerPlayer(JOptionPane.showInputDialog("Computerns namn:"));

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

}