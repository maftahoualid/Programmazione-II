package es28;

import java.util.*;
import java.util.stream.Collectors;

/*
 * ============================================================
 *  F — MAP  (strutture CHIAVE → VALORE)
 * ============================================================
 *
 *  Le chiavi sono UNICHE. I valori possono essere duplicati.
 *  Map NON estende Collection.
 *
 *  ┌───────────────────┬──────────────────────────────────────────────────┐
 *  │ HashMap           │ Hashing. O(1) put/get. Nessun ordine chiavi.    │
 *  ├───────────────────┼──────────────────────────────────────────────────┤
 *  │ LinkedHashMap     │ Come HashMap + mantiene ordine di inserimento.   │
 *  ├───────────────────┼──────────────────────────────────────────────────┤
 *  │ TreeMap           │ Albero Red-Black. O(log n). Chiavi ordinate.     │
 *  │                   │ Implementa anche NavigableMap.                   │
 *  ├───────────────────┼──────────────────────────────────────────────────┤
 *  │ Hashtable         │ Legacy, sincronizzato. Da non usare.             │
 *  └───────────────────┴──────────────────────────────────────────────────┘
 *
 *  REGOLA D'ORO: le chiavi devono implementare hashCode() e equals()
 *  correttamente (String, Integer e i tipi wrapper lo fanno già).
 * ============================================================
 */
public class F_Strutture_Map {

    public static void demo() {

        // ── A. CREAZIONE ──────────────────────────────────────

        // A1. Vuota e MODIFICABILE
        Map<Integer, String> mappa = new HashMap<>();
        mappa.put(1, "Uno");
        mappa.put(2, "Due");
        mappa.put(3, "Tre");

        // A2. IMMUTABILE — fino a 10 coppie (Java 9+)
        Map<Integer, String> immutabile = Map.of(1, "Uno", 2, "Due", 3, "Tre");

        // A3. IMMUTABILE — per più di 10 coppie (Java 9+)
        Map<Integer, String> grande = Map.ofEntries(
            Map.entry(1, "Uno"),
            Map.entry(2, "Due"),
            Map.entry(3, "Tre")
            // ... quante ne vuoi
        );

        // A4. Da valori esistenti, MODIFICABILE
        Map<Integer, String> modificabile = new HashMap<>(Map.of(1, "Uno", 2, "Due"));

        // A5. LinkedHashMap (ordine di inserimento)
        Map<String, Integer> linked = new LinkedHashMap<>();
        linked.put("banana", 3); linked.put("mela", 1); linked.put("uva", 2);
        System.out.println(linked);  // {banana=3, mela=1, uva=2}  ordine garantito

        // A6. TreeMap (ordine alfabetico delle chiavi)
        Map<String, Integer> tree = new TreeMap<>(linked);
        System.out.println(tree);  // {banana=3, mela=1, uva=2}  → {banana=3, mela=1, uva=2}
        // (già in ordine per caso, ma TreeMap garantisce l'ordine alfabetico)


        // ── B. METODI PRINCIPALI ──────────────────────────────
        Map<String, Integer> m = new HashMap<>();
        m.put("alice", 85);
        m.put("bob", 92);
        m.put("charlie", 78);

        // Lettura
        System.out.println(m.get("alice"));           // 85
        System.out.println(m.get("inesistente"));     // null
        System.out.println(m.getOrDefault("xyz", 0)); // 0 (default se chiave assente)
        System.out.println(m.containsKey("bob"));     // true
        System.out.println(m.containsValue(78));      // true
        System.out.println(m.size());                 // 3
        System.out.println(m.isEmpty());              // false

        // Scrittura
        m.put("alice", 90);           // sovrascrive il valore esistente
        m.putIfAbsent("alice", 100);  // NON sovrascrive — alice esiste già
        m.putIfAbsent("diana", 88);   // inserisce — diana non esiste
        System.out.println(m.get("alice")); // 90 (non modificato da putIfAbsent)
        System.out.println(m.get("diana")); // 88

        // Rimozione
        m.remove("charlie");          // rimuove la chiave (e il valore)
        m.remove("bob", 92);          // rimuove SOLO se chiave + valore corrispondono
        System.out.println(m);

        // ── C. METODI AVANZATI DI MODIFICA ───────────────────

        // compute — aggiorna il valore basandosi su chiave + valore attuale
        Map<String, Integer> conteggio = new HashMap<>();
        String[] parole = {"mela", "pera", "mela", "uva", "mela"};
        for (String p : parole) {
            conteggio.compute(p, (k, v) -> (v == null) ? 1 : v + 1);
        }
        System.out.println(conteggio);  // {uva=1, mela=3, pera=1}

        // merge — simile a compute, ma più conciso per i conteggi
        Map<String, Integer> conteggio2 = new HashMap<>();
        for (String p : parole) {
            conteggio2.merge(p, 1, Integer::sum);
        }
        System.out.println(conteggio2);  // {uva=1, mela=3, pera=1}

        // computeIfAbsent — calcola il valore SOLO se la chiave è assente
        Map<String, List<String>> gruppati = new HashMap<>();
        String[] nomi = {"Alice", "Anna", "Bob", "Carlo", "Bea"};
        for (String n : nomi) {
            gruppati.computeIfAbsent(String.valueOf(n.charAt(0)), k -> new ArrayList<>()).add(n);
        }
        System.out.println(gruppati);  // {A=[Alice, Anna], B=[Bob, Bea], C=[Carlo]}

        // computeIfPresent — aggiorna SOLO se la chiave esiste
        conteggio.computeIfPresent("mela", (k, v) -> v * 10);
        System.out.println(conteggio.get("mela"));  // 30

        // replace / replaceAll
        Map<String, Integer> voti = new HashMap<>(Map.of("alice", 85, "bob", 70));
        voti.replace("bob", 75);                          // sovrascrive se presente
        voti.replaceAll((nome, voto) -> voto + 5);        // aggiunge 5 a tutti
        System.out.println(voti);  // {alice=90, bob=80}


        // ── D. ITERAZIONE ─────────────────────────────────────
        Map<String, Integer> frutti = new LinkedHashMap<>(
            Map.of("mela", 3, "pera", 1, "uva", 5)
        );

        // D1. forEach con BiConsumer (il modo più conciso)
        frutti.forEach((k, v) -> System.out.println(k + " → " + v));

        // D2. entrySet — le coppie chiave+valore come Set<Map.Entry<K,V>>
        for (Map.Entry<String, Integer> entry : frutti.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // D3. keySet — solo le chiavi
        for (String chiave : frutti.keySet()) {
            System.out.print(chiave + " ");
        }
        System.out.println();

        // D4. values() — solo i valori (Collection, non Set!)
        for (int val : frutti.values()) {
            System.out.print(val + " ");
        }
        System.out.println();


        // ── E. NAVIGAZIONE CON TreeMap (NavigableMap) ─────────
        TreeMap<String, Integer> navMap = new TreeMap<>(
            Map.of("alpha", 1, "beta", 2, "gamma", 3, "delta", 4)
        );
        System.out.println(navMap.firstKey());        // alpha
        System.out.println(navMap.lastKey());         // gamma (non 'gamma' perché d<g<...)
        System.out.println(navMap.floorKey("c"));     // beta  (≤ "c")
        System.out.println(navMap.ceilingKey("c"));   // delta (≥ "c")
        System.out.println(navMap.headMap("delta"));  // {alpha=1, beta=2}
        System.out.println(navMap.tailMap("delta"));  // {delta=4, gamma=3}


        // ── F. CONVERSIONE DA/VERSO STREAM ────────────────────
        Map<String, Integer> punteggi = Map.of("Alice", 85, "Bob", 92, "Carol", 78);

        // Stream delle Entry
        punteggi.entrySet().stream()
            .filter(e -> e.getValue() >= 85)
            .map(Map.Entry::getKey)
            .forEach(System.out::println);  // Alice, Bob (ordine variabile)

        // Raccogliere in una nuova mappa (con toMap)
        Map<String, Integer> promossi = punteggi.entrySet().stream()
            .filter(e -> e.getValue() >= 85)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(promossi);

        // Raggruppare per un criterio (groupingBy)
        List<String> studenti = List.of("Alice", "Anna", "Bob", "Carlo", "Bea");
        Map<Character, List<String>> perLettera = studenti.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(perLettera);  // {A=[Alice, Anna], B=[Bob, Bea], C=[Carlo]}


        // ── G. THREAD-SAFETY ──────────────────────────────────
        // HashMap NON è thread-safe. Alternative:
        // - Collections.synchronizedMap(new HashMap<>())
        // - java.util.concurrent.ConcurrentHashMap  ← preferita in contesti concorrenti
        Map<String, Integer> concorrente = new java.util.concurrent.ConcurrentHashMap<>();
    }
}
