package es28;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/*
 * ============================================================
 *  H — OPERAZIONI SULLO STREAM
 * ============================================================
 *
 *  Due categorie:
 *
 *  1. INTERMEDIE (lazy) — restituiscono uno Stream, non eseguono nulla
 *     da sole. Vengono eseguite solo quando c'è un'operazione terminale.
 *     ┌──────────────────────────┬──────────────────────────────────────┐
 *     │ .filter(Predicate)       │ filtra elementi che soddisfano cond. │
 *     │ .map(Function)           │ trasforma ogni elemento              │
 *     │ .flatMap(Function)       │ appiattisce stream di stream         │
 *     │ .mapToInt/Long/Double    │ trasforma in stream primitivo        │
 *     │ .sorted()                │ ordina (naturale o con Comparator)   │
 *     │ .distinct()              │ rimuove duplicati (usa equals)       │
 *     │ .limit(n)                │ tronca allo stream ai primi n elem.  │
 *     │ .skip(n)                 │ salta i primi n elementi             │
 *     │ .peek(Consumer)          │ azione intermedia (debug)            │
 *     │ .takeWhile(Predicate)    │ prende finché il pred. è true (J9+)  │
 *     │ .dropWhile(Predicate)    │ salta finché il pred. è true (J9+)   │
 *     └──────────────────────────┴──────────────────────────────────────┘
 *
 *  2. TERMINALI (eager) — consumano lo stream e producono un risultato.
 *     ┌──────────────────────────┬──────────────────────────────────────┐
 *     │ .collect(Collector)      │ accumula in struttura dati           │
 *     │ .forEach(Consumer)       │ azione su ogni elemento (void)       │
 *     │ .count()                 │ numero di elementi                   │
 *     │ .findFirst()             │ primo elemento (Optional)            │
 *     │ .findAny()               │ qualsiasi elemento (parallel-safe)   │
 *     │ .min(Comparator)         │ elemento minimo (Optional)           │
 *     │ .max(Comparator)         │ elemento massimo (Optional)          │
 *     │ .anyMatch(Predicate)     │ true se almeno uno soddisfa          │
 *     │ .allMatch(Predicate)     │ true se TUTTI soddisfano             │
 *     │ .noneMatch(Predicate)    │ true se NESSUNO soddisfa             │
 *     │ .reduce(BinaryOperator)  │ riduce a un singolo valore           │
 *     │ .toArray()               │ raccoglie in array                   │
 *     └──────────────────────────┴──────────────────────────────────────┘
 * ============================================================
 */
public class H_Stream_Operazioni {

    record Studente(String nome, int voto, String classe) {}

    public static void demo() {

        List<Studente> studenti = List.of(
            new Studente("Alice",  92, "A"),
            new Studente("Bob",    75, "B"),
            new Studente("Carol",  88, "A"),
            new Studente("Diana",  60, "B"),
            new Studente("Eve",    95, "A"),
            new Studente("Frank",  75, "C"),
            new Studente("Grace",  82, "B")
        );

        // ── OPERAZIONI INTERMEDIE ─────────────────────────────

        // filter — mantieni solo gli elementi che soddisfano il predicato
        List<String> promossi = studenti.stream()
            .filter(s -> s.voto() >= 80)
            .map(Studente::nome)
            .collect(Collectors.toList());
        System.out.println("Promossi: " + promossi);
        // [Alice, Carol, Eve, Grace]

        // map — trasforma ogni elemento in un altro tipo
        List<String> nomeLunghezza = studenti.stream()
            .map(s -> s.nome() + "(" + s.voto() + ")")
            .collect(Collectors.toList());
        System.out.println(nomeLunghezza);

        // sorted — ordine naturale o con Comparator
        List<Studente> perVotoDesc = studenti.stream()
            .sorted(Comparator.comparingInt(Studente::voto).reversed())
            .collect(Collectors.toList());
        perVotoDesc.forEach(s -> System.out.print(s.nome() + " "));
        System.out.println();  // Eve Alice Carol Grace Bob Frank Diana

        // distinct — rimuove duplicati (usa equals/hashCode)
        List<Integer> votiDistinti = studenti.stream()
            .map(Studente::voto)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Voti distinti: " + votiDistinti);

        // limit e skip — paginazione
        List<String> pagina1 = studenti.stream()
            .map(Studente::nome)
            .skip(0).limit(3)
            .collect(Collectors.toList());
        List<String> pagina2 = studenti.stream()
            .map(Studente::nome)
            .skip(3).limit(3)
            .collect(Collectors.toList());
        System.out.println("Pagina1: " + pagina1);
        System.out.println("Pagina2: " + pagina2);

        // peek — azione intermedia per il debug (NON modificare la sorgente!)
        long n = studenti.stream()
            .filter(s -> s.voto() >= 90)
            .peek(s -> System.out.println("  DEBUG: " + s.nome()))
            .count();
        System.out.println("Studenti con voto >= 90: " + n);

        // flatMap — appiattisce stream di stream
        List<List<Integer>> matriceList = List.of(
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9)
        );
        List<Integer> flat = matriceList.stream()
            .flatMap(Collection::stream)   // ogni List<Integer> → Stream<Integer>
            .collect(Collectors.toList());
        System.out.println("flatMap: " + flat);  // [1,2,3,4,5,6,7,8,9]

        // Caso comune: dividere frasi in parole
        List<String> frasi = List.of("ciao mondo", "hello world", "hola mundo");
        List<String> tutteLeParole = frasi.stream()
            .flatMap(frase -> Arrays.stream(frase.split(" ")))
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Parole: " + tutteLeParole);

        // mapToInt — converte in IntStream (più efficiente con primitivi)
        int sommaVoti = studenti.stream()
            .mapToInt(Studente::voto)
            .sum();
        System.out.println("Somma voti: " + sommaVoti);

        // takeWhile / dropWhile — Java 9+
        // (funzionano bene su stream ordinati)
        List<Integer> numeri = List.of(2, 4, 6, 7, 8, 10);

        List<Integer> primaPariDiSpezzata = numeri.stream()
            .takeWhile(n2 -> n2 % 2 == 0) // prende finché sono pari → si ferma a 7
            .collect(Collectors.toList());
        System.out.println("takeWhile: " + primaPariDiSpezzata);  // [2, 4, 6]

        List<Integer> dopoSpezzata = numeri.stream()
            .dropWhile(n2 -> n2 % 2 == 0) // salta finché sono pari → parte da 7
            .collect(Collectors.toList());
        System.out.println("dropWhile: " + dopoSpezzata);  // [7, 8, 10]


        // ── OPERAZIONI TERMINALI ──────────────────────────────

        // count
        long countPromossi = studenti.stream()
            .filter(s -> s.voto() >= 80)
            .count();
        System.out.println("Count promossi: " + countPromossi);  // 4

        // findFirst / findAny (ritornano Optional)
        Optional<Studente> primo = studenti.stream()
            .filter(s -> s.classe().equals("B"))
            .findFirst();
        primo.ifPresent(s -> System.out.println("Primo di B: " + s.nome()));  // Bob

        // min / max
        Optional<Studente> migliore = studenti.stream()
            .max(Comparator.comparingInt(Studente::voto));
        System.out.println("Migliore: " + migliore.map(Studente::nome).orElse("nessuno"));  // Eve

        // anyMatch / allMatch / noneMatch
        boolean alcuniEccellenti = studenti.stream().anyMatch(s -> s.voto() >= 90);
        boolean tuttiPromossi    = studenti.stream().allMatch(s -> s.voto() >= 60);
        boolean nessunoNeg       = studenti.stream().noneMatch(s -> s.voto() < 0);
        System.out.println(alcuniEccellenti + " " + tuttiPromossi + " " + nessunoNeg);
        // true true true

        // reduce — riduzione a un singolo valore
        // Forma 1: senza identità → Optional (stream potrebbe essere vuoto)
        Optional<Integer> somma1 = studenti.stream()
            .map(Studente::voto)
            .reduce((a, b) -> a + b);

        // Forma 2: con identità → valore diretto (non Optional)
        int somma2 = studenti.stream()
            .map(Studente::voto)
            .reduce(0, Integer::sum);
        System.out.println("Somma voti (reduce): " + somma2);

        // Prodotto
        int prodotto = Stream.of(1, 2, 3, 4, 5).reduce(1, (a, b) -> a * b);
        System.out.println("Prodotto: " + prodotto);  // 120

        // forEach (attenzione: non garantisce l'ordine con parallelStream)
        studenti.stream()
            .filter(s -> s.voto() >= 90)
            .map(Studente::nome)
            .forEach(nome -> System.out.print(nome + " "));
        System.out.println();

        // forEachOrdered (garantisce l'ordine anche con parallelStream)
        studenti.parallelStream()
            .map(Studente::nome)
            .forEachOrdered(nome -> System.out.print(nome + " "));
        System.out.println();
    }
}
