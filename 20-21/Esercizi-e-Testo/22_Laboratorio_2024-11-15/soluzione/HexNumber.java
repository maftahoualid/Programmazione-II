package it.univr.numbers;

public class HexNumber extends AbstractNumber {

	public HexNumber(int value) {
		super(value);
	}

	protected int getBase() {
		return 16;
	}

	// 0 <= digit < getBase()
	protected char getCharForDigit(int digit) {
		return "0123456789abcdef".charAt(digit);
	}
}
