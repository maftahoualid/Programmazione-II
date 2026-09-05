package it.univr.cards;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainCards {

	public static void main(String[] args) {
		Set<Card> hs = new HashSet<Card>();
		Set<Card> ts = new TreeSet<Card>();
		
		long t1 = System.currentTimeMillis();
		
		for (int i = 1; i <= 100_000_000; i++)
			hs.add(new Card());
		
		long t2 = System.currentTimeMillis();
		System.out.println("HashSet: " + (t2 - t1) + "ms");

		for (int i = 1; i <= 100_000_000; i++)
			ts.add(new Card());
		
		long t3 = System.currentTimeMillis();
		System.out.println("TreeSet: " + (t3 - t2) + "ms");

		System.out.println("hs.size() = " + hs.size());
		System.out.println("ts.size() = " + ts.size());
		System.out.println("hs.equals(ts) ? " + hs.equals(ts));
	}

}
