package it.univr.collections;

import java.util.HashSet;
import java.util.Set;

public class MainHashSet {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		s.add("buongiorno");
		s.add("hello");
		s.add("bella giornata!");
		s.add("bonjour");
		s.add("hello"); // non lo riaggiunge
		String x = new String("bonjour");
		s.add(x); // non lo riaggiunge
		System.out.println(s);
		System.out.println("s contiene bonjour? " + s.contains("bonjour"));
		s.remove("bonjour");
		System.out.println("s contiene bonjour? " + s.contains("bonjour"));
		System.out.println("s è grande: " + s.size());
		for (String y: s)
			System.out.println(y);
	}

}
