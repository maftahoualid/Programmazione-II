package es25.pkg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testUnboundedPair() {
        Pair<Person> pair = new Pair<>(new Person("Alice"), new Person("Bob"));
        assertNotNull(pair.getFirst());
        assertNotNull(pair.getSecond());
        assertEquals("Alice", pair.getFirst().getName());
        assertEquals("Bob", pair.getSecond().getName());

        Pair<String> strPair = new Pair<>("uno", "due");
        assertEquals("uno", strPair.getFirst());
        assertEquals("due", strPair.getSecond());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
