package it.oop.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestItalianDate { // test class
    // test setup
    private static ItalianDate date;

    @BeforeAll
    public static void setup() {
            date = new ItalianDate(1, 1, 1970);
    }

    @Test
    public void printFormatTest() { // test method
        Assertions.assertEquals("dd/mm/yyyy", date.printFormat());
        //assert date.printFormat().equals("dd/mm/yyyy") : "wrong format";
    }
}
