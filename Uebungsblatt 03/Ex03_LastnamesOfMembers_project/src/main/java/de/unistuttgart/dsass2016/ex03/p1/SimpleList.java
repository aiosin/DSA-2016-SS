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
		// TODO REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE WHY NOT WORK REEEEEEEEEEEEEE
		return new Iterator<T>() {

			int index = 0;

			@Override
			public boolean hasNext() {
				return index < list.size() && list.get(index) != null;
			}

			@Override
			public T next() {
				T temp = list.get(index++);
				index++;
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
				return index < list.size() + n && list.get(index + n) != null;
			}

			@Override
			public T next() {

				return list.get(index + n);
			}

		};
	}


}
