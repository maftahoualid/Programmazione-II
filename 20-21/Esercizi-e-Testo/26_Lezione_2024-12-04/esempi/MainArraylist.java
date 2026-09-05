package it.univr.collections;

import java.util.ArrayList;
import java.util.List;

public class MainArraylist {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("ciao");
		l1.add("come va?");
		l1.add("buongiorno");
		l1.add("ciao");
		System.out.println(l1);
		System.out.println("elemento #1: " + l1.get(1));
		for (String s: l1)
			System.out.println("  " + s);
		l1.add(2, "hello");
		System.out.println(l1);
		l1.set(2, "bonjour");
		System.out.println(l1);
		//l1.set(6, "bonjour"); // eccezione perché vado fuori dalla lista
		l1.remove("ciao");
		System.out.println(l1);
		l1.remove("ciao");
		System.out.println(l1);
		int where = l1.indexOf("bonjour");
		System.out.println("bonjour si trova in posizione "  + where);
		System.out.println("contiene buongiorno? " + l1.contains("buongiorno"));
		String s = new String("buongiorno");
		System.out.println("contiene s? " + l1.contains(s));
	}

}
