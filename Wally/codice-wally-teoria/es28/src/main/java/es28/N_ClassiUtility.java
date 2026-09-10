package es28;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/*
 * ============================================================
 *  N — CLASSI UTILITY: Arrays, Collections, Collectors
 * ============================================================
 *
 *  Tre classi piene di metodi STATICI per manipolare strutture dati.
 *
 *  • java.util.Arrays      → per lavorare con gli array []
 *  • java.util.Collections → per lavorare con le Collection (List, Set, ...)
 *  • java.util.stream.Collectors → per terminare uno stream raccogliendo dati
 * ============================================================
 */
public class N_ClassiUtility {

    public static void demo() {

        System.out.println("=== Arrays ===");
        demoArrays();

        System.out.println("\n=== Collections ===");
        demoCollections();

        System.out.println("\n=== Collectors ===");
        demoCollectors();
    }


    // ──────────────────────────────────────────────────────────
    //  ARRAYS  (java.util.Arrays)
    //  Lavora esclusivamente sugli array primitivi e di oggetti.
    // ──────────────────────────────────────────────────────────
    static void demoArrays() {

        int[]    interi  = {5, 2, 8, 1, 9, 3};
        String[] parole  = {"banana", "mela", "uva", "pera"};

        // ── ORDINAMENTO ───────────────────────────────────────
        Arrays.sort(interi);                       // ordina in-place (ordine naturale)
        System.out.println(Arrays.toString(interi)); // [1, 2, 3, 5, 8, 9]

        Arrays.sort(parole);                       // ordine alfabetico
        System.out.println(Arrays.toString(parole)); // [banana, mela, pera, uva]

        // Ordine personalizzato (solo su array di oggetti, non primitivi)
        Arrays.sort(parole, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(parole)); // [uva, mela, pera, banana]

        // Ordina solo un sottointervallo [fromIndex, toIndex)
        int[] parziale = {5, 2, 8, 1, 9, 3};
        Arrays.sort(parziale, 1, 4);  // ordina solo gli indici 1, 2, 3
        System.out.println(Arrays.toString(parziale)); // [5, 1, 2, 8, 9, 3]


        // ── RICERCA BINARIA ───────────────────────────────────
        // ATTENZIONE: l'array DEVE essere già ordinato!
        int[] ordinati = {1, 2, 3, 5, 8, 9};
        int idx = Arrays.binarySearch(ordinati, 5);   // 3
        int non = Arrays.binarySearch(ordinati, 7);   // negativo (non trovato)
        System.out.println(idx + " " + non);  // 3 -5  (valore neg = -(punto inserimento)-1)


        // ── COPIA ─────────────────────────────────────────────
        int[] orig = {1, 2, 3, 4, 5};

        // copyOf(array, newLength) — tronca o padda
        int[] corta   = Arrays.copyOf(orig, 3);    // [1, 2, 3]
        int[] lunga   = Arrays.copyOf(orig, 7);    // [1, 2, 3, 4, 5, 0, 0]

        // copyOfRange(array, from, to)  — copia [from, to)
        int[] sub     = Arrays.copyOfRange(orig, 1, 4);  // [2, 3, 4]

        System.out.println(Arrays.toString(corta));
        System.out.println(Arrays.toString(lunga));
        System.out.println(Arrays.toString(sub));


        // ── RIEMPIMENTO ───────────────────────────────────────
        int[] zeri = new int[5];
        Arrays.fill(zeri, 99);
        System.out.println(Arrays.toString(zeri));  // [99, 99, 99, 99, 99]

        // fill su un intervallo
        Arrays.fill(zeri, 1, 3, 0);   // [99, 0, 0, 99, 99]
        System.out.println(Arrays.toString(zeri));


        // ── CONFRONTO ─────────────────────────────────────────
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = {1, 2, 4};
        System.out.println(Arrays.equals(a, b));      // true  (elemento per elemento)
        System.out.println(Arrays.equals(a, c));      // false
        System.out.println(a == b);                   // false (confronta i riferimenti!)

        // deepEquals per array multidimensionali
        int[][] m1 = {{1,2},{3,4}};
        int[][] m2 = {{1,2},{3,4}};
        System.out.println(Arrays.deepEquals(m1, m2));  // true


        // ── STAMPA ────────────────────────────────────────────
        System.out.println(Arrays.toString(a));           // [1, 2, 3]
        System.out.println(Arrays.deepToString(m1));      // [[1, 2], [3, 4]]


        // ── CONVERSIONE ───────────────────────────────────────
        // Array → List (dimensione fissa, non puoi add/remove)
        List<String> listaFissa = Arrays.asList("x", "y", "z");

        // Array → Stream (per tipo primitivo → IntStream/LongStream/DoubleStream)
        int sum = Arrays.stream(orig).sum();
        System.out.println("Sum array: " + sum);  // 15

        // Array → List modificabile (via stream)
        List<Integer> listaMod = Arrays.stream(orig).boxed().collect(Collectors.toList());
    }


    // ──────────────────────────────────────────────────────────
    //  COLLECTIONS  (java.util.Collections)
    //  Lavora sulle Collection (List, Set, Queue…). NON sugli array.
    // ──────────────────────────────────────────────────────────
    static void demoCollections() {

        List<Integer> l = new ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6));

        // ── ORDINAMENTO E INVERSIONE ──────────────────────────
        Collections.sort(l);                   // ordine naturale in-place
        System.out.println(l);                 // [1, 1, 2, 3, 4, 5, 6, 9]

        Collections.sort(l, Comparator.reverseOrder()); // ordine inverso
        System.out.println(l);                 // [9, 6, 5, 4, 3, 2, 1, 1]

        Collections.reverse(l);               // inverte l'ordine attuale
        System.out.println(l);                 // [1, 1, 2, 3, 4, 5, 6, 9]

        Collections.shuffle(l);               // mescola in ordine casuale
        System.out.println(l);                 // ordine casuale


        // ── RICERCA ───────────────────────────────────────────
        Collections.sort(l);  // prima ordina!
        int idx = Collections.binarySearch(l, 5);  // ricerca binaria O(log n)
        System.out.println("binarySearch(5): " + idx);

        System.out.println("min: " + Collections.min(l));  // 1
        System.out.println("max: " + Collections.max(l));  // 9

        // Frequency e disjoint
        List<String> parole = new ArrayList<>(List.of("mela", "pera", "mela", "uva"));
        int freq = Collections.frequency(parole, "mela");
        System.out.println("Frequenza 'mela': " + freq);  // 2

        boolean disgiunti = Collections.disjoint(List.of("a","b"), List.of("c","d"));
        System.out.println("Disgiunti: " + disgiunti);  // true (nessun elemento in comune)


        // ── RIEMPIMENTO E COPIA ───────────────────────────────
        List<String> dest = new ArrayList<>(Arrays.asList(null, null, null));
        List<String> src  = List.of("x", "y", "z");
        Collections.copy(dest, src);  // copia src in dest (dest deve essere già grande abbastanza)
        System.out.println(dest);     // [x, y, z]

        List<String> riempita = new ArrayList<>(Arrays.asList(null, null, null, null));
        Collections.fill(riempita, "default");
        System.out.println(riempita);  // [default, default, default, default]

        // nCopies — crea una lista immutabile con n copie dello stesso valore
        List<String> copie = Collections.nCopies(4, "Java");
        System.out.println(copie);  // [Java, Java, Java, Java]


        // ── ROTAZIONE E SWAP ──────────────────────────────────
        List<Integer> rot = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Collections.rotate(rot, 2);   // sposta a destra di 2 posizioni
        System.out.println(rot);       // [4, 5, 1, 2, 3]

        Collections.swap(rot, 0, 4);  // scambia gli elementi agli indici 0 e 4
        System.out.println(rot);


        // ── WRAPPER IMMUTABILI ────────────────────────────────
        // Crea una vista non modificabile (lancia UnsupportedOperationException su add/remove)
        List<String> modificabile = new ArrayList<>(List.of("a","b","c"));
        List<String> immutabile   = Collections.unmodifiableList(modificabile);
        // immutabile.add("d");  // → UnsupportedOperationException
        System.out.println(immutabile);

        // Nota: se modifichi la lista originale, la vista immutabile si aggiorna!
        // Per una vera immutabilità usa List.copyOf() o List.of()
        List<String> copiaCopy = List.copyOf(modificabile);  // Java 10+


        // ── WRAPPER SINCRONIZZATI (thread-safe) ───────────────
        List<String> synced = Collections.synchronizedList(new ArrayList<>());
        Set<String>  syncedSet = Collections.synchronizedSet(new HashSet<>());
        Map<String,Integer> syncedMap = Collections.synchronizedMap(new HashMap<>());
        // Quando itero devo usare synchronized(synced) { ... }


        // ── SINGLETON E EMPTY ─────────────────────────────────
        List<String>  listaVuota  = Collections.emptyList();   // immutabile e vuota
        Set<String>   setVuoto    = Collections.emptySet();
        Map<String,?> mappaVuota  = Collections.emptyMap();

        List<String>  listaSingle = Collections.singletonList("unico"); // 1 elemento, immutabile
        Set<String>   setSingle   = Collections.singleton("unico");
        System.out.println(listaSingle);
    }


    // ──────────────────────────────────────────────────────────
    //  COLLECTORS  (java.util.stream.Collectors)
    //  Vedi anche I_Stream_OutStream.java per esempi completi.
    //  Qui un riepilogo dei Collector più usati.
    // ──────────────────────────────────────────────────────────
    static void demoCollectors() {

        List<String> nomi = List.of("Alice", "Bob", "Carol", "Anna", "Bruno", "Carlo");

        // ── RACCOLTA SEMPLICE ─────────────────────────────────
        List<String>     toList      = nomi.stream().collect(Collectors.toList());
        Set<String>      toSet       = nomi.stream().collect(Collectors.toSet());
        List<String>     toListImmut = nomi.stream().collect(Collectors.toUnmodifiableList());

        // ── JOINING ───────────────────────────────────────────
        String tutti   = nomi.stream().collect(Collectors.joining(", "));
        String formatt = nomi.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(tutti);    // Alice, Bob, Carol, Anna, Bruno, Carlo
        System.out.println(formatt);  // [Alice, Bob, Carol, Anna, Bruno, Carlo]

        // ── CONTEGGIO, MEDIA, SOMMA ───────────────────────────
        long count  = nomi.stream().collect(Collectors.counting());
        Double avg  = nomi.stream().collect(Collectors.averagingInt(String::length));
        int   sum   = nomi.stream().collect(Collectors.summingInt(String::length));
        System.out.println("Count: " + count + "  Avg: " + avg + "  Sum: " + sum);

        // ── GROUPINGBY ────────────────────────────────────────
        // Per iniziale del nome
        Map<Character, List<String>> perIniziale = nomi.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0)));
        perIniziale.forEach((k, v) -> System.out.println(k + " → " + v));
        // A → [Alice, Anna]
        // B → [Bob, Bruno]
        // C → [Carol, Carlo]

        // Con downstream collector: conta per iniziale
        Map<Character, Long> conteggioPerIniziale = nomi.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        System.out.println(conteggioPerIniziale);  // {A=2, B=2, C=2}

        // Con TreeMap per ordine delle chiavi
        Map<Character, Long> ordinato = nomi.stream()
            .collect(Collectors.groupingBy(
                s -> s.charAt(0),
                TreeMap::new,
                Collectors.counting()
            ));
        System.out.println(ordinato);

        // ── PARTITIONINGBY ────────────────────────────────────
        Map<Boolean, List<String>> partizione = nomi.stream()
            .collect(Collectors.partitioningBy(s -> s.length() > 4));
        System.out.println("Lunghi (>4): "  + partizione.get(true));   // [Alice, Carol, Bruno, Carlo]
        System.out.println("Corti (<=4): " + partizione.get(false));  // [Bob, Anna]

        // ── TOMAP ────────────────────────────────────────────
        Map<String, Integer> nome2Lunghezza = nomi.stream()
            .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(nome2Lunghezza);

        // ── SUMMARIZING ──────────────────────────────────────
        IntSummaryStatistics stats = nomi.stream()
            .collect(Collectors.summarizingInt(String::length));
        System.out.println("Min: " + stats.getMin() + " Max: " + stats.getMax());

        // ── COLLECTINGANDTHEN ─────────────────────────────────
        // Applica una trasformazione al risultato finale del collector
        List<String> listaImmutabile = nomi.stream()
            .filter(s -> s.startsWith("A"))
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                Collections::unmodifiableList  // rende immutabile il risultato
            ));
        System.out.println(listaImmutabile);  // [Alice, Anna]

        // ── TEEING (Java 12+) ─────────────────────────────────
        // Applica due collector e combina i risultati con una funzione
        record Statistiche(long count, double media) {}
        Statistiche s = nomi.stream()
            .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.averagingInt(String::length),
                (c, a) -> new Statistiche(c, a)
            ));
        System.out.println("Teeing: count=" + s.count() + " media=" + s.media());
    }
}
