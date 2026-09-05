package it.univr.numbers;

public class Base58Number extends AbstractNumber {

	public Base58Number(int value) {
		super(value);
	}

	protected int getBase() {
		return 58;
	}

	// 0 <= digit < getBase()
	protected char getCharForDigit(int digit) {
		return "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".charAt(digit);
	}
}
