package es28;

import java.util.*;
import java.util.stream.*;

/*
 * ============================================================
 *  G — ENTRARE NELLO STREAM  (sorgenti di dati)
 * ============================================================
 *
 *  Uno Stream<T> rappresenta una sequenza di elementi su cui
 *  applicare operazioni in stile funzionale.
 *
 *  CARATTERISTICHE CHIAVE:
 *  • LAZY: le operazioni intermedie non vengono eseguite finché
 *    non c'è un'operazione terminale.
 *  • MONOUSO: uno stream consumato non può essere riusato
 *    (lancia IllegalStateException).
 *  • NO SIDE-EFFECTS: idealmente non modificano la sorgente.
 *
 *  Pipeline tipica:
 *  [sorgente] → .filter() → .map() → .sorted() → .collect()
 *                  intermedie (lazy)                terminale (eager)
 * ============================================================
 */
public class G_Stream_InStream {

    public static void demo() {

        // ── A. DA Collection (List, Set, Queue…) ──────────────
        // Tutte le classi che implementano Collection hanno .stream()
        List<String> lista = List.of("mela", "pera", "banana");
        Stream<String> daLista = lista.stream();
        daLista.forEach(System.out::println);

        Set<Integer> set = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        Stream<Integer> daSet = set.stream();

        Queue<String> coda = new ArrayDeque<>(List.of("a", "b", "c"));
        Stream<String> daCoda = coda.stream();


        // ── B. DA ARRAY ───────────────────────────────────────
        String[] array = {"x", "y", "z"};

        // B1. Arrays.stream() — il metodo corretto per array
        Stream<String> daArray1 = Arrays.stream(array);

        // B2. Stream.of() — varianti
        Stream<String> daArray2 = Stream.of(array);
        Stream<String> daArray3 = Stream.of("x", "y", "z");  // varargs inline

        // ATTENZIONE: Arrays.stream() su int[] → IntStream (non Stream<Integer>)
        int[] primitivi = {1, 2, 3};
        IntStream intStream = Arrays.stream(primitivi);        // IntStream
        Stream<Integer> boxed = Arrays.stream(primitivi).boxed(); // Stream<Integer>

        // Stream.of su int[] → Stream<int[]>  con UN SOLO elemento (l'array stesso)!
        // Stream<int[]> SBAGLIATO = Stream.of(primitivi); // da evitare


        // ── C. DA MAPPA ───────────────────────────────────────
        // Map non implementa Collection → non ha .stream() diretto
        // Devi scegliere COSA estrarre:
        Map<Integer, String> mappa = Map.of(1, "Uno", 2, "Due", 3, "Tre");

        Stream<Map.Entry<Integer,String>> streamEntry  = mappa.entrySet().stream(); // coppia K+V
        Stream<Integer>                  streamChiavi  = mappa.keySet().stream();   // solo chiavi
        Stream<String>                   streamValori  = mappa.values().stream();   // solo valori

        streamChiavi.sorted().forEach(System.out::println);


        // ── D. STREAM DIRETTAMENTE COSTRUITI ─────────────────

        // D1. Stream.empty() — stream vuoto (utile come valore di ritorno sicuro)
        Stream<String> vuoto = Stream.empty();

        // D2. Stream.of() — elementi inline
        Stream<String> diretto = Stream.of("alpha", "beta", "gamma");

        // D3. Stream.generate() — stream infinito generato da un Supplier
        //     ATTENZIONE: usare sempre con .limit() per non andare in loop infinito
        Stream<Double> random = Stream.generate(Math::random).limit(5);
        random.forEach(System.out::println);

        // D4. Stream.iterate() — stream infinito con accumulo (Java 8)
        //     iterate(seme, funzione_passo)
        Stream<Integer> pari = Stream.iterate(0, n -> n + 2).limit(5);
        pari.forEach(n -> System.out.print(n + " ")); // 0 2 4 6 8
        System.out.println();

        // D5. Stream.iterate() con predicato di stop — Java 9+
        //     iterate(seme, predicato_di_stop, funzione_passo)  — come un for loop
        Stream<Integer> finoa10 = Stream.iterate(1, n -> n <= 10, n -> n + 1);
        finoa10.forEach(n -> System.out.print(n + " ")); // 1 2 3 4 5 6 7 8 9 10
        System.out.println();

        // D6. Stream.builder() — costruzione elemento per elemento
        Stream.Builder<String> builder = Stream.builder();
        builder.add("uno");
        builder.add("due");
        builder.accept("tre");   // equivale a .add()
        Stream<String> built = builder.build();
        built.forEach(System.out::println);

        // D7. Stream.concat() — concatena due stream
        Stream<String> parte1 = Stream.of("a", "b");
        Stream<String> parte2 = Stream.of("c", "d");
        Stream<String> tutto  = Stream.concat(parte1, parte2);
        tutto.forEach(System.out::print);  // abcd
        System.out.println();


        // ── E. STREAM PARALLELO ───────────────────────────────
        // Sfrutta il ForkJoinPool per elaborazione multi-thread
        // Attenzione: NON garantisce l'ordine degli elementi
        List<Integer> grandi = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) grandi.add(i);

        long count = grandi.parallelStream()
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Pari (parallel): " + count);  // 500000

        // Convertire stream sequenziale in parallelo e viceversa
        Stream<String> seq      = lista.stream().sequential();
        Stream<String> parallel = lista.stream().parallel();


        // ── F. STREAM PRIMITIVI SPECIALIZZATI ─────────────────
        // (vedi L_Stream_Primitivi.java per dettagli completi)
        IntStream    intS  = IntStream.range(1, 5);    // [1, 2, 3, 4]
        IntStream    intS2 = IntStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
        LongStream   longS = LongStream.of(1L, 2L, 3L);
        DoubleStream dblS  = DoubleStream.of(1.0, 2.5, 3.14);

        System.out.println(IntStream.rangeClosed(1, 100).sum());  // 5050
    }
}
