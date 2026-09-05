package it.univr.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MainTreeSet3 {

	public static void main(String[] args) {
		Comparator<String> comparator = new ComparatorByLength();
		Set<String> s = new TreeSet<String>(comparator);
		s.add("buongiorno");
		s.add("hello");
		s.add("bella giornata!");
		s.add("bonjour");
		s.add("hello"); // non lo riaggiunge
		System.out.println(s);
	}

}
