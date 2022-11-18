package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> temp = new QueueNode<E>(e);

		if (last == null) {    
			last = temp;
			last.next = last;
		} else {
			temp.next = last.next;
			last.next = temp;
		}
			
		last = temp;
		size = last.element.equals(e) ? size + 1 : size;
		return last.element.equals(e);
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		return last == null ? null : last.next == null ? last.element : last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {

		if (size == 0) { 
			return null;
		}

		QueueNode<E> temp = last;

		if (size == 1) { 
			last = null;
			size--;
			return temp.element;
		}

		temp = last.next;
		last.next = temp.next;

		size--;
		return temp.element;
	}
	
	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * to this queue. The specified queue (q) is empty after the call.
	 * 
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q) {
		if (q.equals(this)) {
			throw new IllegalArgumentException();
		}

		if (last == null) {
			last = q.last;
		} else if (q.last == null) {
			return;
		} else {

		QueueNode<E> tempF = this.last.next;
		QueueNode<E> tempQ = q.last.next;

		this.last.next = tempQ;
		q.last.next = tempF;
		this.last = q.last;
		}

		this.size = this.size + q.size;
		q.size = 0;
		q.last = null;		
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos = null;

		private QueueIterator() {
			pos = last;
		}

		public boolean hasNext() {	
			return pos != null ? pos.next != null ? true : false : false;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (pos.next == last) {
				E element = pos.next.element;
				pos = null;
				return element;
			}

			pos = pos.next;
			return pos.element;
		}
	}
}