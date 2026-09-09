package es25.pkg2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testBoundedPair() {
        Pair<Person> pair = new Pair<>(new Person("Alice"), new Person("Bob"));
        assertEquals("Alice", pair.getFirstName());
        assertEquals("Bob", pair.getSecondName());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
