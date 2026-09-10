package es28;

/*
 * ============================================================
 *  ES28 — REFERENCE COMPLETO: Collections, Stream API e
 *          Interfacce Funzionali in Java
 * ============================================================
 *
 *  INDICE DEI FILE:
 *  ─────────────────────────────────────────────────────────
 *  1. Main.java                   ← questo file (punto d'ingresso + tabelle rapide)
 *  2. A_InterfacceFunzionali.java ← Predicate, Function, Consumer, Supplier, ...
 *  3. B_Strutture_Array.java      ← array primitivi e di oggetti
 *  4. C_Strutture_List.java       ← ArrayList, LinkedList, List.of…
 *  5. D_Strutture_Set.java        ← HashSet, LinkedHashSet, TreeSet
 *  6. E_Strutture_Queue.java      ← PriorityQueue, ArrayDeque (FIFO/LIFO)
 *  7. F_Strutture_Map.java        ← HashMap, LinkedHashMap, TreeMap
 *  8. G_Stream_InStream.java      ← come ENTRARE nello stream
 *  9. H_Stream_Operazioni.java    ← operazioni intermedie e terminali
 * 10. I_Stream_OutStream.java     ← come USCIRE dallo stream (.collect, .toArray…)
 * 11. L_Stream_Primitivi.java     ← IntStream, LongStream, DoubleStream
 * 12. M_Optional.java             ← Optional<T>
 * 13. N_ClassiUtility.java        ← Arrays, Collections, Collectors
 * ─────────────────────────────────────────────────────────
 *
 *  MAPPA RAPIDA — INTERFACCE FUNZIONALI (java.util.function):
 *  ┌──────────────────────┬─────────────────────────────────┬──────────────────────┐
 *  │ Interfaccia          │ Firma del metodo astratto        │ Usata in…            │
 *  ├──────────────────────┼─────────────────────────────────┼──────────────────────┤
 *  │ Predicate<T>         │ boolean test(T t)               │ .filter()            │
 *  │ BiPredicate<T,U>     │ boolean test(T t, U u)          │ —                    │
 *  │ Function<T,R>        │ R apply(T t)                    │ .map()               │
 *  │ BiFunction<T,U,R>    │ R apply(T t, U u)               │ —                    │
 *  │ Consumer<T>          │ void accept(T t)                │ .forEach()           │
 *  │ BiConsumer<T,U>      │ void accept(T t, U u)           │ mappa.forEach()      │
 *  │ Supplier<T>          │ T get()                         │ Optional.orElseGet() │
 *  │ UnaryOperator<T>     │ T apply(T t)   [= Func<T,T>]   │ .replaceAll()        │
 *  │ BinaryOperator<T>    │ T apply(T,T)  [= BiF<T,T,T>]  │ .reduce()            │
 *  └──────────────────────┴─────────────────────────────────┴──────────────────────┘
 *
 *  MAPPA RAPIDA — STRUTTURE DATI (java.util):
 *  ┌────────────┬─────────────────┬──────────┬────────────┬──────────────────────────┐
 *  │ Interfaccia│ Implementazione │ Ordine   │ Duplicati  │ Complessità chiave        │
 *  ├────────────┼─────────────────┼──────────┼────────────┼──────────────────────────┤
 *  │ List       │ ArrayList       │ indice   │ sì         │ get O(1), add-mid O(n)   │
 *  │ List       │ LinkedList      │ indice   │ sì         │ get O(n), add-head O(1)  │
 *  │ Set        │ HashSet         │ nessuno  │ no         │ O(1)                     │
 *  │ Set        │ LinkedHashSet   │ inserim. │ no         │ O(1)                     │
 *  │ Set        │ TreeSet         │ naturale │ no         │ O(log n)                 │
 *  │ Queue/Deque│ PriorityQueue   │ priorità │ sì         │ poll O(log n)            │
 *  │ Queue/Deque│ ArrayDeque      │ FIFO/LIFO│ sì         │ O(1) amort.              │
 *  │ Map        │ HashMap         │ nessuno  │ chiavi no  │ O(1)                     │
 *  │ Map        │ LinkedHashMap   │ inserim. │ chiavi no  │ O(1)                     │
 *  │ Map        │ TreeMap         │ naturale │ chiavi no  │ O(log n)                 │
 *  └────────────┴─────────────────┴──────────┴────────────┴──────────────────────────┘
 *
 *  MAPPA RAPIDA — STREAM PIPELINE:
 *
 *   Struttura/Array
 *       │
 *       ▼ .stream() / Arrays.stream() / Stream.of() / IntStream.range()
 *   Stream<T>  ──── operazioni intermedie (lazy, ritornano uno stream) ────▶
 *       │  .filter(Predicate)     .map(Function)      .flatMap(Function)
 *       │  .sorted()              .distinct()         .limit(n)
 *       │  .peek(Consumer)        .mapToInt/Long/Double
 *       │
 *       ▼ operazione terminale (eager, consuma lo stream)
 *   Risultato finale:
 *       .collect(Collectors.toList() / toSet() / toMap() / groupingBy())
 *       .forEach(Consumer)   .count()   .findFirst()   .anyMatch()
 *       .reduce(BinaryOperator)   .toArray()   .min() / .max()
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== ES28: Reference — Java Collections, Stream API & Interfacce Funzionali ===\n");

        System.out.println("--- A: Interfacce Funzionali ---");
        A_InterfacceFunzionali.demo();

        System.out.println("\n--- B: Array ---");
        B_Strutture_Array.demo();

        System.out.println("\n--- C: List ---");
        C_Strutture_List.demo();

        System.out.println("\n--- D: Set ---");
        D_Strutture_Set.demo();

        System.out.println("\n--- E: Queue e Deque ---");
        E_Strutture_Queue.demo();

        System.out.println("\n--- F: Map ---");
        F_Strutture_Map.demo();

        System.out.println("\n--- G: Entrare nello Stream ---");
        G_Stream_InStream.demo();

        System.out.println("\n--- H: Operazioni sullo Stream ---");
        H_Stream_Operazioni.demo();

        System.out.println("\n--- I: Uscire dallo Stream ---");
        I_Stream_OutStream.demo();

        System.out.println("\n--- L: Stream Primitivi ---");
        L_Stream_Primitivi.demo();

        System.out.println("\n--- M: Optional ---");
        M_Optional.demo();

        System.out.println("\n--- N: Classi Utility (Arrays, Collections, Collectors) ---");
        N_ClassiUtility.demo();
    }
}
