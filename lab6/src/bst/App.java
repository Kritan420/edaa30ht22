package bst;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();


        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(15));
        System.out.println(test.add(8));
        System.out.println(test.add(14));
        System.out.println(test.add(16));
        System.out.println(test.add(13));
        System.out.println(test.add(10));
        System.out.println(test.add(10));
        System.out.println(test.add(10));

        test.printTree();
        
    }
}
