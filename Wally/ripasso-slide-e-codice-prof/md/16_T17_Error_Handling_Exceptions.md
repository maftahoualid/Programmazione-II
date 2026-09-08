# Blocco 16 — Lezione 17 / Slide T17: *Error Handling with Exceptions* & `Lezione16/MavenDate`

---

## 1. Analisi Teorica Approfondita (Slide T17)

La lezione 17 affronta la gestione degli errori e delle anomalie a runtime attraverso il meccanismo delle **Eccezioni** in Java.

---

### 1.1 Limiti della Gestione Tradizionale degli Errori (Slide 3-6)
Nei linguaggi procedurali privi di eccezioni (come C) o nell'uso ingenuo dei metodi, gli errori vengono segnalati tramite **valori sentinella** (es. restituire `-1`, `null`, `Float.MAX_VALUE`):
```java
float division(int num, int den) {
    if (den != 0)
        return (float) num / den;
    else
        return Float.MAX_VALUE; // Valore speciale di errore
}
```
#### Perché questo approccio è inadeguato?
1. **Inquinamento della logica applicativa**: Il chiamante deve ricordarsi di controllare continuamente i valori di ritorno con una ragnatela di `if-else`.
2. **Ambiguità semantica**: A volte il valore sentinella può essere un risultato matematico o di dominio assolutamente lecito.
3. **Inapplicabilità ai Costruttori**: Un costruttore non ha tipo di ritorno (`void` implicito); se i parametri sono non validi, non può restituire `-1` per segnalare il fallimento!
4. **Difficoltà di propagazione**: Se l'errore avviene a 10 livelli di profondità nello stack di chiamate, ogni singola funzione intermedia dovrebbe propagare manualmente il codice d'errore fino al punto in cui può essere gestito.

---

### 1.2 La Filosofia delle Eccezioni in Java: `try-catch-throw` (Slide 7-10)
Java disaccoppia la **logica di business** (*cosa deve fare il programma quando tutto va bene*) dalla **logica di gestione degli errori** (*cosa fare quando accade un'anomalia*):
* **`try`**: racchiude il blocco di codice a rischio di eccezione.
* **`throw`**: solleva attivamente un'istanza di eccezione nel punto in cui l'anomalia viene riscontrata.
* **`catch`**: cattura l'eccezione ed esegue il codice di ripristino/notifica.
* **Interruzione immediata**: quando viene eseguito `throw`, il metodo **interrompe immediatamente la propria esecuzione**, svuota lo stack frame corrente e risale lungo la catena di chiamate (*call stack*) fino al primo blocco `catch` compatibile.

---

### 1.3 La Gerarchia delle Eccezioni in Java (Slide 20-21)

Tutto l'albero discende da `java.lang.Throwable`:

```
                 ┌─────────────────────┐
                 │ java.lang.Throwable │
                 └──────────▲──────────┘
                            │
        ┌───────────────────┴───────────────────┐
        │                                       │
┌───────┴─────────┐                   ┌─────────┴─────────┐
│      Error      │                   │     Exception     │
└───────▲─────────┘                   └─────────▲─────────┘
        │                                       │
┌───────┴───────────────┐               ┌───────┴───────────────┐
│  OutOfMemoryError     │               │  Checked Exceptions   │
│  StackOverflowError   │               │ (IOException, ecc.)   │
│  ThreadDeath          │               └───────────▲───────────┘
└───────────────────────┘                           │
                                        ┌───────────┴───────────┐
                                        │   RuntimeException    │
                                        │ (Unchecked Exceptions)│
                                        └───────────▲───────────┘
                                                    │
                                        ┌───────────┴───────────┐
                                        │ NullPointerException  │
                                        │ ClassCastException    │
                                        │ IndexOutOfBoundsExc.  │
                                        └───────────────────────┘
```

1. **`Error` (Unchecked)**:
   * Condizioni anomale e catastrofiche interne alla JVM o al sistema operativo (`OutOfMemoryError`, `StackOverflowError`).
   * Il codice utente non deve tentare di catturarle, poiché lo stato della memoria della JVM è compromesso.
2. **`Exception`**:
   * Anomalie derivanti da condizioni esterne o logiche. Si ramificano in due grandi famiglie:
     * **Checked Exceptions** (sottoclassi dirette di `Exception`, escluse le `RuntimeException`).
     * **Unchecked Exceptions** (sottoclassi di `RuntimeException`).

---

### 1.4 Checked vs Unchecked Exceptions (Slide 22-24)

| Caratteristica | Checked Exceptions (`extends Exception`) | Unchecked Exceptions (`extends RuntimeException`) |
| :--- | :--- | :--- |
| **Natura dell'errore** | Situazioni anomale **prevedibili** ma esterne (es. `FileNotFoundException`, rete disconnessa). | **Errori del programmatore** (bug logici, precondizioni violate, puntatori nulli). |
| **Controllo del compilatore** | **Obbligatorio** (*Catch or Declare rule*). Il codice non compila se non gestite con `try-catch` o dichiarate con `throws`. | **Opzionale**. Il compilatore non richiede alcuna dichiarazione o cattura. |
| **Firma del metodo** | Modificata: `public void foo() throws MyCheckedException` | Invariata: nessun `throws` richiesto. |
| **Diffusione (*Propagazione*)** | *"Si propagano come un virus"* (Slide 24): costringono tutti i chiamanti intermedi a dichiarare `throws` o gestire. | Risalgono naturalmente lo stack fino al `main` o al gestore globale. |
| **Raccomandazione moderna (Slide 24)** | Definirle solo se l'utente del metodo **può ragionevolmente intraprendere un'azione di recupero**. | **Preferite** per errori di validazione dello stato o degli argomenti. |

---

### 1.5 "Exception Dirty Tricks": Trasformare Checked in Unchecked (Slide 25-26)
Un pattern comune quando una checked exception sporcherebbe decine di firme senza che il chiamante intermedio possa gestirla:
```java
public void bar() { // Nessuna dichiarazione throws richiesta!
    try {
        foo(); // foo() dichiara throws MyCheckedException
    } catch (MyCheckedException e) {
        throw new RuntimeException(e); // Incapsulata e rilanciata come Unchecked!
    }
}
```
L'eccezione originale non viene persa: è memorizzata come causa (*chained exception* visibile nel messaggio `Caused by:` dello stacktrace).

---

### 1.6 Eccezioni nei Cicli (*Exceptions and Loops*, Slide 27-28)
* **Errore sulla singola iterazione (Slide 27)**: il blocco `try-catch` è **all'interno** del ciclo. Se l'iterazione fallisce, viene intercettata e il ciclo prosegue con la successiva (es. lettura da input utente fino a valore corretto).
* **Errore fatale per l'intero ciclo (Slide 28)**: il blocco `try-catch` **avvolge** il ciclo. Se si verifica un'anomalia, il ciclo viene interrotto definitivamente e l'esecuzione salta direttamente al `catch` esterno.

---

## 2. Analisi Dettagliata del Codice (`Lezione16/MavenDate`)

In `Lezione16/MavenDate` il prof. Pasqua applica i principi della Slide T17 rimuovendo i vecchi `System.out.println("Illegal date!")` e introducendo la gestione strutturata degli errori tramite il package `it.oop.exception`.

### 2.1 Le Nuove Eccezioni: [IllegalDateException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/IllegalDateException.java) e [OrderdPairException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/OrderdPairException.java)

#### 1. [IllegalDateException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/IllegalDateException.java) (Unchecked)
```java
package it.oop.exception;

public class IllegalDateException extends RuntimeException {
    public IllegalDateException(String message) {
        super(message);
    }
}
```
* Estende `RuntimeException`: è una **Unchecked Exception**.
* Modella una violazione delle precondizioni sui valori numerici (giorno, mese, anno).
* Non costringe tutti i client a dichiarare `throws IllegalDateException`.

#### 2. [OrderdPairException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/OrderdPairException.java) (Checked)
```java
package it.oop.exception;

public class OrderdPairException extends Exception { // Notare il typo del docente "Orderd"
    public OrderdPairException(String message) {
        super(message);
    }
}
```
* Estende direttamente `Exception`: è una **Checked Exception**.
* **Impatto immediato sulla firma**:
  * In [OrderedPair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/core/OrderedPair.java#L9):
    ```java
    public OrderedPair(T first, T second) throws OrderdPairException {
        this.first = first;
        this.second = second;
        if (first.compareTo(second) > 0)
            throw new OrderdPairException("Not orderd pair");
    }
    ```
  * In [DateInterval.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/core/DateInterval.java#L6):
    ```java
    public DateInterval(Date left, Date right) throws OrderdPairException {
        super(left, right); // Invoca super() che lancia la checked exception, quindi DateInterval DEVE dichiarare throws!
    }
    ```

---

### 2.2 Refactoring del Metodo `verify()` in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/core/Date.java#L28-L35)
```java
    void verify() {
        if (year < 0)
            throw new IllegalDateException("Illegal date: wrong year");
        if (month < 1 || month > 12)
            throw new IllegalDateException("Illegal date: wrong month");
        if (day < 1 || day > daysPerMonth(month))
            throw new IllegalDateException("Illegal date: wrong day");
    }
```
* **Miglioramento architetturale**:
  * Prima: un giorno errato (es. 35) stampava un messaggio sulla console ma creava comunque un oggetto `Date` incoerente nell'Heap.
  * Ora: il costruttore viene interrotto da `throw` prima che l'assegnazione sia completata. **È impossibile creare un'istanza con stato non valido!**

---

### 2.3 [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/ui/MainDate.java) e l'Applicazione di Tutti i Pattern della Slide T17

```java
package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;
import it.oop.exception.IllegalDateException;
import it.oop.exception.OrderdPairException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDate {

    public static void main(String[] args) {
        System.out.println("Insert day, month, year as numbers");
        int d = -1, m = -1, y = -1;
        boolean correct = false;

        // 1. Pattern Slide 27: try-catch dentro il ciclo per recuperare l'errore di input dell'utente
        while (correct == false) {
            try {
                Scanner sc = new Scanner(System.in);
                d = sc.nextInt();
                m = sc.nextInt();
                y = sc.nextInt();
                correct = true; // Se uno dei nextInt() fallisce, questa riga non viene raggiunta
            } catch (InputMismatchException ime) {
                System.out.println("Input not valid, retry");
            }
        }

        // 2. Cattura della Unchecked Exception IllegalDateException per notifica pulita
        try {
            FormattedDate date = new ItalianDate(d, m, y);
            System.out.println(date.toString());
        } catch (IllegalDateException ide) {
            System.out.println("Date not valid: " + ide.getMessage());
        }

        // 3. Pattern Slide 26 ("Dirty Trick"): incapsulamento di Checked Exception in RuntimeException
        try {
            DateInterval di = new DateInterval(new Date(31, 1, 2025), new Date(1, 1, 2025));
        } catch (OrderdPairException ope) {
            ope.printStackTrace();
            throw new RuntimeException(ope); // Rilanciata come unchecked!
        }
    }
}
```

---

## 3. Risultato di Esecuzione Reale da Terminale

### Test 1: Input con data errata (`35 1 2025`)
Esecuzione:
```bash
mvn exec:java -Dexec.mainClass="it.oop.ui.MainDate" <<< "35 1 2025"
```
Output:
```text
Insert day, month, year as numbers
Date not valid: Illegal date: wrong day
it.oop.exception.OrderdPairException: Not orderd pair
	at it.oop.core.OrderedPair.<init>(OrderedPair.java:13)
	at it.oop.core.DateInterval.<init>(DateInterval.java:7)
	at it.oop.ui.MainDate.main(MainDate.java:35)
...
Caused by: it.oop.exception.OrderdPairException: Not orderd pair
```

### Analisi dell'output:
1. `Date not valid: Illegal date: wrong day`: il costruttore di `ItalianDate` delega a `Date.verify()`, che lancia `IllegalDateException("Illegal date: wrong day")`, catturata dal blocco `catch (IllegalDateException ide)` che stampa il messaggio di errore controllato.
2. `DateInterval di = new DateInterval(31/1/2025, 1/1/2025)`: poiché la data iniziale `31/1/2025` è cronologicamente successiva alla data finale `1/1/2025` (violazione dell'invariante `start <= end`), `OrderedPair` solleva la checked `OrderdPairException`. Il blocco catch stampa lo stack trace con `ope.printStackTrace()` e poi rilancia l'errore incapsulato con `throw new RuntimeException(ope);`, terminando l'esecuzione con codice di uscita d'errore (build failure) come previsto.

---

Dimmi **"vai"** per procedere con il **Blocco 17** (Lezione 18 / Slide T18 — *Streams and Functional Programming*, Stream API, operazioni intermedie vs terminali, `map`, `filter`, `reduce`, `collect` e il nuovo file `MainStream.java` in `Lezione17/MavenDate`).
