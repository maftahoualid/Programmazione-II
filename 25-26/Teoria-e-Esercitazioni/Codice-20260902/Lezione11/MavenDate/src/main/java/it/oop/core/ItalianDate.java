package it.oop.core;

public class ItalianDate extends Date {

    private static final String FORMAT = "dd/mm/yyyy";
    private static final String[] MONTHS = { "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "setembre", "ottobre", "novembre", "dicembre" };

    public ItalianDate(int day, int month, int year) {
        super(day, month, year);
    }

    public String getMonthAsString() {
        return MONTHS[getMonth()-1];
    }
    public String printFormat() {
        return FORMAT;
    }
    public String prettyPrint() {
        return day + " " + getMonthAsString() + " " + getYear();
    }
    @Override
    public String toString() {
        return day + "/" + getMonth() + "/" + getYear();
    }
}
