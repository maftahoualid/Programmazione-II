package it.univr.lambdas;

import java.util.ArrayList;
import java.util.List;

public class MainLists {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("ciao");
		l.add("Fausto");
		l.add("come va?");
		l.add("oggi?");
		System.out.println(l);
		l.replaceAll(s -> s.toUpperCase());
		System.out.println(l);
		l.replaceAll(s -> s.substring(0, 2));
		System.out.println(l);
		l.forEach(s -> System.out.println(s + ": " + s.length()));
	}
}
