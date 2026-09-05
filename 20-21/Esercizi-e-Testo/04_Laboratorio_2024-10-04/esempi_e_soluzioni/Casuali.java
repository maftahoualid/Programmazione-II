package it.univr;

import java.util.Random;

public class Casuali {

	public static void main(String[] args) {
		Random random = new Random();

		for (int i = 0; i < 100; i++) {
			int x = random.nextInt();
			double radice = Math.sqrt(x);
			//System.out.println("x = " + x + ", sqrt(" + x + ") = " + radice);
			String riga = String.format("x = %d, sqrt(%d) = %.2f\n", x, x, radice);
			System.out.println(riga);
		}
	}
}
