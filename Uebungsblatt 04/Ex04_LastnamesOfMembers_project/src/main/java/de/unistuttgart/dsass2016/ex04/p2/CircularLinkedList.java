package de.unistuttgart.dsass2016.ex04.p2;

public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {

	private ILinkedListNode<T> head = new LinkedListNode<T>();

	// do we need this ?
	@SuppressWarnings("unused")
	private ILinkedListNode<T> last = new LinkedListNode<T>();

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
			
			//getting the last element in the list
			ILinkedListNode<T> last = head;
			while (last.getNext() != head) {
				last = last.getNext();
			}
			//setting the last item in the circle list
			last.setNext(temp);
			size++;
		}

	}

	@Override
	public T get(int index) {
		// TODO implement
		return null;
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
