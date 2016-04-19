package de.unistuttgart.dsass2016.ex01.p2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SpeedList<T> implements ISpeedList<T>, Iterable<T> {
	// TODO: COMMENT THIS SHIT
	private int speedListSize;
	// add head
	private Node<T> head;

	@Override
	/**
	 * size method of SpeedList, returns the current value of speedListSize
	 */
	public int size() {
		return speedListSize;
	}

	@Override
	public void prepend(T t) {
		addFirst(t);
	}

	@Override
	public T getElementAt(int pos) {
		return get(pos);
	}

	@Override
	// TODO: fix and clean up
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
			
			//then the pointer advances another 8 nodes
			//TODO: null or NoSuchElementException ?
			for (int i = 0; i < 8; i++) {
				if (last.hasNext()) {
					last = last.getNext();
				} else {
					throw new NoSuchElementException();
				}
			}
			return last.getData();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(T t) {
		head = new Node<T>(t, head);
		speedListSize++;
	}

	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			return head.t;
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
			addFirst(t);
		} else {
			Node<T> tmp = head;
			// TODO: check while loop
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node<T>(t, null);
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

	public void flush() {
		this.head = null;
		speedListSize = 0;
	}

	public T get(int index) {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		} else {

			Node<T> tmp = head;
			for (int i = 0; i < index; i++) {
				tmp = tmp.next;
			}

			if (tmp == null) {
				throw new IndexOutOfBoundsException();
			}

			return tmp.t;
		}
	}

	// TODO: Node finished
	@SuppressWarnings("hiding")
	public class Node<T> {

		private T t;

		private Node<T> next;

		public Node(T t, Node<T> next) {
			this.t = t;
			this.next = next;

		}

		public T getData() {
			return t;
		}

		public Node<T> getNext() {
			if (next != null) {
				return next;
			} else {
				return null;
			}
		}

		public boolean hasNext() {
			return next != null;
		}

	}

	@Override
	public Iterator<T> iterator() {

		return new SpeedListIterator();
	}

	private class SpeedListIterator implements Iterator<T> {
		private Node<T> nextNode;

		public SpeedListIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				T res = nextNode.t;
				nextNode = nextNode.next;
				return res;
			}
		}

	}

}
