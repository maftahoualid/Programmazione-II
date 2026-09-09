package es23.pkg2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainVarargsMethodTest {

    @Test
    void testMinVarargs() {
        assertEquals(0, MainVarargsMethod.min(1, 0, 5));
        assertEquals(2, MainVarargsMethod.min(3, 7, 2, 6, 9));
        assertEquals(-10, MainVarargsMethod.min(5, -10, 20));
        assertEquals(42, MainVarargsMethod.min(42));
        assertEquals(Integer.MAX_VALUE, MainVarargsMethod.min());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainVarargsMethod.main(new String[]{}));
    }
}
