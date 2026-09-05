package it.univr;

import java.util.Scanner;

public class ReadString {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		boolean done = false;
		do {
			System.out.print("Inserisci una stringa: ");
			String s = keyboard.nextLine();
			System.out.println(s);

			try {
				int i = Integer.parseInt(s);
				System.out.println(i);
				done = true;
			}
			catch (NumberFormatException e) {
				System.out.println("Devi inserire una stringa traducibile in int");
			}
		}
		while (!done);
		
		System.out.println("fine");
	}

}
