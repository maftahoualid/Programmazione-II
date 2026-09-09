package es27.pkg3;

/**
 * es27.pkg3: Flusso di esecuzione con blocchi Catch Multipli (Slide T17).
 *
 * REGOLA DEL FLUSSO:
 * È possibile collegare più blocchi catch a un singolo blocco try.
 * Tuttavia:
 * 1. Durante l'esecuzione, non appena una riga solleva un'eccezione, il blocco try
 *    viene interrotto IMMEDIATAMENTE e le istruzioni successive nel try vengono ignorate!
 * 2. Solo UN SINGOLO blocco catch (quello compatibile con il tipo di eccezione sollevata)
 *    viene eseguito.
 * 3. Al termine del blocco catch eseguito, l'esecuzione del programma prosegue normalmente
 *    con le istruzioni successive al costrutto try-catch.
 */
public class ExecutionFlowDemo {
    public static void main(String[] args) {
        System.out.println("=== es27.pkg3: Flusso di esecuzione con blocchi Catch Multipli ===");

        MyFile f = new MyFile("foo.txt", true); // configurato per fallire all'apertura

        try {
            System.out.println("1. Inizio blocco try: invocazione f.open()...");
            f.open(); // Lancia FileError, interrompe il blocco try QUI!
            System.out.println("2. Invocazione f.read()..."); // Ignorato
            f.read(); // Ignorato
            System.out.println("3. Invocazione f.close()..."); // Ignorato
            f.close(); // Ignorato
        } catch (FileError fe) {
            System.out.println("-> Blocco catch (FileError): " + fe.getMessage()); // Solo questo catch viene eseguito
        } catch (IOError ioe) {
            System.out.println("-> Blocco catch (IOError): " + ioe.getMessage()); // Ignorato
        }

        // continue execution
        System.out.println("Esecuzione continuata normalmente dopo il blocco try-catch.");
    }
}
