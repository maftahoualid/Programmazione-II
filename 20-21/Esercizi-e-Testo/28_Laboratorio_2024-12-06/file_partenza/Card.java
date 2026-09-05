package it.univr.cards;

import java.util.Random;

public class Card {

	/**
	 * Il valore della carta.
	 */
	private final Value value;

	/**
	 * Il seme della carta.
	 */
	private final Suit suit;

	/**
	 * Genera una carta a caso con un valore da min (incluso) in su.
	 * 
	 * @param min il valore minimo della carta che può essere generata
	 */
	public Card(Value min) {
		Random random = new Random();
		value = Value.values()[min.ordinal() + random.nextInt(13 - min.ordinal())];
		suit = Suit.values()[random.nextInt(4)];
	}

	/**
	 * Genera una carta a caso con un valore da 0 (incluso) in su.
	 */
	public Card() {
		this(Value._2);
	}

	public Value getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	/**
	 * Ritorna una descrizione della carta sotto forma di stringa, del tipo 10♠ oppure J♥.
	 */
	public String toString() {
		String valueAsString = value == Value._10 ? "10" : String.valueOf("23456789?JQK1".charAt(value.ordinal()));
		char suitAsCharacter = "♠♣♦♥".charAt(suit.ordinal());
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