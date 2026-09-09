package es27.pkg6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Dimostrazione completa dei 3 casi di gestione delle eccezioni da parte del chiamante
 * presentati nelle Slide 17, 18 e 19 della lezione T17 ("Error Handling with Exceptions").
 *
 * <ol>
 *   <li><b>Slide 17</b>: Catturare direttamente l'eccezione (<i>Directly catch the exception</i>).</li>
 *   <li><b>Slide 18</b>: Propagare l'eccezione al chiamante (<i>Propagate the exception to the caller</i>).</li>
 *   <li><b>Slide 19</b>: Catturare l'eccezione e rilanciarla (<i>Catch the exception and re-throw it</i>).</li>
 * </ol>
 */
public class CatchingExceptionsDemo {

    public static void main(String[] args) {
        System.out.println("=== es27.pkg6: Le 3 Strategie di Gestione delle Eccezioni (Slide T17 p.17-19) ===\n");

        Dummy dummy = new Dummy();
        String fileInesistente = "file_inesistente_per_test.txt";

        // ---------------------------------------------------------------------
        // CASO 1 (Slide 17): Directly catch the exception
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 1 (Slide 17): Cattura Diretta (Directly Catch) ---");
        System.out.println("Il chiamante invoca dummy.fooCase1_DirectCatch()...");
        // Nota: NON serve try-catch nel chiamante perché fooCase1 gestisce tutto internamente
        dummy.fooCase1_DirectCatch(fileInesistente);
        System.out.println("-> Il chiamante continua regolarmente senza interruzioni.\n");

        // ---------------------------------------------------------------------
        // CASO 2 (Slide 18): Propagate the exception to the caller
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 2 (Slide 18): Propagazione al Chiamante (Propagate to Caller) ---");
        System.out.println("Il chiamante invoca dummy.fooCase2_Propagate()...");
        try {
            // Poiché fooCase2_Propagate dichiara 'throws FileNotFoundException',
            // il compilatore OBBLIGA il chiamante a usare try-catch o dichiarare throws a sua volta!
            dummy.fooCase2_Propagate(fileInesistente);
            System.out.println("Questa riga non viene raggiunta!");
        } catch (FileNotFoundException e) {
            System.out.println("-> Eccezione intercettata dal chiamante (nel main): " + e.getMessage());
            System.out.println("-> Il metodo foo non l'ha gestita: l'ha delegata interamente a monte!\n");
        }

        // ---------------------------------------------------------------------
        // CASO 3 (Slide 19): Catch the exception and re-throw it
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 3 (Slide 19): Cattura e Rilancio (Catch and Re-throw) ---");
        System.out.println("Il chiamante invoca dummy.fooCase3_CatchAndRethrow()...");
        try {
            // Anche qui il metodo dichiara 'throws' perché rilancia l'eccezione
            dummy.fooCase3_CatchAndRethrow(fileInesistente);
            System.out.println("Questa riga non viene raggiunta!");
        } catch (FileNotFoundException e) {
            System.out.println("-> Eccezione rilanciata intercettata dal chiamante (nel main): " + e.getMessage());
            System.out.println("-> Il metodo foo ha eseguito log/cleanup locale e poi ha rilanciato con 'throw fnf'.\n");
        }

        // ---------------------------------------------------------------------
        // DIMOSTRAZIONE HAPPY PATH (Quando il file esiste)
        // ---------------------------------------------------------------------
        System.out.println("--- Caso Happy Path: Quando il file ESISTE ---");
        File tempFile = null;
        try {
            tempFile = File.createTempFile("demo_es27_", ".txt");
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write("Contenuto di prova!");
            }

            System.out.println("Creato file temporaneo: " + tempFile.getName());
            dummy.fooCase1_DirectCatch(tempFile.getAbsolutePath());
            dummy.fooCase2_Propagate(tempFile.getAbsolutePath());
            dummy.fooCase3_CatchAndRethrow(tempFile.getAbsolutePath());
            System.out.println("-> Tutti e 3 i metodi sono stati eseguiti con successo senza sollevare eccezioni.");
        } catch (IOException e) {
            System.out.println("Errore I/O imprevisto nel test file: " + e.getMessage());
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }
}
