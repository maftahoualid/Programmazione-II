package it.univr.numbers;

public class DecimalNumber extends AbstractNumber {

	public DecimalNumber(int value) {
		super(value);
	}

	protected int getBase() {
		return 10;
	}

	// 0 <= digit < getBase()
	protected char getCharForDigit(int digit) {
		return "0123456789".charAt(digit);
	}
}
