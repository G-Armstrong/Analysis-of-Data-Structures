import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<E> {
	// Data members
	private Node head, tail;
	int size;
	// Inner class Node
	private class Node{
		E value;
		Node next;
		Node(E initialValue){
			value = initialValue; next = null;
		}
	}
	/**
	 *  Constructor
	 */
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	/**
	 *  Adding an item to the list
	 * @param item to be added
	 * @return result of operation
	 */
	public boolean addFirst(E item) {
		Node newNode = new Node(item);
		if(head == null) { head = tail = newNode; }
		else { 
			newNode.next = head;     
			head = newNode;
		}
		size++; 
		return true;
	}
	/**
	 * Adds item at end of linked list
	 * @param item
	 * @return
	 */
	public boolean addLast(E item) {
		Node newNode = new Node(item);
		if(head == null) { head = tail = newNode; }
		else { 
			tail.next = newNode; 
			tail = newNode; 
		}
		size++; 
		return true;
	}
	/**
	 * Calls addLast
	 * @param item to be added last
	 * @return result of operation
	 */
	public boolean add(E item) {
		return addLast(item);
	}
	/**
	 *  Retrieving an item from the list
	 * @return the item retrieved
	 */
	public E getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.value;
	}
	/**
	 *  Retrieving an item from the list
	 * @return the item retrieved
	 */
	public E getLast() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return tail.value;
	}
	/**
	 *  Removing first item from the list
	 * @return the result of the operation
	 */
	public boolean removeFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		head = head.next;
		if(head == null) {
			tail=null;
		}
		size--; 
		return true;
	}
	/**
	 *  Removing last item from the list
	 * @return the result of the operation
	 */
	public boolean removeLast() {
		if (head == null) 
			throw new NoSuchElementException();
		if(size == 1) 
			return removeFirst();
		Node current = head;
		Node previous = null;
		while(current.next != null) {
			previous = current; 
			current = current.next;
		}
		previous.next = null; tail = previous;
		size--; return true;
	}
	/**
	 * toString() method
	 */
	public String toString() {
		String output = "[";
		Node current = head;
		while(current != null) {
			output += current.value + " ";
			current = current.next;
		}
		output += "]";
		return output;
	}
	/**
	 *  clear, check if empty, and size of the list
	 */
	public void clear() { head = tail = null; size = 0; }
	public boolean isEmpty() { return (size == 0); }
	public int size() { return size; }
	
	/**
	 *  Generating an iterator for the list
	 * @return
	 */
	public Iterator<E> iterator(){  
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E>{
		private Node current = head;
		/**
		 * checks if an object is in the list
		 */
		public boolean hasNext() {
			return (current != null);
		}
		/**
		 * Returns the current value
		 */
		public E next() {
			if(current == null)  
				throw new NoSuchElementException();
			E value = current.value;
			current = current.next; 
			return value;
		}	
	}
	/**
	 * Returns the number of iterations for the search
	 * @param item value searched for
	 * @return int number of iterations
	 */
	//O(n) = linear time complexity
	public int searchIterations(E item) {
		int iterations = 0;
		Node current = head;
		while(current != null) {
			iterations++;
			if(current.value.equals(item)) {
				return iterations;
			}
			current = current.next;
		}
		return iterations;
	}
}
