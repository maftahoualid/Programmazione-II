package it.oop.ui;

import it.oop.core.ItalianDate;
import it.oop.core.AmericanDate;
import it.oop.core.Time;
import it.oop.core.TimeStamp;
import it.oop.core.Date;
import java.util.Arrays;

public class MainDate {

    public static void main(String[] args) {
        Date date = new Date(3,11,2025);
        ItalianDate itDate = new ItalianDate(3, 11, 2025);
        AmericanDate usDate = new AmericanDate(3, 11, 2025);
        System.out.println("date: " + date.toString());
        System.out.println("itDate: " + itDate.toString());
        System.out.println("usDate: " + usDate.toString());
        //System.out.println("date format: " + date.printFormat()); // compile-time error, method printFormat() not defined in Date
        System.out.println("itDate format: " + itDate.printFormat());
        System.out.println("usDate format: " + usDate.printFormat());
        System.out.println("date ?= itDate: " + date.equals(itDate));
        System.out.println("itDate ?= usDate: " + itDate.equals(usDate));
        System.out.println("date ?= 4/11/2025: " + date.equals(new Date(4,11,2025)));
        Date d = new ItalianDate(1,1,1970); // upcast
        //ItalianDate id = new Date(1,1,1970);
        //AmericanDate ad = new ItalianDate(1,1,1970);
        ItalianDate id = (ItalianDate) d; // legit downcast
        System.out.println("id format: " + id.printFormat());
        //ItalianDate id2 = (ItalianDate) date; // not legit downcast
        //System.out.println(id2.printFormat());
        //
        Time ts1 = new TimeStamp(0, 0, 10, 10, 11, 2025);
        System.out.println(ts1.toString());
        Date ts2 = new TimeStamp(0, 0, 10, 10, 11, 2025);
        System.out.println(ts2.getDay());
        // System.out.println(ts1.getDay()); // compile-time error
        System.out.println(((Date) ts1).getDay());
        Date[] arr = {ts2, itDate, new Date(9,9,2025)};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
