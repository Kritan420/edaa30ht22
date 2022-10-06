package textproc;

import java.util.*;
import java.io.*;

public class BookReaderApplication{


    public static void main(String[] args) {

        Scanner s = new Scanner(new File("./lab2/nilsholg.txt"), "UTF-8");
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		
		Scanner u = new Scanner(new File("./lab2/undantagsord.txt"), "UTF-8");
		u.useDelimiter(" ");
		Set<String> stopwords = new HashSet<String>();

		while (u.hasNext()) {
			stopwords.add(u.next().toLowerCase());
		}

        /**ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();
		list.add(new SingleWordCounter("nils"));
		list.add(new SingleWordCounter("norge"));
		list.add(new MultiWordCounter(REGIONS));*/

        while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor a : list) {
				a.process(word);
			}
		}


		BookReaderController brc = new BookReaderController(new GeneralWordCounter(stopwords));

		s.close();
		u.close();

        


    }
}