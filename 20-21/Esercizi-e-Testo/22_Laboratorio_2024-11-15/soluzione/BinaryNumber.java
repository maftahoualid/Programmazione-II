package it.univr.numbers;

public class BinaryNumber extends AbstractNumber {

	public BinaryNumber(int value) {
		super(value);
	}

	protected int getBase() {
		return 2;
	}

	// 0 <= digit < getBase()
	protected char getCharForDigit(int digit) {
		if (digit == 0)
			return '0';
		else
			return '1';
	}
}
