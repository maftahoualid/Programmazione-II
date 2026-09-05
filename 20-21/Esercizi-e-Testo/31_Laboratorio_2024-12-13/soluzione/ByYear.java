package it.univr.library;

import java.util.Comparator;

public class ByYear implements Comparator<Book> {

	public int compare(Book book1, Book book2) {
		int diff = book1.getYear() - book2.getYear();
		if (diff != 0)
			return diff;
		else
			return book1.compareTo(book2);
	}
}
