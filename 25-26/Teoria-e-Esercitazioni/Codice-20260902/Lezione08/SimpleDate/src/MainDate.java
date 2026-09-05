import java.util.Scanner;

public class MainDate {

    public static void main(String[] args) {
        Date d1 = new Date(7, 1, 2025);
        Date d2 = new Date(20, 2);
        Date d3 = new Date(d2);
        d2.setAmerican(); // set format to US
        System.out.println(d1.toString() + " " + d1.printFormat());
        System.out.println(d2.toString() + " " + d2.printFormat());
        System.out.println(d3.toString() + " " + d3.printFormat());
        System.out.println(d1.prettyPrint());
        System.out.println(d2.prettyPrint());
        System.out.println(d3.prettyPrint());
        //
        Date[] dates = {d1, d2, d3, new Date(14, 2, 2024)};
        for (int i = dates.length-1; i >= 0; i--)
            System.out.println(dates[i].toString() + ": " + dates[i].getMonthAsString());
        for (Date date : dates)
            System.out.println(date.toString() + ": " + date.getMonthAsString());
    }

}
