import java.util.Scanner;

public class MainDate {

    public static void main(String[] args) {
        Date d1 = new Date(-7, 10, 2025);
        Date d2 = new Date(20, 10);
        Date d3 = new Date(d2);
        //d3.day = -7; // compile-time error
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());
        System.out.println(d3.getDay());
        d3.setDay(-6); // illegal date
        d3.setDay(2); // ok
        //Date d4 = new Date();
        //System.out.println(d4.toString());
        d2.setLang((byte) 1); // set format to US
        System.out.println(d2.toString() + " " + d2.printFormat());
        System.out.println(d3.toString() + " " + d3.printFormat());
    }

}
