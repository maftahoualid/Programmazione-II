package es14.it.univr.pkg2;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;

class pkg2_Class1Test {
    @Test
    void testMain() {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream("1\n2\n3\n\nTest\n0\n".getBytes()));
            Assertions.assertDoesNotThrow(() -> {
                pkg2_Class1.main(new String[]{});
            });
        } finally {
            System.setIn(stdin);
        }
    }
}
