package mountain;

public class Test {

    public static void main(String[] args) {
        Point a = new Point(10, 10);
        Point b = new Point(20, 20);

        Side test = new Side(a, b);
        Side test2 = new Side(b, a);

        System.out.println(test.equals(test2));
    }
    
}
