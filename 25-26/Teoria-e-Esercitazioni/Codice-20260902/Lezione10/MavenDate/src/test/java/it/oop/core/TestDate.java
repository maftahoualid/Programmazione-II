package it.oop.core;

public class TestDate { // test class
    // test setup
    private static Date date = new Date(1, 1, 1970);

    private static void printFormatTest() { // test method
        date.setAmerican();
        assert date.printFormat().equals(Date.FORMAT_US);
        /*
        // compile-time error, it.oop.ui.Date is not visible outside the it.oop.ui package
        it.oop.ui.Date d = new it.oop.ui.Date(12345);
        System.out.println(d.toString());
        System.out.println(d.time);
        */
    }

    // run with -ea JVM option, cli: java -ea it.oop.core.TestDate
    public static void main(String[] args) {
        printFormatTest(); // execute test
    }
}
