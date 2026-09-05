package it.univr;

import java.util.Random;

import it.univr.dates.AmericanDate;
import it.univr.dates.Date;
import it.univr.dates.ItalianDate;
import it.univr.dates.ItalianDateAndTime;

public class MainClass {

	public static void main(String[] args) {
		Date d;
		Random random = new Random();
		switch (random.nextInt(4)) {
		case 0: d = new ItalianDate(14, 11, 2024); break;
		case 1: d = new AmericanDate(14, 11, 2024); break;
		case 2: d = new ItalianDate(15, 11, 2024); break;
		default: d = new ItalianDateAndTime(14, 16, 00, 14, 11, 2024);
		}

		System.out.println(d);
		ItalianDate d2 = (ItalianDate) d;
		System.out.println(d2);
	}
}
