package es23.pkg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainAnonToLambdaTest {

    @Test
    void testSingleIncAnonymousClass() {
        SingleInterface singleInc = new SingleInterface() {
            @Override
            public int singleMethod(int param) { 
                return param + 1; 
            }
        };

        assertEquals(6, singleInc.singleMethod(5));
        assertEquals(1, singleInc.singleMethod(0));
        assertEquals(0, singleInc.singleMethod(-1));
    }

    @Test
    void testSingleDecLambda() {
        SingleInterface singleDec = param -> param - 1;

        assertEquals(4, singleDec.singleMethod(5));
        assertEquals(-1, singleDec.singleMethod(0));
        assertEquals(-2, singleDec.singleMethod(-1));
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainAnonToLambda.main(new String[]{}));
    }
}
