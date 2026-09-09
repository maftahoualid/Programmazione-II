package es25;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testOverallMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
