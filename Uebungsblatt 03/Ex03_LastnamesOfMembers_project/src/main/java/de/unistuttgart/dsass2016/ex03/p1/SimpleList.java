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
		final SimpleList<T> list = this;
		return new Iterator<T>() {

			int index = 0;

			@Override
			public boolean hasNext() {
				return index < list.size() && list.get(index) != null;
			}

			@Override
			public T next() {
				T temp = list.get(index++);
				return temp;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}

	@Override
	public Iterator<T> skippingIterator(final int n) {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < list.size() + n-1 && list.get(index + n-1) != null;
			}

			@Override
			public T next() {

				return list.get(index + n-1);
			}

		};
	}

	public static void main(String[] args) {
		SimpleList<String> list = new SimpleList<String>();
		list.append("aylmao");
		list.append("1aylmao");
		list.append("2aylmao");
		list.append("3aylmao");
		list.append("4aylmao");
		list.append("5aylmao");
		list.append("6aylmao");

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
//		Iterator<String> iter2 = list.skippingIterator(2);
//		while(iter2.hasNext()){
//			System.out.println(iter2.next());
//		}
	}

}
