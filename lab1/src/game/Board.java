package game;

public class Board {
	private static int noPins = 0;
	
	
	public void setUp(int n) {
		noPins = n;
	}
	
	public void takePins(int n) {
		noPins -= n;

	}
	
	public int getNoPins() {
		return noPins;
	}
}
