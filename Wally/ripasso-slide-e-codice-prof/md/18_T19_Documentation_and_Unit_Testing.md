# Blocco 18 — Lezione 18 / Slide T19: *Documentation and Unit Testing* & `Lezione18/MavenDate`

---

## 1. Analisi Teorica Approfondita (Slide T19)

La lezione 19 approfondisce due pratiche ingegneristiche irrinunciabili nello sviluppo professionale in Java:
1. **Documentazione automatizzata del codice** tramite lo standard **Javadoc**.
2. **Collaudo e Unit Testing automatizzato** tramite il framework **JUnit 5 (Jupiter)** e il plugin Maven **Surefire**.

---

### 1.1 Documentazione con Javadoc (Slide 3-11)
La documentazione del codice sorgente è essenziale per manutenibilità, collaborazione e pubblicazione di API riusabili. In Java la documentazione vive a stretto contatto con il codice nei cosiddetti **Doc Comments**:
* **Sintassi**: Delimitati da `/**` all'inizio e `*/` alla fine. Ogni riga intermedia inizia convenzionalmente con `*`:
  ```java
  /**
   * Descrizione sintetica del componente.
   * <p>Supporta l'uso di tag HTML come paragrafi, link e formattazione.</p>
   */
  ```
* **I Tag Javadoc Standard (Slide 5-6)**: Iniziano con `@`, sono *case-sensitive* e devono comparire a inizio riga:
  * `@param <nome>`: descrive un parametro formale di un metodo o costruttore.
  * `@return`: descrive il significato del valore restituito da un metodo (omesso nei metodi `void` e nei costruttori).
  * `@throws <Eccezione>` (o `@exception`): descrive le condizioni anomale che causano il sollevamento di una determinata eccezione.
  * `{@link <package.Classe#metodo>}`: genera un ipertesto cliccabile verso un'altra classe o metodo.
  * `@author`: autore del modulo.
  * `@since <versione>`: versione a partire dalla quale la feature è disponibile.
  * `@version`: versione corrente del sorgente.
  * `@deprecated`: avvisa che l'elemento è obsoleto, illustrandone il motivo e l'alternativa moderna da utilizzare.

#### Regole di Visibilità e Generazione (Slide 9-11)
* **Default di Javadoc**: Per impostazione predefinita, Javadoc genera la documentazione per le sole entità **`public` e `protected`** (l'interfaccia pubblica esposta ai client). I campi e metodi `private` o *package-private* vengono omessi.
* **Inclusione del privato**: Si deve passare esplicitamente il flag `-private` da riga di comando:
  ```bash
  javadoc -private -d doc *
  ```
* **Integrazione Maven (`maven-javadoc-plugin`, Slide 11)**:
  Aggiungendo il plugin nel `pom.xml`, la documentazione viene generata con un singolo comando standard:
  ```bash
  mvn javadoc:javadoc
  ```

---

### 1.2 Unit Testing con JUnit (Slide 13-16)
Il testing programmatico garantisce la correttezza delle singole unità software in isolamento (metodi o singole classi):
* **Vantaggi sistemici**:
  * **Test-Driven Development (TDD)**: scrivere i test prima ancora di implementare il codice applicativo.
  * **Regression Testing**: certezza che refactoring o nuove feature non rompano comportamenti pregressi funzionanti.
  * Riduzione drastica del tempo speso nel debugging manuale.
* **Anatomia di un Test Case**:
  1. Preparazione dell'input (*Arrange / Setup*).
  2. Esecuzione del metodo sotto test (*Act*).
  3. Confronto dell'output effettivo (*Actual*) con l'output atteso (*Expected*) tramite **asserzioni** (*Assert*).
* **Meccanismo di Fallimento**:
  * Un metodo di test restituisce sempre `void`.
  * Se tutte le asserzioni sono soddisfatte, il metodo termina normalmente e JUnit lo contrassegna come **PASSED** (verde).
  * Se un'asserzione fallisce, solleva un errore di tipo `AssertionError` (o `AssertionFailedError`). Il framework JUnit cattura l'errore, contrassegna il test come **FAILED** (rosso) con il report della discrepanza, e **prosegue regolarmente con i test successivi** senza arrestare l'intera suite.

---

### 1.3 Asserzioni in JUnit 5 (`org.junit.jupiter.api.Assertions`, Slide 17-21)

Il pacchetto Jupiter standardizza una vasta famiglia di metodi statici:

| Metodo Asserzione | Comportamento |
| :--- | :--- |
| `assertEquals(expected, actual, [msg])` | Verifica che `expected.equals(actual)`. Valido per primitivi e oggetti. |
| `assertTrue(condition, [msg])` | Verifica che la condizione booleana sia `true`. |
| `assertFalse(condition, [msg])` | Verifica che la condizione booleana sia `false`. |
| `assertArrayEquals(expected, actual)` | Confronta il contenuto e l'ordinamento di due array elemento per elemento. |
| `assertNull(obj)` / `assertNotNull(obj)` | Verifica se il puntatore è `null` o non nullo. |
| `assertThrows(Exception.class, executable)` | Verifica che l'esecuzione di una lambda/blocco sollevi tassativamente l'eccezione attesa! |

#### Best Practice: Static Imports (Slide 21)
Per evitare di anteporre continuamente `Assertions.` davanti a ogni chiamata, si usa l'import statico:
```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
```

---

### 1.4 Il Ciclo di Vita del Test e le Annotazioni JUnit 5 (Slide 22)

```
┌────────────────────────┐
│      @BeforeAll        │ (eseguito 1 sola volta prima di tutti, STATIC)
└───────────┬────────────┘
            │
┌───────────┴─────────────────┐
│   Per ogni metodo @Test:    │
│  ┌────────────────────────┐ │
│  │      @BeforeEach       │ │ (setup specifico per il test)
│  └───────────┬────────────┘ │
│              ▼              │
│  ┌────────────────────────┐ │
│  │         @Test          │ │ (esecuzione del caso di test)
│  └───────────┬────────────┘ │
│              ▼              │
│  ┌────────────────────────┐ │
│  │       @AfterEach       │ │ (teardown / pulizia risorse)
│  └────────────────────────┘ │
└───────────┬─────────────────┘
            │
┌───────────┴────────────┐
│       @AfterAll        │ (eseguito 1 sola volta alla fine, STATIC)
└────────────────────────┘
```

* `@BeforeAll`: Inizializzazione "pesante" o condivisa tra tutti i test (es. apertura connessione, setup di un database o di costanti immutabili). **Deve essere `static`**.
* `@AfterAll`: Chiusura finale delle risorse globali. **Deve essere `static`**.
* `@BeforeEach`: Inizializzazione fresca prima di *ciascun* test per garantire l'isolamento e l'indipendenza dei test (evitando che un test modifichi lo stato di un altro).
* `@AfterEach`: Pulizia post-test (es. cancellazione di file temporanei creati durante il test).
* `@DisplayName("Descrizione chiara")`: Personalizza il nome del test visualizzato nei report o nell'IDE.
* `@Disabled`: Disabilita temporaneamente il test senza doverlo commentare o cancellare.

---

### 1.5 Organizzazione del Progetto e Convenzioni Maven (Slide 23-24)

Maven e i moderni build tool impongono una struttura standard di cartelle:
* **`src/main/java`**: Contiene il codice sorgente dell'applicazione (es. `it.oop.core.Date`).
* **`src/test/java`**: Contiene esclusivamente le classi di collaudo.
* **Allineamento dei Package (Regola Fondamentale)**:
  Una classe di test che verifica `it.oop.core.Date` **deve risiedere nello stesso identico package `it.oop.core`** (all'interno di `src/test/java`). In questo modo la classe di test ha accesso non solo ai membri `public`, ma anche a tutti i metodi e campi con visibilità di **package (`package-private`)**, facilitando il testing interno senza forzare l'apertura a `public` di dettagli architetturali riservati!

---

## 2. Analisi Dettagliata del Codice (`Lezione18/MavenDate`)

In `Lezione18/MavenDate` troviamo la configurazione completa del plugin Maven Surefire e due classi di test che collaudano la gerarchia di `Date`.

### 2.1 Configurazione in [pom.xml](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate/pom.xml#L44-L68)
```xml
    <build>
        <plugins>
            <!-- Plugin Javadoc (Slide 11) -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>3.6.2</version>
                <configuration>
                    <source>1.8</source>
                    <show>private</show> <!-- Include metodi e campi privati -->
                </configuration>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <!-- Motore di esecuzione JUnit 5 (Slide 24) -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.0</version>
            <scope>test</scope> <!-- Visibile solo durante la fase di test -->
        </dependency>
        <!-- Maven Surefire Plugin per l'esecuzione di 'mvn test' -->
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.5.4</version>
        </dependency>
    </dependencies>
```

---

### 2.2 [TestDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate/src/test/java/it/oop/core/TestDate.java)
Questa classe collauda sia il flusso nominale (costruzione valida) che il flusso eccezionale (lancio di eccezioni):
```java
package it.oop.core;

import it.oop.exception.IllegalDateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDate {

    private Date date;

    // 1. Collaudo del caso nominale con assertEquals
    @Test
    public void testDateConstructor() {
        date = new Date(1, 12, 2025);
        Assertions.assertEquals(1, date.getDay());
        Assertions.assertEquals(12, date.getMonth());
        Assertions.assertEquals(2025, date.getYear());
    }

    // 2. Collaudo del caso eccezionale con assertThrows e Lambda
    @Test
    public void testDateConstructorException() {
        // Verifica che passando un anno negativo (-2), il costruttore sollevi tassativamente IllegalDateException
        assertThrows(IllegalDateException.class, () -> date = new Date(1, 12, -2));
    }
}
```

---

### 2.3 [TestItalianDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate/src/test/java/it/oop/core/TestItalianDate.java)
Esemplifica l'uso della fixture `@BeforeAll` e mette in luce il superamento della vecchia parola chiave `assert`:
```java
package it.oop.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestItalianDate {
    private static ItalianDate date;

    // Fixture statica eseguita una volta sola prima di tutti i test
    @BeforeAll
    public static void setup() {
        date = new ItalianDate(1, 1, 1970);
    }

    @Test
    public void printFormatTest() {
        // Verifica del formato con JUnit 5:
        Assertions.assertEquals("dd/mm/yyyy", date.printFormat());
        
        // Confronto con la vecchia sintassi 'assert' del linguaggio (commentata dal docente):
        // assert date.printFormat().equals("dd/mm/yyyy") : "wrong format";
    }
}
```

---

## 3. Risultato di Esecuzione Reale da Terminale

Comando eseguito nel progetto [Lezione18/MavenDate](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate):
```bash
mvn test
```

Output ottenuto:
```text
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running it.oop.core.TestDate
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.106 s -- in it.oop.core.TestDate
[INFO] Running it.oop.core.TestItalianDate
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 s -- in it.oop.core.TestItalianDate
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

I 3 test sono stati eseguiti con successo, validando in modo formale la suite del progetto e generando i relativi file di report XML e TXT nella cartella `target/surefire-reports/`.

---

Dimmi **"vai"** per procedere con il **Blocco 19** (Lezione 19 / Slide T20 — *Java I/O*, stream di byte vs caratteri, `InputStream`, `OutputStream`, `Reader`, `Writer`, `BufferedReader`, serializzazione, gestione delle risorse con `try-with-resources` e analisi di `MainIO.java` in `Lezione19/MavenDate`).
