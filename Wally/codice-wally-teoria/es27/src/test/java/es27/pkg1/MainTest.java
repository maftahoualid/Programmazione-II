package es27.pkg1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSomeFuncError() {
        assertEquals(OldErrorHandling.ERROR, OldErrorHandling.someFunc());
    }

    @Test
    void testReadFile() {
        // Stringa vuota o null -> errore step 1 (-1)
        assertEquals(-1, OldErrorHandling.readFile(""));
        assertEquals(-1, OldErrorHandling.readFile(null));

        // File con nome valido -> successo (0)
        assertEquals(0, OldErrorHandling.readFile("test.txt"));
    }

    @Test
    void testDivision() {
        // Divisione per zero -> Float.MAX_VALUE
        assertEquals(Float.MAX_VALUE, OldErrorHandling.division(10, 0));

        // Divisione regolare
        assertEquals(2.5f, OldErrorHandling.division(5, 2), 0.0001f);
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> OldErrorHandling.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
