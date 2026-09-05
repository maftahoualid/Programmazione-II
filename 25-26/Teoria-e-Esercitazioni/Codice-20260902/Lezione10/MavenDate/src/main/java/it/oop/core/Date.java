package it.oop.core;

public class Date {

    //enum it.oop.core.Language { IT, US }

    private final int day;
    private final int month;
    private final int year;
    static final String FORMAT_IT = "dd/mm/yyyy";
    static final String FORMAT_US = "mm/dd/yyyy";
    private Language lang;
    private static final String[] MONTHS_IT = { "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "setembre", "ottobre", "novembre", "dicembre" };
    private static final String[] MONTHS_US = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    // constructors
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify();
        lang = Language.IT;
    }
    public Date(int day, int month) {
        this(day, month, 2025); // default year
    }
    public Date(Date other) { // copy constructor
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
        verify();
        lang = other.lang;
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
    public int getMonth() { return day; }
    public int getYear() { return day; }
    public Language getlang() { return lang; }

    // setters
    public void setAmerican() { lang = Language.US; }
    public void setItalian() { lang = Language.IT; }

    // methods
    public String getMonthAsString() {
        if (lang == Language.IT) return MONTHS_IT[month-1];
        else return MONTHS_US[month-1];
    }
    public String printFormat() {
        if (lang == Language.IT) return FORMAT_IT;
        else return FORMAT_US;
    }
    public String toString() {
        if (lang == Language.IT) return day + "/" + month + "/" + year;
        else return month + "/" + day + "/" + year;
    }
    public String prettyPrint() {
        if (lang == Language.IT) return day + " " + MONTHS_IT[month-1] + " " + year;
        else return MONTHS_US[month-1] + " " + day + ", " + year;
    }
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
}
