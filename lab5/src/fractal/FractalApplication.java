package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {

		/** 
		a: 150, 400
		b: 250, 200
		c: 450, 430
		*/

		Point a = new Point(50, 480);
		Point b = new Point(200, 20);
		Point c = new Point(530, 500);


		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Mountain(a, b, c,36.0);
		fractals[1] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}