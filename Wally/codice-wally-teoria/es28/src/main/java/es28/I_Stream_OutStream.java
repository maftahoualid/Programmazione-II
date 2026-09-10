package es28;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/*
 * ============================================================
 *  I — USCIRE DALLO STREAM  (.collect e altri terminali)
 * ============================================================
 *
 *  .collect(Collector) è l'operazione terminale più potente e flessibile.
 *  Il parametro è un Collector, che puoi ottenere tramite:
 *  • Collectors.toList()         → java.util.List (Java 8+)
 *  • .toList()                   → List immutabile (Java 16+, più conciso)
 *  • Collectors.toUnmodifiableList()  → List immutabile (Java 10+)
 *  • Collectors.toSet()
 *  • Collectors.toCollection(costruttore)
 *  • Collectors.toMap(keyFn, valueFn)
 *  • Collectors.groupingBy(classificatore)
 *  • Collectors.partitioningBy(predicato)
 *  • Collectors.joining(sep, prefix, suffix)
 *  • Collectors.counting()
 *  • Collectors.summarizingInt/Long/Double()
 *  • Collectors.toUnmodifiableMap/Set/List()
 * ============================================================
 */
public class I_Stream_OutStream {

    record Studente(String nome, int voto, String classe) {}

    public static void demo() {

        Stream<String> frutta = Stream.of("mela", "pera", "banana", "mela", "uva");

        // ── A. IN UNA LISTA ───────────────────────────────────

        // A1. Java 16+ — .toList() direttamente sullo stream
        //     Restituisce una List IMMUTABILE (come List.of)
        List<String> listaModerna = Stream.of("a","b","c").toList();

        // A2. Java 10+ — Collectors.toUnmodifiableList()
        List<String> immutabile = Stream.of("a","b","c")
            .collect(Collectors.toUnmodifiableList());

        // A3. Java 8+  — Collectors.toList() (implementazione può variare)
        List<String> classica = Stream.of("a","b","c")
            .collect(Collectors.toList());

        // A4. ArrayList specifica (quando ti serve proprio ArrayList)
        ArrayList<String> arrayList = Stream.of("a","b","c")
            .collect(Collectors.toCollection(ArrayList::new));


        // ── B. IN UN INSIEME (Set) ────────────────────────────
        // Rimuove automaticamente i duplicati
        Set<String> set = Stream.of("mela", "pera", "banana", "mela")
            .collect(Collectors.toSet());
        System.out.println(set);  // {mela, pera, banana}  (ordine variabile)

        // Collezione specifica: TreeSet (ordinato)
        TreeSet<String> treeSet = Stream.of("mela", "pera", "banana", "mela")
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);  // [banana, mela, pera]

        // LinkedHashSet (ordine di inserimento, no duplicati)
        LinkedHashSet<String> linkedSet = Stream.of("mela", "pera", "banana", "mela")
            .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(linkedSet);  // [mela, pera, banana]


        // ── C. IN UN ARRAY ────────────────────────────────────
        String[] array = Stream.of("a","b","c")
            .toArray(String[]::new);   // Method reference del costruttore
        System.out.println(Arrays.toString(array));  // [a, b, c]

        // Array di Object (senza specificare il tipo)
        Object[] objArr = Stream.of("a","b","c").toArray();


        // ── D. IN UNA MAPPA ───────────────────────────────────

        // D1. Chiave = la parola stessa, Valore = lunghezza
        Map<String, Integer> parola2Lunghezza = Stream.of("mela", "pera", "banana")
            .collect(Collectors.toMap(
                Function.identity(),  // chiave = l'elemento stesso
                String::length        // valore = lunghezza
            ));
        System.out.println(parola2Lunghezza);  // {mela=4, pera=4, banana=6}

        // D2. Gestire duplicati nelle chiavi con mergeFunction
        //     Senza mergeFunction, una chiave duplicata lancia IllegalStateException!
        Map<Integer, String> lunghezza2Parola = Stream.of("mela", "pera", "banana")
            .collect(Collectors.toMap(
                String::length,                  // chiave = lunghezza
                Function.identity(),             // valore = parola
                (existing, newVal) -> existing + "," + newVal  // in caso di duplicato
            ));
        System.out.println(lunghezza2Parola);  // {4=mela,pera, 6=banana}

        // D3. Specificare l'implementazione della mappa
        TreeMap<String, Integer> treeMap = Stream.of("mela", "pera", "banana")
            .collect(Collectors.toMap(
                Function.identity(),
                String::length,
                (e1, e2) -> e1,   // merge function (non serviva, ma obbligatoria se specifichi la mappa)
                TreeMap::new      // costruttore della mappa
            ));
        System.out.println(treeMap);  // {banana=6, mela=4, pera=4}


        // ── E. GROUPINGBY — raggruppa per chiave ──────────────
        List<Studente> studenti = List.of(
            new Studente("Alice",  92, "A"),
            new Studente("Bob",    75, "B"),
            new Studente("Carol",  88, "A"),
            new Studente("Diana",  60, "B"),
            new Studente("Eve",    95, "A")
        );

        // E1. Raggruppamento semplice: classe → lista di studenti
        Map<String, List<Studente>> perClasse = studenti.stream()
            .collect(Collectors.groupingBy(Studente::classe));
        perClasse.forEach((cl, lista) ->
            System.out.println("Classe " + cl + ": " + lista.stream().map(Studente::nome).toList())
        );
        // Classe A: [Alice, Carol, Eve]
        // Classe B: [Bob, Diana]

        // E2. groupingBy + downstream collector (conta gli studenti per classe)
        Map<String, Long> conteggioPerClasse = studenti.stream()
            .collect(Collectors.groupingBy(Studente::classe, Collectors.counting()));
        System.out.println(conteggioPerClasse);  // {A=3, B=2}

        // E3. groupingBy + averaging
        Map<String, Double> mediaPerClasse = studenti.stream()
            .collect(Collectors.groupingBy(Studente::classe,
                Collectors.averagingInt(Studente::voto)));
        System.out.println(mediaPerClasse);  // {A=91.66..., B=67.5}

        // E4. groupingBy + mapping (solo i nomi)
        Map<String, List<String>> nomiPerClasse = studenti.stream()
            .collect(Collectors.groupingBy(Studente::classe,
                Collectors.mapping(Studente::nome, Collectors.toList())));
        System.out.println(nomiPerClasse);


        // ── F. PARTITIONINGBY — divide in true/false ──────────
        Map<Boolean, List<Studente>> promossiVsRimandati = studenti.stream()
            .collect(Collectors.partitioningBy(s -> s.voto() >= 80));

        System.out.println("Promossi: " +
            promossiVsRimandati.get(true).stream().map(Studente::nome).toList());
        System.out.println("Rimandati: " +
            promossiVsRimandati.get(false).stream().map(Studente::nome).toList());


        // ── G. JOINING — concatenazione di stringhe ───────────
        String nomiConcatenati = studenti.stream()
            .map(Studente::nome)
            .collect(Collectors.joining(", "));
        System.out.println(nomiConcatenati);  // Alice, Bob, Carol, Diana, Eve

        String conPrefisso = studenti.stream()
            .map(Studente::nome)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(conPrefisso);  // [Alice, Bob, Carol, Diana, Eve]


        // ── H. STATISTICHE CON summarizingInt ────────────────
        IntSummaryStatistics stats = studenti.stream()
            .collect(Collectors.summarizingInt(Studente::voto));
        System.out.println("Min: " + stats.getMin());   // 60
        System.out.println("Max: " + stats.getMax());   // 95
        System.out.println("Avg: " + stats.getAverage()); // ~82
        System.out.println("Sum: " + stats.getSum());     // 410
        System.out.println("Count: " + stats.getCount()); // 5

        // Equivalente diretto su IntStream (più efficiente)
        IntSummaryStatistics stats2 = studenti.stream()
            .mapToInt(Studente::voto)
            .summaryStatistics();
        System.out.println("Max (primitivo): " + stats2.getMax());
    }
}
