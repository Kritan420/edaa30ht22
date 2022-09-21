package game;

import java.util.Random;

public class ModComputerPlayer extends Player {

	public ModComputerPlayer(String id) {
		super(id);
	}
	//
	public int takePins(Board b) {
		Random rand = new Random();
		int n = 0;
		if (b.getNoPins() > 0) {
			n = 1+rand.nextInt(2);
            if (b.getNoPins() % 3 == 0) {
                n = 1;
            }

			if (b.getNoPins() == 1) {
				n = 1;
			}
			else if (b.getNoPins() == 2) {
				n = 2;
			}



			
		}
		b.takePins(n);
		return n;
		
	}

}
