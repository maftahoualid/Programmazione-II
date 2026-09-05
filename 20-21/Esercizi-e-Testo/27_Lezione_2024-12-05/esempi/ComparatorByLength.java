package it.univr.collections;

import java.util.Comparator;

public class ComparatorByLength implements Comparator<String> {

	public int compare(String x, String y) {
		return x.length() - y.length();
	}
}
