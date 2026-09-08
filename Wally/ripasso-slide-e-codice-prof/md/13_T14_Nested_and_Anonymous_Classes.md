# Blocco 13 — Lezione 14 / Slide T14: *Nested and Anonymous Classes* & Introduzione ai Generici

---

## 1. Analisi Teorica Approfondita (Slide T14)

La lezione 14 esplora la gerarchia delle classi definite all'interno di altre classi (meccanismo introdotto fin da Java 1.1), le classi anonime, l'evoluzione verso le **espressioni Lambda** (Java 8) e la feature dei **Varargs**.

```
                 ┌───────────────────────────┐
                 │  Classi Annidate in Java  │
                 └─────────────┬─────────────┘
                               │
            ┌──────────────────┴──────────────────┐
            ▼                                     ▼
 ┌───────────────────────┐             ┌───────────────────────┐
 │ Static Nested Classes │             │     Inner Classes     │
 │   (static class ...)  │             │     (non-static)      │
 └───────────────────────┘             └───────────┬───────────┘
                                                   │
                  ┌────────────────────────────────┼─────────────────┐
                  ▼                                ▼                 ▼
       ┌──────────────────┐ ┌──────────────────┐ ┌──────────────────┐
       │Member Inner Class│ │   Local Class    │ │ Anonymous Class  │
       │(a livello classe)│ │(dentro un metodo)│ │(senza nome/corpo)│
       └──────────────────┘ └──────────────────┘ └────────┬─────────┘
                                                           │ (SAM Interface)
                                                           ▼
                                                 ┌──────────────────┐
                                                 │Lambda Expression │
                                                 │  (arg -> body)   │
                                                 └──────────────────┘
```

---

### 1.1 Static Nested Classes (`static class Nested`)
Una classe dichiarata con il modificatore `static` all'interno di un'altra classe contenitore (*enclosing class*):
```java
package pkg;
class Outer {
    static class Nested {
        // ...
    }
}
```
* **Natura**: È a tutti gli effetti una classe di primo livello (*top-level*), ma inserita nel *namespace* della classe che la ospita.
* **Nome completo (Fully Qualified Name)**: `pkg.Outer.Nested` (a livello di bytecode su disco viene generato il file `Outer$Nested.class`).
* **Accesso ai membri**:
  * Trattandosi di un membro statico, **ha accesso a tutti i membri statici** della classe contenitore, **compresi quelli privati (`private`)**!
  * **NON ha accesso** ai membri di istanza (campi o metodi non statici) di `Outer`, poiché non esiste alcun riferimento implicito ad un'istanza di `Outer`.
* **Istanziazione**: Può essere istanziata in modo totalmente indipendente dall'esistenza di un oggetto `Outer`:
  ```java
  Outer.Nested nestedObject = new Outer.Nested();
  ```
* **Caso d'uso tipico**: Il pattern **Builder** (visto in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/Date.java#L85-L106)), classi di utilità, nodi interni di strutture dati (es. `static class Node<E>` in un albero o grafo).

---

### 1.2 Member Inner Classes (`class Inner` non-statica)
Una classe dichiarata all'interno di un'altra classe **senza** la parola chiave `static`:
```java
package pkg;
class Outer {
    class Inner {
        // ...
    }
}
```
* **Natura**: Un'istanza di `Inner` **non può esistere senza un'istanza associata di `Outer`**.
* **Riferimento implicito (`Outer.this` o `this$0`)**:
  * Ogni oggetto `Inner` memorizza internamente un puntatore sintetico nascosto all'oggetto `Outer` che l'ha generato.
  * Tramite questo puntatore, `Inner` ha accesso a **tutti** i membri di `Outer`, sia statici che di istanza, inclusi quelli `private`!
* **Sintassi di istanziazione da codice esterno**:
  ```java
  Outer outerObject = new Outer();
  Outer.Inner innerObject = outerObject.new Inner(); // Sintassi specifica con outerObject.new
  ```

#### Confronto: `Nested` vs `Inner` (Slide 7)
```java
class Outer {
    private static int I = 5;
    private int i;

    static class Nested {
        // NON ha accesso al campo di istanza i!
        static void print() { System.out.println(I); } // OK: accede a membro statico privato I
    }

    class Inner {
        // Ha accesso sia a I che al campo di istanza i della sua Outer associata
        void print() { System.out.println(i); }
    }

    public void outerMethod() {
        Nested.print();
        Inner innerObject = new Inner(); // Qui 'this.new Inner()' è implicito
        innerObject.print();
    }
}
```

---

### 1.3 Local Classes (Classi Locali a un Metodo)
Una classe definita all'interno del corpo di un blocco di codice (tipicamente un metodo):
```java
public void outerMethod() {
    final int j = 1;

    class Local { // NESSUN modificatore di visibilità ammesso (no public, private, protected)
        int addOne() { return j + 1; }
    }

    Local localObject = new Local();
    System.out.println(localObject.addOne()); // Stampa 2
}
```
* **Regole di visibilità**: La classe è visibile e istanziabile **esclusivamente all'interno del blocco/metodo** in cui è dichiarata.
* **Cattura delle variabili locali (*Variable Capture* & *Closures*)**:
  * Può accedere alle variabili locali e ai parametri del metodo contenitore **solo se sono dichiarati `final` oppure sono *effectively final*** (ovvero il loro valore non viene mai modificato dopo l'inizializzazione).
  * **Perché questo vincolo severo? (Domanda classica d'esame)**:
    * Le variabili locali risiedono nello **Stack Frame** del metodo e vengono distrutte non appena il metodo termina (`return`).
    * L'oggetto della classe locale (`localObject`) risiede nell'**Heap** e potrebbe sopravvivere ben oltre la fine del metodo (ad esempio se restituito come interfaccia o registrato come listener).
    * Per permettere all'oggetto di accedere a `j`, il compilatore Java crea un campo sintetico nascosto dentro `Local` e vi **copia** il valore di `j` al momento della creazione.
    * Se `j` potesse essere riassegnato (`j++`), il valore nello stack e la copia nell'heap diverrebbero disallineati, rompendo la coerenza del linguaggio. Rendendo la variabile immutabile (`final`), la copia rimane identica e coerente per sempre.

---

### 1.4 Il Meme della Slide 10: *Objects inside objects*
Nella Slide 10, il prof. Pasqua inserisce il celebre meme di Xzibit (*Pimp My Ride*):
> *"YO DAWG, I HEAR YOU LIKE OBJECT ORIENTED PROGRAMMING SO I NESTED A CLASS INSIDE YOUR CLASS SO YOU CAN CREATE OBJECTS WHILE YOU CREATE OBJECTS"*

A sottolineare con ironia la tentazione (e il potere) di creare gerarchie di classi dentro classi per incapsulare comportamenti strettamente accoppiati.

---

### 1.5 Motivazioni Architetturali & Il Caso di Studio *Iterator Pattern* (Slide 11-12)
Perché annidare le classi?
1. **Migliore organizzazione del codice**: collocare classi di supporto logico all'interno del namespace della sola classe che le utilizza.
2. **Politica di visibilità privilegiata (*Privileged Access*)**: le classi annidate possono leggere lo stato privato della classe ospitante senza costringere a esporre metodi `public` o `package-private` pericolosi verso l'esterno.
3. **Meno complessità nel codebase**: evita la proliferazione di decine di minuscoli file `.java` separati.

#### L'Esempio del pattern `Iterable` / `Iterator` (Slide 12)
* **Senza annidamento (Due classi separate)**: `CRIterator` deve essere dichiarata all'esterno, riceve l'array `Student[] arr` nel costruttore e necessita di visibilità speciale:
  ```java
  class ClassRoom implements Iterable {
      private Student[] students;
      @Override
      public Iterator iterator() { return new CRIterator(students); }
  }
  class CRIterator implements Iterator {
      private Student[] arr;
      private int next = 0;
      CRIterator(Student[] arr) { this.arr = arr; }
      @Override public boolean hasNext() { return next < arr.length; }
      @Override public Object next() { return new Student(arr[next++]); }
  }
  ```
* **Con Inner Class (Soluzione idiomatica Java)**: `CRIterator` è una `Inner Class` dentro `ClassRoom`. Non serve memorizzare un array duplicato: accede direttamente al campo privato `students` di `ClassRoom`!
  ```java
  class ClassRoom implements Iterable {
      private Student[] students;
      @Override
      public Iterator iterator() { return new CRIterator(); }

      class CRIterator implements Iterator {
          private int next = 0;
          @Override public boolean hasNext() { return next < students.length; }
          @Override public Object next() { return new Student(students[next++]); }
      }
  }
  ```

---

### 1.6 Anonymous Classes (Classi Anonime, Slide 13-16)
Una classe locale **priva di nome**, definita e istanziata contestualmente all'interno di una singola espressione.
* **Vincolo**: Può essere creata solo estendendo una classe esistente o implementando un'interfaccia:
  ```java
  // 1. Estendendo una classe esistente:
  Person sam = new Person("Sam") {
      @Override
      public String toString() { return "It's Sam!"; }
  };

  // 2. Implementando un'interfaccia:
  Time init = new Time() {
      @Override public int getHours() { return 0; }
      @Override public int getMinutes() { return 0; }
      @Override public int getSeconds() { return 0; }
  };
  ```
* **Regola aurea sui Costruttori**: **Una classe anonima NON può dichiarare alcun costruttore esplicito!** (Poiché i costruttori devono avere per definizione lo stesso nome della classe, e una classe anonima non ha nome). Eventuali inizializzazioni devono sfruttare gli *instance initializer blocks* `{ ... }` o i parametri passati al costruttore della superclasse (`new SuperClass(arg1, arg2) { ... }`).
* **Espressioni**: Essendo espressioni, devono terminare con un punto e virgola `;` (se assegnate a una variabile) o possono essere passate direttamente come parametri attuali di un metodo:
  ```java
  tasks.add(new Runnable() {
      @Override
      public void run() { System.out.println("Running!"); }
  });
  ```

---

### 1.7 Lambda Expressions (Slide 17-19)
Introdotte in Java 8, sono una notazione sintattica ultra-compatta per implementare **interfacce funzionali** (interfacce con un **unico metodo astratto**, note come SAM — *Single Abstract Method*).
```
(parametri) -> corpo
```
* **Parametri**:
  * Nessun parametro: `() -> 42`
  * Un parametro: `x -> x + 1` (le parentesi tonde sono opzionali se non si specifica il tipo esplicito)
  * Due o più parametri: `(x, y) -> x + y`
* **Corpo**:
  * Espressione singola: `param -> param - 1` (restituzione implicita del valore calcolato, niente `return` né graffe)
  * Blocco di codice: `param -> { int res = param - 1; return res; }` (richiede graffe esplicite e `return`)
* **Inferenza di tipo (*Type Inference*)**: Il compilatore Java deduce i tipi dei parametri e del valore di ritorno dal contesto d'uso (*target typing* dell'interfaccia funzionale).
* **Differenza tra Classi Anonime e Lambda**:
  * La classe anonima può implementare interfacce con più metodi astratti o estendere classi concrete/astratte; la lambda può implementare **solo interfacce funzionali SAM**.
  * La classe anonima crea un nuovo scope per `this` (che punta all'istanza anonima stessa); nella lambda `this` è **lessicale** (punta all'istanza della classe circostante).
  * La classe anonima può dichiarare campi di istanza che mantengono stato; la lambda è per natura *stateless*.

---

### 1.8 Varargs (`type... args`, Slide 20-21)
Consente a un metodo di accettare un numero variabile (da zero a molti) di argomenti dello stesso tipo:
```java
static int min(int... values) {
    int res = Integer.MAX_VALUE;
    for (int v : values)
        if (v < res) res = v;
    return res;
}
```
* **Dietro le quinte del compilatore**: Il parametro `int... values` viene tradotto esattamente in un array `int[] values`. Al momento della chiamata:
  * `min(1, 0, 5)` $\rightarrow$ il compilatore inietta il codice: `min(new int[]{ 1, 0, 5 })`.
  * `min()` (senza argomenti) $\rightarrow$ crea un array vuoto `min(new int[]{})`.
* **Regole tassative**:
  1. Ci può essere **al massimo un** parametro varargs per metodo.
  2. Il parametro varargs deve essere tassativamente l'**ultimo** nella lista dei parametri formali (`void foo(String s, int... nums)` è valido; `void foo(int... nums, String s)` genera errore di compilazione).

---

## 2. Analisi Dettagliata del Codice (`Lezione14/MavenDate`)

Nella Lezione 14 il progetto [MavenDate](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate) introduce il primo ponte fondamentale verso i **Tipi Generici** (anticipando la teoria formale di Slide T15) e sfrutta le classi annidate, le classi anonime e le lambda viste nella Lezione 13.

### 2.1 Diff di [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/Date.java#L1-L80) (Lezione 13 vs Lezione 14)
Fino alla Lezione 13, `Date` implementava l'interfaccia non tipizzata (*raw*) `Comparable`:
```diff
--- Lezione13/Date.java
+++ Lezione14/Date.java
@@ -1,6 +1,6 @@
 package it.oop.core;
 
-public class Date implements Comparable {
+public class Date implements Comparable<Date> {
 
@@ -73,15 +73,14 @@
     @Override
-    public int compareTo(Object other) {
-        Date otherAsDate = (Date) other;
-        int diff = this.year - otherAsDate.getYear();
+    public int compareTo(Date other) {
+        int diff = this.year - other.getYear();
         if (diff != 0)
             return diff;
-        diff = this.month - otherAsDate.getMonth();
+        diff = this.month - other.getMonth();
         if (diff != 0)
             return diff;
-        return this.day - otherAsDate.getDay();
+        return this.day - other.getDay();
     }
```
* **Beneficio immediato del Generics**:
  1. La firma del metodo diventa fortemente tipizzata a compile-time: `compareTo(Date other)` anziché `compareTo(Object other)`.
  2. Viene eliminato il cast esplicito `(Date) other`, azzerando il rischio di incorrere a runtime in una `ClassCastException`.

---

### 2.2 La Nuova Classe Generica [Pair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/Pair.java)
```java
package it.oop.core;

public class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() { return first; }
    public S getSecond() { return second; }
}
```
* `F` (*First*) e `S` (*Second*) sono due **Type Parameters** indipendenti.
* I campi sono `private final`, rendendo la coppia immutabile una volta istanziata.

---

### 2.3 La Classe Generica con Bounded Type [OrderedPair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/OrderedPair.java)
```java
package it.oop.core;

public class OrderedPair <T extends Comparable<T>> {
    private final T first;
    private final T second;

    public OrderedPair(T first, T second) {
        this.first = first;
        this.second = second;
        if (first.compareTo(second) > 0)
            System.out.println("Pair not ordered!");
    }

    public T getFirst() { return first; }
    public T getSecond() { return second; }
}
```
* **Bounded Type Parameter (`<T extends Comparable<T>>`)**:
  * Il tipo `T` non può essere un qualsiasi tipo `Object`: deve tassativamente implementare l'interfaccia `Comparable<T>`.
  * Grazie a questo vincolo, il compilatore consente all'interno del costruttore di invocare legalmente `first.compareTo(second)`.
  * Se si tentasse di istanziare `OrderedPair<Object>`, il compilatore bloccherebbe l'operazione con un errore prima ancora di eseguire.

---

### 2.4 Le Sottoclassi Specializzate [DatePair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/DatePair.java) e [DateInterval.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/DateInterval.java)

#### [DatePair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/DatePair.java)
```java
package it.oop.core;

public class DatePair extends Pair<Date, Date> {
    public DatePair(Date left, Date right) {
        super(left, right);
    }

    public Date getLeft() { return getFirst(); }
    public Date getRight() { return getSecond(); }

    @Override
    public String toString() {
        Date l = getLeft();
        Date r = getRight();
        return String.format("[%s .. %s]", l.toString(), r.toString());
    }
}
```
* Fissa sia `F` che `S` al tipo concreto `Date` (`extends Pair<Date, Date>`).
* Offre metodi con semantica di dominio più chiara: `getLeft()` e `getRight()`.

#### [DateInterval.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/DateInterval.java)
```java
package it.oop.core;

public class DateInterval extends OrderedPair<Date> {
    public DateInterval(Date left, Date right) {
        super(left, right);
    }

    public Date getLeft() { return getFirst(); }
    public Date getRight() { return getSecond(); }

    @Override
    public String toString() {
        Date l = getLeft();
        Date r = getRight();
        return String.format("[%s .. %s]", l.toString(), r.toString());
    }
}
```
* Eredita da `OrderedPair<Date>`: è legale perché `Date implements Comparable<Date>`.
* Se le date passate non sono cronologicamente ordinate (`left > right`), il costruttore di `OrderedPair` emette il messaggio d'avviso `"Pair not ordered!"`.

---

### 2.5 [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/ui/MainDate.java)
Raccoglie in un unico punto di ingresso tutte le feature viste nelle lezioni 13 e 14:
```java
package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;

public class MainDate {

    public static void main(String[] args) {
        // 1. Static Nested Class (Builder Pattern da Lezione 13)
        Date.Builder dateBuilder = new Date.Builder(2025);
        Date d1 = dateBuilder.build(10,9);
        Date d2 = dateBuilder.build(10,-1);
        System.out.println(d1.toString());
        System.out.println(d2.toString());

        // 2. Anonymous Class che implementa l'interfaccia Time (Lezione 13/14)
        Time init = new Time() {
            @Override public int getHours() { return 0; }
            @Override public int getMinutes() { return 0; }
            @Override public int getSeconds() { return 0; }
            @Override public String toString() {
                return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
            }
        };
        System.out.println(init.toString());

        // 3. Lambda Expression che implementa FormattedDateConverter (Lezione 13/14)
        FormattedDateConverter toAmerican =
                d -> new AmericanDate(d.getDay(), d.getMonth(), d.getYear());
        System.out.println(toAmerican.convert(new ItalianDate(11, 11, 2025)) instanceof AmericanDate);

        // 4. Generics: Pair con Diamond Operator <>
        Pair<String, FormattedDate> event =
                new Pair<>("OOP exam", new ItalianDate(2, 2, 2026));
        System.out.println(event.getFirst() + " on " + event.getSecond().prettyPrint());

        // 5. DatePair e DateInterval
        DatePair dp = new DatePair(new Date(1,2,2025), new Date(1,1,2025));
        System.out.println("date pair: " + dp.toString());

        // Qui scatta l'avviso di ordinamento perché 1/2/2025 è successivo a 1/1/2025!
        DateInterval di = new DateInterval(new Date(1,2,2025), new Date(1,1,2025));

        // 6. Wildcard con Bounded Type (anticipazione Lezione 15)
        Pair<?, ? extends FormattedDate> unknown = event;
        System.out.println(unknown.getFirst().toString() + " on " + unknown.getSecond().prettyPrint());
    }
}
```

---

## 3. Risultato di Compilazione ed Esecuzione Reale

Comando eseguito nel workspace del corso:
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
```

### Dettaglio riga per riga dell'output:
1. `y2025m9d10` $\rightarrow$ generato da `d1 = dateBuilder.build(10, 9)` (10 settembre 2025).
2. `y2025m1d1` $\rightarrow$ generato da `d2 = dateBuilder.build(10, -1)` (mese errato fallback su 1/1/2025).
3. `00:00:00` $\rightarrow$ generato dall'override di `toString()` della **classe anonima** `init` che implementa `Time`.
4. `true` $\rightarrow$ la **lambda** `toAmerican` converte l'istanza di `ItalianDate` in `AmericanDate`.
5. `OOP exam on 2 febbraio 2026` $\rightarrow$ `Pair<String, FormattedDate>` con formattazione italiana.
6. `date pair: [y2025m2d1 .. y2025m1d1]` $\rightarrow$ `DatePair` stampa le due date senza controllo di sequenzialità.
7. `Pair not ordered!` $\rightarrow$ emesso dal costruttore di `OrderedPair` dentro `new DateInterval(1/2/2025, 1/1/2025)` perché `1/2/2025 > 1/1/2025`.
8. `OOP exam on 2 febbraio 2026` $\rightarrow$ invocazione polimorfica tramite wildcard generica `Pair<?, ? extends FormattedDate>`.

---

Dimmi **"vai"** per procedere con il **Blocco 14** (Lezione 15 / Slide T15 — *Generic Types*, Type Erasure, Wildcards, PECS e diff in `Lezione15/MavenDate`).
