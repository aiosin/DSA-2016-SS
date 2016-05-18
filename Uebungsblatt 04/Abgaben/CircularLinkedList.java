package de.unistuttgart.dsass2016.ex04.p2;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {

	private ILinkedListNode<T> head = new LinkedListNode<T>();

	private int size = 0;
	
	@Override
	public void append(T element) {
		if (size == 0) {
			
			head.setElement(element);
			//Because head is only element:
			head.setNext(head);
			head.setPrev(head);
			size++;
			
		} else {
			
			//Instantiating new node
			ILinkedListNode<T> temp = new LinkedListNode<T>();
			//Saving data in node
			temp.setElement(element);

			//Getting tail element, its one back from head
			ILinkedListNode<T> tail = head.getPrev();
			
			//Appending to tail
			tail.setNext(temp);
			
			//Changing previous node to new tail
			head.setPrev(temp);
			
			//New tails previous is old tail
			temp.setPrev(tail);
			
			//New tails next is head
			temp.setNext(head);


			size++;
		}

	}

	@Override
	public T get(int index) {
		//Creating temporary node:
		ILinkedListNode<T> temp = null;
		
		if (index == 0) {
			return head.getElement();
		} else if (index < 0) {
			index = Math.abs(index);
			temp = head;
			for(int i = 0; i < index; i++)
			{
				temp = temp.getPrev();
			}
			return temp.getElement();
		} else if (index > 0) {
			temp = head;
			for(int i = 0; i < index; i++)
			{
				temp = temp.getNext();
			}
			return temp.getElement();
		} else return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedListNode<T> /* höhöhöhö => */ getHead() {
		return head;
	}

}
