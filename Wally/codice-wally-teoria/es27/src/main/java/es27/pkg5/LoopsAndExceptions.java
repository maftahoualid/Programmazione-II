package es27.pkg5;

import java.util.ArrayList;
import java.util.List;

/**
 * es27.pkg5: Eccezioni e Cicli (Posizionamento del blocco try-catch) (Slide T17).
 *
 * La posizione del blocco try-catch rispetto a un ciclo cambia drasticamente il comportamento:
 *
 * 1. Try ANNIDATO DENTRO il ciclo:
 *    Se si verifica un'eccezione, il blocco catch la gestisce localmente e il ciclo
 *    procede regolarmente con l'iterazione successiva (recupero locale dell'errore).
 *
 * 2. Try CHE AVVOLGE il ciclo (FUORI dal ciclo):
 *    Se si verifica un'eccezione in una qualsiasi iterazione, il flusso esce
 *    immediatamente dal blocco try e quindi il ciclo viene INTERROTTO DEFINITIVAMENTE
 *    (fallimento atomico/globale del processo).
 */
public class LoopsAndExceptions {

    public static List<Integer> parseWithTryInsideLoop(String[] data) {
        List<Integer> result = new ArrayList<>();
        // Scenario 1: Try DENTRO il ciclo
        for (int i = 0; i < data.length; i++) {
            try {
                int number = Integer.parseInt(data[i]); // Lancia NumberFormatException per "ERRORE"
                result.add(number);
                System.out.println("  [Dentro Loop] Elaborato indice " + i + ": " + number);
            } catch (NumberFormatException e) {
                System.out.println("  [Dentro Loop] Errore locale all'indice " + i + " ('" + data[i] + "'): elemento saltato, si procede!");
            }
        }
        return result;
    }

    public static List<Integer> parseWithTryOutsideLoop(String[] data) {
        List<Integer> result = new ArrayList<>();
        // Scenario 2: Try FUORI dal ciclo
        try {
            for (int i = 0; i < data.length; i++) {
                int number = Integer.parseInt(data[i]);
                result.add(number);
                System.out.println("  [Fuori Loop] Elaborato indice " + i + ": " + number);
            }
        } catch (NumberFormatException e) {
            System.out.println("  [Fuori Loop] Errore globale intercettato: interruzione totale del ciclo per dato non valido ('" + e.getMessage() + "')!");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== es27.pkg5: Eccezioni e Cicli (Loops and Exceptions) ===");
        String[] data = { "10", "20", "ERRORE", "40" };

        System.out.println("\n--- Scenario 1: Try DENTRO il ciclo ---");
        List<Integer> resInside = parseWithTryInsideLoop(data);
        System.out.println("Risultato Scenario 1 (elementi recuperati): " + resInside);

        System.out.println("\n--- Scenario 2: Try FUORI dal ciclo ---");
        List<Integer> resOutside = parseWithTryOutsideLoop(data);
        System.out.println("Risultato Scenario 2 (elementi prima del blocco): " + resOutside);
    }
}
