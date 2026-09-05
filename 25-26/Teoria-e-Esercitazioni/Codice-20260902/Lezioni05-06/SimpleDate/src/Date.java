public class Date {
    // fields of the objects from the Date class
    // state of a Date object
    int day;
    int month;
    int year;
    // constant
    static final String FORMAT = "dd/mm/yyyy";

    // constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify();
    }

    // instance methods
    void verify() {
        if (year < 0 || month < 1 || month > 12) // year and month check
            System.out.println("Illegal date!");
        else
            if (day < 1 || day > daysPerMonth(month)) // day check
                System.out.println("Illegal date!");
    }

    String print() {
        return day + "/" + month + "/" + year + " [" + FORMAT + "]";
    }

    public String toString() { //
        return print();
    }
    
    // static method
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
