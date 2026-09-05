package it.univr;

import java.util.Scanner;

public class Hexadecimal {

	public static void main(String[] args) {
		int n;
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.print("n: ");
			n = keyboard.nextInt(); // se negativo devo richiederlo
		}
		while (n < 0);

		// traduco n in esadecimale dentro result
		String result = "";
		do {
			if (n <= 9)
				result = n % 16 + result;
			else
				result = (char) ('a' + (n % 16 - 10)) + result;

			n /= 16;
		}
		while (n > 0);

		System.out.println(result);
	}
}
