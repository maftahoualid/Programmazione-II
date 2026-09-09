package es27.pkg4;

/**
 * es27.pkg4: Propagazione e "Dirty Tricks" (Checked vs Unchecked) (Slide T17).
 */
public class DirtyTrickDemo {
    public static void main(String[] args) {
        System.out.println("=== es27.pkg4: Propagazione e Dirty Tricks (Checked vs Unchecked) ===");
        Dummy d = new Dummy();

        // Chiamare d.bar() NON richiede un try-catch obbligatorio a compile-time:
        // il compilatore non segnala errori perché bar() non dichiara 'throws'.
        // Tuttavia, a runtime scatena la RuntimeException che contiene la causa originale.
        System.out.println("Invocazione di d.bar()...");
        try {
            d.bar();
        } catch (RuntimeException re) {
            System.out.println("-> Intercettata RuntimeException (Unchecked): " + re.getMessage());
            System.out.println("-> Causa sottostante recuperata con getCause(): " + re.getCause());
            System.out.println("-> Tipo causa: " + re.getCause().getClass().getSimpleName());
        }
    }
}
