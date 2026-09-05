package it.univr;

import java.util.Scanner;

public class Base58 {

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
		String digits = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
		do {
			result = digits.charAt(n % 58) + result;
			n /= 58;
		}
		while (n > 0);

		System.out.println(result);
	}
}
