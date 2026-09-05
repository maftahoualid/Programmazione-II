package it.univr.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyTextFile {

	public static void main(String[] args) {
		try (Reader reader = new BufferedReader(new FileReader("commedia.txt"));
			 Writer writer = new BufferedWriter(new FileWriter("copia.txt"))) {

			int c;
			while ((c = reader.read()) != -1)
				writer.write(c);
		}
		catch (FileNotFoundException e) {
			System.out.println("Non trovo il file da leggere");
		}
		catch (IOException e) {
			System.out.println("I/O error");
		}
	}

}
