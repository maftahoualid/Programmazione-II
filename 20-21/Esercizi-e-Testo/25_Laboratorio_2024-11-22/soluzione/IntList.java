package it.univr.lists;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IntList extends List<Integer> {

	public IntList(Integer head, IntList tail) {
		super(head, tail);
	}

	public IntList(Integer head, Integer... elements) {
		super(head, elements);
	}

	// restituisce una lista di interi letta dal file testuale indicato;
	// in caso di errore di lettura, lancia una IOException; uno Scanner vi aiuterà
	public static IntList readFrom(String fileName) throws IOException {
		try (Scanner scanner = new Scanner(new FileReader(fileName))) {
			return readFrom(scanner);
		}
	}
	
	private static IntList readFrom(Scanner scanner) throws IOException {
		try {
			return new IntList(scanner.nextInt(),
					scanner.hasNextInt() ? readFrom(scanner) : null);
		}
		catch (NoSuchElementException e) {
			throw new IOException(e);
		}
	}





}