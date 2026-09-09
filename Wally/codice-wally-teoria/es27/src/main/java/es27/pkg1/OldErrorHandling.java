package es27.pkg1;

/**
 * es27.pkg1: Gestione degli errori senza eccezioni (Tecnica Tradizionale).
 *
 * Prima dell'introduzione dei meccanismi di eccezione strutturati, le funzioni
 * segnalavano le anomalie al chiamante tramite:
 * 1. Costanti / Codici di errore (es. ERROR = -1, SUCCESS = 0).
 * 2. Codici di errore differenziati per step sequenziali (es. -1, -2, -3, ...).
 * 3. Valori sentinella / speciali (es. Float.MAX_VALUE in caso di divisione per zero).
 *
 * SVANTAGGI:
 * - Obbliga il chiamante a ricordarsi di controllare manualmente ogni valore di ritorno.
 * - Mescola i dati di business con i codici di errore.
 * - Non garantisce l'interruzione immediata in caso di mancato controllo.
 */
public class OldErrorHandling {

    // Costanti per simulare i codici di ritorno
    public static final int ERROR = -1;
    public static final int SUCCESS = 0;

    // --- Esempio 1: the callee detected the error ---
    public static int someFunc() {
        boolean anomaliaRilevata = true; // Simulazione di un errore interno
        if (anomaliaRilevata) {
            return ERROR; // Il chiamato rileva l'errore e restituisce il codice
        }
        return SUCCESS;
    }

    // --- Esempio 2: everything went well o codici di errore sequenziali ---
    public static int readFile(String fileName) {
        boolean operationError;

        // 1. open the file
        operationError = (fileName == null || fileName.isEmpty()); // Fallisce se il nome manca
        if (operationError)
            return -1;

        // 2. compute file size
        operationError = false; // Simulazione step superato
        if (operationError)
            return -2;

        // 3. allocate memory for file
        if (operationError)
            return -3;

        // 4. read file into memory
        if (operationError)
            return -4;

        // 5. close the file
        if (operationError)
            return -5;

        return 0; // everything went well
    }

    // --- Esempio 3: special value returned ---
    public static float division(int num, int den) {
        float res;
        if (den != 0) {
            res = (float) num / den; // this solves the problem
        } else {
            res = Float.MAX_VALUE; // special value returned
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== es27.pkg1: Gestione Errori Tradizionale (Senza Eccezioni) ===");

        // Test Esempio 1: someFunc()
        System.out.println("\n--- Test someFunc() ---");
        if (someFunc() == ERROR) { // the callee detected the error
            // the caller handles the error
            System.out.println("-> Errore intercettato dal chiamante: someFunc() ha restituito ERROR (" + ERROR + ").");
        } else {
            // normal execution
            System.out.println("-> Esecuzione normale di someFunc().");
        }

        // Test Esempio 2: readFile()
        System.out.println("\n--- Test readFile() ---");
        // Passando stringa vuota forziamo 'operationError' a true nel primo step
        int statoLettura = readFile(""); 
        if (statoLettura < 0) {
            System.out.println("-> Errore operazione file. Codice restituito: " + statoLettura);
        } else {
            System.out.println("-> Lettura completata con successo (Codice 0).");
        }

        // Test con file valido
        statoLettura = readFile("documento.txt");
        if (statoLettura < 0) {
            System.out.println("-> Errore operazione file. Codice restituito: " + statoLettura);
        } else {
            System.out.println("-> Lettura completata con successo per 'documento.txt' (Codice " + statoLettura + ").");
        }

        // Test Esempio 3: division()
        System.out.println("\n--- Test division() ---");
        float risultatoDivZero = division(5, 0);
        if (risultatoDivZero == Float.MAX_VALUE) { 
            System.out.println("-> Rilevato valore speciale di errore: divisione per zero (Float.MAX_VALUE).");
        } else { 
            System.out.println("-> Risultato: " + risultatoDivZero);
        }

        float risultatoDivOk = division(10, 2);
        if (risultatoDivOk == Float.MAX_VALUE) { 
            System.out.println("-> Rilevato valore speciale di errore.");
        } else { 
            System.out.println("-> Risultato divisione 10 / 2: " + risultatoDivOk);
        }
    }
}
