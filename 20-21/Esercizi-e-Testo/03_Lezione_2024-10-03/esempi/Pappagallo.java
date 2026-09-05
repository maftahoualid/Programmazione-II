package it.univr;

import java.util.Scanner;

public class Pappagallo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ciao, come ti chiami?");
		String name = scanner.nextLine();
		System.out.println("Ciao " + name + ", piacere di conoscerti!");
		name = name.toUpperCase();
		System.out.println("Ciao " + name + ", piacere di conoscerti!");
		if (name.equals("ERMENEGILDO"))
			System.out.println("E' un nome bellissimo");
	}

}
