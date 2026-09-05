package it.univr;

import java.util.Random;
import java.util.Scanner;

public class Cerchio {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		long n;
		do {
			System.out.print("Inserisci n: ");
			n = keyboard.nextLong();
		}
		while (n < 0);
		
		long dentro = 0;
		Random random = new Random();
		for (long i = 0; i < n; i++) {
			double x = random.nextDouble() * 2 - 1;
			double y = random.nextDouble() * 2 - 1;
			if (x * x + y * y <= 1)
				dentro++;
		}

		System.out.println(dentro * 4.0 / n);
	}
}
