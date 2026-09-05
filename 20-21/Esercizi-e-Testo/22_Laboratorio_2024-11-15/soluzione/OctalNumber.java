package it.univr.numbers;

public class OctalNumber extends AbstractNumber {

	public OctalNumber(int value) {
		super(value);
	}

	protected int getBase() {
		return 8;
	}

	// 0 <= digit < getBase()
	protected char getCharForDigit(int digit) {
		return "01234567".charAt(digit);
	}
}
