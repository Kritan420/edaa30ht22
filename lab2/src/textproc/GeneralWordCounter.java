package textproc;
import java.util.*;

public class GeneralWordCounter implements TextProcessor{
    
    private Set<String> stopwords;
    //private Map<String, Integer> m = new HashMap<String, Integer>();
    private Map<String, Integer> m = new TreeMap<String, Integer>();

    public GeneralWordCounter(Set<String> s) {
            stopwords = s;  
    }

	public void process(String w) {
        if (m.containsKey(w)) {
            m.replace(w, m.get(w)+1 );
        }
        else if (!stopwords.contains(w)) {
            m.put(w, 1);
        } 
          
	}

	public void report() {
        Set<Map.Entry<String, Integer>> wordSet = m.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        
        wordList.sort((a, b) -> { 
                                if (b.getValue().compareTo(a.getValue()) != 0) {  
                                    return b.getValue().compareTo(a.getValue());  
                                } else {
                                    return a.getKey().compareTo(b.getKey()); 
                                }
                                });   

        for (int i = 0; i < 5; i++) {
                System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
            } 


    }
}

