package it.input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Input {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(new FileReader("file.txt")); // java.io.FileNotFoundException
			int x = keyboard.nextInt(); // java.util.InputMismatchException
			int y = keyboard.nextInt();
			System.out.println("Hai inserito " + x + " e " + y);
		}
		// alla fine, in ogni caso
		finally {
			// se sono riuscito ad inizializzarlo, allora lo chiudo
			if (keyboard != null)
				keyboard.close(); // chiude lo Scanner
		}
	}

}
