package de.unistuttgart.dsass2016.ex03.p1;

import java.util.*;


public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {
	
	/** Do not modify the existing methods and signatures */
	private final List<T> list;
	
	public SimpleList() {
		list = new ArrayList<T>();
	}
	
	@Override
	public void append(T element) {
		list.add(element);
	}
	
	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public T get(int index) {
		return list.get(index);
	}
	
	@Override
	public void swap(int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

	@Override
	public Iterator<T> iterator() {
		
		return new SimpleListIterator<T>();

	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		//TODO skipping iterator
		return null;
	}
	
	@SuppressWarnings("hiding")
	class SimpleListIterator<T> implements Iterator<T>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	@SuppressWarnings("hiding")
	class SimpleListSkippingIterator<T> implements Iterator<T>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
