package textproc;
import java.util.*;

public class GeneralWordCounter implements TextProcessor{
    
    private Set<String> stopwords;
    private Map<String, Integer> m = new HashMap<String, Integer>();
    
    public GeneralWordCounter(Set<String> s) {
        stopwords = s;        
    }

	public void process(String w) {

        if (m.containsKey(w)) {
            for(String a : m.keySet()){
                if (a.equals(w)) {
                    m.replace(w, m.get(w)+1 );
                }
            } 
        }
        else if (!stopwords.contains(w)) {
            m.put(w, 1);
        } 
          
	}

	public void report() {
        for(String key : m.keySet()){
            if (m.get(key) > 200) {
                System.out.println(key + ": " + m.get(key));
            }
        }
        }
        
	}

