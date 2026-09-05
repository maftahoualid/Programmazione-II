public class Date {
    private int day;
    private int month;
    private int year;
    static final String FORMAT_IT = "dd/mm/yyyy";
    static final String FORMAT_US = "mm/dd/yyyy";
    private byte lang; // 0: IT, 1: US

    // constructors
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify();
        lang = 0;
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
    public byte getlang() { return lang; }

    // setters
    public void setDay(int day) {
        this.day = day;
        verify();
    }
    public void setMonth(int month) {
        this.month = month;
        verify();
    }
    public void setYear(int year) {
        this.year = year;
        verify();
    }
    public void setLang(byte lang) {
        if (lang == 1) this.lang = 1;
        else this.lang = 0;
    }

    // methods
    public String printFormat() {
        if (lang == 0) return FORMAT_IT;
        else return FORMAT_US;
    }
    public String toString() {
        if (lang == 0) return day + "/" + month + "/" + year;
        else return month + "/" + day + "/" + year;
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
