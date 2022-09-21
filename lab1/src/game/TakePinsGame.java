package game;


import javax.swing.JOptionPane;

public class TakePinsGame {

	public static void main(String[] args) {
		Board b = new Board();
		Player cp = null;
		String[] options = {"ComputerPlayer", "ModuloComputerPlayer", "PrimeComputerPlayer"};
		HumanPlayer hp = new HumanPlayer(JOptionPane.showInputDialog("Ditt namn:"));
		String cpname = JOptionPane.showInputDialog("Computerns namn:");
		int cpu = JOptionPane.showOptionDialog(null, "Välj din motspelare", "Välj", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		
		while (cpu == -1) {
			UserInterface.printMessage("Välj cp, mcp eller pcp");
			cpu = JOptionPane.showOptionDialog(null, "Välj din motspelare", "Välj", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		}

		if (cpu == 0) {
			cp = new ComputerPlayer(cpname);
		}
		else if (cpu == 1) {
			cp = new ModComputerPlayer(cpname);
		}
		else if (cpu == 2) {
			cp = new PrimeComputerPlayer(cpname);
		}
		
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

