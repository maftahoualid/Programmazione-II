package it.oop.core;

/**
 * A class representing italian dates.
 * The class extends {@link FormattedDate}.
 */
public class ItalianDate extends FormattedDate {

    private static final String[] MONTHS_IT = { "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "setembre", "ottobre", "novembre", "dicembre" };

    public ItalianDate(int day, int month, int year) {
        super(day, month, year, "dd/mm/yyyy", MONTHS_IT);
    }

    @Override
    public String prettyPrint() {
        return day + " " + getMonthAsString() + " " + getYear();
    }

    @Override
    public String toString() {
        return day + "/" + getMonth() + "/" + getYear();
    }
}
