package de.unistuttgart.dsass2016.ex02.p2;

public class Sorter {

	public static <T extends Comparable<T>> void selectionSort(ISimpleList<T> list) {

	}

	public static <T extends Comparable<T>> void bubbleSort(ISimpleList<T> list) {

		for (int outerloopIndex = 0; outerloopIndex < list.size(); outerloopIndex++) {
			for (int innerloopIndex = 0; innerloopIndex < list.size() -outerloopIndex -1; innerloopIndex++) {
				if (list.get(innerloopIndex).compareTo(list.get(innerloopIndex + 1))> 0) {
					//TODO: so far so good
					list.swap(innerloopIndex, innerloopIndex + 1);
				}
			}
		}
		
		return;
	}

	public static <T extends Comparable<T>> void shakerSort(ISimpleList<T> list) {
	}

	public static void main(String[] args) {
		SimpleList<Integer> smplList = new SimpleList<Integer>();
		smplList.append(2);
		smplList.append(122);
		smplList.append(32);
		smplList.append(42);
		smplList.append(28);
		smplList.append(29567);
		smplList.append(245);
		smplList.append(1);
		smplList.append(76);
		System.out.println(smplList.get(0));
		bubbleSort(smplList);
		for (int i = 0; i < smplList.size(); i++) {
			System.out.println(smplList.get(i));
		}
	}
}
