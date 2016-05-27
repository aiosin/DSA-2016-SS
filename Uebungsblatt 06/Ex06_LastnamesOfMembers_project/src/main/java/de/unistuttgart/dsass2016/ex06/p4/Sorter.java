package de.unistuttgart.dsass2016.ex06.p4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class Sorter {

	private Sorter() {
	}

	public static void main(String[] args) {
		// for testing purposes
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		heapSort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {
		if (list != null && list.size() > 0) {
			// initializing the temporary list
			ISimpleList<T> tempList = new SimpleList<T>();

			for (int i = 0; i < list.size(); i++) {

			}
		}

	}
	//COPYPASTED HEAPSORT FOR FUNCTIONALITY
	public static <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> array) {

		MaxHeap<T> heap = new MaxHeap<T>(array);

		for (int i = array.size() - 1; i >= 0; --i) {

			array.set(i, heap.delete());
		}

		return array;
	}
}

class MaxHeap<T extends Comparable<T>> {

	private ArrayList<T> array = null;

	public MaxHeap() {
	};

	public MaxHeap(ArrayList<T> arrayList) {

		array = new ArrayList<T>();

		/*
		 * Need a deep copy because the array representing the heap will need to
		 * maintain the heap property, but arraylist may need to be in a
		 * different ordering
		 */

		for (int i = 0; i < arrayList.size(); ++i) {

			array.add(arrayList.get(i));
		}

		for (int i = arrayList.size() / 2 - 1; i >= 0; --i) {

			this.siftDown(i);

		}
	}

	// Adds the object to the array list and preserves the
	// heap property with siftUp()
	// O(logn)
	public void insert(T obj) {

		array.add(obj);
		this.siftUp();
	}

	public T peek() {

		return array.get(0);
	}

	/*
	 * Deletes the top element of the tree and then swaps in the element at the
	 * end of the array (the rightmost leaf in the tree given level order
	 * sequence), compares its children, and then compares the key to its larger
	 * child. If the key is smaller then swap and keep doing thus until it
	 * floats down the tree and it is larger than both of its children or it is
	 * a leaf. This it maintains the heap property.
	 */
	public T delete() throws NoSuchElementException {

		if (array.size() == 0) {
			throw new NoSuchElementException();
		} else if (array.size() == 1) {

			return array.remove(0);
		} else {
			T result = array.get(0);
			array.set(0, array.remove(array.size() - 1));
			this.siftDown(0);
			return result;
		}
	}

	// Checks to see if the heap is empty
	public boolean isEmpty() {

		return array.size() == 0;
	}

	// Returns the size of the heap i.e. the number of nodes
	public int size() {

		return array.size();
	}

	/*
	 * Places an element at the end of the array list (at the end of the tree in
	 * level order sequence) and compares that element to its parent node and
	 * swaps if the key is larger than it's parent. Repeats until the key's
	 * parent is larger, maintaining the heap property. O(logn)
	 */

	private void siftUp() {

		T swap = null;
		int key = array.size() - 1;
		int parent = key / 2;

		// If the key is greater than the parent swap their places in the tree
		while (0 > array.get(parent).compareTo(array.get(key))) {

			swap = array.get(key);
			array.set(key, array.get(parent));
			array.set(parent, swap);

			key = parent;
			parent = key / 2;

		}
	}

	/*
	 * Takes in an index to start and compares its children, and then compares
	 * the key to its larger child. If the key is smaller then swap and keep
	 * doing thus until it floats down the tree and it is larger than both of
	 * its children or it is a leaf. This it maintains the heap property.
	 */
	private void siftDown(int index) {

		T swap = null;
		int key = index;
		int left = 2 * key + 1;
		int right = 2 * key + 2;
		int child = 0;

		while (left < array.size() || right < array.size()) {

			if (right < array.size()) {

				if (0 > array.get(left).compareTo(array.get(right))) {

					child = right;
				} else {

					child = left;
				}
			} else {

				child = left;
			}

			if (0 > array.get(key).compareTo(array.get(child))) {

				swap = array.get(child);
				array.set(child, array.get(key));
				array.set(key, swap);

				key = child;
				left = 2 * key + 1;
				right = 2 * key + 2;
			} else {
				break;
			}

		}
	}

	// Clears the heap if elements
	public void clear() {

		array.clear();
	}
}