package es26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {

    @Test
    void testTopLevelMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
