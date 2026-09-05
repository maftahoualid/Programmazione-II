package it.univr.autosentences;

import java.util.Iterator;

public class Sequences implements Iterable<int[]> {
	private final int howManyIndices;
	private final int howManyValues;

	public Sequences(int howManyIndices, int howManyValues) {
		this.howManyIndices = howManyIndices;
		this.howManyValues = howManyValues;
	}

	public Iterator<int[]> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<int[]> {
		private int[] next = new int[howManyIndices];

		public boolean hasNext() {
			return next != null;
		}

		public int[] next() {
			int[] result = next.clone();
			for (int pos = 0; pos < howManyIndices; pos++) {
				next[pos] = (next[pos] + 1) % howManyValues;
				if (next[pos] != 0)
					return result;
			}

			// è finita l'iterazione
			next = null;
			return result;
		}
	}
}
