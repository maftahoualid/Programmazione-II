package es26.pkg1;

import java.util.*;

/*
================================================================================
                    JAVA COLLECTIONS FRAMEWORK (JCF) - GUIDA COMPLETA
================================================================================

/// 1. COLLECTION INTERFACE <E> ///
// Radice comune di tutte le collezioni di elementi singoli (estende Iterable<E>).

public interface Collection<E> extends Iterable<E> {
    int size();                                 // Restituisce il numero di elementi attualmente presenti nella collezione
    boolean isEmpty();                          // Restituisce true se la collezione è vuota (size() == 0), altrimenti false
    boolean contains(Object o);                 // Verifica se l'elemento è presente, basandosi sul confronto equals()
    boolean containsAll(Collection<?> c);       // Verifica se la collezione contiene TUTTI gli elementi della collezione specificata c
    boolean add(E e);                           // Aggiunge un elemento; restituisce true se modificata, false se rifiutato (es. duplicato in Set)
    boolean addAll(Collection<? extends E> c);  // Aggiunge tutti gli elementi della collezione c (usa wildcard covariante PECS: Producer Extends)
    boolean remove(Object o);                   // Rimuove la prima occorrenza dell'oggetto (basato su equals()); true se rimosso con successo
    boolean removeAll(Collection<?> c);         // Rimuove tutti gli elementi presenti anche nella collezione c (differenza insiemistica: this \ c)
    boolean retainAll(Collection<?> c);         // Mantiene solo gli elementi presenti anche nella collezione c (intersezione insiemistica: this ∩ c)
    void clear();                               // Rimuove tutti gli elementi, svuotando completamente la collezione
    Object[] toArray();                         // Converte la collezione in un array di tipo generico Object[]
    <T> T[] toArray(T[] a);                     // Converte in un array fortemente tipizzato a runtime (es. col.toArray(new Person[0]))
    Iterator<E> iterator();                     // Restituisce un iteratore per scorrere sequenzialmente gli elementi (da Iterable<E>)
}


/// 2. LIST INTERFACE <E> ///
// Sequenza ordinata di elementi. Caratteristiche:
// - Preserva l'ordine di inserimento.
// - Accetta elementi duplicati (possono esistere e1, e2 con e1.equals(e2) == true).
// - Accesso posizionale tramite indici interi [0 ... size() - 1].

public interface List<E> extends Collection<E> {
    E get(int index);                           // Restituisce l'elemento alla posizione specificata (0-based)
    E set(int index, E element);                // Sostituisce l'elemento alla posizione data; restituisce il vecchio elemento sostituito
    void add(int index, E element);             // Inserisce l'elemento all'indice specificato, shiftando a destra gli elementi successivi
    E remove(int index);                        // Rimuove e restituisce l'elemento all'indice specificato, shiftando a sinistra i successivi
    int indexOf(Object o);                      // Restituisce l'indice della prima occorrenza dell'oggetto (via equals()), oppure -1 se assente
    int lastIndexOf(Object o);                  // Restituisce l'indice dell'ultima occorrenza dell'oggetto (via equals()), oppure -1 se assente
    ListIterator<E> listIterator();             // Restituisce un iteratore bidirezionale avanzato per scorrere la lista
    ListIterator<E> listIterator(int index);    // Restituisce un ListIterator posizionato a partire dall'indice specificato
    List<E> subList(int fromIndex, int toIndex);// Restituisce una "view" (vista) della porzione di lista nell'intervallo [fromIndex, toIndex)
}

// -----------------------------------------------------------------------------
// ARRAYLIST <E> //
// Implementazione di List<E> basata su un array dinamico/ridimensionabile in memoria contigua.
// - Complessità: Accesso per indice O(1); inserimento in coda O(1) ammortizzato;
//   inserimento/rimozione in testa o al centro O(n) (richiede System.arraycopy per shiftare gli elementi).
// - Overhead di memoria: Minimo (array contiguo con eventuale capacità non utilizzata).
// Costruttori e metodi specifici:
//   ArrayList();                               // Costruttore di default con capacità iniziale standard (10 elementi)
//   ArrayList(int initialCapacity);            // Costruttore con capacità iniziale preallocata (ottimizza le prestazioni)
//   ArrayList(Collection<? extends E> c);      // Costruttore di conversione: copia tutti gli elementi della collezione fornita
//   void ensureCapacity(int minCapacity);      // Aumenta preventivamente la capacità interna per evitare riallocazioni continue
//   void trimToSize();                         // Riduce la capacità interna alla dimensione effettiva attuale (size) per risparmiare RAM
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------
// LINKEDLIST <E> //
// Implementazione di List<E>, Deque<E> e Queue<E> basata su una lista doppiamente concatenata.
// - Complessità: Accesso per indice O(n) (deve scorrere i nodi dal capo più vicino);
//   inserimento/rimozione in testa o in coda O(1); inserimento/rimozione conoscendo il nodo O(1).
// - Overhead di memoria: Alto (ogni elemento è racchiuso in un nodo con due puntatori: prev e next).
// Costruttori e metodi specifici (da Deque/Queue/Stack):
//   LinkedList();                              // Crea una lista concatenata vuota
//   LinkedList(Collection<? extends E> c);     // Crea una lista contenente gli elementi della collezione data
//   void addFirst(E e);                        // Inserisce l'elemento in testa alla lista in tempo O(1)
//   void addLast(E e);                         // Inserisce l'elemento in coda alla lista in tempo O(1) (equivalente ad add(e))
//   E getFirst();                              // Restituisce il primo elemento (lancia NoSuchElementException se vuota)
//   E getLast();                               // Restituisce l'ultimo elemento (lancia NoSuchElementException se vuota)
//   E removeFirst();                           // Rimuove e restituisce il primo elemento (lancia NoSuchElementException se vuota)
//   E removeLast();                            // Rimuove e restituisce l'ultimo elemento (lancia NoSuchElementException se vuota)
//   E peek(); / E peekFirst();                 // Ispeziona la testa senza rimuoverla (restituisce null se la lista è vuota)
//   E peekLast();                              // Ispeziona l'ultimo elemento senza rimuoverlo (restituisce null se vuota)
//   E poll(); / E pollFirst();                 // Estrae e rimuove la testa (restituisce null se la lista è vuota, senza eccezioni)
//   E pollLast();                              // Estrae e rimuove l'ultimo elemento (restituisce null se vuota)
//   boolean offer(E e); / offerLast(E e);      // Inserisce in coda (metodo standard dell'interfaccia Queue)
//   boolean offerFirst(E e);                   // Inserisce in testa (metodo dell'interfaccia Deque)
//   void push(E e);                            // Inserisce in cima alla pila (Stack LIFO: equivale ad addFirst(e))
//   E pop();                                   // Estrae dalla cima della pila (Stack LIFO: equivale a removeFirst())
// -----------------------------------------------------------------------------


/// 3. SET INTERFACE <E> ///
// Modella il concetto matematico di insieme:
// - NESSUN DUPLICATO ammesso: non possono mai coesistere e1, e2 tali che e1.equals(e2) == true.
// - NESSUN ACCESSO PER INDICE: non esistono indici posizionali (non si può fare get(i)).
// - add(e) restituisce false se l'elemento è già presente nel Set, lasciando l'insieme inalterato.

public interface Set<E> extends Collection<E> {
    // Eredita tutti i metodi di Collection<E> rafforzandone il contratto semantico (unicità assoluta).
}

// -----------------------------------------------------------------------------
// HASHSET <E> //
// Implementazione di Set<E> basata su una tabella hash (internamente incapsula una HashMap<E, Object>).
// - Complessità: Ricerca (contains), inserimento (add) e rimozione (remove) in tempo medio costante O(1).
// - Ordine: NESSUN ORDINE GARANTITO. L'ordine di iterazione può cambiare nel tempo dopo un rehash.
// - VINCOLO FONDAMENTALE SULLA CHIAVE:
//   Gli elementi DEVONO fare l'override coerente sia di equals(Object) che di hashCode().
//   Regola: se a.equals(b) == true  ===>  a.hashCode() DEVE essere uguale a b.hashCode().
// Costruttori:
//   HashSet();                                 // Costruttore predefinito (capacità iniziale 16, load factor 0.75)
//   HashSet(int initialCapacity);              // Costruttore con capacità iniziale esplicita
//   HashSet(int initialCapacity, float loadFactor); // Con capacità iniziale e fattore di carico personalizzati
//   HashSet(Collection<? extends E> c);        // Costruttore di conversione da altra collezione (elimina automaticamente i duplicati!)
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------
// TREESET <E> //
// Implementazione di Set<E>, SortedSet<E> e NavigableSet<E> basata su albero binario Red-Black (TreeMap).
// - Complessità: Ricerca, inserimento e cancellazione in tempo logaritmico O(log n).
// - Ordine: ELEMENTI SEMPRE ORDINATI in modo permanente:
//   1. Secondo l'ordinamento naturale: gli elementi devono implementare Comparable<E>.
//   2. Secondo un Comparator<E> personalizzato passato al costruttore: new TreeSet<>(comparator).
// Metodi specifici per insiemi ordinati:
//   TreeSet();                                 // Crea un insieme ordinato secondo l'ordine naturale (Comparable)
//   TreeSet(Comparator<? super E> comparator); // Crea un insieme ordinato secondo il comparatore fornito
//   TreeSet(Collection<? extends E> c);        // Crea un TreeSet contenente gli elementi della collezione data, ordinandoli
//   E first();                                 // Restituisce il primo elemento (il valore minimo)
//   E last();                                  // Restituisce l'ultimo elemento (il valore massimo)
//   E lower(E e);                              // Restituisce il più grande elemento strettamente minore di e (< e), o null
//   E floor(E e);                              // Restituisce il più grande elemento minore o uguale a e (<= e), o null
//   E ceiling(E e);                            // Restituisce il più piccolo elemento maggiore o uguale a e (>= e), o null
//   E higher(E e);                             // Restituisce il più piccolo elemento strettamente maggiore di e (> e), o null
//   E pollFirst();                             // Rimuove e restituisce il primo elemento (minimo), o null se vuoto
//   E pollLast();                              // Rimuove e restituisce l'ultimo elemento (massimo), o null se vuoto
//   SortedSet<E> subSet(E from, E to);         // Vista dell'intervallo semi-aperto [from, to)
//   SortedSet<E> headSet(E toElement);         // Vista degli elementi strettamente minori di toElement [0,toElement)
//   SortedSet<E> tailSet(E fromElement);       // Vista degli elementi maggiori o uguali a fromElement [fromElement, fine]
//   NavigableSet<E> descendingSet();           // Vista dell'insieme ordinato in senso decrescente (inverso)
// -----------------------------------------------------------------------------


/// 4. MAP INTERFACE <K, V> ///
// Modella una funzione matematica / dizionario di associazioni chiave-valore (K -> V).
// NOTA IMPORTANTE: Map<K, V> NON estende Collection<E>, ma fa parte a pieno titolo del JCF!
// - Le chiavi (K) sono univoche: formano un Set<K> (nessuna chiave duplicata).
// - I valori (V) possono essere duplicati: formano una Collection<V>.

public interface Map<K, V> {
    int size();                                 // Restituisce il numero di coppie chiave-valore presenti nella mappa
    boolean isEmpty();                          // Restituisce true se la mappa non contiene alcuna associazione (size() == 0)
    boolean containsKey(Object key);            // Verifica se la mappa contiene un'associazione per la chiave specificata (equals/hashCode)
    boolean containsValue(Object value);        // Verifica se una o più chiavi sono associate al valore specificato (equals)
    V get(Object key);                          // Restituisce il valore associato alla chiave specificata, oppure null se assente
    V getOrDefault(Object key, V defaultValue); // Restituisce il valore associato, oppure defaultValue se la chiave non è presente
    V put(K key, V value);                      // Associa il valore alla chiave; se già presente, rimpiazza e restituisce il vecchio valore
    void putAll(Map<? extends K, ? extends V> m);// Copia tutte le associazioni della mappa m nella mappa corrente
    V putIfAbsent(K key, V value);              // Inserisce l'associazione solo se la chiave non è già associata a un valore
    V remove(Object key);                       // Rimuove l'associazione per la chiave e restituisce il valore rimosso (oppure null)
    boolean remove(Object key, Object value);   // Rimuove la coppia solo se la chiave è mappata esattamente su quel valore
    boolean replace(K key, V oldValue, V newValue); // Sostituisce il valore solo se attualmente associato ad oldValue
    V replace(K key, V value);                  // Sostituisce il valore per la chiave specificata solo se già presente nella mappa
    void clear();                               // Rimuove tutte le associazioni, svuotando completamente la mappa
    Set<K> keySet();                            // Restituisce la vista Set di tutte le chiavi (senza duplicati)
    Collection<V> values();                     // Restituisce la vista Collection di tutti i valori (può contenere duplicati)
    Set<Map.Entry<K, V>> entrySet();            // Restituisce la vista Set di tutte le coppie chiave-valore (oggetti Map.Entry<K, V>)

    // Sotto-interfaccia per la singola coppia chiave-valore:
    interface Entry<K, V> {
        K getKey();                             // Restituisce la chiave della coppia corrente
        V getValue();                           // Restituisce il valore della coppia corrente
        V setValue(V value);                    // Modifica il valore della coppia corrente
    }
}

// -----------------------------------------------------------------------------
// HASHMAP <K, V> //
// Implementazione di Map basata su tabella hash.
// - Complessità: get(), put(), containsKey(), remove() in tempo medio O(1).
// - Ordine: Nessun ordine garantito per le chiavi.
// - Vincolo: Richiede equals() e hashCode() coerenti sulla classe delle chiavi (K).
// Costruttori:
//   HashMap();                                 // Costruttore default (capacità 16, load factor 0.75)
//   HashMap(int initialCapacity);              // Con capacità iniziale esplicita
//   HashMap(Map<? extends K, ? extends V> m);  // Copia da un'altra mappa esistente
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------
// TREEMAP <K, V> //
// Implementazione di NavigableMap e SortedMap basata su Red-Black Tree.
// - Complessità: Operazioni get(), put(), remove() in tempo logaritmico O(log n).
// - Ordine: Chiavi SEMPRE ORDINATE (ordine naturale Comparable<K> oppure Comparator<K>).
// Metodi specifici:
//   K firstKey();                              // Restituisce la chiave minima
//   K lastKey();                               // Restituisce la chiave massima
//   Map.Entry<K, V> firstEntry();              // Restituisce la coppia chiave-valore con la chiave minima
//   Map.Entry<K, V> lastEntry();               // Restituisce la coppia chiave-valore con la chiave massima
//   K lowerKey(K key);                         // Restituisce la più grande chiave strettamente minore di key
//   K higherKey(K key);                        // Restituisce la più piccola chiave strettamente maggiore di key
// -----------------------------------------------------------------------------


/// 5. QUEUE <E> & DEQUE <E> ///
// Strutture per la gestione di code ed elaborazione di elementi:

public interface Queue<E> extends Collection<E> {
    // Metodi che lanciano eccezioni se l'operazione fallisce:
    boolean add(E e);                           // Inserisce in coda (lancia IllegalStateException se la coda ha capacità limitata ed è piena)
    E remove();                                 // Estrae e rimuove la testa (lancia NoSuchElementException se vuota)
    E element();                                // Ispeziona la testa senza rimuoverla (lancia NoSuchElementException se vuota)

    // Metodi equivalenti "safe" che restituiscono valori speciali (null o false) anziché eccezioni:
    boolean offer(E e);                         // Inserisce in coda (restituisce false se la coda è piena)
    E poll();                                   // Estrae e rimuove la testa (restituisce null se vuota)
    E peek();                                   // Ispeziona la testa senza rimuoverla (restituisce null se vuota)
}

public interface Deque<E> extends Queue<E> {
    // Supporta inserimento, rimozione e ispezione da entrambi i capi (Double Ended Queue):
    void addFirst(E e); void addLast(E e);
    boolean offerFirst(E e); boolean offerLast(E e);
    E removeFirst(); E removeLast();
    E pollFirst(); E pollLast();
    E getFirst(); E getLast();
    E peekFirst(); E peekLast();

    // Metodi per usare Deque direttamente come Stack LIFO (Pila):
    void push(E e);                             // Equivalente ad addFirst(e)
    E pop();                                    // Equivalente a removeFirst()
}


/// 6. ITERATOR <E> & LISTITERATOR <E> ///
// Meccanismi standard per attraversare e manipolare in sicurezza le collezioni:

public interface Iterator<E> {
    boolean hasNext();                          // Restituisce true se ci sono ancora elementi da scorrere nella scansione
    E next();                                   // Restituisce il prossimo elemento e avanza il cursore (lancia NoSuchElementException se fine)
    void remove();                              // Rimuove l'ultimo elemento restituito da next() in modo sicuro (evita ConcurrentModificationException)
}

public interface ListIterator<E> extends Iterator<E> {
    boolean hasPrevious();                      // Restituisce true se ci sono elementi precedenti (scorrimento all'indietro)
    E previous();                               // Restituisce l'elemento precedente e arretra il cursore
    int nextIndex();                            // Restituisce l'indice dell'elemento che verrebbe restituito da una successiva chiamata a next()
    int previousIndex();                        // Restituisce l'indice dell'elemento che verrebbe restituito da previous()
    void set(E e);                              // Rimpiazza l'ultimo elemento restituito da next() o previous() con e
    void add(E e);                              // Inserisce un nuovo elemento nella lista prima del cursore corrente
}
*/

public class MainCollectionsIterable {
    public static void main(String[] args) {

        // 1. LINKEDLIST : SI DUPLICATI, SI ORDINE INSERIMENTO
        List<Person> lista = new LinkedList<>();
        lista.add(new Person("Joe"));
        lista.add(new Person("Sam"));
        lista.add(new Person("Bob"));
        lista.add(new Person("Alice"));
        lista.add(new Person("Joe")); // Inseriamo un duplicato per verificare il comportamento

        System.out.println("Dimensione lista: " + lista.size());
        // scorrimento con iterator
        Iterator<Person> it1 = lista.iterator();
        while (it1.hasNext()) { System.out.println(it1.next()); }
        // scorrimento con for each
        for (Person p : lista) { System.out.println(p); }

        // --- ESEMPIO ADATTATO DA SLIDE T16 (Fail-Fast Iterator vs Iterator.remove()) ---
        // 1) Tentativo di rimozione errata con for-each: l'invocazione di list.remove()
        // modifica la lista alle spalle dell'iteratore, scatenando ConcurrentModificationException
        try {
            int count = 0;
            for (Person p : lista) {
                System.out.println(p);
                if (count == 2) lista.remove(count); // runtime error -- ConcurrentModificationException
                count++;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("// ConcurrentModificationException intercettata!");
        }

        // 2) Rimozione corretta e sicura tramite il metodo remove() dell'Iterator:
        // it.remove() aggiorna lo stato interno dell'iteratore evitando eccezioni
        int count = 0;
        for (Iterator<Person> it = lista.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
            if (count == 2) it.remove(); // ok
            count++;
        }

        // 2. HASHSET : NO DUPLICATI, NO ORDINE INSERIMENTO
        // Conversione da List a Set tramite costruttore universale (elimina al volo i duplicati via equals/hashCode):
        Collection<Person> sett = new HashSet<>(lista);

        System.out.println("Dimensione set: " + sett.size());
        // scorrimento con iterator
        Iterator<Person> it2 = sett.iterator();
        while (it2.hasNext()) { System.out.println(it2.next()); }
        // scorrimento con for each
        for (Person p : sett) { System.out.println("  - " + p); }

        // 3. ARRAY : SI DUPLICATI, SI ORDINE INSERIMENTO
        // Esportazione in Array tipizzato: metodo standard Java
        Person[] arrayP = sett.toArray(new Person[0]);
        System.out.println("Lunghezza array: " + arrayP.length);
        System.out.println("Contenuto array: " + Arrays.toString(arrayP));
    }
}
