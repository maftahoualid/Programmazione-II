package es23.pkg3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainAnonToLambdaVarargsTest {

    @Test
    void testSingleIncVarargsAnonymousClass() {
        SingleInterface singleInc = new SingleInterface() {
            @Override
            public int singleMethod(int... params) { 
                return params[0] + 1; 
            }
        };

        assertEquals(4, singleInc.singleMethod(3, 4, 5));
        assertEquals(11, singleInc.singleMethod(10));
    }

    @Test
    void testSingleDecVarargsLambda() {
        SingleInterface singleDec = params -> params[0] - 1;

        assertEquals(2, singleDec.singleMethod(3, 2));
        assertEquals(9, singleDec.singleMethod(10));
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainAnonToLambdaVarargs.main(new String[]{}));
    }
}
