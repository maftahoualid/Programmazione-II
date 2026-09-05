package it.univr;

import java.util.Scanner;

public class Cornice {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserisci n: ");
		int n = scanner.nextInt();
		char c = '@';
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++)
				if (x == 0 || x == n - 1 || y == 0 || y == n - 1)
					System.out.print(c);
				else
					System.out.print(" ");

			System.out.println();
		}
	}
}
