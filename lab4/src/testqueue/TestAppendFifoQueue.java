package testqueue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

public class TestAppendFifoQueue {
    private FifoQueue<Integer> Q1;
    private FifoQueue<Integer> Q2;
    private FifoQueue<Integer> Q1e;
    private FifoQueue<Integer> Q2e;
    private FifoQueue<String> Q1s;
    private FifoQueue<String> Q2s;
    @BeforeEach
	void setUp() {
		Q1 = new FifoQueue<Integer>();
        Q2 = new FifoQueue<Integer>();
        for (int i = 1; i <= 5; i++) {
            Q1.offer(i);
            Q2.offer(i+5);
        }
        Q1e  = new FifoQueue<Integer>();
        Q2e = new FifoQueue<Integer>();
        Q1s  = new FifoQueue<String>();
        Q2s = new FifoQueue<String>();
        for (int i = 1; i <= 5; i++) {
            Q1s.offer("Sofiero " + Integer.toString(i));
            Q2s.offer("Sofie " + Integer.toString(i+5));
        }
	}

    @AfterEach
	void tearDown(){
		Q1 = null;
        Q2 = null;
        Q1e = null;
        Q2e = null;
	}


	@Test
	void testSize() {
        assertTrue(Q1.size() == 5 && Q1e.size() == 0 && Q2.size() == 5 &&  Q2e.size() == 0, "Sizes wrong");
	}

    @Test
    void testEmpty() {
        assertTrue(Q1e.isEmpty() && Q2e.isEmpty(), "Queues empty wrong");
        assertThrows(NullPointerException.class, () -> Q1e.append(Q2e));
    }
    @Test
    void emptyOnNot() {
        assertTrue(!Q1.isEmpty() && !Q2.isEmpty() && Q1e.isEmpty() && Q2e.isEmpty(), "Queues empty state wrong");
        assertThrows(NullPointerException.class, () -> Q1.append(Q2e));
        assertThrows(NullPointerException.class, () -> Q1e.append(Q2));
    }

	@Test
	void testSelf() {
		assertThrows(IllegalArgumentException.class, () -> Q1.append(Q1));
        assertThrows(IllegalArgumentException.class, () -> Q2e.append(Q2e));
	}

    @Test
    void testDressRehearsal() {
       

        int sumSize = Q1.size() + Q2.size();
        
        Q1.append(Q2);
        assertTrue(Q1.size() == sumSize, "Q1 size wrong");
        assertTrue(Q2.size() == 0, "Q2 size wrong");
        Iterator<Integer> itr1 = Q1.iterator();
        for (int i = 1; i <= Q1.size(); i++) {
			assertTrue(itr1.hasNext(), "itr1 hasNext");
			assertEquals(Integer.valueOf(i), itr1.next(), "Wrong numbers in order");
		}
        Iterator<Integer> itr2 = Q2.iterator();
        assertFalse(itr2.hasNext(), "itr2 hasNext");
    }
    @Test
    void testDressRehearsalString() {
       

        int sumSize = Q1s.size() + Q2s.size();
        
        Q1s.append(Q2s);
        assertTrue(Q1s.size() == sumSize, "Q1 size wrong");
        assertTrue(Q2s.size() == 0, "Q2 size wrong");
        Iterator<String> itr1 = Q1s.iterator();
        for (int i = 1; i <= sumSize; i++) {
			assertTrue(itr1.hasNext(), "itr1 hasNext");
            assertEquals("Sofie", itr1.next().substring(0, 5));
        }
        
        Iterator<String> itr2 = Q2s.iterator();
        assertFalse(itr2.hasNext(), "itr2 hasNext");
    }
}
