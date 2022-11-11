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

		if (last == null) {    // om tom kö
			last = temp;
			size++;

		} else {
			if (last.next == null) {  // om en i kön

				last.next = temp;
				temp.next = last;
				last = temp;
				
			} else {

				temp.next = last.next;
				last.next = temp;
				last = temp;
			}
			size++;
		}

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

		if (size == 0) { // om tom
			return null;
		}

		if (size == 1) { // om en i kön
			QueueNode<E> temp = last;
			last = null;
			size--;
			return temp.element;
		}

		QueueNode<E> temp = last.next;

		last.next = temp.next == null ? null : temp.next;
		
		size--;
		return temp.element;
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

		/* Konstruktor */
		private QueueIterator() {
			pos = last != null ? last.next != null ? last : null : null;
		}

		public boolean hasNext() {	
			return pos != null ? pos.next != null ? true : false : false;
		}
		public E next() {

			if (pos == null || pos.next == null) {
				throw new NoSuchElementException();
			}

			pos = pos.next;
			return pos.element;

			
		}
	}
	

}
