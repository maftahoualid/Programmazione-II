package it.oop.core;

public class TestItalianDate { // test class
    // test setup
    private static ItalianDate date = new ItalianDate(1, 1, 1970);

    private static void printFormatTest() { // test method
        assert date.printFormat().equals("dd/mm/yyyy");
        assert date.printFormat().equals("dd/mm/yyyy") : "wrong format";
    }

    // run with -ea JVM option, cli: java -ea it.oop.core.TestDate
    public static void main(String[] args) {
        printFormatTest(); // execute test
    }
}
