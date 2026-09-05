package it.univr;

import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		int n;
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.print("n: ");
			n = keyboard.nextInt(); // se negativo devo richiederlo
		}
		while (n < 0);

		// traduco n in binario dentro result
		String result = "";
		do {
			result = n % 2 + result;
			n /= 2;
		}
		while (n > 0);

		System.out.println(result);
	}
}
