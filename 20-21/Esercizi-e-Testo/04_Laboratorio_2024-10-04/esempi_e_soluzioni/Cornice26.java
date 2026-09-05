package it.univr;

import java.util.Scanner;

public class Cornice26 {

	public static void main(String[] args) {
		int n = 10;

		for (char c = 'a'; c <= 'z'; c++) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (x == 0 || x == n - 1 || y == 0 || y == n - 1)
						System.out.print(c);
					else
						System.out.print(' ');
				}
				System.out.println();
			}
		}
	}
}