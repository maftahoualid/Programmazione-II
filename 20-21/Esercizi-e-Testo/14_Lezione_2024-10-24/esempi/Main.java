package it.univr;

public class Main {

	public static void main(String[] args) {
		ItalianDateAndTime d1 = new ItalianDateAndTime(17, 48, 30, 24, 10, 2024);
		ItalianDateAndTime d2 = new ItalianDateAndTime(17, 48, 31, 24, 10, 2024);
		ItalianDateAndTime d3 = new ItalianDateAndTime(17, 48, 30, 24, 10, 2024);
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
	}
	
	private static void print(Date date) {
		System.out.println(date.toString() + ": " + date.getSeason());
	}
}
