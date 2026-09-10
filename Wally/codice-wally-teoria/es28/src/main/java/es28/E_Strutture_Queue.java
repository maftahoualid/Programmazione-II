package es28;

import java.util.*;

/*
 * ============================================================
 *  E — QUEUE & DEQUE  (code per la gestione dei flussi)
 * ============================================================
 *
 *  Queue (coda) — FIFO: entra dalla coda, esce dalla testa
 *  Deque (double-ended queue) — sia FIFO che LIFO (stack)
 *
 *  ┌───────────────────┬──────────────────────────────────────────────────┐
 *  │ PriorityQueue     │ Heap binario. Gli elementi escono in base alla   │
 *  │                   │ priorità (ordine naturale o Comparator).         │
 *  │                   │ poll O(log n), peek/add O(log n).                │
 *  ├───────────────────┼──────────────────────────────────────────────────┤
 *  │ ArrayDeque        │ Array circolare ridimensionabile. FIFO e LIFO.   │
 *  │                   │ Più veloce di Stack e LinkedList. O(1) amort.   │
 *  ├───────────────────┼──────────────────────────────────────────────────┤
 *  │ LinkedList        │ Implementa anche Deque. Utile come coda          │
 *  │                   │ concatenata, ma generalmente più lenta.          │
 *  └───────────────────┴──────────────────────────────────────────────────┘
 *
 *  Convenzione sui metodi:
 *  ┌────────────────┬──────────────────┬─────────────────────────────────┐
 *  │ Operazione     │ Lancia eccezione │ Ritorna null/false (sicuro)     │
 *  ├────────────────┼──────────────────┼─────────────────────────────────┤
 *  │ Inserimento    │ add(e)           │ offer(e)                        │
 *  │ Rimozione      │ remove()         │ poll()                          │
 *  │ Peek (testa)   │ element()        │ peek()                          │
 *  └────────────────┴──────────────────┴─────────────────────────────────┘
 *  → Preferisci sempre la versione sicura: offer/poll/peek
 * ============================================================
 */
public class E_Strutture_Queue {

    public static void demo() {

        // ── A. QUEUE — FIFO CON ArrayDeque ────────────────────
        // La queue standard: entrano dalla coda, escono dalla testa
        Queue<String> coda = new ArrayDeque<>();

        coda.offer("primo");   // aggiunge in coda (equivale a add, ma non lancia eccezione)
        coda.offer("secondo");
        coda.offer("terzo");
        System.out.println(coda);           // [primo, secondo, terzo]

        System.out.println(coda.peek());    // "primo" — legge la testa senza rimuovere
        System.out.println(coda.poll());    // "primo" — rimuove e restituisce la testa
        System.out.println(coda.size());    // 2
        System.out.println(coda);           // [secondo, terzo]


        // ── B. STACK — LIFO CON ArrayDeque ────────────────────
        // NON usare la classe Stack (legacy) — usa ArrayDeque
        Deque<String> stack = new ArrayDeque<>();

        stack.push("base");     // equivale a addFirst() — inserisce in testa
        stack.push("mezzo");
        stack.push("cima");
        System.out.println(stack);          // [cima, mezzo, base]

        System.out.println(stack.peek());   // "cima" — guarda la cima senza rimuovere
        System.out.println(stack.pop());    // "cima" — rimuove e restituisce la cima
        System.out.println(stack);          // [mezzo, base]


        // ── C. DEQUE COMPLETO — tutti i metodi ────────────────
        Deque<Integer> deque = new ArrayDeque<>(List.of(10, 20, 30));

        // Inserimento (due estremità)
        deque.addFirst(5);   // [5, 10, 20, 30]
        deque.addLast(40);   // [5, 10, 20, 30, 40]
        deque.offerFirst(1); // sicuro, non lancia eccezione
        deque.offerLast(50); // [1, 5, 10, 20, 30, 40, 50]
        System.out.println(deque);

        // Rimozione (due estremità)
        System.out.println(deque.pollFirst()); // 1
        System.out.println(deque.pollLast());  // 50

        // Peek (due estremità)
        System.out.println(deque.peekFirst()); // 5
        System.out.println(deque.peekLast());  // 40


        // ── D. PRIORITYQUEUE ──────────────────────────────────
        // Gli elementi NON escono in ordine FIFO ma per PRIORITÀ (min-heap di default)

        // D1. Ordine naturale (numeri → min prima; String → alfabetico)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(50);
        minHeap.offer(20);

        System.out.println(minHeap.peek()); // 10 — il minimo è sempre in testa
        // Svuota la coda in ordine di priorità
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 10 20 30 50
        }
        System.out.println();

        // D2. Max-heap: basta invertire il Comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(List.of(30, 10, 50, 20));
        System.out.print("MaxHeap: ");
        while (!maxHeap.isEmpty()) System.out.print(maxHeap.poll() + " "); // 50 30 20 10
        System.out.println();

        // D3. Oggetti con priorità personalizzata
        record Task(String nome, int priorita) {}
        PriorityQueue<Task> tasks = new PriorityQueue<>(
            Comparator.comparingInt(Task::priorita) // numero più basso = più urgente
        );
        tasks.offer(new Task("Relazione", 3));
        tasks.offer(new Task("Bug critico", 1));
        tasks.offer(new Task("Email", 2));

        while (!tasks.isEmpty()) {
            Task t = tasks.poll();
            System.out.println("[" + t.priorita() + "] " + t.nome());
        }
        // [1] Bug critico
        // [2] Email
        // [3] Relazione


        // ── E. METODI COMUNI DI Queue/Deque ───────────────────
        Deque<String> d = new ArrayDeque<>(List.of("a", "b", "c"));

        System.out.println(d.contains("b")); // true
        System.out.println(d.size());        // 3
        System.out.println(d.isEmpty());     // false
        d.clear();
        System.out.println(d.isEmpty());     // true

        // Iterazione (nessun accesso per indice!)
        Deque<String> frutti = new ArrayDeque<>(List.of("mela", "pera", "uva"));
        for (String f : frutti) System.out.print(f + " ");
        System.out.println();
        frutti.forEach(f -> System.out.print(f + " "));
        System.out.println();


        // ── F. QUANDO USARE COSA ──────────────────────────────
        // PriorityQueue: job scheduling, algoritmi (Dijkstra, A*)
        // ArrayDeque come Stack: algoritmi (DFS, backtracking, parentesi bilanciate)
        // ArrayDeque come Queue: algoritmi (BFS), buffer, undo/redo
    }
}
