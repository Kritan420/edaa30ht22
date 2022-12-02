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
	private BinarySearchTree<String>  myBST2;

	@BeforeEach
	void setUp() {
		myBST = new BinarySearchTree<Integer>();
		myBST2 = new BinarySearchTree<String>((e1, e2) -> (e2).compareTo(e1));
	}

	@AfterEach
	void tearDown(){
        myBST = null;
		myBST2 = null;
	}

	/**
	 * Test if a newly created binary search tree is empty.
	 */
	@Test
	void testNewBST() {
		assertEquals(0, myBST.size(), "Wrong size of empty queue");
		assertEquals(0, myBST2.size(), "Wrong size of empty queue");
	}

	
	/** Test a single add */
	@Test
	void testAddOne() {
		assertTrue(myBST.add(1), "add boolean error");
		assertFalse(myBST.add(1), "Add boolean error");
		assertEquals(1, myBST.size(), "Wrong size of queue");
        assertEquals(1, myBST.height(), "Wrong height of queue");
		myBST2.add("A");
		assertEquals(1, myBST2.size(), "Wrong size of queue");
        assertEquals(1, myBST2.height(), "Wrong height of queue");
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
		assertFalse(myBST.add(10), "Add boolean error");
		assertEquals(7, myBST.size(), "Wrong size of queue");
        assertEquals(3, myBST.height(), "Wrong height of queue");
		myBST2.add("a");
        myBST2.add("b");
        myBST2.add("c");
        myBST2.add("d");
        myBST2.add("e");
        myBST2.add("f");
		myBST2.add("g");
		assertFalse(myBST2.add("a"), "Add boolean error");
		assertEquals(7, myBST.size(), "Wrong size of queue");
        assertEquals(3, myBST.height(), "Wrong height of queue");
	}

	    	/** Test multiple add followed by clear. */
	@Test
	void testClear() {
		myBST.add(10);
        myBST.add(5);
        myBST.add(15);
        myBST.add(3);
        myBST.add(6);
        myBST.add(11);
		myBST.add(16);
		myBST.clear();
		myBST2.add("a");
        myBST2.add("b");
        myBST2.add("c");
        myBST2.add("d");
        myBST2.add("e");
        myBST2.add("f");
		myBST2.add("g");
		myBST2.clear();
		assertEquals(0, myBST2.size(), "Wrong size of queue after clear");
        assertEquals(0, myBST2.height(), "Wrong height of queue after clear");
		assertEquals(0, myBST.size(), "Wrong size of queue after clear");
        assertEquals(0, myBST.height(), "Wrong height of queue after clear");
	}


}