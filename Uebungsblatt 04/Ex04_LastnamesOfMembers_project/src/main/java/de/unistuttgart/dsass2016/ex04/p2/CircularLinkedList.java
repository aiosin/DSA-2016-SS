package de.unistuttgart.dsass2016.ex04.p2;

public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {

	private ILinkedListNode<T> head = new LinkedListNode<T>();

	private int size;

	@Override
	public void append(T element) {
		if (size == 0) {
			ILinkedListNode<T> temp = new LinkedListNode<T>();

			temp.setElement(element);
			temp.setPrev(temp);
			temp.setNext(temp);

			head.setNext(temp);

			size++;
		} else {
			// instatiating a new node
			ILinkedListNode<T> temp = new LinkedListNode<T>();
			// giving the node the data
			temp.setElement(element);

			// making the circle go round
			temp.setNext(head.getNext());

			// getting the last element in the list
			ILinkedListNode<T> last = head;
			while (last.getNext() != head) {
				last = last.getNext();
			}
			// setting the last item in the circle list
			last.setNext(temp);
			temp.setPrev(last);

			size++;
		}

	}

	@Override
	public T get(int index) {
		//creating dummy node
		ILinkedListNode<T> dummy = new LinkedListNode<T>();
		
		// decide in which way we'll go
		if (index <= 0) {
			//ASCENDING
			dummy = head;
			for (int i = 0; i < index; i++) {
				dummy = dummy.getNext();
			}
		
		} else {
			//getting last element of the list
			dummy = head.getNext().getPrev();
			
			//DESCENDING
			index = Math.abs(index);
			for (int i = 0; i < index; i++) {
				dummy = dummy.getPrev();
			}
		}
		return dummy.getElement();
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
