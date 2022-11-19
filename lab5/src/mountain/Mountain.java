package mountain;

import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal{
    private double dev;
    private Point a;
    private Point b;
    private Point c;
	private HashMap<Side,Point> map;

    	/** Creates an object that handles Mountain's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
        this.b = b;
        this.c = c;
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
			turtle.penUp();
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
