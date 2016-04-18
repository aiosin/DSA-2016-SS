package de.unistuttgart.dsass2016.ex01.p2;

import java.beans.ConstructorProperties;
import java.util.*;

public class SpeedList<T> implements ISpeedList<T>, Iterable<T> {
	// TODO: COMMENT THIS SHIT
	private int speedListSize;
	// add head
	private Node<T> head;

	@Override
	public int size() {
		return speedListSize;
	}

	@Override
	public void prepend(T t) {

	}

	@Override
	public T getElementAt(int pos) {
		return null;
	}

	@Override
	public T getNext8thElementOf(int pos) {
		return null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(T t) {
		head = new Node<T>(t, head);
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
