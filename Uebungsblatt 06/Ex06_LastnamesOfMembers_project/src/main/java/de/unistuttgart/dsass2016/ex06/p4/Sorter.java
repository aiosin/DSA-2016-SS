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
		list.append(9);
		list.append(8);
		list.append(7);
		list.append(6);
		list.append(5);
		list.append(4);
		list.append(3);
		list.append(2);
		list.append(1);
		list.append(0);

		System.out.println("list size:");
		System.out.println(list.size());
		System.out.println("unsorted list");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("start heapsort");
		heapSort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("heapsort end");
	}

	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {

		// build maxheap
		for (int i = list.size() / 2; i >= 0; i--) {
			percolate(list, i, list.size()-1);
		}

		for (int i = list.size() - 1; i > 0; i--) {
			// swapping the biggest and the last element in the heap
			list.swap(0, i);

			// rebuild heap
			percolate(list, 0, i - 1);

		}

	}

	private static <T extends Comparable<T>> void percolate(ISimpleList<T> f, int idx, int last) {
		int i = idx, j;
		while ((2 * i) + 1 <= last) {
			// f[i] hat linkes Kind
			j = (2 * i) + 1;
			// f[j] ist linkes Kind von f[i]
			if (j + 1 <= last) {
				// f[i] hat auch rechtes Kind
				if (f.get(j).compareTo(f.get(j + 1)) < 0) {
					// vergleiche Kinder
					j++;
					// f[j] ist jetzt kleiner
				}
			}
			if (f.get(i).compareTo(f.get(j)) < 0) {
				// vergleiche Elter mit Kind
				f.swap(i, j);
				i = j;
				// versickere weiter
			} else {
				// halte an, Heap - Bedingung erfüllt
				break;
			}
		}
	}

}
