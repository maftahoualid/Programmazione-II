# GUIDA COMPLETA AI TEMI D'ESAME DI PROGRAMMAZIONE II (JAVA)
### Dipartimento di Informatica — Università di Verona
**Analisi sistematica di tutti gli appelli (2012–2025) e Master Prompt per IA**

---

# INDICE
1. [Regole Generali e Criteri di Valutazione](#1-regole-generali-e-criteri-di-valutazione)
2. [Tassonomia dei Temi d'Esame (Le 5 Grandi Famiglie)](#2-tassonomia-dei-temi-desame-le-5-grandi-famiglie)
3. [Analisi Dettagliata dei Pattern e Idiomi di Soluzione](#3-analisi-dettagliata-dei-pattern-e-idiomi-di-soluzione)
4. [Catalogo e Mappatura degli Appelli (2012–2025)](#4-catalogo-e-mappatura-degli-appelli-20122025)
5. [Le Trappole più Frequenti e Errori Fatali](#5-le-trappole-più-frequenti-e-errori-fatali)
6. [MASTER PROMPT PER L'INTELLIGENZA ARTIFICIALE](#6-master-prompt-per-lintelligenza-artificiale)

---

# 1. Regole Generali e Criteri di Valutazione

Dall'analisi dei file di consegna (`compito.tex` / `compito.pdf`) e dei test di collaudo del docente (Prof. Fausto Spoto), emergono vincoli tassativi:

1. **Vincolo di Compilazione Assoluto:** La soluzione deve compilare senza errori. Se il codice non compila (anche per un singolo errore di sintassi o import mancante), la prova riceve 0 punti.
2. **Integrità delle Firme:** È severamente vietato modificare le dichiarazioni pubbliche o protette (package, nomi classi, interfacce, firme dei metodi, tipi di ritorno, eccezioni dichiarate) fornite nello scheletro (`consegna/`).
3. **Principio di Minima Visibilità (Campi e Metodi Aggiuntivi):** Qualsiasi campo, metodo helper o costruttore aggiunto dallo studente DEVE essere dichiarato `private`. L'aggiunta di membri `public` o `protected` non previsti comporta penalità o errori nei test di riflessione.
4. **Classi Ausiliarie:** È consentito definire ulteriori classi o eccezioni di supporto, purché appartengano allo stesso package e vengano consegnate insieme ai file richiesti.
5. **Collaudo Automatico:** Viene fornito un `Main.java` come test di fumo con l'output atteso, ma la correzione del docente esegue suite di test JUnit/automatici estesi che coprono corner cases, mutabilità non controllata e violazioni dei contratti standard.

---

# 2. Tassonomia dei Temi d'Esame (Le 5 Grandi Famiglie)

L'analisi dei 67 appelli e varianti evidenzia 5 macro-tipologie ricorrenti:

```
                  ┌──────────────────────────────────────────────┐
                  │        TIPOLOGIE D'ESAME PROGRAMMAZIONE II   │
                  └──────────────────────┬───────────────────────┘
                                         │
     ┌───────────────────┬───────────────┴───────────────┬───────────────────┐
     ▼                   ▼                               ▼                   ▼
┌──────────────┐  ┌──────────────┐                ┌──────────────┐    ┌──────────────┐
│  Gerarchie   │  │  Iteratori   │                │  Strutture   │    │  Interpreti  │
│  & Classi    │  │Personalizzati│                │Dati & Insiemi│    │  & Composite │
│   Astratte   │  │  (Iterable)  │                │(Mappe, Grafi)│    │(Tree/Stack)  │
└──────────────┘  └──────────────┘                └──────────────┘    └──────────────┘
```

### 1. Gerarchie Polimorfe e Classi Astratte (Fattorizzazione)
* **Temi tipici:** Rappresentazione di entità con varianti formali o comportamentali.
* **Appelli rappresentativi:**
  - `2025-02-05` (`Time`, `AbstractTime`, `ItalianTime`, `AmericanTime`)
  - `2025-02-20` (`Note`, `AbstractNote`, `ItalianNote`, `EnglishNote`)
  - `2025-07-09` (`Figure`, `AbstractFigure`, `Triangle`, `Circle`, `Frame`)
  - `2025-09-09` / `2022-06-16` (`Dado`, `AbstractDado`, `DadoUniforme`, `D6`, `D8`, `D10`, `D6Truccato`)
  - `2022-03-04` (`Product`, `ProductNotExpiring`, `ProductWithExpiration`, `Supermarket`)
  - `2019-01-29` (`Model`, `AbstractModel`, `Car`, `Bus`, `Truck`, `Motorbike`)
  - `2018-06-21` (`Number`, `AbstractNumber`, `BinaryNumber`, `DecimalNumber`, `HexNumber`, `Base58Number`)
  - `2017-06-26` (`Pizza`, `AbstractPizza`, `Margherita`, `PizzaWith`, `PizzaWithout`)
* **Struttura di soluzione:**
  - L'interfaccia stabilisce i contratti pubblici.
  - La classe astratta (`Abstract...`) detiene i campi immutabili (`private final`), implementa la logica comune, i metodi standard (`equals`, `hashCode`), e lascia astratti i metodi specifici (es. `getSuffix()`, `format()`).
  - Le classi concrete invocano `super(...)` nel costruttore e implementano esclusivamente il comportamento differenziante.

### 2. Iteratori Personalizzati e Sequenze Dinamiche (`Iterable` / `Iterator`)
* **Temi tipici:** Generazione lazy di intervalli temporali, scale musicali, date, sequenze numeriche o simulazioni di lanci.
* **Appelli rappresentativi:**
  - `2025-02-05` (`Interval` — sequenza di istanti temporali consecutivi)
  - `2025-02-20` (`Scale` — iterazione sulle note di una scala musicale con shift)
  - `2021-09-01` (`Dates` — iterazione su tutti i giorni di un anno)
  - `2022-06-16` / `2025-09-09` (`Lanci`, `LanciFrecce`, `LanciFrecceAlternate` — sequenze di estrazioni da dadi)
  - `2019-07-25` (`Words` — estrazione iterativa di parole da testo)
  - `2012-09-24` (`Numbers`, `Concat`, `Alternate`, `UpTo` — combinatori di sequenze numeriche)
* **Struttura di soluzione:**
  - La classe implementa `Iterable<T>`.
  - Il metodo `iterator()` restituisce un'istanza di classe anonima (`new Iterator<T>() { ... }`).
  - Lo stato (indice, cursore, elemento corrente) è incapsulato privatamente nell'iteratore.
  - `hasNext()` è una pura query (idempotente e senza side-effect).
  - `next()` valida lo stato con `if (!hasNext()) throw new NoSuchElementException();`, aggiorna il cursore e restituisce l'elemento.

### 3. Strutture Dati Specializzate, Mappe e Insiemi Generici
* **Temi tipici:** Contenitori con semantiche avanzate di appartenenza, scadenza o ricerca per prefisso.
* **Appelli rappresentativi:**
  - `2024-02-16` (`PrefixMap<V>` — mappa interrogabile per prefisso di chiave stringa)
  - `2023-07-05` (`PunishableSet<E>` — insieme con elementi dotati di punteggio, perdonabili/punibili fino a rimozione)
  - `2019-09-26` (`Graph<E>` — grafo orientato generico con nodi e archi interni)
  - `2024-02-01` (`Sudoku` — griglia di gioco con validazione di righe, colonne e sottomatrici)
  - `2012-09-03` (`ArraySet<E>`, `ModifiableArraySet<E>` — insiemi basati su array dinamici)
* **Struttura di soluzione:**
  - Uso massiccio di Generics (`<E>`, `<K, V>`).
  - Incapsulamento di collezioni standard Java (`Map<K, Integer>`, `List<E>`, `Set<E>`) all'interno della classe come campi `private final`.
  - Protezione dell'invariante di classe e delegazione selettiva delle operazioni.

### 4. Pattern Composite, Interpreti e Strutture ad Albero / Stack
* **Temi tipici:** Esecuzione di programmi tramite istruzioni su stack o navigazione gerarchica di file system ed espressioni.
* **Appelli rappresentativi:**
  - `2024-06-20` (`Component`, `AbstractComponent`, `FileComponent`, `DirectoryComponent` — filesystem ad albero)
  - `2023-09-29` (`Instruction`, `Machine`, `SimpleMachine`, `PrintingMachine`, `ADD`, `SUB`, `MUL`, `DIV`, `PUSH`, `POP`, `REPEAT`)
  - `2013-07-15` (`Spreadsheet`, `Cell`, `Exp`, `Add`, `Div`, `NumericConstant`, `StringConstant`)
* **Struttura di soluzione:**
  - Pattern **Composite**: Interfaccia comune `Component`, foglia `FileComponent` con dimensione esplicita, contenitore `DirectoryComponent` con lista interna di figli e calcolo ricorsivo di dimensione e rendering con indentazione.
  - Pattern **Interpreter**: Istruzioni che mutano uno stack (`List<Integer>`) e sollevano eccezioni verificate di dominio (`IllegalProgramException`, `EvaluationException`) in caso di underflow, divisione per zero o cicli.

### 5. Modelli di Dominio, Viste e Ordinamenti Multipli
* **Temi tipici:** Sistemi di gestione corsi/esami, sondaggi Doodle, cataloghi editoriali o elezioni con conteggi e raggruppamenti.
* **Appelli rappresentativi:**
  - `2024-09-13` (`Corso`, `Esame`, `Studente`, `StudenteLavoratore`, `StudenteIllegaleException`)
  - `2023-02-09` (`Doodle`, `WeightedDoodle`, `Person`, `CEO`, `CTO`, `Programmer`, `Secretary`, `Slot`)
  - `2022-07-05` / `2016-02-03` / `2013-02-04` (`Elezioni`, `Partito`, `VotiPerPartito`, `ElezioniVincitore`)
  - `2021-06-17` (`Library`, `Book`, `LibraryBySize`, `LibraryEnglishFirst`)
  - `2018-02-07` (`HairBnB`, `Room`, `Review`, `NoRoomAvailableException`)
  - `2018-02-27` (`Esame`, `EsamePerMatricola`, `EsamePerEsito`, `Studente`, `Esito`)
* **Struttura di soluzione:**
  - Ordinamento naturale tramite `Comparable<T>` (`compareTo`).
  - Ordinamenti alternativi tramite sottoclassi o `Comparator<T>` (es. ordinamento per lunghezza prima che alfabetico).
  - Raggruppamenti tramite `Map<Key, List<Value>>` o `TreeMap` per conservare l'ordinamento delle chiavi.

---

# 3. Analisi Dettagliata dei Pattern e Idiomi di Soluzione

Nelle soluzioni ufficiali del docente si riscontrano pattern di codice altamente standardizzati:

### A. Contratti `equals` e `hashCode`
Il docente predilige la sintassi concisa a singola espressione:
```java
@Override
public boolean equals(Object other) {
    return other instanceof MyClass &&
           this.stringField.equals(((MyClass) other).stringField) &&
           this.intField == ((MyClass) other).intField;
}

@Override
public int hashCode() {
    return stringField.hashCode() ^ Integer.hashCode(intField);
    // oppure: return Objects.hash(stringField, intField);
}
```

### B. Implementazione degli `Iterator`
Pattern canonico con classe anonima:
```java
@Override
public Iterator<T> iterator() {
    return new Iterator<T>() {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("Nessun ulteriore elemento");
            return computeOrGet(cursor++);
        }
    };
}
```

### C. Validazione dei Costruttori
Controllo rigoroso dei parametri prima dell'assegnazione dei campi:
```java
public ConcreteTime(int seconds) {
    if (seconds < 0 || seconds >= 86400)
        throw new IllegalArgumentException("Secondi illegali: " + seconds);
    this.seconds = seconds;
}
```

### D. Eccezioni di Dominio
Definizione pulita con passaggio del messaggio alla superclasse:
```java
package it.univr.domain;

public class DomainException extends Exception { // o RuntimeException
    public DomainException(String message) {
        super(message);
    }
    public DomainException() {
        super();
    }
}
```

### E. Incapsulamento e Copie Difensive
Se un metodo pubblico restituisce elementi o liste memorizzati internamente:
```java
public List<Component> getChildren() {
    return Collections.unmodifiableList(this.children);
}
```

---

# 4. Catalogo e Mappatura degli Appelli (2012–2025)

| Anno / Appello | Package | Concetto Chiave | Classi Principali |
| :--- | :--- | :--- | :--- |
| **2025-09-09** | `it.univr.dadi` | Gerarchia Dadi & Sequenze Lanci con barre/frecce | `Dado`, `AbstractDado`, `DadoUniforme`, `D6`, `D8`, `D10`, `D6Truccato`, `Lanci` |
| **2025-07-09** | `it.univr.figures` | Figure geometriche su righe con matrici ASCII | `Figure`, `AbstractFigure`, `Triangle`, `Circle`, `Frame`, `NoSuchRowException` |
| **2025-02-20** | `it.univr.notes` | Canzoni, Scale musicali, Iteratori lazy | `Note`, `AbstractNote`, `ItalianNote`, `EnglishNote`, `Song`, `Scale` |
| **2025-02-05** | `it.univr.time` | Tempo modulare 24h, formattazione IT/US, intervalli | `Time`, `AbstractTime`, `ItalianTime`, `AmericanTime`, `Interval` |
| **2024-09-13** | `it.univr.corso` | Gestione esami studenti, studenti lavoratori, CFU | `Corso`, `Esame`, `Studente`, `StudenteLavoratore`, `StudenteIllegaleException` |
| **2024-06-20** | `it.univr.file` | Composite Pattern filesystem (File / Directory) | `Component`, `AbstractComponent`, `FileComponent`, `DirectoryComponent` |
| **2024-02-16** | `it.univr.prefix` | Mappa generica con lookup per prefisso chiave | `PrefixMap<V>` |
| **2024-02-01** | `it.univr.sudoku` | Validazione Sudoku & formattazione con Emoji | `Sudoku`, `Emoji` |
| **2023-09-29** | `it.univr.instructions` | Macchina a stack virtuale & interprete bytecode | `Instruction`, `Machine`, `SimpleMachine`, `PrintingMachine`, `ADD`, `PUSH`, `REPEAT` |
| **2023-07-05** | `it.univr.sets` | Insieme generico con sistema di punizioni/punteggio | `PunishableSet<E>` |
| **2023-02-24** | `it.univr.quindici` | Gioco del 15 & Factory di tessere numeriche/alfabetiche | `Gioco`, `Tessera`, `FattoriaDiTessere` |
| **2023-02-09** | `it.univr.doodle` | Doodle ponderato con pesi per ruolo aziendale | `Doodle`, `WeightedDoodle`, `Person`, `CEO`, `CTO`, `Programmer` |
| **2022-09-02** | `it.univr.letters` | Lettere maiuscole/minuscole & alfabeto Vulcaniano | `Letters`, `LowerCase`, `Vulcanian` |
| **2022-07-05** | `it.univr.elezioni` | Voti di partito e determinazione del vincitore | `Elezioni`, `ElezioniVincitore`, `Partito`, `VotiPerPartito` |
| **2022-06-16** | `it.univr.dadi` | Simulazione estrazioni dadi a 6/8/10 facce e grafici | `Dado`, `D6`, `D8`, `D10`, `Lanci`, `LanciBarreDiverse` |
| **2022-03-04** | `it.univr.supermarket` | Prodotti con/senza scadenza e supermercato ordinato | `Product`, `ProductWithExpiration`, `ProductNotExpiring`, `Supermarket` |
| **2022-02-02 (v1/v2/v3)** | `it.univr.identifiers` | Identificatori multi-parola (Camel, Snake, Vowel, Three) | `Identifier`, `MultiWordIdentifier`, `CamelStyleIdentifier`, `SnakeStyleIdentifier` |
| **2021-09-01** | `it.univr.dates` | Date, anni bisestili e iterazione su giorni | `Date`, `Dates` |
| **2021-07-20** | `it.univr.bank` | Conti bancari con vincolo di saldo minimo | `Bank`, `SimpleBank`, `BankWithMinimum`, `BankException` |
| **2021-06-17** | `it.univr.books` | Libreria con ordinamenti multipli (taglia, lingua) | `Book`, `Library`, `LibraryBySize`, `LibraryEnglishFirst` |
| **2021-04-30 (es1/es2)** | `it.univr.insurance` | Polizze assicurative e stagionalità | `Insurance`, `Season` |
| **2020-02-05** | `it.univr.cards` | Mazzo di carte da poker e punteggi | `Card`, `Deck`, `Ranking`, `Suit`, `Value` |
| **2019-09-26** | `it.univr.graph` | Grafo orientato generico con nodi interni | `Graph<E>`, `Graph.Node` |
| **2019-07-25** | `it.univr.words` | Iteratore di estrazione parole da stringa | `Words` |
| **2019-06-24** | `it.univr.tictactoe` | Tris semplice e varianti su griglia | `TicTacToe`, `SimpleTicTacToe`, `RowsTicTacToe`, `FullTicTacToe` |
| **2019-02-18 (v1/v2)** | `it.univr.library` | Catalogo multimediale con libri cartacei/audiolibri | `Book`, `PaperBook`, `AudioBook`, `Catalog`, `CatalogWithStatistics` |
| **2019-02-04 (v1/v2)** | `it.univr.agenda` | Gestione appuntamenti orari e date trimestrali | `Event`, `Time`, `ItalianTime`, `AmericanTime`, `Date`, `QuarterDate` |
| **2019-01-29** | `it.univr.rent` | Flotta noleggio veicoli con patenti e disponibilità | `Model`, `AbstractModel`, `Car`, `Bus`, `Truck`, `Motorbike`, `Agency` |
| **2018-09-28** | `it.univr.music` | Note musicali italiane/inglesi e spartiti | `Note`, `ItalianNote`, `EnglishNote`, `Song` |
| **2018-06-21** | `it.univr.numbers` | Numeri in base 2, 8, 10, 16, 58 e parità | `Number`, `AbstractNumber`, `BinaryNumber`, `DecimalNumber`, `HexNumber` |
| **2018-02-27** | `it.univr.esami` | Registrazione esami per matricola o voto | `Esame`, `EsamePerMatricola`, `EsamePerEsito`, `Studente`, `Esito` |
| **2018-02-07** | `it.univr.hairbnb` | Prenotazione camere con recensioni e stelle | `HairBnB`, `Room`, `Review` |
| **2017-09-04** | `it.univr.airbust` | Prenotazioni aeree e gestione flotta velivoli | `Aircraft`, `Fleet`, `AirBustFleet`, `Bookings`, `AirBustBookings` |
| **2017-07-28** | `it.univr.ecommerce` | E-commerce, carrello e ordini splittati | `Product`, `Shop`, `Order`, `SimpleOrder`, `SplitOrder` |
| **2017-06-26** | `it.univr.pizza` | Menu pizzeria con aggiunta e rimozione ingredienti | `Pizza`, `AbstractPizza`, `Margherita`, `PizzaWith`, `PizzaWithout` |
| **2017-02-03** | `it.univr.doodle` | Selezione date disponibili tramite Doodle | `Doodle`, `Slot`, `WeightedDoodle` |
| **2016-09-06** | `it.univr.phones` | Rubrica telefonica con viste ordinate e per sesso | `PhoneBook`, `View`, `SortedView`, `SexView` |
| **2016-06-21** | `it.univr.email` | Server di posta e mailbox utenti | `Email`, `Mailbox`, `Server` |
| **2016-02-24** | `it.univr.palestra` | Registro iscrizioni palestra con vincoli temporali | `Registro`, `Iscrizione`, `Utente`, `Mese` |
| **2016-02-03** | `it.univr.elezioni` | Elezioni con calcolo istogrammi di voti | `Elezioni`, `ElezioniIstogramma`, `Partito`, `VotiPerPartito` |
| **2015-09-30** | `it.univr.date` | Pattern MVC per visualizzazione date | `Model`, `View`, `Controller`, `SwingDateView`, `TextDateView` |
| **2015-06-18** | `it.univr.charseq` | Sequenze di caratteri e codici di controllo | `AbstractCharSequence`, `Alphabetical`, `ControlCode` |
| **2015-02-23** | `it.univr.life` | Gioco della vita (Conway Life) con figure note | `Board`, `Cell`, `Figure`, `Blinker`, `Glider`, `Toad`, `Ship` |
| **2015-02-02** | `it.univr.paranoid` | Store di applicazioni e installazione su device | `Store`, `Device`, `App`, `OS` |
| **2014-09-15** | `it.univr.token` | Tokenizzazione di stringhe su delimitatori | `Tokenization`, `StringTokenization`, `DoubleTokenization` |
| **2014-07-14** | `it.univr.identifiers` | Identificatori progressivi Camel/Snake | `Identifier`, `ProgressiveIdentifier`, `CamelStyleIdentifier` |
| **2014-02-28** | `it.univr.cartellone` | Cartellone partenze/arrivi treni modificabile | `Cartellone`, `CartelloneModificabile`, `CartelloneLimitato`, `Train` |
| **2014-02-07** | `it.univr.freebay` | Carrello acquisti con prodotti 3x2 e scontati | `Cart`, `Product`, `DiscountedProduct`, `Buy2Take3Product` |
| **2013-09-27** | `it.univr.numeri` | Numeri BCD e conversioni tra basi | `Numero`, `AbstractNumero`, `NumeroInBaseDue`, `NumeroBCD` |
| **2013-09-02** | `it.univr.quindici` | Tessere gioco del 15 con Factory | `Gioco`, `Tessera`, `FattoriaDiTessere` |
| **2013-07-15** | `it.univr.spreadsheet` | Foglio di calcolo con formule ed eccezioni di ciclo | `Sheet`, `Cell`, `Exp`, `Add`, `Div`, `NumericConstant` |
| **2013-06-24** | `it.univr.musica` | Canzoni ribasate e note musicali | `Nota`, `NotaIT`, `NotaUK`, `Canzone`, `CanzoneRibasata` |
| **2013-02-26** | `it.univr.calendar` | Calendario eventi con intervalli temporali | `Calendar`, `Event`, `Time` |
| **2013-02-04** | `it.univr.elezioni` | Partiti, coalizioni ed elezioni | `Elezione`, `Partito`, `Coalizione` |
| **2012-09-24** | `it.univr.numbers` | Sequenze numeriche con combinatori | `Numbers`, `From`, `UpTo`, `Concat`, `Alternate` |
| **2012-09-03** | `it.univr.sets` | Insiemi modificabili su array | `Set`, `ModifiableSet`, `ArraySet`, `ModifiableArraySet` |
| **2012-07-06** | `it.univr.plot` | Grafici di campioni sequenziali e alternati | `Plot`, `SequentialPlot`, `AlternatePlot`, `Sample` |
| **2012-06-18** | `it.univr.poly` | Polinomi di secondo grado | `Polynomial`, `SecondDegreePolynomial` |
| **2012-02-06** | `it.univr.television` | Telecomando e comandi televisivi | `Television`, `Controller`, `Command` |

---

# 5. Le Trappole più Frequenti e Errori Fatali

| Errore Fatale | Conseguenza nei Test | Come risolverlo |
| :--- | :--- | :--- |
| **`hasNext()` con effetti collaterali** | Chiamare `hasNext()` due volte di fila salta un elemento o corrompe la sequenza. | `hasNext()` deve essere **puro**: verifica solo la condizione di terminazione senza incrementare contatori o cursori. L'avanzamento spetta solo a `next()`. |
| **Mancata `NoSuchElementException`** | Se il test invoca `next()` a fine iterazione e ottiene `null` o `IndexOutOfBoundsException`, il test fallisce. | Inserire come prima riga di `next()`: `if (!hasNext()) throw new NoSuchElementException();`. |
| **Esposizione di riferimenti mutabili interni** | I test modificano la lista restituita dall'esterno e corrompono lo stato interno dell'oggetto. | Restituire `Collections.unmodifiableList(...)`, `Collections.unmodifiableSet(...)` o una copia difensiva (`new ArrayList<>(this.items)`). |
| **Incoerenza tra `equals` e `hashCode`** | L'oggetto non viene ritrovato in `HashSet` o usato come chiave in `HashMap`. | Se due oggetti sono uguali secondo `equals()`, devono tassativamente produrre lo stesso `hashCode()`. Includere in `hashCode()` gli stessi campi valutati in `equals()`. |
| **Duplicazione di codice tra sottoclassi** | Penalità pesante per mancata fattorizzazione OOP. | Spostare campi `private final`, validazioni e logiche condivise nella classe astratta genitore (`Abstract...`). |
| **Modificatori `public` su metodi helper aggiunti** | Violazione delle specifiche di consegna. | Dichiarare rigorosamente `private` ogni metodo ausiliario o campo introdotto ex novo. |

---

# 6. MASTER PROMPT PER L'INTELLIGENZA ARTIFICIALE

*Di seguito è riportato il prompt master pronto per essere utilizzato come System Prompt o User Prompt per qualsiasi LLM.*

```markdown
Sei un esperto sviluppatore Java e docente del corso di "Programmazione II" dell'Università di Verona (Dipartimento di Informatica). Il tuo compito è risolvere i temi d'esame del corso o guidare lo studente alla loro risoluzione, garantendo il 100% dei punti e la conformità totale alle regole di correzione automatica e manuale del docente.

### REGOLE FERREE DI CONSEGNA E COMPILAZIONE:
1. IL CODICE DEVE COMPILARE SENZA ERRORI O WARNING. Un errore di compilazione comporta 0 punti.
2. NON MODIFICARE MAI i nomi dei package, delle classi, delle interfacce e le firme dei metodi/costruttori forniti nella consegna/stub.
3. VISIBILITÀ: Qualsiasi campo, metodo di supporto o costruttore aggiuntivo DEVE essere rigorosamente `private`. È vietato aggiungere metodi `public` o `protected` non esplicitamente richiesti dal testo.
4. Consegna solo ed esclusivamente i file `.java` richiesti (più eventuali classi ausiliarie create appositamente, che devono appartenere allo stesso package).

### STANDARD E IDIOMI DI IMPLEMENTAZIONE:

1. GERARCHIE, CLASSI ASTRATTE E POLIMORFISMO:
   - Quando esiste una classe astratta (es. `AbstractX`) e classi figlie (es. `ConcreteA`, `ConcreteB`), FATTORIZZA TUTTO il codice comune, i campi `private final` e i controlli dei costruttori nella classe astratta genitore.
   - Nelle sottoclassi invoca sempre `super(...)` come prima istruzione e implementa solo i metodi astratti e differenzianti.

2. ITERATORI (Iterable<T> / Iterator<T>):
   - Implementa `Iterable<T>` restituendo un'istanza di classe anonima `new Iterator<T>() { ... }`.
   - `hasNext()` DEVE essere un metodo puro e idempotente: NON deve mai modificare indici, cursori o stato interno.
   - `next()` DEVE verificare `if (!hasNext()) throw new NoSuchElementException();`, avanzare il cursore interno e restituire l'elemento corrente.

3. CONTRATTI STANDARD DI OBJECT:
   - `equals(Object other)`: usa SEMPRE il pattern conciso:
     `return other instanceof MyClass && this.campo.equals(((MyClass) other).campo) && this.primitivo == ((MyClass) other).primitivo;`
   - `hashCode()`: DEVE essere coerente con `equals()`. Combina gli hash con `^`, `Objects.hash(...)` o `31 * result + ...`.
   - `toString()`: Rispetta maniacalmente il formato richiesto dal testo e visibile nel `Main.java` (parentesi, virgole, spazi, padding `%02d`, terminatori di riga).

4. VALIDAZIONE E GESTIONE ECCEZIONI:
   - Valida subito i parametri nei costruttori e metodi: se non validi (null, valori negativi, fuori range), lancia `IllegalArgumentException` o `NullPointerException` secondo specifica.
   - Le eccezioni personalizzate devono estendere `Exception` (se checked) o `RuntimeException` (se unchecked) e implementare il costruttore `public CustomException(String msg) { super(msg); }` o `public CustomException() { super(); }`.

5. COLLEZIONI, INCAPSULAMENTO E GENERICS:
   - Dichiara i campi di tipo interfaccia (`List<T>`, `Set<T>`, `Map<K, V>`) e istanziali con `ArrayList`, `HashSet`, `TreeSet`, `HashMap`, `TreeMap`.
   - Campi interni SEMPRE `private final`. Non esporre mai riferimenti diretti a collezioni mutabili private (usa `Collections.unmodifiableList(...)` o copie difensive).
   - Gestisci correttamente i generics `<E>`, `<K, V>` e i bounded wildcards (`<? extends T>`, `<? super T>`) quando richiesto da `Comparable` o collezioni.

6. STRUTTURE COMPOSITE E RICORSIONE:
   - Nei problemi ad albero / composite / interpreti (es. file system, AST, macchine a stack), usa metodi ricorsivi di supporto `private` per attraversare la struttura o formattare con indentazione progressiva.

Quando ti viene fornito un tema d'esame (testo .tex/pdf o stub Java):
1. Analizza la gerarchia dei tipi e individua cosa va fattorizzato.
2. Identifica i casi limite (sequenze vuote, indici fuori scala, null, overflow).
3. Produci il codice Java completo di ogni file richiesto, pronto per essere salvato e compilato senza ulteriori modifiche.
```
