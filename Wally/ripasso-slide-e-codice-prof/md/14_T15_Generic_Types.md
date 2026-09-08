# Blocco 14 — Lezione 15 / Slide T15: *Generic Types* & Prime Collezioni in `MavenDate`

---

## 1. Analisi Teorica Approfondita (Slide T15)

La lezione 15 introduce formalmente i **Tipi Generici** (*Generics*), introdotti in Java 5 per abilitare il **polimorfismo parametrico**, eliminare la fragilità dei cast a `Object` e garantire la **Type Safety** a tempo di compilazione.

---

### 1.1 L'Idea Guida & La Tazza `Cup<T>` (Slide 2-3)
Nella Slide 3 campeggia l'immagine di una tazza con la scritta:
$$\mathbf{Cup\langle T\rangle}$$
accompagnata dal motto: **"Same container, different content"**.
Un contenitore (una tazza, una coppia, una lista, un albero) possiede una logica strutturale identica a prescindere dal tipo di dato che custodisce (caffè, tè, stringhe, interi, date). Prima di Java 5, per ottenere contenitori riusabili si usava `Object`, con conseguenze disastrose sull'affidabilità del software.

---

### 1.2 Polimorfismo Parametrico vs Approccio Basato su `Object` (Slide 4-7)
Consideriamo la funzione identità matematica $\lambda x.\, x$:
* Se riceve un `int`, restituisce lo stesso `int`.
* Se riceve una `String`, restituisce la stessa `String`.

#### L'approccio ingenuo (pre-Java 5): segnaposto `Object`
```java
public class Pair {
    private Object first, second;
    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }
    public Object getFirst() { return first; }
    public Object getSecond() { return second; }
}
```
* **Casting obbligatorio**:
  ```java
  Pair p = new Pair("one", "two");
  String first = (String) p.getFirst(); // Cast esplicito verboso e tedioso
  ```
* **Il disastro della mancanza di Type Safety**:
  ```java
  Pair q = new Pair(1, 2); // Autoboxing da int a Integer
  String second = (String) q.getSecond(); // COMPILA SENZA ERRORI!
  // Ma a RUNTIME crasha con: java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
  ```

---

### 1.3 Classi e Metodi Generici (Slide 8-10)
Con i Generics, la classe introduce una o più **variabili di tipo** (*Type Parameters*):
```java
public class Pair<T> {
    private T first, second;
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() { return first; }
    public T getSecond() { return second; }
}
```
* **Sintassi d'uso**:
  ```java
  Pair<String> p = new Pair<String>("one", "two");
  Pair<Integer> q = new Pair<Integer>(1, 2);
  ```
* **Controllo a compile-time**:
  ```java
  String first = p.getFirst(); // Nessun cast necessario: p restituisce String garantita!
  String second = q.getSecond(); // COMPILE-TIME ERROR: Type mismatch (Integer non convertibile a String)
  ```
  L'errore viene intercettato prima ancora di mandare in esecuzione il programma!
* **Regola fondamentale sui Tipi Primitivi**: **Un parametro di tipo $T$ può essere sostituito solo da tipi riferimento (oggetti), MAI da tipi primitivi!** Non è consentito scrivere `Pair<int>`, ma si deve usare il wrapper `Pair<Integer>`.
* **Convenzioni di Naming**: Si usano lettere maiuscole singole:
  * `T`: *Type* generico.
  * `E`: *Element* (usato nelle collezioni: `List<E>`, `Set<E>`).
  * `K, V`: *Key* e *Value* (usato nelle mappe: `Map<K, V>`).
  * `N`: *Number*.
  * `S, U`: Tipi secondari ausiliari.

---

### 1.4 Interfacce della Libreria Standard Riscritte con i Generics (Slide 11-13)
* **`Comparable<T>`**:
  ```java
  public interface Comparable<T> {
      int compareTo(T obj);
  }
  ```
  Consente alla classe che la implementa (es. `Student implements Comparable<Student>`) di ricevere direttamente un parametro di tipo `Student` nel metodo `compareTo(Student other)`, eliminando controlli `instanceof` e downcast forzati.
* **`Iterable<E>` e `Iterator<E>`**:
  ```java
  public interface Iterable<E> {
      Iterator<E> iterator();
  }
  public interface Iterator<E> {
      boolean hasNext();
      E next();
  }
  ```
  Permette a costrutti come il ciclo `for-each` di iterare in modo fortemente tipizzato senza alcun cast:
  ```java
  for (Student student : classRoom) {
      System.out.println(student.toString());
  }
  ```

---

### 1.5 Il Diamond Operator `<>` (Slide 14)
Introdotto in Java 7, evita la ridondanza tra la dichiarazione del tipo di riferimento e l'istanziazione:
```java
// Java 5 e 6:
Pair<Integer> intPair = new Pair<Integer>(2, 4);

// Java 7+:
Pair<Integer> intPair = new Pair<>(2, 4); // Il compilatore inferisce il tipo Integer dai membri a sinistra
```

---

### 1.6 Bounded Type Parameters: Vincolare i Parametri di Tipo (Slide 15-17)

* **Unbounded Type Parameter (Slide 15)**:
  Se dichiariamo `public class Pair<T>`, $T$ è privo di vincoli. Il compilatore applica il meccanismo del **Type Erasure** assumendo che $T$ sia un generico `Object`.
  Di conseguenza, su un oggetto di tipo $T$ è possibile invocare **esclusivamente i metodi definiti in `Object`** (`equals`, `hashCode`, `toString`, `getClass`).
  Se tentiamo di chiamare `first.getName()`, il compilatore rigetta il codice con errore: `cannot find symbol: method getName() in T`.

* **Upper Bound con `extends` (Slide 16-17)**:
  Possiamo imporre che $T$ sia un sottotipo di una determinata classe o implementi una o più interfacce:
  ```java
  public class Pair<T extends Person> {
      private T first, second;
      // ...
      public String getFirstName() {
          return first.getName(); // PERFETTAMENTE LEGALE: T è garantito essere almeno una Person!
      }
  }
  ```
  * **Vincoli multipli**: `<T extends ClassA & InterfaceB & InterfaceC>`. La classe (se presente) deve comparire per prima, seguita dalle interfacce separate da `&`.
  * *Nota terminologica della Slide 16*: La slide cita `class Clazz<T super S>`, ma in Java a livello di dichiarazione di classe generica è ammesso solo `extends`. La parola chiave `super` è utilizzabile **esclusivamente nelle Wildcards** (che vediamo subito sotto).

---

### 1.7 Ereditarietà e Generics: La Trappola dell'Invarianza (Slide 18-20)

Questo è uno dei punti più critici dell'intero corso e delle domande d'esame.

```
   Ereditarietà Normale             Ereditarietà con Generics
      ┌────────────┐                     ┌───────────────┐
      │   Person   │                     │ Pair<Person>  │
      └─────▲──────┘                     └───────▲───────┘
            │ extends                            │ (Nessun legame
            │                                    │  di parentela!)
      ┌─────┴──────┐                     ┌───────┴───────┐
      │  Student   │                     │ Pair<Student> │
      └────────────┘                     └───────────────┘
   Student È UN Person             Pair<Student> NON È Pair<Person>
```

* **Invarianza dei Generics (Slide 19)**:
  Anche se `Student` è sottotipo di `Person`, **`Pair<Student>` NON è un sottotipo di `Pair<Person>`**!
  ```java
  Student s = new Student("Sam", 123);
  Person p = s; // OK: principio di sostituzione di Liskov

  Pair<Student> pairS = new Pair<>(s, new Student("Paul", 456));
  Pair<Person> pairP = pairS; // COMPILE-TIME ERROR: Incompatible types!
  ```
* **Perché Java vieta questo assegnamento?**:
  Se `pairP = pairS` fosse consentito, potremmo eseguire:
  ```java
  pairP.setFirst(new Professor("Mario", 999)); // Legale su Pair<Person>, poiché un Professor è una Person!
  ```
  Ma poiché `pairP` e `pairS` punterebbero allo stesso identico oggetto nell'Heap, `pairS` (che pretende di contenere solo `Student`) si troverebbe a contenere un `Professor`, distruggendo la garanzia di tipo a runtime!

* **Il Contrasto con gli Array (Array Covariance, Slide 20)**:
  In Java gli array sono storicamente **covarianti**:
  ```java
  Student[] arrS = { new Student("Sam", 123) };
  Person[] arrP = arrS; // COMPILA PERFETTAMENTE!
  arrP[0] = new Professor("Mario", 999); // BOOM! A runtime genera: java.lang.ArrayStoreException
  ```
  La covarianza degli array è universalmente riconosciuta come una debolezza storica di Java (introdotta in Java 1.0 prima dell'avvento dei generics). I Generics sono stati resi **invarianti** proprio per risolvere questa falla a tempo di compilazione.

---

### 1.8 Wildcards: `<?>`, `<? extends T>`, `<? super T>` (Slide 21-23)
Per recuperare la flessibilità polimorfica senza rinunciare alla Type Safety, Java ha introdotto il carattere jolly (*Wildcard*) `?`.

1. **Unbounded Wildcard (`<?>`, Slide 21)**:
   * Rappresenta un tipo totalmente sconosciuto:
     ```java
     Pair<?> pairUnknown = pairS; // Legale!
     ```
   * Possiamo **leggere** elementi, ma il loro tipo a compile-time è unicamente `Object`.
   * **Non possiamo scrivere o aggiungere nulla** (tranne il letterale `null`), perché non sappiamo quale sia il tipo effettivo accettabile.

2. **Upper-Bounded Wildcard (`<? extends T>`, Slide 22-23)**:
   * Accetta `T` o qualsiasi sottoclasse di `T`:
     ```java
     Pair<? extends Person> pairP = pairS; // Legale! Student extends Person
     ```
   * Ora possiamo invocare in sicurezza tutti i metodi di `Person`:
     ```java
     System.out.println(pairP.getFirst().getName()); // OK!
     ```
   * **Sintassi pulita nei metodi**:
     Invece di dichiarare un parametro formale di tipo esplicito a livello di metodo:
     ```java
     <T extends Person> void printPair(Pair<T> p) { ... }
     ```
     possiamo scrivere in modo molto più compatto e leggibile:
     ```java
     void printPair(Pair<? extends Person> p) { ... }
     ```

3. **Il Principio Guida PECS (*Producer Extends, Consumer Super*)**:
   * Se la struttura generica funge da **produttore** di dati (vogliamo solo *leggere* dati di tipo `T`), si usa `<? extends T>`.
   * Se la struttura funge da **consumatore** di dati (vogliamo *scrivere/aggiungere* elementi di tipo `T`), si usa `<? super T>`.

---

## 2. Analisi Dettagliata del Codice (`Lezione15/MavenDate`)

Tra la Lezione 14 e la Lezione 15, il prof. Pasqua compie due modifiche sostanziali:
1. Implementa `hashCode()` in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/core/Date.java#L102-L105).
2. Riscrive ed espande [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java) per integrare la libreria delle **Java Collections** (`List`, `Set`, `Map`), il contratto `equals`/`hashCode`, e i meccanismi di ordinamento con `Comparable` e `Comparator` (usando classi anonime e lambdas).

---

### 2.1 Il Contratto `equals` / `hashCode` in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/core/Date.java#L102-L105)

Nel passaggio da Lezione 14 a Lezione 15 viene aggiunto a `Date`:
```java
    @Override
    public int hashCode() {
        return (day + month) * year;
    }
```
#### Perché questo metodo è vitale e non opzionale?
In Java vige la regola ferrea del contratto di `Object`:
> **Se due oggetti sono considerati uguali dal metodo `equals(Object)` (`a.equals(b) == true`), allora le chiamate a `hashCode()` su entrambi gli oggetti DEVONO restituire lo stesso valore intero (`a.hashCode() == b.hashCode()`).**

Se si fa l'override di `equals` senza fare l'override di `hashCode`, strutture dati basate su hash come `HashSet` e `HashMap` falliscono miseramente: considerano due date identiche come memorizzate in *bucket* differenti, inserendo duplicati o non trovando chiavi presenti.

Nel codice di `MainDate.java`:
```java
AmericanDate usD1 = new AmericanDate(7, 11, 2025);
AmericanDate usD2 = new AmericanDate(7, 11, 2025);
System.out.println("usD1 ?= usD2: " + usD1.equals(usD2)); // true
System.out.println("hash(usD1): " + usD1.hashCode());      // 36450
System.out.println("hash(usD2): " + usD2.hashCode());      // 36450
```
Calcolo: $(7 + 11) \times 2025 = 18 \times 2025 = 36450$. Entrambi gli oggetti hanno identico hash code!

---

### 2.2 `List` vs `Set`: Accettazione vs Rifiuto dei Duplicati in [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java#L43-L55)

```java
// 1. Creazione di una List (ammette elementi duplicati e mantiene l'ordine di inserimento)
List<Date> dateList = new ArrayList<>();
dateList.add(new AmericanDate(7, 11, 2025));
dateList.add(new Date(9, 11, 2025));
dateList.add(new TimeStamp(0, 0, 0, 8, 11, 2025));
dateList.add(new AmericanDate(7, 11, 2025)); // Duplicato!
System.out.println("list(" + dateList.size() + "): " + dateList.toString());

// 2. Creazione di un Set (insieme matematico: nessun duplicato consentito)
Set<Date> dateSet = new HashSet<>();
dateSet.add(new AmericanDate(7, 11, 2025));
dateSet.add(new Date(9, 11, 2025));
dateSet.add(new TimeStamp(0, 0, 0, 8, 11, 2025));
dateSet.add(new AmericanDate(7, 11, 2025)); // Duplicato: viene scartato silenziosamente!
System.out.println("set(" + dateSet.size() + "): " + dateSet.toString());
```
* **Risultato a runtime**:
  * `dateList.size()` vale **4** (contiene entrambe le istanze di `7/11/2025`).
  * `dateSet.size()` vale **3** (la seconda istanza è stata rifiutata perché `equals` ha restituito `true` e l'`hashCode` coincideva).

---

### 2.3 `Map<K, V>` e Lambdas Registrate Dinamicamente in [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java#L61-L69)

```java
Map<String, FormattedDateConverter> converter = new HashMap<>();
// Registrazione di strategie di conversione tramite espressioni lambda
converter.put("usToIt", d -> new ItalianDate(d.getDay(), d.getMonth(), d.getYear()));
converter.put("itToUs", d -> new AmericanDate(d.getDay(), d.getMonth(), d.getYear()));

FormattedDate usDate = new AmericanDate(1, 1, 1970);
FormattedDate itDate = converter.get("usToIt").convert(usDate);
System.out.println(itDate.prettyPrint()); // Stampa "1 gennaio 1970"

for (String k : converter.keySet())
    System.out.println(converter.get(k).toString());
```
* **Finezza di esame sul `toString()` delle Lambdas**:
  Quando si invoca `toString()` su un oggetto lambda in Java, la JVM non stampa il codice sorgente, bensì il descrittore sintetico della classe generata a runtime (`invokedynamic`):
  `it.oop.ui.MainDate$$Lambda/0x...` (la notazione interna con i due dollari `$$Lambda` è la convenzione standard con cui la JVM battezza le classi sintetiche generate dinamicamente).

---

### 2.4 Ordinamento: `Comparable` vs `Comparator` (Slide 11 & [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java#L70-L88))

In Java esistono due modi per ordinare oggetti:
1. **Ordinamento Naturale con `Comparable<T>`**:
   * Definito all'interno della classe stessa tramite `compareTo(T other)`.
   * `Date` implementa `Comparable<Date>`:
     ```java
     Collections.sort(dateList); // Funziona direttamente!
     ```
     La lista disordinata `[11/7/2025, y2025m11d9, y2025m11d8, 11/7/2025]` viene riordinata cronologicamente:
     `[11/7/2025, 11/7/2025, y2025m11d8[00:00:00], y2025m11d9]`.

2. **Ordinamento Personalizzato con `Comparator<T>`**:
   * Consideriamo `DateInterval`: eredita da `OrderedPair<Date>`, ma **NON implementa `Comparable<DateInterval>`**!
   * Se si prova a chiamare:
     ```java
     // Collections.sort(intvList); // COMPILE-TIME ERROR:
     // no suitable method found for sort(List<DateInterval>)
     // reason: cannot infer type-variable(s) T (DateInterval is not Comparable)
     ```
   * Per risolvere il problema, il prof. Pasqua applica due stili per fornire un `Comparator<DateInterval>` esterno:
     * **Stile 1: Classe Anonima** (ordinamento per data di inizio `left` crescente):
       ```java
       Collections.sort(intvList, new Comparator<DateInterval>() {
           @Override
           public int compare(DateInterval di1, DateInterval di2) {
               return di1.getLeft().compareTo(di2.getLeft());
           }
       });
       ```
     * **Stile 2: Espressione Lambda** (ordinamento per data di fine `right` decrescente):
       ```java
       Collections.sort(intvList, (di1, di2) -> di2.getRight().compareTo(di1.getRight()));
       ```

---

## 3. Risultato di Compilazione ed Esecuzione Reale

Comando eseguito nel progetto [Lezione15/MavenDate](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate):
```bash
mvn compile exec:java -Dexec.mainClass="it.oop.ui.MainDate"
```

Output ottenuto:
```text
y2025m9d10
y2025m1d1
00:00:00
true
OOP exam on 2 febbraio 2026
date pair: [y2025m2d1 .. y2025m1d1]
Pair not ordered!
OOP exam on 2 febbraio 2026
list(4): [11/7/2025, y2025m11d9, y2025m11d8[00:00:00], 11/7/2025]
set(3): [11/7/2025, y2025m11d9, y2025m11d8[00:00:00]]
usD1 ?= usD2: true
hash(usD1): 36450
hash(usD2): 36450
1 gennaio 1970
it.oop.ui.MainDate$$Lambda/0x000000008f383b48@21043ee9
it.oop.ui.MainDate$$Lambda/0x000000008f383920@6dc5f73f
[11/7/2025, 11/7/2025, y2025m11d8[00:00:00], y2025m11d9]
[[y2025m1d1 .. y2025m1d20], [y2025m1d10 .. y2025m1d31]]
[[y2025m1d10 .. y2025m1d31], [y2025m1d1 .. y2025m1d20]]
```

### Decodifica puntuale dell'output:
1. `list(4): [...]` vs `set(3): [...]` $\rightarrow$ Dimostrazione pratica che `HashSet` elimina il duplicato `11/7/2025` grazie al corretto funzionamento congiunto di `equals()` e `hashCode()`.
2. `hash(usD1): 36450` e `hash(usD2): 36450` $\rightarrow$ Rispetto formale del contratto di `Object`.
3. `1 gennaio 1970` $\rightarrow$ La mappa `converter` recupera il converter `"usToIt"` memorizzato come lambda e trasforma `1/1/1970` in formato italiano.
4. `it.oop.ui.MainDate$$Lambda/...` $\rightarrow$ Nome sintetico dell'oggetto funzionale generato dalla JVM a runtime (in cui il doppio dollaro `$$Lambda` rappresenta il discriminatore standard del bytecode).
5. `[11/7/2025, 11/7/2025, y2025m11d8[00:00:00], y2025m11d9]` $\rightarrow$ Lista ordinata secondo l'ordinamento naturale di `Date` (7 nov, poi 8 nov, poi 9 nov).
6. `[[y2025m1d1 .. y2025m1d20], [y2025m1d10 .. y2025m1d31]]` $\rightarrow$ Intervalli ordinati per data d'inizio crescente (1 gen prima del 10 gen) tramite `Comparator` in classe anonima.
7. `[[y2025m1d10 .. y2025m1d31], [y2025m1d1 .. y2025m1d20]]` $\rightarrow$ Intervalli ordinati per data di fine decrescente (31 gen prima del 20 gen) tramite `Comparator` in espressione lambda.

---

Dimmi **"vai"** per procedere con il **Blocco 15** (Lezione 16 / Slide T16 — *Collections Framework*, gerarchia completa di `List`, `Set`, `Queue`, `Map`, complessità asintotiche, iteratori e diff in `Lezione16/MavenDate`).
