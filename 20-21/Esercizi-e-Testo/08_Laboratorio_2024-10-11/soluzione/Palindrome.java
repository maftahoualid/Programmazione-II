package it.univr;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String s = keyboard.nextLine();

		boolean result = true;
		for (int sx = 0, dx = s.length() - 1; sx < dx && result; sx++, dx--)
			if (s.charAt(sx) != s.charAt(dx))
				result = false;

		if (result)
			System.out.println(s + " è palindroma");
		else
			System.out.println(s + " non è palindroma");
	}
}
