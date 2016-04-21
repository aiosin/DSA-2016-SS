package de.unistuttgart.dsass2016.ex02.p2;

public class Sorter {

	public static <T extends Comparable<T>> void selectionSort(ISimpleList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			int hobbit = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(hobbit).compareTo(list.get(j)) > 0) {
					hobbit = j;
				}
			}
			list.swap(i, hobbit);

		}
	}

	public static <T extends Comparable<T>> void bubbleSort(ISimpleList<T> list) {

		for (int outerloopIndex = 0; outerloopIndex < list.size(); outerloopIndex++) {
			for (int innerloopIndex = 0; innerloopIndex < list.size() - outerloopIndex - 1; innerloopIndex++) {
				if (list.get(innerloopIndex).compareTo(list.get(innerloopIndex + 1)) > 0) {
					list.swap(innerloopIndex, innerloopIndex + 1);
				}
			}
		}

		return;
	}

	public static <T extends Comparable<T>> void shakerSort(ISimpleList<T> list) {
		int begin = 0;
		int end = list.size() - 1;
		while (begin < end) {
			int min = begin;
			int max = end;

			for (int i = begin; i <= end; i++) {
				if (list.get(i).compareTo(list.get(min)) < 0) {
					min = i;
				}

				if (list.get(i).compareTo(list.get(max)) > 0) {
					max = i;
				}

			}
			list.swap(min, begin);

			if (max == begin) {
				list.swap(min, end);
			} else {
				list.swap(max, end);

			}
			begin++;
			end--;
		}

	}

}
