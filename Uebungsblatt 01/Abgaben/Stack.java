package de.unistuttgart.dsass2016.ex01.p3;

import java.util.LinkedList;

/**
 * @author Wilhelm Buchmüller 3133783
 * @author Daniel Waner 3149308
 * @author Artur Frenzen 2736424
*/

public class Stack<T> implements IStack<T> {
	//usage of java.util.LinkedList ist not illegal by assignment
	private LinkedList <T> stackList = new LinkedList<T>();
	@Override
	public void push(T t) {
		stackList.addFirst(t);
	}

	@Override
	public T pop() {
		return stackList.removeFirst();
	}

	@Override
	public T top() {
		return stackList.getFirst();
	}
	

	@Override
	public boolean isEmpty() {
		return stackList.isEmpty();
	}
	

}
