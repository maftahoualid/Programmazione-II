package it.univr.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyTextFile2 {

	public static void main(String[] args) {
		try (Scanner reader = new Scanner(new FileReader("commedia.txt"));
			 PrintWriter writer = new PrintWriter("copia.txt")) {

			while (reader.hasNext())
				writer.println(reader.nextLine());
		}
		catch (FileNotFoundException e) {
			System.out.println("Non trovo il file da leggere");
		}
		catch (IOException e) {
			System.out.println("I/O error");
		}
	}

}
