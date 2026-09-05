package it.univr.numbers;

import java.util.Scanner;

public class MainNumbers {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n;

		do {
			System.out.print("Inserisci n: ");
			n = keyboard.nextInt();
		}
		while (n < 0);
		
		Number n1 = new DecimalNumber(n);
		Number n2 = new BinaryNumber(n);
		Number n3 = new BinaryNumberWithParity(n);
		Number n4 = new OctalNumber(n);
		Number n5 = new HexNumber(n);
		Number n6 = new Base58Number(n);
		
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		System.out.println(n6);
	}

}
