package es27.pkg3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testFileError() {
        MyFile f = new MyFile("bad.txt", true);
        assertThrows(FileError.class, f::open);
    }

    @Test
    void testFileSuccess() {
        MyFile f = new MyFile("good.txt", false);
        assertDoesNotThrow(f::open);
        assertDoesNotThrow(f::read);
        assertDoesNotThrow(f::close);
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> ExecutionFlowDemo.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
