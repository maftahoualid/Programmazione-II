package it.oop.core;

public abstract class FormattedDate extends Date {
    protected final String format;
    protected final String[] months;

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
