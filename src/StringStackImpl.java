import java.io.PrintStream;
import java.util.NoSuchElementException;

/*
 * Class that implements the Stack Interface's methods. More comments for each
 * method can be found in StringStack.java. Generics were used.
 */

public class StringStackImpl<T> implements StringStack<T> {

	private Node<T> top;
	private int size = 0;

	// Default Constructor
	public StringStackImpl() {

	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(T item) {

		// creating a new node object that will be inserted
		Node<T> node = new Node<>(item);
		size++;

		/*
		 * If the stack is not empty, previous top must be connected to the newly
		 * inserted node which will be the new top
		 */
		if (!isEmpty()) {
			node.next = top;
		}

		top = node;
	}

	@Override
	public T pop() throws NoSuchElementException {

		// If stack is empty throw an Exception
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is Empty");
		}

		/*
		 * else remove the top and make the previous node as the new top and return the
		 * old top
		 */
		Node<T> previous_top = top;
		top = top.next;
		previous_top.next = null;
		size--;
		return previous_top.item;
	}

	@Override
	public T peek() throws NoSuchElementException {

		// If stack is empty throw an exception
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is Empty");
		}

		// else return the top
		return top.item;
	}

	@Override
	public void printStack(PrintStream stream) {

		// if stack is empty print an appropriate message and return
		if (isEmpty()) {
			stream.println("Stack is empty");
			return;
		}

		// else print each node
		Node<T> node = top;
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
