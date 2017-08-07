package lesson8.demo.mystringlist;

import java.util.*;

//Final solution in labsolns folder
//No need to implement Iterable manually if instead
//you extend AbstractList
public class MyStringList implements Iterable<String> {
	private final int INITIAL_LENGTH = 4;
	private String[] strArray;
	private int size;

	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}

	public void add(String s) {
		if (size == strArray.length)
			resize();
		strArray[size++] = s;
	}

	public String get(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		return strArray[i];
	}

	public boolean find(String s) {
		for (String test : strArray) {
			if (test.equals(s))
				return true;
		}
		return false;
	}

	public void insert(String s, int pos) {
		if (pos > size)
			return;
		if (pos >= strArray.length || size + 1 > strArray.length) {
			resize();
		}
		String[] temp = new String[strArray.length + 1];
		System.arraycopy(strArray, 0, temp, 0, pos);
		temp[pos] = s;

		System.arraycopy(strArray, pos, temp, pos + 1, strArray.length - pos);
		strArray = temp;
		++size;

	}

	public boolean remove(String s) {
		if (size == 0)
			return false;
		int index = -1;
		for (int i = 0; i < size; ++i) {
			if (strArray[i].equals(s)) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return false;
		String[] temp = new String[strArray.length];
		System.arraycopy(strArray, 0, temp, 0, index);
		System.arraycopy(strArray, index + 1, temp, index, strArray.length
				- (index + 1));
		strArray = temp;
		--size;
		return true;
	}

	private void resize() {
		System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2 * len;
		String[] temp = new String[newlen];
		System.arraycopy(strArray, 0, temp, 0, len);
		strArray = temp;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(strArray[i] + ", ");
		}
		sb.append(strArray[size - 1] + "]");
		return sb.toString();
	}

	public int size() {
		return size;
	}

	//not yet implemented
	public void sort() {
		if (strArray == null || size <= 1)
			return;

		int temp = 0;
		for (int i = 0; i < size; ++i) {
			// int nextMinPos = minpos(i,size-1);
			// swap(i,nextMinPos);
		}

	}

	// implement
	public Iterator<String> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<String> {

		private int position;

		MyIterator() {
			position = 0;
		}

		public boolean hasNext() {
			return (position < size);
		}

		public String next() throws IndexOutOfBoundsException {
			if (!hasNext())
				throw new IndexOutOfBoundsException();
			return strArray[position++];
		}

		@SuppressWarnings("unused")
		public void reset() {
			position = 0;
		}

		/** optional -- not necessary to implement */
		public void remove() {
			// not implemented

		}

	}

	public static void main(String[] args) {
		// examples of compareTo for String class
		System.out.println("abc".compareTo("efg"));
		System.out.println("abc".compareTo("aaa"));
		System.out.println("abc".compareTo("abc"));
		System.out.println("abc".compareTo("ab"));

		// iterator example
		MyStringList l = new MyStringList();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		Iterator<String> iterator = l.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
		//for each style
		for(String str : l) {
			System.out.println(str.toString());
		}
		
		//using java 8 forEach method with MyStringList
		l.forEach(name -> System.out.println(name));
	}
}
