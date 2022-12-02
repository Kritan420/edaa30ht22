package bst;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * F1a: 10 20 30 47
 * F1b: 3
 * F1c: 4
 * F2: 0
 * F2: Maxdjup för nod
 * F2: Math.max
 * 	First + (last-first) / 2
 * 
 * 
 * Slippa skicka in alla parametrar vid t.ex. rebuild
 * Använda root som allmän node
 * 
 * 
 * Linkedlist jobbigt pga mid, funkar säkert men finns ju bara first och last som index
 */

public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> ccomparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		ccomparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		ccomparator = comparator;
	}

	public static void main(String[] args) {
		BSTVisualizer bstv = new BSTVisualizer("BinarySearchTree", 600, 600);
		BSTVisualizer bstv2 = new BSTVisualizer("BinarySearchTree", 600, 600);
		//BinarySearchTree<Integer> test = new BinarySearchTree<>();
		BinarySearchTree<String> testString = new BinarySearchTree<>((e1, e2) -> ((Comparable<String>) e2).compareTo(e1));

		/** test.add(12);
        test.add(6);
		test.add(14);
		test.add(5);
		test.add(8);
		test.add(18);
		test.add(7);
		test.add(9);
		test.add(16);
		test.add(19); */

  		
		testString.add("e");
		testString.add("w");
		testString.add("a");
		testString.add("m");
		testString.add("d");
		testString.add("a");
		testString.add("z");
		testString.add("y");
		testString.add("b");
		testString.add("o");
		testString.add("z");
		testString.add("p");
		testString.add("q"); 

		/** for (int i = 1; i < 25; i++) {
			test.add(i);
		}*/

		bstv.drawTree(testString);

		testString.rebuild();
		
		bstv2.drawTree(testString);
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {

		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}else {
			return insertAdd(root, x);
		}
	}

	private boolean insertAdd(BinaryNode<E> node, E x) {


		if (ccomparator.compare(node.element, x) > 0) {
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return insertAdd(node.left, x);

		} else if (ccomparator.compare(node.element, x) < 0) {
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return insertAdd(node.right, x);
			}

		return false;
	}

	public boolean search(BinaryNode<E> node, E x) {

	if (node == null ) {
		return false;
	} else {
		if (ccomparator.compare(node.element, x) == 0) {
			return true;
		}
		else if (ccomparator.compare(node.element, x) > 0) {
			return search(node.left, x);
		}
		else if (ccomparator.compare(node.element, x) < 0) {
			return search(node.right, x);
		}
	}
	return false;
}

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return calcHeight(root);
	}

	private int calcHeight(BinaryNode<E> node) {

		if (node == null) {
			return 0;
		} else {
			int leftHeight = calcHeight(node.left);
			int rightHeight = calcHeight(node.right);

			return Math.max(leftHeight, rightHeight)+1;
			
		}

	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printInOrder(root);

	}

	private void printInOrder(BinaryNode<E> node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node.element);
			printInOrder(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<>();
		
		toArray(root, sorted);

		root = buildTree(sorted, 0, sorted.size()-1);

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		
		if (n != null) {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}

	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {


		int mid = first + (last-first) / 2;
		BinaryNode<E> node = new BinaryNode<E>(sorted.get(mid));

		if (first > last) {
			node = null;
			return node; 
		} else if (first == last) {
			return node;
		}else { 
			node.left = buildTree(sorted, first, mid-1);
			node.right = buildTree(sorted, mid+1, last);
			}
			return node;
		}
	
	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
