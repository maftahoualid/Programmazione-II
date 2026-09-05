package it.univr;

public class MainInheritance {

	public static void main(String[] args) {
		ItalianDate d1 = new ItalianDate(17, 10, 2024);
		Date d2 = new ItalianDate(13, 1, 2025);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1.compareTo(d2));
		AmericanDate d3 = new AmericanDate(17, 10, 2024);
		System.out.println(d3);
		System.out.println(d1.equals(d3));
	}
}
