package es25.pkg5;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGabbiaSpecialeUpperBounds() {
        Anatra anatra = new Anatra();
        GabbiaSpeciale<Anatra> gabbia = new GabbiaSpeciale<>(anatra);
        assertSame(anatra, gabbia.getAnimale());
        assertDoesNotThrow(gabbia::faiAgire);
    }

    @Test
    void testAggiungiPadreLowerBounds() {
        List<Padre> listaPadri = new ArrayList<>();
        TestLower.aggiungiPadre(listaPadri);
        assertEquals(2, listaPadri.size());
        assertInstanceOf(Padre.class, listaPadri.get(0));
        assertInstanceOf(Figlio.class, listaPadri.get(1));

        List<Nonno> listaNonni = new ArrayList<>();
        TestLower.aggiungiPadre(listaNonni);
        assertEquals(2, listaNonni.size());
    }

    @Test
    void testTestUpperMain() {
        assertDoesNotThrow(() -> TestUpper.main(new String[]{}));
    }

    @Test
    void testTestLowerMain() {
        assertDoesNotThrow(() -> TestLower.main(new String[]{}));
    }

    @Test
    void testMainPkg5() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
