package es25.pkg3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMultipleBoundsPair() {
        Student s1 = new Student("Sam", 456);
        Student s2 = new Student("Paul", 123);
        Pair<Student> pair = new Pair<>(s1, s2);

        // Verifica metodo da Person
        assertEquals("Sam", pair.getFirstName());

        // Verifica metodi da Comparable<T>
        assertEquals(s1, pair.getMax());
        assertEquals(s2, pair.getMin());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
