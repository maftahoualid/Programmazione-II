package es26.pkg3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSortStrings() {
        String[] nomi = { "Zeno", "Anna", "Mario", "Bob" };
        Arrays.sort(nomi);
        assertArrayEquals(new String[]{ "Anna", "Bob", "Mario", "Zeno" }, nomi);
    }

    @Test
    void testSortIntegers() {
        Integer[] numeri = { 42, 10, 88, 5, 23 };
        Arrays.sort(numeri);
        assertArrayEquals(new Integer[]{ 5, 10, 23, 42, 88 }, numeri);
    }

    @Test
    void testSortPersonComparable() {
        Person[] persone = {
            new Person("Sam"),
            new Person("Alice"),
            new Person("Bob")
        };
        Arrays.sort(persone);
        assertEquals("Alice", persone[0].getName());
        assertEquals("Bob", persone[1].getName());
        assertEquals("Sam", persone[2].getName());
    }

    @Test
    void testSortNonComparableThrowsClassCastException() {
        Cane[] cani = { new Cane("Fido"), new Cane("Bobby") };
        assertThrows(ClassCastException.class, () -> Arrays.sort(cani));
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
