package de.unistuttgart.dsass2016.ex04.p2;

public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T>{
	
	public LinkedListNode(){
		
	}
	//TODO: if errors occur change back to normal node not interface defined
	private T data;
	private ILinkedListNode<T> prev;
	private ILinkedListNode<T> next;
	@Override
	public T getElement() {
		
		return this.data;
	}

	@Override
	public void setElement(T element) {
		this.data = element;
		
	}

	@Override
	public ILinkedListNode<T> getNext() {
		return this.next;
	}

	@Override
	public void setNext(ILinkedListNode<T> next) {
		this.next = next;
	}

	@Override
	public ILinkedListNode<T> getPrev() {
		return this.prev;
	}

	@Override
	public void setPrev(ILinkedListNode<T> prev) {
		this.prev = prev;
		
	}


}
