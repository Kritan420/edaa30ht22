package mountain;

import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal{
    private double dev;
    private Point a, b, c;
	private HashMap<Side,Point> map;

    	/** Creates an object that handles Mountain's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(int length, double dev) {
		super();

		// Trigonometri för tringelns alla sidlängder
		int lengthA = (int)(length + (length * (1 - Math.sin(Math.toRadians(50.4)))));  // Triangelns högersida
		int lengthB = (int)(lengthA * Math.sin(Math.toRadians(50)) / Math.sin(Math.toRadians(70))); // Triangelns bottensida
		int lengthC = (int)(lengthA * Math.sin(Math.toRadians(60)) / Math.sin(Math.toRadians(70))); // Triangelns vänstersida

		/** A samma som Koch
		 * B och C beror på trig ovan */
		a = new Point( (((length+length/2) / 2) - (length / 2)) , (((length+length/2) / 2) + (int)(Math.sqrt(3.0) * length / 4.0))); 
		b = new Point(a.getX() + (int)(lengthB - Math.rint(lengthA * Math.cos(Math.toRadians(60)))), (a.getY() - (int)Math.rint(lengthC * Math.sin(Math.toRadians(70)))));
		c = new Point(a.getX() + lengthB, a.getY() + 20);

		this.dev = dev;
		map = new HashMap<Side, Point>();
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
    @Override
	public String getTitle() {
		return "Mountain";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
    @Override
	public void draw(TurtleGraphics turtle) {
		fractalLine(turtle, order, a, b, c, dev);
	}

    	/* 
	 * Reursive method: Draws a recursive line of the mountain. 
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		
		if (order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.penDown();
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		}
		else {
			Point ab = midPoint(a, b, dev);
			Point bc = midPoint(b, c, dev);
			Point ac = midPoint(a, c, dev);

			dev = dev/2;
			
			fractalLine(turtle, order-1, a, ab, ac, dev);
			fractalLine(turtle, order-1, b, ab, bc, dev);
			fractalLine(turtle, order-1, c, bc, ac, dev);
			fractalLine(turtle, order-1, ac, ab, bc, dev);
		}
	}

	public Point midPoint(Point a, Point b, double dev)  {
		Point mid;

		Side side = new Side(a, b);
		
		if (map.containsKey(side)) {
			mid = map.get(side);
			map.remove(side);
		} else {
			int midX = ((a.getX() + b.getX()) /2);
			int midY = ((a.getY() + b.getY()) /2);
			mid = new Point( midX , (midY + (int)Math.rint(RandomUtilities.randFunc(dev))) );
			map.put(side, mid);
		}

		return mid;
	}
}
