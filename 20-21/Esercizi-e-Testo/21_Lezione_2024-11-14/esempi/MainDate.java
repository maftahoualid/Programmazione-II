package it.univr;

import java.util.Scanner;

import it.univr.dates.Date;
import it.univr.dates.IllegalDateException;
import it.univr.dates.ItalianDate;

public class MainDate {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int g = keyboard.nextInt();
		int m = keyboard.nextInt();
		int a = keyboard.nextInt();

		try {
			Date d = new ItalianDate(g, m, a);
			System.out.println("d = " + d);
		}
		catch (IllegalDateException e) {
			System.out.println("La data richiesta è inesistente!");
		}
	}

}
