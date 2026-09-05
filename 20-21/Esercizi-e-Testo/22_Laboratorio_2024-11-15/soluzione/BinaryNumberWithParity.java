package it.univr.numbers;

public class BinaryNumberWithParity extends BinaryNumber {

	public BinaryNumberWithParity(int value) {
		super(value);
	}

	public String toString() {
		String binary = super.toString();
		return binary + countOnes(binary) % 2;
	}

	// conta quanti caratteri '1' ci sono in s
	private int countOnes(String s) {
		int counter = 0;
		for (int pos = 0; pos < s.length(); pos++)
			if (s.charAt(pos) == '1')
				counter++;

		return counter;
	}
}
