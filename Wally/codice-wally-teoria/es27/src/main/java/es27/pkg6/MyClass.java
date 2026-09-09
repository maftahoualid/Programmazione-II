package es27.pkg6;

import java.io.FileNotFoundException;

/**
 * Slide 18 di T17: Esempio di MyClass che delega a sua volta l'eccezione
 * non catturata propagandola fino alla JVM.
 *
 * <pre>
 * public class MyClass {
 *     public static void main(String[] args) throws FileNotFound {
 *         Dummy d = new Dummy();
 *         d.foo(); // questo può sollevare l'eccezione FileNotFound
 *     }
 * }
 * </pre>
 */
public class MyClass {

    /**
     * Metodo di prova che riproduce la firma e il comportamento della Slide 18.
     * Se il file 'file.txt' non esiste, l'eccezione risale ed esce dal metodo.
     */
    public static void runSlide18Demo() throws FileNotFoundException {
        Dummy d = new Dummy();
        d.fooCase2_Propagate(); // questo può sollevare l'eccezione FileNotFoundException
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("=== Esecuzione di MyClass (Slide 18) ===");
        runSlide18Demo();
    }
}
