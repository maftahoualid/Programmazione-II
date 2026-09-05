package it.univr.numbers;

import java.util.Arrays;

public class MainNumbersSort {

	public static void main(String[] args) {
		Number[] arr = {
			new DecimalNumber(2024),
			new BinaryNumber(113),
			new BinaryNumberWithParity(158),
			new OctalNumber(827),
			new HexNumber(2066),
			new Base58Number(8092)
		};

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
