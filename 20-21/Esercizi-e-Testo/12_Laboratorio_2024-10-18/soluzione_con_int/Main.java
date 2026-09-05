package it.univr.cards;

public class Main {

	public static void main(String[] args) {
		Card card1 = new Card();
		Card card2;
		
		do {
			card2 = new Card();
			System.out.println(card1 + " vs " + card2);
		}
		while (!card1.equals(card2));
	}
}