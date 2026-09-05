package it.oop.core;

public class Date implements Comparable { // raw use

    protected final int day;
    private final int month;
    private final int year;

    // constructors
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify();
    }
    public Date(int day, int month) {
        this(day, month, 2025); // default year
    }
    public Date(Date other) { // copy constructor
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
        verify();
    }

    void verify() {
        if (year < 0 || month < 1 || month > 12) // year and month check
            System.out.println("Illegal date!");
        else
            if (day < 1 || day > daysPerMonth(month)) // day check
                System.out.println("Illegal date!");
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
    public int compareTo(Object other) {
        Date otherAsDate = (Date) other;
        int diff = this.year - otherAsDate.getYear();
        if (diff != 0)
            return diff;
        diff = this.month - otherAsDate.getMonth();
        if (diff != 0)
            return diff;
        return this.day - otherAsDate.getDay();
    }
}
