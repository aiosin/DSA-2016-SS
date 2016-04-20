package de.unistuttgart.dsass2016.ex01.p2;

import java.util.NoSuchElementException;

/**
 * 
 * @author Wilhelm Buchmüller 3133783
 * @author Daniel Wanner 3149308
 * @author Artur Frenzen 2736424
 * 
 *
 * @param <T>
 */
public class SpeedList<T> implements ISpeedList<T> {
	private int speedListSize;
	private Node<T> head;

	/**
	 * size method of SpeedList, returns the current value of speedListSize
	 * 
	 * @return speedListSize
	 */
	public int size() {
		return speedListSize;
	}

	/**
	 * inserts a element T at the beginning of the list
	 * 
	 */
	public void prepend(T t) {
		head = new Node<T>(t, head);
		speedListSize++;
	}

	/**
	 * Returns the element at the specified position in the list
	 * 
	 * @param Position
	 * @return The specified element in the list
	 */
	public T getElementAt(int pos) {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		} else {

			Node<T> tmp = head;
			for (int i = 0; i < pos; i++) {
				tmp = tmp.next;
			}

			if (tmp == null) {
				throw new IndexOutOfBoundsException();
			}

			return tmp.t;
		}

	}

	/**
	 * Returns the next 8th element of the specified element in the list
	 * 
	 * @param Position
	 * @return The next 8th element of the specified element
	 */
	public T getNext8thElementOf(int pos) {
		try {
			// setting up a tmp head-node
			Node<T> last = head;
			// advances the pointer to the desired position
			for (int i = 0; i < pos; i++) {
				if (last.hasNext()) {
					last = last.getNext();
				} else {
					break;
				}
			}

			// then the pointer advances another 8 nodes
			for (int i = 0; i < 8; i++) {
				if (last.hasNext()) {
					last = last.getNext();
				} else {
					throw new IndexOutOfBoundsException();
				}
			}
			// if the pointer could find an n+8 element it returns it
			return last.getData();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * checks if the head is null, which when its filled it should'nt
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * 
	 * @return
	 */
	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			return head.getData();
		}
	}

	public T removeFirst() {
		T tmp = getFirst();
		head = head.next;
		speedListSize--;
		return tmp;
	}

	public void addLast(T t) {
		if (head == null) {
			prepend(t);
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(t, null);
		}
		speedListSize++;
	}

	public T getLast() {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			return tmp.t;
		}
	}

	/**
	 * if the head is null we can forget about the rest of the list maybe gc
	 * will clear it
	 */
	public void dropList() {
		this.head = null;
		speedListSize = 0;
	}

	@SuppressWarnings("hiding")
	public class Node<T> {
		// stored information
		private T t;
		// null node next, also works as TAIL at the end node
		private Node<T> next;

		// constructor
		public Node(T t, Node<T> next) {
			this.t = t;
			this.next = next;

		}

		// return data
		public T getData() {
			return t;
		}

		// returns the next element
		public Node<T> getNext() {
			if (next != null) {
				return next;
			} else {
				return null;
			}
		}

		// checks if there exists a next element
		public boolean hasNext() {
			return next != null;
		}

	}

}
