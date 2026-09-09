package es27.pkg7;

import java.util.ArrayList;
import java.util.List;

/**
 * Slide 27 e 28 su 29 di T17: "Exceptions and Loops".
 *
 * Questa classe confronta i due pattern architetturali per l'uso delle eccezioni nei cicli:
 *
 * 1. SLIDE 27 - ECCEZIONI E CICLI (Try annidato DENTRO il ciclo):
 *    "Per errori che riguardano singole iterazioni, il blocco try .. catch è annidato nel ciclo
 *     In caso di eccezione, si prosegue con la prossima iterazione"
 *    <pre>
 *    while (condition) {
 *        try {
 *            // codice che può sollevare un'eccezione
 *        } catch (AnException e) {
 *            // gestisce l'errore locale
 *        }
 *    }
 *    </pre>
 *
 * 2. SLIDE 28 - ECCEZIONI E CICLI (Try che AVVOLGE il ciclo):
 *    "Per errori che compromettono l'intero ciclo, il blocco try .. catch avvolge il ciclo
 *     In caso di eccezione, si esce dal ciclo"
 *    <pre>
 *    try {
 *        while (condition) {
 *            // codice che può sollevare un'eccezione
 *        }
 *    } catch (AnException e) {
 *        // gestisce l'errore globale
 *    }
 *    </pre>
 */
public class ExceptionsAndLoops {

    /**
     * Operazione a rischio che solleva 'AnException' in presenza di dati non validi.
     */
    public static void riskyOperation(String item) throws AnException {
        if ("ERRORE".equalsIgnoreCase(item) || "FAIL".equalsIgnoreCase(item)) {
            throw new AnException("Dato non valido o corrotto: '" + item + "'");
        }
    }

    // =========================================================================
    // 1. SLIDE 27: TRY .. CATCH ANNIDATO NEL CICLO WHILE
    // =========================================================================
    /**
     * Slide 27: Il blocco try-catch è DENTRO il ciclo while.
     * Quando un elemento genera AnException:
     * - Il catch intercetta l'anomalia.
     * - Viene gestito l'errore locale (log, scarto del dato, notifica).
     * - Il ciclo continua regolarmente elaborando l'iterazione successiva.
     */
    public static List<String> processWithTryInsideLoop(List<String> items) {
        List<String> processed = new ArrayList<>();
        int i = 0;

        // Struttura letterale della Slide 27:
        while (i < items.size()) {
            try {
                String item = items.get(i);
                riskyOperation(item); // Può sollevare AnException
                processed.add(item);
                System.out.println("  [Dentro Loop] Iterazione " + i + ": elemento '" + item + "' elaborato con successo.");
            } catch (AnException e) {
                // Gestisce l'errore locale e prosegue con la prossima iterazione
                System.out.println("  [Dentro Loop] Iterazione " + i + ": ERRORE LOCALE intercettato (" + e.getMessage() + "). Elemento scartato, si prosegue!");
            }
            i++;
        }

        return processed;
    }

    // =========================================================================
    // 2. SLIDE 28: TRY .. CATCH CHE AVVOLGE IL CICLO WHILE
    // =========================================================================
    /**
     * Slide 28: Il blocco try-catch AVVOLGE il ciclo while.
     * Quando un elemento genera AnException:
     * - L'eccezione interrompe immediatamente l'iterazione corrente.
     * - L'esecuzione esce DEFINITIVAMENTE dal ciclo while.
     * - Il controllo salta al blocco catch esterno per gestire l'errore globale.
     * - Tutti gli elementi successivi NON vengono elaborati.
     */
    public static List<String> processWithTryOutsideLoop(List<String> items) {
        List<String> processed = new ArrayList<>();
        int i = 0;

        // Struttura letterale della Slide 28:
        try {
            while (i < items.size()) {
                String item = items.get(i);
                riskyOperation(item); // Può sollevare AnException
                processed.add(item);
                System.out.println("  [Fuori Loop] Iterazione " + i + ": elemento '" + item + "' elaborato con successo.");
                i++;
            }
        } catch (AnException e) {
            // Gestisce l'errore globale: l'intero processo è compromesso
            System.out.println("  [Fuori Loop] ERRORE GLOBALE intercettato all'iterazione " + i + " (" + e.getMessage() + ")!");
            System.out.println("  [Fuori Loop] Il ciclo while è stato INTERROTTO DEFINITIVAMENTE. Gli elementi successivi vengono ignorati.");
        }

        return processed;
    }

    // =========================================================================
    // 3. SLIDE 27 VARIANTE: WHILE(TRUE) CON RETRY PATTERN
    // =========================================================================
    /**
     * Dimostra l'uso letterale del "while (true)" presente nella Slide 27,
     * tipico pattern per riprovare un'operazione fino a quando non ha successo
     * (es. richiesta input utente corretta o riconnessione a una risorsa).
     */
    public static String retryUntilSuccess(String[] inputs) {
        int index = 0;
        while (true) {
            try {
                String input = (index < inputs.length) ? inputs[index] : "DEFAULT_OK";
                System.out.println("  [Retry while(true)] Tentativo con input: '" + input + "'");
                riskyOperation(input); // Se fallisce solleva AnException
                System.out.println("  [Retry while(true)] Successo! Esco dal ciclo con break.");
                return input; // oppure break;
            } catch (AnException e) {
                System.out.println("  [Retry while(true)] Fallito (" + e.getMessage() + "), riprovo al prossimo ciclo...");
                index++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== es27.pkg7: Exceptions and Loops (Slide T17 p. 27-28) ===");

        List<String> dataset = new ArrayList<>();
        dataset.add("Dato_1");
        dataset.add("Dato_2");
        dataset.add("ERRORE"); // Elemento che scatena AnException
        dataset.add("Dato_4");
        dataset.add("Dato_5");

        System.out.println("Dataset in input: " + dataset);

        // 1. Esempio Slide 27: Try DENTRO il ciclo
        System.out.println("\n--- 1. Slide 27: Try DENTRO il ciclo (recupero iterazione per iterazione) ---");
        List<String> resInside = processWithTryInsideLoop(dataset);
        System.out.println("-> Risultato finale Slide 27: " + resInside);
        System.out.println("   (Nota: 'ERRORE' è stato saltato, ma 'Dato_4' e 'Dato_5' sono stati elaborati!)");

        // 2. Esempio Slide 28: Try FUORI dal ciclo
        System.out.println("\n--- 2. Slide 28: Try FUORI dal ciclo (errore critico per l'intero ciclo) ---");
        List<String> resOutside = processWithTryOutsideLoop(dataset);
        System.out.println("-> Risultato finale Slide 28: " + resOutside);
        System.out.println("   (Nota: il ciclo si è fermato a 'ERRORE'; 'Dato_4' e 'Dato_5' NON sono mai stati esaminati!)");

        // 3. Esempio Slide 27: while (true) retry pattern
        System.out.println("\n--- 3. Slide 27: Pattern 'while (true)' con tentativi ripetuti ---");
        String[] tentativi = { "FAIL", "ERRORE", "DATO_CORRETTO" };
        String successo = retryUntilSuccess(tentativi);
        System.out.println("-> Valore ottenuto con successo: " + successo);
    }
}
