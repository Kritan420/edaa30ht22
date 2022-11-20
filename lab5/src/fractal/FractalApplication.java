package fractal;

import koch.Koch;
import mountain.Mountain;

public class FractalApplication {
	public static void main(String[] args) {


		int length = 650; 

		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Mountain(length, length/15);
		fractals[1] = new Koch(length);

	    new FractalView(fractals, "Fraktaler", (length+length/2), (length+length/2));
	}

}