package es27.pkg2;

/**
 * es27.pkg2: Generazione e Intercettazione di Eccezioni Custom (Slide T17).
 *
 * Mostra il ciclo di vita completo di un'eccezione:
 * 1. Dichiarazione della classe di eccezione (EmptyStackException extends Exception).
 * 2. Dichiarazione di 'throws' nella firma del metodo (pop() throws EmptyStackException).
 * 3. Istanziazione dell'eccezione (new EmptyStackException(this)).
 * 4. Lancio dell'eccezione (throw ...).
 * 5. Intercettazione e gestione con blocco try-catch.
 */
public class ExceptionGenerationDemo {
    public static void main(String[] args) {
        System.out.println("=== es27.pkg2: Generazione e Intercettazione Eccezioni Custom ===");
        Stack stack = new Stack();

        // Tentativo di pop su stack vuoto: scatena EmptyStackException
        System.out.println("\n--- Tentativo 1: pop() su stack vuoto ---");
        try {
            System.out.println("Esecuzione di stack.pop()...");
            stack.pop();
            System.out.println("Tutto ok!"); // Questa riga NON viene eseguita
        } catch (EmptyStackException e) {
            // Viene eseguito se accade l'anomalia
            System.out.println("Errore gestito nel blocco catch: " + e.getMessage());
        }

        // Tentativo dopo push: operazione normale con successo
        System.out.println("\n--- Tentativo 2: pop() dopo push() ---");
        stack.push("Dato A");
        stack.push("Dato B");

        try {
            System.out.println("Estratto elemento: " + stack.pop());
            System.out.println("Estratto elemento: " + stack.pop());
            System.out.println("Tutto ok, elementi rimasti: " + stack.size());
        } catch (EmptyStackException e) {
            System.out.println("Errore inatteso: " + e.getMessage());
        }

        // =====================================================================
        // PROPAGAZIONE A CASCATA DELLA CLAUSOLA 'throws' (Call Stack)
        // Dimostrazione: gestisciRichiesta -> elaboraElemento -> prelevaElemento -> pop
        // Poiché EmptyStackException è una checked exception, ogni metodo nella catena
        // è costretto dal compilatore a dichiarare 'throws' se non usa un try-catch.
        // =====================================================================
        System.out.println("\n--- Dimostrazione: Propagazione a cascata di 'throws' lungo il Call Stack ---");
        Stack stackVuotoCascata = new Stack();
        try {
            System.out.println("Il main() chiama gestisciRichiesta(), che chiama elaboraElemento(),");
            System.out.println("che chiama prelevaElemento(), che infine invoca stack.pop()...");
            gestisciRichiesta(stackVuotoCascata);
        } catch (EmptyStackException e) {
            System.out.println("-> Eccezione intercettata nel main() al vertice della catena di chiamate!");
            System.out.println("   Messaggio eccezione: " + e.getMessage());
        }

        // Esempio con stack popolato lungo la stessa catena a cascata
        Stack stackPopolatoCascata = new Stack();
        stackPopolatoCascata.push("Elemento a cascata");
        try {
            Object risultato = gestisciRichiesta(stackPopolatoCascata);
            System.out.println("-> Successo lungo la catena a cascata: " + risultato);
        } catch (EmptyStackException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    // =========================================================================
    // METODI A CASCATA:
    // Regola "Catch or Specify" per le Checked Exceptions in Java:
    // Se un metodo chiama un altro metodo che dichiara una Checked Exception,
    // ha solo DUE opzioni:
    //   1. Gestirla localmente con un blocco try-catch
    //   2. Dichiararla nella propria firma con 'throws' (propagandola al chiamante)
    //
    // Se non la gestisce e NON la dichiara, il codice NON compila:
    // "unreported exception EmptyStackException; must be caught or declared to be thrown"
    // =========================================================================

    /**
     * Livello 1 (basso livello): chiama direttamente stack.pop().
     * Poiché non cattura EmptyStackException, DEVE dichiarare 'throws EmptyStackException'.
     */
    public static Object prelevaElemento(Stack stack) throws EmptyStackException {
        System.out.println("  [prelevaElemento] Invoco stack.pop()...");
        return stack.pop();
    }

    /**
     * Livello 2 (intermedio): NON lancia direttamente eccezioni con 'throw new',
     * ma chiama prelevaElemento() che dichiara 'throws EmptyStackException'.
     *
     * Di conseguenza, ANCHE elaboraElemento() è obbligato a dichiarare
     * 'throws EmptyStackException' a cascata!
     */
    public static Object elaboraElemento(Stack stack) throws EmptyStackException {
        System.out.println("  [elaboraElemento] Invoco prelevaElemento()...");
        return prelevaElemento(stack);
    }

    /**
     * Livello 3 (alto livello): chiama elaboraElemento().
     * L'obbligo di dichiarare 'throws EmptyStackException' risale ancora una volta
     * a cascata fino a questo metodo!
     */
    public static Object gestisciRichiesta(Stack stack) throws EmptyStackException {
        System.out.println("  [gestisciRichiesta] Invoco elaboraElemento()...");
        return elaboraElemento(stack);
    }
}
