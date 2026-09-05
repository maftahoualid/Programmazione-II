package it.univr.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	public static void main(String[] args) {
		Map<String, String> dict = new HashMap<String, String>();
		dict.put("gatto", "cat");
		dict.put("cane", "dog");
		dict.put("casa", "house");
		dict.put("farfalla", "butterfly");
		
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.print("Parola da tradurre: ");
			String it = keyboard.next();
			String uk = dict.get(it);
			if (uk != null)
				System.out.println("L'italiano " + it + " si traduce come " + uk);
			else
				System.out.println("La parola " + it + " non sta nel dizionario");
		}

	}

}
