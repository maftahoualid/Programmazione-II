package es14.it.univr.pkg2;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;

class ImportPacchettiTest {
    @Test
    void testMain() {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream("1\n2\n3\n\nTest\n0\n".getBytes()));
            Assertions.assertDoesNotThrow(() -> {
                ImportPacchetti.main(new String[]{});
            });
        } finally {
            System.setIn(stdin);
        }
    }
}
