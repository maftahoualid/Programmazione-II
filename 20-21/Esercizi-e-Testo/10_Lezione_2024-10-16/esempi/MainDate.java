package it.univr;

import java.util.Arrays;

public class MainDate {

	public static void main(String[] args) {
		Date d1;
		d1 = new Date(9, 10, 2024);
		System.out.println("d1 = " + d1.toString());
		Date xmas = new Date(25, 12, 2024);
		xmas.setAmerican();
		System.out.println("xmas = " + xmas.toString());
		System.out.println("d1 = " + d1.toString());
		Date d2 = new Date(9, 10);
		System.out.println("d2 = " + d2);
		Date xmas2 = new Date();
		System.out.println("xmas2 = " + xmas2);
		Date d3 = new Date(29, 2, 2025);
		Date d4 = new Date(-5, 4, 2023);
		System.out.println("d3 = " + d3);
		System.out.println("d4 = " + d4);
		System.out.println("d1 è uguale a d2? " + d1.equals(d2));
		System.out.println("xmas è uguale a xmas2? " + xmas.equals(xmas2));
		System.out.println("xmas è uguale a d1? " + xmas.equals(d1));
		System.out.println("d1 viene prima di xmas? " + d1.compareTo(xmas));
		System.out.println("xmas viene prima di d1? " + xmas.compareTo(d1));
		System.out.println("xmas viene prima di xmas? " + xmas.compareTo(xmas));
		System.out.println("La stagione di " + d1 + " è " + d1.getSeason());
		System.out.println("La stagione di " + xmas + " è " + xmas.getSeason());

		// creazione esplicita per enumerazione degli elementi
		Date[] dates = {
			d1, xmas, d2, d3, d4, xmas2, new Date(13, 1, 2025)
		};

		System.out.println(Arrays.toString(dates));
		//Arrays.fill(dates, new Date(6, 2, 2025));
		System.out.println(Arrays.toString(dates));
		
		// creazione vuota e successivo riempimento
		Date[] dates2 = new Date[3];
		dates2[1] = d1;
		dates2[0] = d2;
		dates2[2] = new Date(11, 3, 2025);
		System.out.println(Arrays.toString(dates2));
		//System.out.println(dates2[3]);
		System.out.println("dates è lungo " + dates.length);
		System.out.println("dates2 è lungo " + dates2.length);
		for (int pos = 0; pos < dates.length; pos++)
			System.out.println(dates[pos] + ": " + dates[pos].getSeason());
		for (Date date: dates) // for each equivalente al ciclo precedente ma compatto
			System.out.println(date + ": " + date.getSeason());
			
	}
}






