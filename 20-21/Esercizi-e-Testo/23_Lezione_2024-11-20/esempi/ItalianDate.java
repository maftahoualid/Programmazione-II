package it.univr.dates;

// ItalianDate è una Date (grazie ad extends)
// conseguentemente i campi e i metodi di Date
// esistono anche in ItalianDate
public class ItalianDate extends Date {

	public ItalianDate(int day, int month, int year) {
		// chiedi a Date di inizializzare tutto con day, month e year
		super(day, month, year);
	}

	protected Date mk(int day, int month, int year) {
		return new ItalianDate(day, month, year);
	}
	
	// da usare solo per campi costanti
	private static String[] months = {
			"gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno",
			"luglio", "agosto", "settembre", "ottobre", "novembre", "dicembre"
	};

	public String toString() {
		return getDay() + " " + months[getMonth() - 1] + " " + getYear();
	}
}
