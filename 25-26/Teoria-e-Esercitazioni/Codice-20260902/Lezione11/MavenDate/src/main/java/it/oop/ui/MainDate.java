package it.oop.ui;

import it.oop.core.AmericanDate;
import it.oop.core.Date;
import it.oop.core.ItalianDate;

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
        Date d = new ItalianDate(1,1,1970); // ok, upcast
        // AmericanDate ad = new ItalianDate(1,1,1970); // compile-time eror
        // ItalianDate id = new Date(1,1,1970); // compile-time error
        ItalianDate id = (ItalianDate) d; // ok, legit downcast
        System.out.println(id.printFormat());
        // ItalianDate id = (ItalianDate) date; // runtime error, not legit downcast
    }

}
