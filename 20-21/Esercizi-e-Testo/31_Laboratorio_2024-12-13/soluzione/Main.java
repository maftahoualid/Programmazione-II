package it.univr.library;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Book jj = new PaperBook("The joy of Java", "John Stack", 2018, Genre.COMPUTING, 557);
		Book cr = new AudioBook("Cappuccetto rosso", "Charles Perrault", 1697, Genre.FICTION, 13);
		Book ps = new AudioBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 1223);
		Book ps2 = new PaperBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 622);
		Book gl = new PaperBook("Sentieri in Lessinia", "Giovanni Gamba", 2015, Genre.GUIDE, 233);
		Book sv = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);
		Book sv2 = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);

		System.out.println("Ordinamento naturale:");
		// TODO: crea e poi stampa un catalogo con statistiche che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// secondo il compareTo fra i libri
		Catalog cat1 = new CatalogWithStatistics(jj, cr, ps, ps2, gl, sv, sv2);
		System.out.println(cat1);

		System.out.println("Ordinamento per autore:");
		// TODO: crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// per autore e, a parita' di autore, secondo il compareTo fra i libri
		Comparator<Book> byAuthor = (book1, book2) -> {
				int diff = book1.getAuthor().compareTo(book2.getAuthor());
				if (diff != 0)
					return diff;
				else
					return book1.compareTo(book2);
			};

		Catalog cat2 = new Catalog(byAuthor, jj, cr, ps, ps2, gl, sv, sv2);
		System.out.println(cat2);

		System.out.println("Ordinamento per anno di pubblicazione:");
		// TODO: crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// per anno e, a parita' di anno, secondo il compareTo fra i libri
		Comparator<Book> byYear = new Comparator<Book>() {
			public int compare(Book book1, Book book2) {
				int diff = book1.getYear() - book2.getYear();
				if (diff != 0)
					return diff;
				else
					return book1.compareTo(book2);
			}
		};

		Catalog cat3 = new Catalog(byYear, jj, cr, ps, ps2, gl, sv, sv2);
		System.out.println(cat3);

		try {
			new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, -380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		try {
			new PaperBook("Gli Scala di Verona", null, 2012, Genre.HISTORY, 380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}
	}
	
	private static class ByYear implements Comparator<Book> {

		public int compare(Book book1, Book book2) {
			int diff = book1.getYear() - book2.getYear();
			if (diff != 0)
				return diff;
			else
				return book1.compareTo(book2);
		}
	}

	private static class ByAuthor implements Comparator<Book> {

		public int compare(Book book1, Book book2) {
			int diff = book1.getAuthor().compareTo(book2.getAuthor());
			if (diff != 0)
				return diff;
			else
				return book1.compareTo(book2);
		}
	}
}
