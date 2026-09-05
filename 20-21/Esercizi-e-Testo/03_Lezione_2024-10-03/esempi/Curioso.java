package it.univr;

import java.util.Scanner;

public class Curioso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ciao, quanti anni hai?");
		int years = scanner.nextInt();
		if (years < 0) {
			System.out.println("Mi sembra strano");
			System.out.println();
		}
		else if (years > 50)
			System.out.println("Ma che vecchio!");
		else
			System.out.println("Hai " + years + " anni");
	}

}
