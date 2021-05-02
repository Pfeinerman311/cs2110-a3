package LinkedList;

import java.util.NoSuchElementException;

/* Name: Parker Feinerman
 * Netid: pjf73
 * What I thought about this assignment:
 * The assignment itself was fine I just personally felt like some
 * of it was a bit ambiguous. Specifically, I didn't feel very
 * confident that I did the test cases correctly/included all
 * of the necessary test cases.
 */

/** An instance is a doubly linked list. */
public class DList<E> {

	/** Replace "-1" by the time you spent on A3 in hours.<br>
	 * Example: for 3 hours 15 minutes, use 3.25<br>
	 * Example: for 4 hours 30 minutes, use 4.50<br>
	 * Example: for 5 hours, use 5 or 5.0 */
	public static double timeSpent= 2.50;

	/** First node of linked list (null if size is 0) */
	private Node first;
	/** Last node of linked list (null if size is 0) */
	private Node last;
	/** Number of nodes in the linked list */
	private int size;

	/** Constructor: an empty linked list. */
	public DList() {}

	/** = the number of values in this list. <br>
	 * This function takes constant time. */
	public int size() {
		return size;
	}

	/** First value in the list. <br>
	 * Throw a NoSuchElementException if list is empty. */
	public E first() {
		if (size == 0) throw new NoSuchElementException();
		return first.val;
	}

	/** = the last value of the list. <br>
	 * Throw a NoSuchElementException if list is empty. */
	public E last() {
		if (size == 0) throw new NoSuchElementException();
		return last.val;
	}

	/** = the first node of the list (null if the list is empty). */
	public Node firstNode() {
		return first;
	}

	/** = the last node of the list (null if the list is empty). */
	public Node lastNode() {
		return last;
	}

	/** = the value of node n of this list. This function takes constant time.<br>
	 * Precondition: n is a node of this list; it may not be null. */
	public E value(Node n) {
		assert n != null;
		return n.val;
	}

	/** Return a representation of this list: its values, with adjacent ones <br>
	 * separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 * Note: Exactly one blank separates a ',' from the next value.<br>
	 * Takes time proportional to the length of this list.<br>
	 * E.g. for the list containing 4 7 8 in that order, the result is "[4, 7, 8]". <br>
	 * E.g. for the list containing two empty strings, the result is "[, ]" */
	@Override
	public String toString() {
		String res= "[";
		Node n= first;
		// invariant: res contains "[" followed by the String repr of values of nodes
		// before node n (all of them if n = null),
		// with ", " after each (except for the last value)
		while (n != null) {
			res= res + n.val;
			n= n.next;
			if (n != null) res= res + ", ";
		}

		return res + "]";
	}

	/** Return a representation of this list: its values in reverse, with adjacent <br>
	 * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 * Note: Exactly one blank separates a ',' from the next value.<br>
	 * Takes time proportional to the length of this list. <br>
	 * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]". <br>
	 * E.g. for the list containing two empty strings, the result is "[, ]". */
	public String toStringR() { // Note:
		// TODO 1. Look at toString to see how that was written.
		// Use the same scheme. Extreme case to watch out for:
		// E is String and values are the empty string.
		// You can't test this fully until ToDo 2, prepend, is written.
		String res= "[";
		Node n= last;
		while (n != null) {
			res= res + n.val;
			n= n.prev;
			if (n != null) res= res + ", ";
		}

		return res + "]";
	}

	/** Add value v to the front of the list. <br>
	 * This operation takes constant time. */
	public void prepend(E v) {
		// TODO 2. After writing this method, test this method and
		// method toStringR thoroughly before starting on the next
		// method. These two methods must be correct in order to be
		// able to write and test all the others.
		if (first == null) {
			Node n= new Node(null, v, null);
			first= n;
			last= n;
		} else {
			Node n= new Node(null, v, first);
			first.prev= n;
			first= n;
		}
		size++ ;
	}

	/** add value v to the end of the list. <br>
	 * This operation takes constant time. */
	public void append(E v) {
		// TODO 3. This is the third method to write and test
		if (last == null) this.prepend(v);
		else {
			Node n= new Node(last, v, null);
			last.next= n;
			last= n;
			size++ ;
		}
	}

	/** Return node number h: If h is 0, return first node;<br>
	 * if h = 1, return second node, etc.<br>
	 * Precondition: 0 <= h < size of the list. */
	public Node getNode(int h) {
		// TODO 4. This method should take time proportional to min(h, size-h).
		// For example, if h <= size/2, search from the beginning of the
		// list, otherwise search from the end of the list.
		if (h <= size / 2) {
			int i= 0;
			Node n= first;
			while (i != h) {
				n= n.next;
				i++ ;
			}
			return n;
		} else {
			int i= size - 1;
			Node n= last;
			while (i != h) {
				n= n.prev;
				i-- ;
			}
			return n;
		}
	}

	/** Remove node n from this list. <br>
	 * This operation must take constant time.<br>
	 * Precondition: n must be a node of this list; it may not be null. */
	public void delete(Node n) {
		// TODO 5. Make sure this method takes constant time.
		if (n == first) first= n.next;
		if (n == last) last= n.prev;
		if (n.next != null) n.next.prev= n.prev;
		if (n.prev != null) n.prev.next= n.next;
		size-- ;
	}

	/** Insert value v in a new node before node n.<br>
	 * This operation takes constant time.<br>
	 * Precondition: n must be a node of this list; it may not be null. */
	public void insertBefore(E v, Node n) {
		// TODO 6. Make sure this method takes constant time.
		if (n == first) this.prepend(v);
		else {
			Node x= new Node(n.prev, v, n);
			n.prev.next= x;
			n.prev= x;
			size++ ;
		}
	}

	/*********************/

	/** An instance is a node of this list. */
	public class Node {
		private Node prev; // Previous node on list (null if this is first node)
		private E val;     // The value of this element
		private Node next; // Next node on list. (null if this is last node)

		/** Constructor: an instance with previous node p (can be null), <br>
		 * value v, and next node n (can be null). */
		Node(Node p, E v, Node n) {
			prev= p;
			val= v;
			next= n;
		}

		/** Return the node previous to this one (null if this is the first node of the list). */
		public Node prev() {
			return prev;
		}

		/** Return the value of this node. */
		public E value() {
			return val;
		}

		/** Return the next node in this list (null if this is the last node of this list). */
		public Node next() {
			return next;
		}
	}

}
