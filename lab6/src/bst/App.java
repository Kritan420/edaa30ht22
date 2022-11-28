package bst;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> test = new BinarySearchTree<>();


        test.add(10);
        test.add(9);
        test.add(15);
        test.add(8);
        test.add(14);
        test.add(16);
        test.add(13);

    //System.out.println(t);

        //test.printTree();

        //System.out.println(test.search(test.root, 13));
        System.out.println(test.height());
        
    }
}
