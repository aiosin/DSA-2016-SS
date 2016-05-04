package de.unistuttgart.dsass2016.ex03.p1;

import java.util.*;

public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

	/**
	 * @author Wilhelm Buchmüller 3133783
	 * @author Daniel Waner 3149308
	 * @author Artur Frenzen 2736424
	 */

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
		final SimpleList<T> normieList = this;
		return new Iterator<T>() {

			int index = 0;

			@Override
			public boolean hasNext() {
				return index < normieList.size() && normieList.get(index) != null;
			}

			@Override
			public T next() {
				return normieList.get(index++);
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}

	@Override
	public Iterator<T> skippingIterator(final int n) {
		final SimpleList<T> skipperList = this;
		return new Iterator<T>() {
			int index = 0;

			// int skiperator = index + n;
			@Override
			public boolean hasNext() {

				return index < skipperList.size() && skipperList.get(index) != null;
			}

			@Override
			public T next() {

				try {
					T temp = list.get(index);
					index += n;
					return temp;
				} catch (Exception e) {
					System.out.println("End of ArrayList at idx: " + index);
				}
				return null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

}
