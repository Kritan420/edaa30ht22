package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {

		int length = 300;
		// 150 + 250 = 400
		// 
		Point a = new Point(length/2, length + length/3);
		Point b = new Point(length/3 + length/2, length*2/3);
		Point c = new Point(length + length/2, length + length/3 + length/10);

		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Mountain(a, b, c);
		fractals[1] = new Koch(length);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}
}
