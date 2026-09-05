package it.univr.lists;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			List<String> l1 = new List<String>("hello", "how", "are", "you?");
			System.out.println(l1 + " di lunghezza " + l1.length());
			l1.dump("l1.txt");
			IntList l2 = new IntList(11, 13, 42, 9, -5, 17, 13);
			System.out.println(l2 + " di lunghezza " + l2.length());
			l2.dump("l2.txt");
			IntList l3 = IntList.readFrom("l2.txt");
			System.out.println(l3 + " di lunghezza " + l3.length());
			IntList.readFrom("l1.txt"); // fallisce perché l1.txt contiene stringhe, non interi
		}
		catch (IOException e) {
			System.out.println("Errore di I/O");
		}
	}
}