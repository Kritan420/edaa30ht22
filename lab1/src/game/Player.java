package game;

import javax.swing.JOptionPane;

public abstract class Player {
	protected String userId;
	//
	public Player(String id) {



		while (!(id == null) && id.isBlank()) {
			JOptionPane.showMessageDialog(null, "Du måste välja ett namn", "Error", JOptionPane.ERROR_MESSAGE);
			id = JOptionPane.showInputDialog("Namn:");
		}
		
		if (id == null) {
			UserInterface.exitGame();
		}
		
		userId = id;

	}
	
	public String getUserId() {
		return userId;
	}

	public abstract int takePins(Board b);
	
}
