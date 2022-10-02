package textproc;

import java.util.*;

public class MultiWordCounter implements TextProcessor {
    //private Map<String, Integer> m = new HashMap<String, Integer>();
    private Map<String, Integer> m = new TreeMap<String, Integer>();
    
    public MultiWordCounter(String[] list) {
        for(String a : list) {
        m.put(a, 0);
        }
        
    }

	public void process(String w) {
            if (m.containsKey(w)) {
                m.replace(w, m.get(w)+1 );
            } 
	}

	public void report() {
        for(String key : m.keySet()){
            System.out.println(key + ": " + m.get(key));
        }
        
	}
    
}
