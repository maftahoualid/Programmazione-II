package it.univr.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.univr.dates.AmericanDate;
import it.univr.dates.Date;
import it.univr.dates.ItalianDate;

public class Dictionary2 {

	public static void main(String[] args) {
		Map<Date, String> dict = new HashMap<Date, String>();
		Date d1 = new ItalianDate(5, 12, 2024);
		Date d2 = new ItalianDate(6, 12, 2024);
		Date d3 = new AmericanDate(25, 12, 2024);
		Date d4 = new ItalianDate(25, 12, 2024);
		dict.put(d1, "oggi");
		dict.put(d2, "domani");
		dict.put(d3, "natale");
		dict.put(d4, "natale");
		
		System.out.println("d1 è mappato in " + dict.get(d1));
		System.out.println("d4 è mappato in " + dict.get(d4));
		Set<Date> keys = dict.keySet();
		Collection<String> values = dict.values();
		System.out.println("chiavi: " + keys);
		System.out.println("valori: " + values);
	}

}
