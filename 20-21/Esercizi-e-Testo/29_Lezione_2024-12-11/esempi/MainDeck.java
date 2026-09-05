package it.univr.cards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainDeck {
	public static void main(String[] args) {
		Deck deck = new Deck(5, Value._7);
		System.out.println("deck: " + deck);
		System.out.println("elementi di deck:");
		for (Card card: deck)
			System.out.println("  " + card);
		
		Card[] arr = new Card[5];
		for (int pos = 0; pos < 5; pos++)
			arr[pos] = new Card(Value._7);

		System.out.println(" arr: " + Arrays.toString(arr));
		
		System.out.println("elementi di arr:");
		for (Card card: arr)
			System.out.println("  " + card);

		Set<Card> set = new HashSet<Card>();
		for (int pos = 0; pos < 5; pos++)
			set.add(new Card(Value._7));

		System.out.println(" set: " + set);
		
		System.out.println("elementi di set:");
		for (Card card: set)
			System.out.println("  " + card);
	}
}



