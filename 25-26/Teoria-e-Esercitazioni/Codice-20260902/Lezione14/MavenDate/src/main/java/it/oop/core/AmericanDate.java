package it.oop.core;

public class AmericanDate extends FormattedDate {

    private static final String[] MONTHS_US = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public AmericanDate(int day, int month, int year) {
        super(day, month, year, "mm/dd/yyyy", MONTHS_US);
    }

    @Override
    public String prettyPrint() {
        return getMonthAsString() + " " + day + ", " + getYear();
    }

    @Override
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
}
