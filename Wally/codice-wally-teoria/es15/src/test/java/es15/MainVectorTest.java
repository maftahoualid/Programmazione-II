package es15;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;

class MainVectorTest {
    @Test
    void testMain() {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream("1\n2\n3\n\nTest\n0\n".getBytes()));
            Assertions.assertDoesNotThrow(() -> {
                MainVector.main(new String[]{});
            });
        } finally {
            System.setIn(stdin);
        }
    }
}
