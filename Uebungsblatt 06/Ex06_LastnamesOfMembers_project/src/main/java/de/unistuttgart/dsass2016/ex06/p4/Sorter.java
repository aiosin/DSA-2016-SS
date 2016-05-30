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
		//checking for those ugly cases
		if (list.size() > 1 && list != null) {
			//setting up for the first time
			generateMaxHeap(list);
			
			//actually sorting starts NOW
			
			for (int i = list.size()-1; i > 0; i--) {
				swap(list, i , 0);
				siftDown(list, 0, i);
			}
			
		}
	}
	
	/**
	 * 
	 * @param list
	 * @param siftIndex
	 * @param lastIndex
	 */
	public static <T extends Comparable<T>> void siftDown(ISimpleList<T> list, int siftIndex, int lastIndex) {
		//while siftindex is in a higher level than our lastindex, do this:
		while (siftIndex <= (lastIndex /2) -1) {
			
			//initializing a childindex, next were going to check if theres a left or right child
			int childIndex = ((siftIndex+1)*2) -1;
			//checking for rightchild
			if (childIndex +1 <= lastIndex+1) {

				//checking value of rightChild
				//if its bigger than the leftchild than were taking the rightchild
				if (list.get(childIndex).compareTo(list.get(childIndex+1)) < 0) {
					childIndex++;
				}
				
				
			}
			//continue
			//checking if we need to swap the parent with the child
			if (list.get(siftIndex).compareTo(list.get(childIndex)) <  0) {
				swap(list, siftIndex ,childIndex );
			}else {
				
			//if we dont need to swap then we hit the lowest level and were done
				break;
			}
			
		}
		
	}
	//swap method for verbosity
	public static <T extends Comparable<T>> void swap(ISimpleList<T> list, int swapA, int swapB){
		
		list.swap(swapA, swapB);
		
	}
	
	
	public static <T extends Comparable<T>> void generateMaxHeap(ISimpleList<T> maxHeapList){
		
		//iteration over the whole array
		//the other half of the array is the "last level" of the heap
		for (int i = maxHeapList.size()/2; i > 0; i--) {
			siftDown(maxHeapList, i, maxHeapList.size());
		}
		
	}
}
