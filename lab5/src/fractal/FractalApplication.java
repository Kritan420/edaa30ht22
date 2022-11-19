package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {

		/** TODO:
		Fixa length . length = sqrt((x1+x2)^2 + (y1+y2)^2)
		*/

		Point a = new Point(20, 490);
		Point b = new Point(240, 30);
		Point c = new Point(580, 510);


		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Mountain(a, b, c,30);
		fractals[1] = new Koch(400);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}