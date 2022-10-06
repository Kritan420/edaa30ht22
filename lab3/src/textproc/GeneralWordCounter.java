package textproc;
import java.util.*;

public class GeneralWordCounter implements TextProcessor{
    
    private Set<String> stopwords;
    private Map<String, Integer> wMap = new TreeMap<String, Integer>();
    //private Map<String, Integer> wMap = new HashMap<String, Integer>();
    

    public GeneralWordCounter(Set<String> s) {
            stopwords = s;  
    }

	public void process(String w) {
        w = w.replaceAll("[0-9]", stopwords.iterator().next());
        if (wMap.containsKey(w)) {
            wMap.replace(w, wMap.get(w)+1 );
        }
        else if (!stopwords.contains(w)) {
            wMap.put(w, 1);
        } 
          
	}

    public List<Map.Entry<String, Integer>> getWordList() {
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wMap.entrySet());
        return wordList;
        }
        

	public void report() {
        List<Map.Entry<String, Integer>>wordList = new ArrayList<>(wMap.entrySet());
        
        wordList.sort((a, b) -> { 
                                    if (b.getValue().compareTo(a.getValue()) != 0) {  
                                        return b.getValue().compareTo(a.getValue());  
                                    } else {
                                        return a.getKey().compareTo(b.getKey()); 
                                    }
                                }
                     );   

        for (int i = 0; i < 5; i++) {
                System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
            } 
    }
}

