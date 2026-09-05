package it.univr;

public class Cornice2 {
	
	public static void main(String[] args) {
		final int n = 10;
		for (char c = 'a'; c <= 'z'; c++)
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
