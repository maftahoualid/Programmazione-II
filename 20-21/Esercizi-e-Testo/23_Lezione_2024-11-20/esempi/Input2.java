package it.input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Input2 {

	public static void main(String[] args) throws FileNotFoundException {
		// try with resource: keyboard viene SEMPRE chiuso alla fine
		try (Scanner keyboard = new Scanner(new FileReader("file.txt"))) { // java.io.FileNotFoundException
			int x = keyboard.nextInt(); // java.util.InputMismatchException
			int y = keyboard.nextInt();
			System.out.println("Hai inserito " + x + " e " + y);
		}
	}

}
