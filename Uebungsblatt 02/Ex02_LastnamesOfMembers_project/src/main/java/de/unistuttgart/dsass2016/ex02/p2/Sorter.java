package de.unistuttgart.dsass2016.ex02.p2;

public class Sorter {

	public static <T extends Comparable<T>> void selectionSort(ISimpleList<T> list) {

	}

	public static <T extends Comparable<T>> void bubbleSort(ISimpleList<T> list) {
		// public static int[] bubblesort(int[] zusortieren) {
		// int temp;
		// for(int i=1; i<zusortieren.length; i++) {
		// for(int j=0; j<zusortieren.length-i; j++) {
		// if(zusortieren[j]>zusortieren[j+1]) {
		// temp=zusortieren[j];
		// zusortieren[j]=zusortieren[j+1];
		// zusortieren[j+1]=temp;
		// }
		//
		// }
		// }
		// return zusortieren;
		// }

		int temp;

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size()-i; j++) {
				
			}
		}
	}

	public static <T extends Comparable<T>> void shakerSort(ISimpleList<T> list) {
	}

}
