package it.oop.core;

public class AmericanDate extends Date {

    private static final String FORMAT = "mm/dd/yyyy";
    private static final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public AmericanDate(int day, int month, int year) {
        super(day, month, year);
    }

    public String getMonthAsString() {
        return MONTHS[getMonth()-1];
    }
    public String printFormat() {
        return FORMAT;
    }
    public String prettyPrint() {
        return getMonthAsString() + " " + day + ", " + getYear();
    }
    @Override
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
}
