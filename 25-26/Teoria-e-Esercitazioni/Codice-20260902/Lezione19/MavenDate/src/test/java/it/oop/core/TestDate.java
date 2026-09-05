package it.oop.core;

import it.oop.exception.IllegalDateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDate {

    private Date date;

    @Test
    public void testDateConstructor() {
        date = new Date(1, 12, 2025);
        Assertions.assertEquals(1, date.getDay());
        Assertions.assertEquals(12, date.getMonth());
        Assertions.assertEquals(2025, date.getYear());
    }

    @Test
    public void testDateConstructorException() {
        assertThrows(IllegalDateException.class, () -> date = new Date(1,12,-2));
    }
}
