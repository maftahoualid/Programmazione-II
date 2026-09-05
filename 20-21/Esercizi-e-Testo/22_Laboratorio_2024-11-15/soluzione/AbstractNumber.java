package it.univr.numbers;

public abstract class AbstractNumber implements Number {
	private final int value;

	protected AbstractNumber(int value) {
		// se value è negativo, esegue throw new IllegalArgumentException(); altrimenti inizializza il campo value
		if (value < 0)
			throw new IllegalArgumentException();

		this.value = value;
	}

	// restituisce il valore di questo numero
	public final int getValue() {
		return value;
	}

	// restituice la base di numerazione di questo numero
	protected abstract int getBase();

	// restituisce il carattere che rappresenta la cifra "digit" nella base di numerazione
	// di questo numero. Sarà sempre vero che 0 <= digit < getBase();
	// per esempio, in base sedici si avrà getCharForDigit(10) == 'A' e
	// in base otto si avrà getCharForDigit(7) == '7'
	protected abstract char getCharForDigit(int digit);

	// restituisce una stringa che rappresenta il numero nella sua base di numerazione
	public String toString() {
		int base = getBase();
		String result = "";
		int v = value;
		// divide v ripetutamente per base fino ad arrivare a 0
		// ogni volta prende v % base ed usa getCharForDigit()
		// per trasformarlo in char, che concatena a result
		do {
			result = getCharForDigit(v % base) + result;
			v /= base;
		}
		while (v > 0);

		return result;
	}

	public final boolean equals(Object other) {
		// due numeri sono uguali se e solo se hanno lo stesso valore
		return other instanceof Number otherAsNumber &&
				value == otherAsNumber.getValue();
	}

	public final int compareTo(Number other) {
		// l'ordinamento fra i Number è quello crescente per valore
		return value - other.getValue();
	}
}