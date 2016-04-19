package de.unistuttgart.dsass2016.ex01.p3;

import java.util.LinkedList;

/**
 * 
 * @author Wilhelm Buchmüller 3133783
 * @author Daniel Waner 3149308
 * @author Artur Frenzen 2736424
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {
	//using java.util.Linkedlist is not forbidden by assignment
	private LinkedList<T> queueList = new LinkedList<T>();
	@Override
	public void enqueue(T t) {
		//adds a new element T to the end of the queue
		queueList.addLast(t);
		
	}

	@Override
	public T dequeue() {
		//poll from java.util.LinkedList retrieves and removes the head of the list
		return queueList.poll();
	}

	@Override
	public T front() {
		//getFirst from the linkedlist
		return queueList.getFirst();
	}

	@Override
	public boolean isEmpty() {
		//nothing too special here
		return queueList.isEmpty();
		
	}
	

}
