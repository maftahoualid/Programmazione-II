package it.univr.collections;

import java.util.HashSet;
import java.util.Set;

import it.univr.dates.AmericanDate;
import it.univr.dates.AustralianDateAndTime;
import it.univr.dates.Date;
import it.univr.dates.ItalianDate;
import it.univr.dates.Season;

public class MainHashSetModification {

	public static void main(String[] args) {
		Set<Date> s = new HashSet<Date>();
		Date d1 = new ItalianDate(5, 12, 2024);
		Date d2 = new ItalianDate(25, 12, 2024);
		Date d3 = new AmericanDate(29, 2, 2028);
		Date d5 = new AustralianDateAndTime(20, 10, 18, 7, 1, 2025);
		s.add(d1);
		s.add(d2);
		s.add(d3);
		s.add(d5);
		Set<Date> copy = new HashSet<Date>(s);
		for (Date d: copy)
			if (d.getSeason() == Season.AUTUMN)
				s.remove(d);
		
		System.out.println(s);
		
	}

}
