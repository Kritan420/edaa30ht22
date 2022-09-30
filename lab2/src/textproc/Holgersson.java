package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.w3c.dom.Text;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("./lab2/nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		
		Scanner t = new Scanner(new File("./lab2/undantagsord.txt"));
		t.useDelimiter(" ");

		Set<String> stopwords = new HashSet<String>();
		while (t.hasNext()) {
			stopwords.add(t.next());
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
		
		for (TextProcessor a : list) {
			a.report();
		}

	}
}