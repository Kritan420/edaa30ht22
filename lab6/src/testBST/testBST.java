package testBST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

class  testBST {
	private BinarySearchTree<Integer>  myBST;

	@BeforeEach
	void setUp() {
		myBST = new BinarySearchTree<Integer>();
	}

	@AfterEach
	void tearDown(){
        myBST = null;
	}

	/**
	 * Test if a newly created binary search tree is empty.
	 */
	@Test
	void testNewBST() {
		assertEquals(0, myBST.size(), "Wrong size of empty queue");
	}

	/** Test a single add followed by a single peek. */
	@Test
	void testAddOne() {
		myBST.add(1);
		assertEquals(1, myBST.size(), "Wrong size of queue");
        assertEquals(0, myBST.height(), "Wrong height of queue");
	}
    	/** Test multiple add followed by a single peek. */
	@Test
	void testAddMultiple() {
		myBST.add(10);
        myBST.add(5);
        myBST.add(15);
        myBST.add(3);
        myBST.add(6);
        myBST.add(11);
		myBST.add(16);
		assertEquals(7, myBST.size(), "Wrong size of queue");
        assertEquals(3, myBST.height(), "Wrong height of queue");
	}


}