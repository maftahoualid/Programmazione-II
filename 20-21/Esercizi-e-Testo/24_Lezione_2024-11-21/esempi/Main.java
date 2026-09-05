package it.univr.dates;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Date d1 = new ItalianDate(21, 11, 2024);
		d1.dumpAsText("d1.txt");
		Date d2 = new ItalianDateAndTime(17, 16, 20, 21, 11, 2024);
		d2.dumpAsText("d2.txt");
		try (Scanner scanner = new Scanner(new FileReader("d1.txt"))) {
			Date d1_copy = new ItalianDate(scanner);
			System.out.println(d1_copy);
		}
		try (Scanner scanner = new Scanner(new FileReader("d2.txt"))) {
			Date d2_copy = new ItalianDateAndTime(scanner);
			System.out.println(d2_copy);
		}
	}
}
