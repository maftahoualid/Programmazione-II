package es27.pkg6;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Slide 17-18-19 su 29 di T17: Catching exceptions.
 *
 * Quando un metodo chiama codice che può sollevare un'eccezione (es. FileReader con FileNotFoundException),
 * il chiamante ha 3 possibilità fondamentali di gestione:
 *
 * 1. Catturare direttamente l'eccezione (Slide 17: "Directly catch the exception")
 * 2. Propagare l'eccezione al proprio chiamante (Slide 18: "Propagate the exception to the caller")
 * 3. Catturare l'eccezione e rilanciarla (Slide 19: "Catch the exception and re-throw it")
 *
 * Nota: Nelle slide del corso viene usata la dicitura 'FileNotFound' come abbreviazione
 * didattica per la classe standard Java 'java.io.FileNotFoundException' (Checked Exception).
 */
public class Dummy {

    // =========================================================================
    // CASO 1 (Slide 17): DIRECTLY CATCH THE EXCEPTION
    // =========================================================================
    /**
     * Slide 17: Il metodo intercetta e gestisce l'eccezione localmente con try-catch.
     *
     * Vantaggi:
     * - Il chiamante di foo() è completamente isolato dal problema.
     * - La firma del metodo NON necessita di clausole 'throws'.
     *
     * Quando usarlo:
     * - Quando l'errore è locale e recuperabile (es. valore di fallback, risorsa alternativa, avviso).
     */
    public void fooCase1_DirectCatch() {
        fooCase1_DirectCatch("file.txt");
    }

    public void fooCase1_DirectCatch(String fileName) {
        System.out.println("  [Dummy.foo - Caso 1] Tentativo di apertura file: " + fileName);
        FileReader f = null;
        try {
            // Questa riga può sollevare FileNotFoundException (Checked Exception)
            f = new FileReader(fileName);
            System.out.println("  [Dummy.foo - Caso 1] File aperto con successo!");
        } catch (FileNotFoundException fnf) {
            // Cattura l'eccezione localmente e fa qualcosa (log, notifica, gestione alternativa)
            System.out.println("  [Dummy.foo - Caso 1] -> Eccezione catturata localmente: " + fnf.getMessage());
            System.out.println("  [Dummy.foo - Caso 1] -> Gestione completata: nessuna eccezione propagata al chiamante.");
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ignored) {}
            }
        }
    }

    // =========================================================================
    // CASO 2 (Slide 18): PROPAGATE THE EXCEPTION TO THE CALLER
    // =========================================================================
    /**
     * Slide 18: L'eccezione NON viene catturata qui, ma delegata al chiamante.
     *
     * Regola del compilatore:
     * - Trattandosi di una Checked Exception, il metodo DEVE dichiarare 'throws FileNotFoundException'.
     * - La responsabilità di gestire l'errore o propagarlo ulteriormente passa a chi invoca foo().
     *
     * Quando usarlo:
     * - Quando il metodo corrente non ha sufficiente contesto per rimediare all'errore
     *   e deve essere il livello superiore (es. interfaccia utente o logica di business) a decidere cosa fare.
     */
    public void fooCase2_Propagate() throws FileNotFoundException {
        fooCase2_Propagate("file.txt");
    }

    public void fooCase2_Propagate(String fileName) throws FileNotFoundException {
        System.out.println("  [Dummy.foo - Caso 2] Tentativo di apertura file (con delega al chiamante): " + fileName);
        // Qui la gestione dell'eccezione è delegata al chiamante.
        // Se il file non esiste, FileReader solleva FileNotFoundException e il metodo termina subito!
        FileReader f = new FileReader(fileName);
        try {
            f.close();
        } catch (IOException ignored) {}
    }

    // =========================================================================
    // CASO 3 (Slide 19): CATCH THE EXCEPTION AND RE-THROW IT
    // =========================================================================
    /**
     * Slide 19: L'eccezione viene catturata localmente, viene eseguito del codice di
     * ripristino o log parziale, e poi viene RILANCIATA con 'throw fnf'.
     *
     * Regola del compilatore:
     * - Poiché l'eccezione viene rilanciata verso l'alto ed è checked, il metodo
     *   DEVE comunque dichiarare 'throws FileNotFoundException' nella propria firma!
     *
     * Quando usarlo:
     * - Quando è necessario eseguire pulizia locale (cleanup), rilasciare risorse,
     *   o registrare log di telemetria, ma al contempo notificare il livello superiore che l'operazione è fallita.
     */
    public void fooCase3_CatchAndRethrow() throws FileNotFoundException {
        fooCase3_CatchAndRethrow("file.txt");
    }

    public void fooCase3_CatchAndRethrow(String fileName) throws FileNotFoundException {
        System.out.println("  [Dummy.foo - Caso 3] Tentativo di apertura file (cattura locale + re-throw): " + fileName);
        FileReader f = null;
        try {
            f = new FileReader(fileName);
        } catch (FileNotFoundException fnf) {
            // 1. Cattura l'eccezione e fa qualcosa localmente (es. log di diagnostica, pulizia risorse)
            System.out.println("  [Dummy.foo - Caso 3] -> Intercettata localmente per log di diagnostica!");
            System.out.println("  [Dummy.foo - Caso 3] -> Ora rilancio l'eccezione al chiamante con 'throw fnf'...");

            // 2. Rilancia l'eccezione verso l'alto
            throw fnf;
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ignored) {}
            }
        }
    }
}
