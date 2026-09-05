package it.univr.cards;

import java.util.Random;

public class Card {

	/**
	 * Il valore della carta.
	 */
	private final int value;

	/**
	 * Il seme della carta.
	 */
	private final int suit;

	/**
	 * Genera una carta a caso con un valore da min (incluso) in su.
	 * 
	 * @param min il valore minimo (0-12) della carta che può essere generata
	 */
	public Card(int min) {
		Random random = new Random();
		value = min + random.nextInt(13 - min); // random.nextInt(min, 13)
		suit = random.nextInt(4);
	}

	/**
	 * Genera una carta a caso con un valore da 0 (incluso) in su.
	 */
	public Card() {
		this(0);
	}

	public int getValue() {
		return value;
	}

	public int getSuit() {
		return suit;
	}

	/**
	 * Ritorna una descrizione della carta sotto forma di stringa, del tipo 10♠ oppure J♥.
	 */
	public String toString() {
		String valueAsString = value == 8 ? "10" : String.valueOf("23456789?JQK1".charAt(value));
		char suitAsCharacter = "♠♣♦♥".charAt(suit);
		return valueAsString + suitAsCharacter;
	}

	/**
	 * Determina se questa carta è uguale ad other.
	 * 
	 * @param other l'altra carta con cui confrontarsi
	 * @return true se e solo se le due carte sono uguali
	 */
	public boolean equals(Card other) {
		return value == other.value && suit == other.suit;
	}
}