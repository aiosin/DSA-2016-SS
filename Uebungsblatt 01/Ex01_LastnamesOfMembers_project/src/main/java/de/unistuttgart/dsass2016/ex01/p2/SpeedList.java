package de.unistuttgart.dsass2016.ex01.p2;

import java.util.NoSuchElementException;

public class SpeedList<T> implements ISpeedList<T>{
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
	/**
	 * inserts a element T at the beginning of the list
	 * 
	 */
	public void prepend(T t) {
		addFirst(t);
	}

	@Override
	/**
	 * TODO: implement IndexOutOfBoundsException
	 * 
	 * Returns the element at the specified position in the list
	 * 
	 * @param pos The position of the element in the list starting from 0
	 * 
	 * @return The specified element in the list
	 * 
	 * @throws IndexOutOfBoundsException If the requested element is out of
	 * range
	 */
	public T getElementAt(int pos) {
		return get(pos);
	}

	@Override
	// TODO: fix and clean up
	/**
	 * Returns the next 8th element of the specified element in the list
	 * 
	 * @param pos The position of the specified element in the list starting
	 * from 0
	 * 
	 * @return The next 8th element of the specified element
	 * 
	 * @throws IndexOutOfBoundsException If the requested element is out of
	 * range
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
			
			//then the pointer advances another 8 nodes
			//TODO: null or NoSuchElementException ?
			for (int i = 0; i < 8; i++) {
				if (last.hasNext()) {
					last = last.getNext();
				} else {
					throw new NoSuchElementException();
				}
			}
			//if the pointer could find an n+8 element it returns it 
			return last.getData();
		} catch (NoSuchElementException e) {
			//if NoSuchElementException gets thrown gets catched here and return null
			return null;
		}
	}
	/**
	 * checks if the head is null, which when its filled it shouldnt
	 * @return
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * transfer this code to prepend() 
	 * @param t
	 */
	public void addFirst(T t) {
		head = new Node<T>(t, head);
		speedListSize++;
	}
	/**
	 * TODO: maybe implement a getT(); method in class node ?
	 * @return
	 */
	public T getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		} else {
			return head.t;
		}
	}
	/**
	 * TODO: maybe unnecessary
	 * @return
	 */
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
	/**
	 * if the head is null we can forget about the rest of the list
	 */
	public void dropList() {
		this.head = null;
		speedListSize = 0;
	}
	/**
	 * 
	 * @param index
	 * @return
	 */
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
		//stored information
		private T t;
		//null node next, also works as TAIL at the end
		private Node<T> next;
		
		//constructor
		public Node(T t, Node<T> next) {
			this.t = t;
			this.next = next;

		}
		//
		public T getData() {
			return t;
		}
		//
		public Node<T> getNext() {
			if (next != null) {
				return next;
			} else {
				return null;
			}
		}
		//checks if there exists a next element
		public boolean hasNext() {
			return next != null;
		}

	}
/**
 * dont need dont care
 * 
 */
//	public Iterator<T> iterator() {
//
//		return new SpeedListIterator();
//	}

//	private class SpeedListIterator implements Iterator<T> {
//		private Node<T> nextNode;
//
//		public SpeedListIterator() {
//			nextNode = head;
//		}
//
//		@Override
//		public boolean hasNext() {
//			return nextNode != null;
//		}
//
//		@Override
//		public T next() {
//			if (!hasNext()) {
//				throw new NoSuchElementException();
//			} else {
//				T res = nextNode.t;
//				nextNode = nextNode.next;
//				return res;
//			}
//		}
//
//	}

}
