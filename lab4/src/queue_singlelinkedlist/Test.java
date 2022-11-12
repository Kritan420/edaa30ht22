package queue_singlelinkedlist;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {

        FifoQueue<Integer> f = new FifoQueue<Integer>();
        FifoQueue<Integer> q = new FifoQueue<Integer>();

        
        for (int i = 1; i <= 10; i++) {
         f.offer(i);
         q.offer(i+10);
         
        }
        
        f.append(q);
        Iterator<Integer> itr = f.iterator();
        for (int i = 1; i <= f.size(); i++) {
            System.out.println("Peek: " + f.peek() + " Next: " + itr.next() + " Int: " + i);
        }
            
   
        /**f.offer(1);
        f.offer(2);
        f.poll();
		
        Iterator<Integer> itr = f.iterator();

        System.out.println(itr.hasNext());
        //System.out.println(itr.next());*/

        /** 
        System.out.println("Utan borttagning " + f.peek());
        f.poll();
        System.out.println("Efter 1 borttagning " + f.peek());
        f.poll();
        System.out.println("Efter 2 borttagning " + f.peek());
        f.poll();
        System.out.println("Efter 3 borttagning " + f.peek());
        f.poll();
        System.out.println("Efter 4 borttagning " + f.peek());
        f.poll();
        System.out.println("Efter 5 borttagning " + f.peek());
        */
        
    }
}
