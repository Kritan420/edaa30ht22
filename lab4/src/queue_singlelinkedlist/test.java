package queue_singlelinkedlist;

public class test {

public static void main(String[] args) {
          FifoQueue<Integer> Q1 = new FifoQueue<Integer>();
    FifoQueue<Integer> Q2 = new FifoQueue<Integer>();
     for (int i = 1; i <= 5; i++) {
        Q1.offer(i);
        Q2.offer(i+5);
    }

    Q1.append(Q2);
    for (int j = 1; j <= 10; j++) {
        System.out.println(Q1.poll());
    }
}
 


}
