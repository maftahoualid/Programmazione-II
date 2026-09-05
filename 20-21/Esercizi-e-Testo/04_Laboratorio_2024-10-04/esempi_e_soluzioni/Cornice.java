package it.univr;

import java.util.Scanner;

public class Cornice {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int n;
		do {
			System.out.print("Inserisci n: ");
			n = keyboard.nextInt();
		}
		while (n < 0);

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (x == 0 || x == n - 1 || y == 0 || y == n - 1)
					System.out.print('@');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
	}

}
