package mountain;

import fractal.*;

public class Mountain extends Fractal{
    private int length;
    private Point a;
    private Point b;
    private Point c;

    	/** Creates an object that handles Mountain's fractal. 
	 * @param length the length of the triangle side
	 */
	public Mountain(Point a, Point b, Point c) {
		super();
		this.a = a;
        this.b = b;
        this.c = c;
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
        turtle.penDown();
        fractalLine(turtle, order, a, b, c);
        turtle.penUp();
	}

    	/* 
	 * Reursive method: Draws a recursive line of the mountain. 
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
		TurtleGraphics t = turtle;
		if (order == 0) {
            t.penUp();
			t.moveTo(a.getX(), a.getY());
            t.penDown();
            t.forwardTo(b.getX(), b.getY());
            t.forwardTo(c.getX(), c.getY());
            t.forwardTo(a.getX(), a.getY());
		}
		else {
            Point ab = new Point( (b.getX() + a.getX()) /2, (b.getY()+a.getY()) /2 );
            Point bc = new Point( (c.getX() + b.getX()) /2, (c.getY()+b.getY()) /2 );
            Point ac = new Point( (c.getX() + a.getX()) /2, (c.getY()+a.getY()) /2 );
            fractalLine(turtle, order-1, a, ab, ac);
            fractalLine(turtle, order-1, ab, bc, ac);
            fractalLine(turtle, order-1, ab, b, bc);
            fractalLine(turtle, order-1, ac, bc, c);
		}
	}
}
