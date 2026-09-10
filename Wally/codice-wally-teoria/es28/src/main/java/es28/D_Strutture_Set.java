package es28;

import java.util.*;
import java.util.stream.Collectors;

/*
 * ============================================================
 *  D — SET  (collezioni di elementi UNICI, NO duplicati)
 * ============================================================
 *
 *  Implementazioni principali:
 *  ┌───────────────────┬─────────────────────────────────────────────────┐
 *  │ HashSet           │ Usa hashing. O(1) per add/remove/contains.      │
 *  │                   │ Nessun ordine garantito.                         │
 *  ├───────────────────┼─────────────────────────────────────────────────┤
 *  │ LinkedHashSet     │ Come HashSet + mantiene l'ordine di inserimento. │
 *  │                   │ Costo leggermente maggiore per la linked list.   │
 *  ├───────────────────┼─────────────────────────────────────────────────┤
 *  │ TreeSet           │ Albero Red-Black. O(log n). Ordine naturale o   │
 *  │                   │ tramite Comparator. Implementa anche NavigableSet│
 *  └───────────────────┴─────────────────────────────────────────────────┘
 *
 *  REGOLA D'ORO per HashSet/LinkedHashSet:
 *  Se usi oggetti personalizzati devi implementare ENTRAMBI
 *  hashCode() e equals() — altrimenti i duplicati non vengono rilevati.
 *
 *  Interfaccia: java.util.Set<E>
 *  Estende:     Collection<E>
 * ============================================================
 */
public class D_Strutture_Set {

    public static void demo() {

        // ── A. CREAZIONE ──────────────────────────────────────

        // A1. HashSet vuoto e modificabile
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Mela");
        hashSet.add("Pera");
        hashSet.add("Mela");    // duplicato → ignorato silenziosamente
        System.out.println(hashSet.size());  // 2

        // A2. IMMUTABILE — Java 9+ (lancia IllegalArgumentException se metti duplicati!)
        Set<String> immutabile = Set.of("A", "B", "C");
        // Set.of("A", "A")  →  IllegalArgumentException a runtime!

        // A3. Da valori esistenti, MODIFICABILE
        Set<String> daLista = new HashSet<>(Arrays.asList("X", "Y", "Z", "X")); // "X" una sola volta
        System.out.println(daLista);  // [X, Y, Z] (ordine variabile)

        // A4. LinkedHashSet — mantiene ordine di inserimento
        Set<String> linked = new LinkedHashSet<>(List.of("Banana", "Mela", "Uva"));
        System.out.println(linked);  // [Banana, Mela, Uva]  ← ordine garantito

        // A5. TreeSet — ordine naturale (alfabetico per String)
        Set<String> tree = new TreeSet<>(List.of("Z", "A", "M", "B"));
        System.out.println(tree);  // [A, B, M, Z]  ← sempre ordinato

        // A6. TreeSet con Comparator personalizzato (ordine per lunghezza)
        Set<String> treePerLunghezza = new TreeSet<>(
            Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
        );
        treePerLunghezza.addAll(List.of("banana", "mela", "uva", "pera"));
        System.out.println(treePerLunghezza);  // [uva, mela, pera, banana]


        // ── B. METODI PRINCIPALI ──────────────────────────────
        Set<String> s = new HashSet<>(List.of("alpha", "beta", "gamma"));

        // Scrittura
        boolean aggiunto = s.add("delta");    // true se aggiunto, false se era già presente
        boolean nonAggiunto = s.add("alpha"); // false — già presente
        s.remove("beta");                     // rimuove (se presente)
        System.out.println(aggiunto);         // true
        System.out.println(nonAggiunto);      // false

        // Lettura
        System.out.println(s.contains("alpha")); // true
        System.out.println(s.size());            // 3
        System.out.println(s.isEmpty());         // false

        // I Set NON hanno .get(index) — non c'è accesso per indice!


        // ── C. OPERAZIONI INSIEMISTICHE ───────────────────────
        Set<Integer> A = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> B = new HashSet<>(Set.of(3, 4, 5, 6));

        // UNIONE: A ∪ B
        Set<Integer> unione = new HashSet<>(A);
        unione.addAll(B);
        System.out.println(unione);  // [1, 2, 3, 4, 5, 6]

        // INTERSEZIONE: A ∩ B
        Set<Integer> intersezione = new HashSet<>(A);
        intersezione.retainAll(B);
        System.out.println(intersezione);  // [3, 4]

        // DIFFERENZA: A \ B
        Set<Integer> differenza = new HashSet<>(A);
        differenza.removeAll(B);
        System.out.println(differenza);  // [1, 2]

        // Sotto-insieme: A ⊆ B ?
        System.out.println(A.containsAll(B));  // false
        System.out.println(Set.of(3,4).stream().allMatch(B::contains));  // true


        // ── D. NAVIGAZIONE CON TreeSet (NavigableSet) ─────────
        TreeSet<Integer> nav = new TreeSet<>(List.of(10, 20, 30, 40, 50));

        System.out.println(nav.first());         // 10  (il minimo)
        System.out.println(nav.last());          // 50  (il massimo)
        System.out.println(nav.floor(25));       // 20  (≤ 25)
        System.out.println(nav.ceiling(25));     // 30  (≥ 25)
        System.out.println(nav.lower(20));       // 10  (strettamente < 20)
        System.out.println(nav.higher(20));      // 30  (strettamente > 20)

        // Sottoinsiemi (viste live — modifiche si propagano)
        System.out.println(nav.headSet(30));    // [10, 20]    (< 30)
        System.out.println(nav.tailSet(30));    // [30, 40, 50] (>= 30)
        System.out.println(nav.subSet(20, 40)); // [20, 30]    ([20, 40))

        // Iterazione inversa
        System.out.println(nav.descendingSet());  // [50, 40, 30, 20, 10]


        // ── E. ITERAZIONE ─────────────────────────────────────
        Set<String> frutti = new LinkedHashSet<>(List.of("mela", "pera", "uva"));

        // E1. for-each
        for (String f : frutti) System.out.print(f + " ");
        System.out.println();

        // E2. forEach con lambda
        frutti.forEach(f -> System.out.print(f + " "));
        System.out.println();

        // E3. Iterator (per rimuovere durante l'iterazione)
        Iterator<String> it = frutti.iterator();
        while (it.hasNext()) {
            if (it.next().equals("pera")) it.remove();
        }
        System.out.println(frutti);  // [mela, uva]


        // ── F. CONVERSIONI ────────────────────────────────────
        // Set → List (per avere l'accesso tramite indice)
        Set<String> set = new HashSet<>(Set.of("x","y","z"));
        List<String> lista = new ArrayList<>(set);
        System.out.println(lista.get(0)); // primo elemento (ordine non prevedibile!)

        // Set → Array
        String[] arr = set.toArray(String[]::new);

        // Rimozione duplicati da una List tramite Set
        List<String> conDuplicati = new ArrayList<>(List.of("a","b","a","c","b"));
        List<String> senzaDuplicati = conDuplicati.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println(senzaDuplicati);  // [a, b, c]

        // Alternativa: passaggio per LinkedHashSet (preserva ordine)
        List<String> senzaDup2 = new ArrayList<>(new LinkedHashSet<>(conDuplicati));
        System.out.println(senzaDup2);  // [a, b, c]
    }
}
