package game;


import javax.swing.JOptionPane;

public class TakePinsGame {

	public static void main(String[] args) {
		Board b = new Board();
		HumanPlayer hp = new HumanPlayer(JOptionPane.showInputDialog("Ditt namn:")); 
		UserInterface.printMessage("Ditt namn är " + hp.userId);
		
		ComputerPlayer cp = new ComputerPlayer(JOptionPane.showInputDialog("Computerns namn:"));
		UserInterface.printMessage("Computerns namn är " + cp.userId);

		b.setUp(UserInterface.askForInt(JOptionPane.showInputDialog("Hur många stickor?"), 1));
		UserInterface.printMessage("Du valde " + Integer.toString(b.getNoPins()) + " stickor");
		
		
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
