package it.oop.core;

/**
 * Abstract class modeling formatted dates.
 * The class extends {@link Date}.
 */
public abstract class FormattedDate extends Date {
    protected final String format;
    protected final String[] months;

    /**
     * Formatted date parameterized constructor.
     * @param day day of the date, from 1 to 31
     * @param month month of the date, from 1 to 12
     * @param year year of the date, greater than 0
     * @param format the format of the date, like "dd/mm/yyyy"
     * @param months the string representation of the months of a date
     * @throws it.oop.exception.IllegalDateException when the parameters do not represent a valid date
     */
    public FormattedDate(int day, int month, int year, String format, String[] months) {
        super(day, month, year);
        this.format = format;
        this.months = months;
    }

    public final String printFormat() {
        return format;
    }

    public final String getMonthAsString() {
        return months[getMonth()-1];
    }

    public abstract String prettyPrint();
}
