import java.io.PrintStream;
import java.util.NoSuchElementException;

/*
 * Class that implements the Queue Interface's methods. More comments for each
 * method can be found in StringQueue.java. Generics were used.
 */

public class StringQueueImpl<T> implements StringQueue<T> {

	private Node<T> head;
	private int size = 0;
	private Node<T> tail;

	// Default Constructor
	public StringQueueImpl() {
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void put(T item) {

		// creating a new node object that will be inserted
		Node<T> node = new Node<>(item);
		size++;

		/*
		 * If the queue is empty it will be the new head and tail simultaneously because
		 * it's the only element
		 */
		if (isEmpty()) {
			head = node;
		}

		// else we connect the previous tail to this node, and make this node the tail
		else {
			tail.next = node;
		}

		tail = node;
	}

	@Override
	public T get() throws NoSuchElementException {

		// If queue is empty throw an Exception
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is Empty");
		}

		/*
		 * else remove the head and make the 2nd node as new head and return the old
		 * head
		 */
		Node<T> oldhead = head;
		head = head.next;
		oldhead.next = null;
		size--;
		return oldhead.item;
	}

	@Override
	public T peek() throws NoSuchElementException {

		// if queue is empty throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is Empty");
		}

		// else return the head
		return head.item;
	}

	@Override
	public void printQueue(PrintStream stream) {

		// If queue is empty print an appropriate message and return
		if (isEmpty()) {
			stream.println("Queue is empty");
			return;
		}

		// else print each node
		Node<T> node = head;
		while (node != null) {
			stream.println(node.item);
			node = node.next;
		}
	}

	@Override
	public int size() {
		return size;
	}

}
