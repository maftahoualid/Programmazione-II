package es28;

import java.util.*;
import java.util.stream.Collectors;

/*
 * ============================================================
 *  C — LIST  (collezioni ORDINATE, ammettono DUPLICATI)
 * ============================================================
 *
 *  Implementazioni principali:
 *  ┌─────────────────┬───────────────────────────────────────────────────┐
 *  │ ArrayList       │ Basata su array dinamico. get O(1), add-inmezzo   │
 *  │                 │ O(n). La scelta DEFAULT per quasi tutto.           │
 *  ├─────────────────┼───────────────────────────────────────────────────┤
 *  │ LinkedList      │ Lista doppiamente concatenata. add/remove in testa │
 *  │                 │ O(1), get tramite indice O(n). Usala come Deque.  │
 *  ├─────────────────┼───────────────────────────────────────────────────┤
 *  │ Vector / Stack  │ Legacy, sincronizzati. Usa ArrayList + Deque.     │
 *  └─────────────────┴───────────────────────────────────────────────────┘
 *
 *  Interfaccia: java.util.List<E>
 *  Estende:     Collection<E>  →  Iterable<E>
 * ============================================================
 */
public class C_Strutture_List {

    public static void demo() {

        // ── A. CREAZIONE ──────────────────────────────────────

        // A1. Vuota e MODIFICABILE (caso classico, uso più comune)
        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("Kotlin");

        // A2. IMMUTABILE — Java 9+ (non puoi add/remove/set → UnsupportedOperationException)
        List<String> immutabile = List.of("A", "B", "C");

        // A3. Da valori esistenti — dimensione FISSA (puoi .set() ma non .add()/.remove())
        //     Nota: Arrays.asList restituisce una List backed dall'array originale
        List<String> fissa = Arrays.asList("X", "Y", "Z");

        // A4. Da valori esistenti, MODIFICABILE (il modo più pulito)
        List<String> modificabile = new ArrayList<>(List.of("A", "B", "C"));

        // A5. LinkedList (stessa API di ArrayList + Deque)
        List<String> linked = new LinkedList<>(List.of("uno", "due", "tre"));

        // A6. Inizializzazione anonima con doppia graffa (sconsigliata, crea sottoclasse)
        //     Usata in vecchio codice, da conoscere ma NON usare
        List<String> vecchiaScuola = new ArrayList<>() {{
            add("Uno"); add("Due");
        }};


        // ── B. METODI PRINCIPALI ──────────────────────────────
        List<String> l = new ArrayList<>(List.of("mela", "pera", "banana", "mela"));

        // Lettura
        System.out.println(l.get(0));          // "mela"
        System.out.println(l.size());          // 4
        System.out.println(l.isEmpty());       // false
        System.out.println(l.contains("pera")); // true
        System.out.println(l.indexOf("mela")); // 0  (prima occorrenza)
        System.out.println(l.lastIndexOf("mela")); // 3

        // Modifica
        l.add("ciliegia");               // aggiunge in coda
        l.add(1, "uva");                 // aggiunge all'indice 1
        l.set(0, "MELA");               // sostituisce all'indice 0
        l.remove(0);                     // rimuove per indice
        l.remove("banana");              // rimuove per valore (prima occorrenza)
        System.out.println(l);           // [uva, pera, mela, ciliegia]

        // Ricerca
        System.out.println(l.indexOf("pera")); // 1

        // Sottolista (vista — modifiche si propagano alla lista originale!)
        List<String> sub = l.subList(0, 2);
        System.out.println(sub);  // [uva, pera]

        // Pulizia e controllo
        List<String> copia = new ArrayList<>(l);
        copia.clear();
        System.out.println(copia.isEmpty());  // true

        // ── C. ITERAZIONE ─────────────────────────────────────
        List<Integer> numeri = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        // C1. for classico con indice (quando serve l'indice)
        for (int i = 0; i < numeri.size(); i++) {
            System.out.print(numeri.get(i) + " ");
        }
        System.out.println();

        // C2. for-each (il più comune)
        for (int n : numeri) {
            System.out.print(n + " ");
        }
        System.out.println();

        // C3. forEach con lambda
        numeri.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // C4. Iterator (utile per rimuovere durante l'iterazione senza ConcurrentModificationException)
        Iterator<Integer> it = numeri.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val == 20) it.remove();  // rimozione sicura
        }
        System.out.println(numeri);  // [10, 30, 40, 50]


        // ── D. ORDINAMENTO ────────────────────────────────────
        List<String> frutta = new ArrayList<>(List.of("banana", "mela", "uva", "pera"));

        // D1. Ordine naturale (alfabetico per String, numerico per Number)
        Collections.sort(frutta);              // vecchio stile
        frutta.sort(Comparator.naturalOrder()); // stile moderno, equivalente

        // D2. Ordine inverso
        frutta.sort(Comparator.reverseOrder());

        // D3. Comparator personalizzato (per lunghezza della stringa)
        frutta.sort(Comparator.comparingInt(String::length));
        System.out.println(frutta);  // [uva, mela, pera, banana]

        // D4. Comparator a cascata (prima per lunghezza, poi alfabetico)
        frutta.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(frutta);


        // ── E. OPERAZIONI BULK ────────────────────────────────
        List<String> base = new ArrayList<>(List.of("a", "b", "c"));
        List<String> extra = List.of("d", "e");

        base.addAll(extra);                // aggiunge tutti
        System.out.println(base);          // [a, b, c, d, e]
        base.removeAll(List.of("a", "c")); // rimuove tutti quelli in comune
        System.out.println(base);          // [b, d, e]
        base.retainAll(List.of("b", "e")); // mantiene solo quelli in comune
        System.out.println(base);          // [b, e]

        // replaceAll — sostituisce ogni elemento con il risultato della funzione
        List<String> nomi = new ArrayList<>(List.of("mario", "luigi", "wally"));
        nomi.replaceAll(String::toUpperCase);
        System.out.println(nomi);  // [MARIO, LUIGI, WALLY]

        // removeIf — rimuove tutti gli elementi che soddisfano il predicato
        nomi.removeIf(n -> n.startsWith("M"));
        System.out.println(nomi);  // [LUIGI, WALLY]


        // ── F. CONVERSIONI ────────────────────────────────────
        // List → Array
        String[] arr = nomi.toArray(String[]::new);   // Java 11+
        System.out.println(Arrays.toString(arr));

        // List → Set (rimuove duplicati)
        List<String> conDup = new ArrayList<>(List.of("a","b","a","c"));
        Set<String> senzaDup = new HashSet<>(conDup);
        System.out.println(senzaDup);  // [a, b, c] (ordine variabile)

        // List → Stream e viceversa
        List<String> filtrata = conDup.stream()
            .filter(s -> !s.equals("a"))
            .collect(Collectors.toList());
        System.out.println(filtrata);  // [b, c]


        // ── G. THREAD-SAFETY ──────────────────────────────────
        // ArrayList NON è thread-safe. Alternative:
        // - Collections.synchronizedList(new ArrayList<>())
        // - java.util.concurrent.CopyOnWriteArrayList (lettura senza lock)
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        // Usa synchronized(syncList) { ... } quando itero!
    }
}
