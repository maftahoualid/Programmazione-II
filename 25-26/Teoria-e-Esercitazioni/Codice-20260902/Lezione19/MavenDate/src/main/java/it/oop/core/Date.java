package it.oop.core;

import it.oop.exception.IllegalDateException;

/**
 * A class implementing dates.
 * The class implements the {@link java.lang.Comparable} interface.
 */
public class Date implements Comparable<Date> {

    /**
     * Day of the date.
     */
    protected final int day;
    /**
     * Month of the date.
     */
    private final int month;
    /**
     * Year of the date.
     */
    private final int year;

    /**
     * Date parameterized constructor.
     * @param day day of the date, from 1 to 31
     * @param month month of the date, from 1 to 12
     * @param year year of the date, greater than 0
     * @throws IllegalDateException when the parameters do not represent a valid date
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify();
    }
    public Date(int day, int month) {
        this(day, month, 2025); // default year
    }

    /**
     * Date copy constructor.
     * @param other date to copy
     */
    public Date(Date other) { // copy constructor
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    /**
     * Method verifying the validity of a date
     * @throws IllegalDateException when the parameters do not represent a valid date
     *
     */
    void verify() {
        if (year < 0)  // year and month check
            throw new IllegalDateException("Illegal date: wrong year");
        if (month < 1 || month > 12)
            throw new IllegalDateException("Illegal date: wrong month");
        if (day < 1 || day > daysPerMonth(month)) // day check
            throw new IllegalDateException("Illegal date: wrong day");
    }

    // getters
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // methods
    static int daysPerMonth(int month) {
        int days;
        switch(month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = 28;
                break;
            default:
                days = 31;
                break;
        }
        return days;
    }

    @Override
    public String toString() {
        return "y" + year + "m" + month + "d" + day;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Date)) return false;
        Date otherAsDate = (Date) other;
        return day == otherAsDate.getDay()
                && month == otherAsDate.getMonth()
                && year == otherAsDate.getYear();
    }

    @Override
    public int compareTo(Date other) {
        int diff = this.year - other.getYear();
        if (diff != 0)
            return diff;
        diff = this.month - other.getMonth();
        if (diff != 0)
            return diff;
        return this.day - other.getDay();
    }

    /**
     * Inner class for building dates.
     */
    public static class Builder {
        private final int year;

        public Builder(int year) {
            if (year > 0)
                this.year = year;
            else
                this.year = 1970;
        }
        public Date build(int day, int month) {
            if (month < 1 || month > 12 || day < 1 || day > daysPerMonth(month))
                return new Date(1,1, year);
            return new Date(day, month, year);
        }
    }

    @Override
    public int hashCode() {
        return (day + month) * year;
    }
}
