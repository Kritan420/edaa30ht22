package textproc;

import java.util.*;
import java.io.*;

public class BookReaderApplication{


    public static void main(String[] args) throws FileNotFoundException  {

        Scanner s = new Scanner(new File("./lab3/nilsholg.txt"), "UTF-8");
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		
		Scanner u = new Scanner(new File("./lab3/undantagsord.txt"), "UTF-8");
		u.useDelimiter(" ");


		Set<String> stopwords = new HashSet<String>();

		while (u.hasNext()) {
			stopwords.add(u.next().toLowerCase());
		}

		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);
        while (s.hasNext()) {
			String word = s.next().toLowerCase();
			gwc.process(word);
		}
		

		BookReaderController brc = new BookReaderController(gwc);
		


		s.close();
		u.close();

        


    }
}