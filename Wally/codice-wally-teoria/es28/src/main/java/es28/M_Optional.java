package es28;

import java.util.*;
import java.util.stream.*;

/*
 * ============================================================
 *  M — Optional<T>
 * ============================================================
 *
 *  Optional è un "contenitore" che può o non può contenere un valore.
 *  Il suo scopo è ELIMINARE il NullPointerException costringendoti
 *  a gestire esplicitamente l'assenza di un valore.
 *
 *  QUANDO USARLO:
 *  ✅ Come tipo di ritorno di metodi che potrebbero non trovare un risultato
 *  ✅ Come risultato di operazioni terminali su stream (findFirst, min, max, reduce)
 *  ❌ NON usarlo come campo di una classe
 *  ❌ NON usarlo come parametro di metodo
 *  ❌ NON chiamare mai .get() senza prima controllare .isPresent()!
 *
 *  METODI PRINCIPALI:
 *  ┌──────────────────────────────┬──────────────────────────────────────┐
 *  │ Creazione                    │ of(v)  ofNullable(v)  empty()        │
 *  │ Controllo                    │ isPresent()  isEmpty() (J11+)        │
 *  │ Estrazione sicura            │ orElse()  orElseGet()  orElseThrow() │
 *  │ Trasformazione               │ map()  flatMap()  filter()           │
 *  │ Azione se presente           │ ifPresent()  ifPresentOrElse() (J9+)│
 *  │ Stream                       │ stream() (J9+)                       │
 *  └──────────────────────────────┴──────────────────────────────────────┘
 * ============================================================
 */
public class M_Optional {

    // Metodo di esempio che potrebbe non trovare nulla
    static Optional<String> cercaEmail(String nome, Map<String, String> rubrica) {
        return Optional.ofNullable(rubrica.get(nome));
    }

    public static void demo() {

        Map<String, String> rubrica = Map.of(
            "Alice", "alice@example.com",
            "Bob",   "bob@example.com"
        );


        // ── A. CREAZIONE ──────────────────────────────────────

        // of()          — lancia NullPointerException se il valore è null
        Optional<String> pieno = Optional.of("Java");

        // ofNullable()  — gestisce sia null che non-null
        Optional<String> forse = Optional.ofNullable(rubrica.get("Alice")); // presente
        Optional<String> vuoto = Optional.ofNullable(rubrica.get("Ines"));  // assente

        // empty()       — Optional esplicitamente vuoto
        Optional<String> esplicVuoto = Optional.empty();

        System.out.println(forse);       // Optional[alice@example.com]
        System.out.println(vuoto);       // Optional.empty
        System.out.println(esplicVuoto); // Optional.empty


        // ── B. VERIFICA ───────────────────────────────────────
        System.out.println(forse.isPresent()); // true
        System.out.println(vuoto.isPresent()); // false
        System.out.println(vuoto.isEmpty());   // true  (Java 11+)


        // ── C. ESTRAZIONE DEL VALORE ──────────────────────────

        // get() — DA EVITARE se non si è certi che il valore ci sia
        // Lancia NoSuchElementException se vuoto
        if (forse.isPresent()) {
            System.out.println(forse.get()); // alice@example.com
        }

        // orElse(default) — valore di default se vuoto (il default viene SEMPRE calcolato)
        String email1 = vuoto.orElse("sconosciuto@example.com");
        System.out.println(email1);  // sconosciuto@example.com

        // orElseGet(Supplier) — il default viene calcolato SOLO se il valore è assente
        // Preferisci questa quando il default è costoso da calcolare
        String email2 = vuoto.orElseGet(() -> "default@" + System.currentTimeMillis() + ".com");
        System.out.println(email2);

        // orElseThrow() — lancia NoSuchElementException se vuoto (Java 10+)
        try {
            String email3 = vuoto.orElseThrow();  // lancia eccezione
        } catch (NoSuchElementException e) {
            System.out.println("Valore assente: " + e.getMessage());
        }

        // orElseThrow(Supplier<Exception>) — eccezione personalizzata
        try {
            String email4 = vuoto.orElseThrow(
                () -> new IllegalArgumentException("Utente non trovato nella rubrica")
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        // ── D. AZIONI SE PRESENTE ─────────────────────────────

        // ifPresent(Consumer) — esegue l'azione solo se il valore c'è
        forse.ifPresent(e -> System.out.println("Email trovata: " + e));
        vuoto.ifPresent(e -> System.out.println("Questo non stampa"));

        // ifPresentOrElse(Consumer, Runnable) — Java 9+
        forse.ifPresentOrElse(
            e -> System.out.println("Email: " + e),
            ()  -> System.out.println("Nessuna email")
        );
        vuoto.ifPresentOrElse(
            e -> System.out.println("Email: " + e),
            ()  -> System.out.println("Nessuna email")
        );


        // ── E. TRASFORMAZIONE ─────────────────────────────────

        // map(Function) — trasforma il valore se presente (propagates emptiness)
        Optional<Integer> lunghezza = forse.map(String::length);
        System.out.println(lunghezza);           // OptionalInt[22]

        Optional<Integer> vuotaLunghezza = vuoto.map(String::length);
        System.out.println(vuotaLunghezza);      // Optional.empty

        // filter(Predicate) — svuota l'Optional se il predicato è falso
        Optional<String> emailLunga = forse.filter(e -> e.length() > 10);
        System.out.println(emailLunga.isPresent());  // true (22 > 10)

        Optional<String> emailCourta = forse.filter(e -> e.length() > 50);
        System.out.println(emailCourta.isPresent()); // false

        // flatMap — come map ma il Function ritorna già un Optional
        //           evita Optional<Optional<String>>
        Optional<String> mappata = forse.flatMap(e ->
            e.contains("@") ? Optional.of(e.split("@")[1]) : Optional.empty()
        );
        System.out.println(mappata);  // Optional[example.com]

        // or(Supplier<Optional>) — Java 9+ — alternativa se vuoto
        Optional<String> risultato = vuoto.or(() -> Optional.of("fallback@example.com"));
        System.out.println(risultato);  // Optional[fallback@example.com]


        // ── F. OPTIONAL E STREAM ──────────────────────────────

        // stream() — Java 9+ — converte in Stream<T> con 0 o 1 elemento
        //            Utile per comporre con flatMap sulle stream
        long count = forse.stream().count();    // 1
        long count2 = vuoto.stream().count();   // 0
        System.out.println(count + " " + count2);

        // Caso pratico: filtrare Optional in una lista
        List<Optional<String>> listaOptional = List.of(
            Optional.of("Alice"),
            Optional.empty(),
            Optional.of("Bob"),
            Optional.empty(),
            Optional.of("Carol")
        );
        // Estrarre solo i valori presenti
        List<String> soloPresenti = listaOptional.stream()
            .flatMap(Optional::stream)  // Java 9+: ogni Optional → 0 o 1 elemento
            .collect(Collectors.toList());
        System.out.println(soloPresenti);  // [Alice, Bob, Carol]

        // Alternativa Java 8:
        List<String> soloPresenti8 = listaOptional.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
        System.out.println(soloPresenti8);  // [Alice, Bob, Carol]


        // ── G. OPTIONAL NELLE STREAM PIPELINE ────────────────
        List<String> nomi = List.of("Alice", "Bob", "Charlie");

        // findFirst() / findAny() → Optional
        Optional<String> primoLungo = nomi.stream()
            .filter(n -> n.length() > 4)
            .findFirst();
        System.out.println(primoLungo.orElse("nessuno"));  // Alice (len 5)

        // min() / max() → Optional
        Optional<String> minNome = nomi.stream()
            .min(Comparator.comparingInt(String::length));
        System.out.println(minNome.orElse("?"));  // Bob

        // reduce() senza identità → Optional
        Optional<Integer> somma = Stream.of(1, 2, 3, 4, 5)
            .reduce(Integer::sum);
        System.out.println(somma.orElse(0));  // 15
    }
}
