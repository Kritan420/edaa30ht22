package bst;

import java.util.ArrayList;
import java.util.Comparator;


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

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {

		root = insertAdd(root, x);
		return true;
	}

	private BinaryNode<E> insertAdd(BinaryNode<E> node, E x) {

		if (node == null ) {
			node = new BinaryNode<E>(x);
			size++;
			return node;
		}
		else {
			if (ccomparator.compare(node.element, x) > 0) {
				node.left = insertAdd(node.left, x);
			} else if (ccomparator.compare(node.element, x) < 0) {
				node.right = insertAdd(node.right, x);
			}
		}
		
		return node;
	}


	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return calcHeight(root);
	}

	private int calcHeight(BinaryNode<E> node) {

		if (node == null || (root.left == null && root.right == null)) {
			return 0;
		} else {
			int leftHeight = calcHeight(node.left);
			int rightHeight = calcHeight(node.right);

			return Math.max(leftHeight, rightHeight) +1;
			
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
			System.out.print(node.element + " ");
			printInOrder(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
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
