package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Holgersson {
	

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		
		Scanner s = new Scanner(new File("./lab2/nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		
		Scanner u = new Scanner(new File("./lab2/undantagsord.txt"));
		u.useDelimiter(" ");
		Set<String> stopwords = new HashSet<String>();

		while (u.hasNext()) {
			stopwords.add(u.next());
		}

		ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();
		list.add(new SingleWordCounter("nils"));
		list.add(new SingleWordCounter("norge"));
		list.add(new MultiWordCounter(REGIONS));
		list.add(new GeneralWordCounter(stopwords));

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor a : list) {
				a.process(word);
			}
		}

		s.close();
		u.close();

		for (TextProcessor a : list) {
			a.report();
		}

		long t1 = System.nanoTime();
		double t = (t1 - t0) / 1000000000.0;
		System.out.println("\n" + "tid: " + t  + "s" + "\n");
	}
}