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
        //turtle.penDown();
        fractalLine(turtle, order, a, b, c, dev);
        //turtle.penUp();
	}

    	/* 
	 * Reursive method: Draws a recursive line of the mountain. 
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		TurtleGraphics t = turtle;
		if (order == 0) {
			t.moveTo(a.getX(), a.getY());
            t.penDown();
            t.forwardTo(b.getX(), b.getY());
            t.forwardTo(c.getX(), c.getY());
            t.forwardTo(a.getX(), a.getY());
			t.penUp();
		}
		else {
			
			Point ab = midPoint(a, b, dev);
			Point bc = midPoint(b, c, dev);
			Point ac = midPoint(a, c, dev);

			dev = dev/2;


			fractalLine(t, order-1, a, ab, ac, dev);
			fractalLine(t, order-1, b, ab, bc, dev);
			fractalLine(t, order-1, c, ac, bc, dev);
            fractalLine(t, order-1, ab, bc, ac, dev);


            /**fractalLine(t, order-1, a, ab, ac, dev);
			fractalLine(t, order-1, ab, b, bc, dev);
            fractalLine(t, order-1, ab, bc, ac, dev);
            fractalLine(t, order-1, c, ac, bc, dev);
*/
			
			//Math.abs(order)
			

		}
	}

	public Point midPoint(Point a, Point b, double dev)  {
		Side side = new Side(a, b);
		Point mid;
		if (map.containsKey(side)) {
			mid = map.get(side);
			map.remove(side);
		} else {
			mid = new Point(((a.getX() + b.getX()) /2) , (int)(((a.getY() + b.getY()) / 2) + Math.abs(RandomUtilities.randFunc(dev)))  );
			map.put(side, mid);
		}
		return mid;
	}
}
