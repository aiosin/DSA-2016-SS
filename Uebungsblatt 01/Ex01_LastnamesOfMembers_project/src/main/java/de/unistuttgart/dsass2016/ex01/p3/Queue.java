package de.unistuttgart.dsass2016.ex01.p3;

import java.util.LinkedList;

//TODO: dont fuck up martikelnummern
/**
 * 
 * @author zython5
 *
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {
	//using linkedlist is not forbidden by assignment
	private LinkedList<T> queueList = new LinkedList<T>();
	@Override
	public void enqueue(T t) {
		queueList.addLast(t);
		
	}

	@Override
	public T dequeue() {
		return queueList.poll();
	}

	@Override
	public T front() {
		return queueList.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return queueList.isEmpty();
		
	}
	

}
