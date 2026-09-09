package es24.pkg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainPairTest {

    @Test
    void testGenericPair() {
        GenericPair<String> stringPair = new GenericPair<>("one", "two");
        assertEquals("one", stringPair.getFirst());
        assertEquals("two", stringPair.getSecond());

        GenericPair<Integer> intPair = new GenericPair<>(1, 2);
        assertEquals(1, intPair.getFirst());
        assertEquals(2, intPair.getSecond());
    }

    @Test
    void testGenericPair2() {
        GenericPair2<Integer, String> pair = new GenericPair2<>(123, "Stringa");
        assertEquals(123, pair.getFirst());
        assertEquals("Stringa", pair.getSecond());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainPair.main(new String[]{}));
    }
}
