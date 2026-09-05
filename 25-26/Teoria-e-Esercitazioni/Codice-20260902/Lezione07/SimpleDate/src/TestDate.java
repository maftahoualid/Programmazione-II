public class TestDate { // test class
    // test setup
    private static Date date = new Date(1, 1, 1970);

    private static void printFormatTest() { // test method
        date.setLang((byte) 1);
        assert date.printFormat().equals(Date.FORMAT_US);
    }

    // run with -ea JVM option, cli: java -ea TestDate
    public static void main(String[] args) {
        printFormatTest(); // execute test
    }
}
