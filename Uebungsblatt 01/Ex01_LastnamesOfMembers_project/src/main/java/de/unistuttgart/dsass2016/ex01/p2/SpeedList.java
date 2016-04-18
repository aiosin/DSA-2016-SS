package de.unistuttgart.dsass2016.ex01.p2;

import java.util.*;

public class SpeedList<T> implements ISpeedList<T>, Iterable<T> {

	private int speedListSize;
	//add head 
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
	
	
	//TODO: Node finished
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
		// TODO Auto-generated method stub
		return null;
	}

}
