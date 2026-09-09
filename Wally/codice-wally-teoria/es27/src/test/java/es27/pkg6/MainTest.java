package es27.pkg6;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCase1_DirectCatchHandlesInternally() {
        Dummy dummy = new Dummy();
        // Caso 1: il metodo cattura l'eccezione internamente e NON solleva nulla verso il chiamante
        assertDoesNotThrow(() -> dummy.fooCase1_DirectCatch("file_assolutamente_inesistente_12345.txt"));
    }

    @Test
    void testCase2_PropagateThrowsFileNotFoundException() {
        Dummy dummy = new Dummy();
        // Caso 2: il metodo delega al chiamante apponendo throws FileNotFoundException
        assertThrows(FileNotFoundException.class, () -> dummy.fooCase2_Propagate("file_assolutamente_inesistente_12345.txt"));
    }

    @Test
    void testCase3_CatchAndRethrowThrowsFileNotFoundException() {
        Dummy dummy = new Dummy();
        // Caso 3: il metodo intercetta localmente e poi rilancia con throw fnf
        assertThrows(FileNotFoundException.class, () -> dummy.fooCase3_CatchAndRethrow("file_assolutamente_inesistente_12345.txt"));
    }

    @Test
    void testHappyPathWithExistingFile() throws IOException {
        Dummy dummy = new Dummy();
        File tempFile = File.createTempFile("test_happy_path_", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Hello World");
        }

        try {
            assertDoesNotThrow(() -> dummy.fooCase1_DirectCatch(tempFile.getAbsolutePath()));
            assertDoesNotThrow(() -> dummy.fooCase2_Propagate(tempFile.getAbsolutePath()));
            assertDoesNotThrow(() -> dummy.fooCase3_CatchAndRethrow(tempFile.getAbsolutePath()));
        } finally {
            tempFile.delete();
        }
    }

    @Test
    void testMyClassThrowsWhenDefaultFileNotFound() {
        File fileTxt = new File("file.txt");
        if (!fileTxt.exists()) {
            assertThrows(FileNotFoundException.class, MyClass::runSlide18Demo);
        }
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> CatchingExceptionsDemo.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
