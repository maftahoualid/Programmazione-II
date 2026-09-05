package it.univr.collections;

import java.util.PriorityQueue;
import java.util.Queue;

import it.univr.dates.AmericanDate;
import it.univr.dates.AustralianDate;
import it.univr.dates.Date;
import it.univr.dates.ItalianDate;

public class MainPriorityQueue2 {

	public static void main(String[] args) {
		Queue<Date> q1 = new PriorityQueue<Date>();
		q1.add(new ItalianDate(4, 12, 2024));
		q1.add(new ItalianDate(3, 12, 2024));
		q1.add(new AmericanDate(12, 1, 2025));
		q1.add(new AustralianDate(29, 2, 2020));
		Date d;
		while ((d = q1.poll()) != null)
			System.out.println(d);
	}

}
