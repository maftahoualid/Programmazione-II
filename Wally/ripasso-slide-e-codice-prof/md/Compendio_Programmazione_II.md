# Programmazione II — Compendio Generale Teorico e Pratico

**Autore:** Wally  
**Docente:** Prof. Michele Pasqua  
**Anno Accademico:** 2025/2026 — Università degli Studi di Verona

## Prefazione e Metodologia di Studio

Questo compendio unifica tutte le 19 revisioni dettagliate (Slide T01–T20) dell'insegnamento di Programmazione II.
Ogni capitolo analizza minuziosamente la teoria, il codice incrementale (SimpleDate e MavenDate), le trappole d'esame e le best practice.

## Indice dei Capitoli

1. [T01 --- Course Introduction & Metodologia del Corso](#capitolo-1) — *Obiettivi Formativi, Modalità d'Esame al Calcolatore, Toolchain e Syllabus*
2. [T02 --- Paradigma ad Oggetti e Modellazione UML](#capitolo-2) — *Astrazione, Incapsulamento, Modularità, Gerarchia e Sintassi dei Class Diagram*
3. [T03 --- Compilazione, Esecuzione e Deployment](#capitolo-3) — *JVM, Bytecode, JDK vs JRE, Strumenti CLI (javac, java, jar) e Apache Maven*
4. [T04 --- Sistema di Tipi, Primitive e Reference](#capitolo-4) — *Tipi Primitivi vs Reference, Casting, Wrapper, Operatori e Analisi di Example.java*
5. [T05–T06 --- Sintassi Java, Strutture di Controllo e Classi Base](#capitolo-5) — *Costrutti Condizionali e Iterativi, Definizione di Classe e Nascita del Progetto SimpleDate*
6. [T07 --- Librerie Standard e Manipolazione delle Stringhe](#capitolo-6) — *Java Class Library, Immutabilità della Classe String, Metodi Fondamentali e SimpleDate v2*
7. [T08 --- Costruttori, Inizializzazione ed Incapsulamento](#capitolo-7) — *Ciclo di Inizializzazione, Overloading dei Costruttori, Modificatori e SimpleDate v3*
8. [T09 --- Array, Matrici e Tipi Enumerativi (enum)](#capitolo-8) — *Array Mono e Multidimensionali, Enum Tipizzati, Immutabilità e Singleton in SimpleDate v4*
9. [T10 --- Variabili, Scope, Call Stack e Memoria Heap](#capitolo-9) — *Stack Frame, Passaggio dei Parametri per Valore, Garbage Collection e Debutto di MavenDate*
10. [T11 --- Package, Moduli e Regole di Visibilità](#capitolo-10) — *Struttura Cartelle, Modificatori public/protected/default/private e MavenDate v2 con equals()*
11. [T12 --- Ereditarietà, Dynamic Binding e Polimorfismo](#capitolo-11) — *Estensione di Classi, super, Overriding vs Overloading, Polimorfismo e MavenDate v3*
12. [T13 --- Classi Astratte ed Interfacce](#capitolo-12) — *Contratti Comportamentali, Metodi Astratti, Default e Static Methods, Builder Pattern e Lambda*
13. [T14 --- Classi Annidate, Interne, Locali ed Anonime](#capitolo-13) — *Static Nested vs Inner Classes, Enclosing Pointer, Shadowing, Effectively Final e Classi Anonime*
14. [T15 --- Tipi Generici, Wildcard e Type Erasure](#capitolo-14) — *Polimorfismo Parametrico, Bounded Type Parameters, Invarianza, Wildcard (PECS) e Type Erasure*
15. [T16 --- Java Collections Framework (JCF)](#capitolo-15) — *Gerarchia Collection, List, Set, Map, Queue; Prestazioni e Scelta delle Strutture Dati*
16. [T17 --- Gestione degli Errori ed Architettura delle Eccezioni](#capitolo-16) — *Gerarchia Throwable, Checked vs Unchecked, try-catch-finally, Try-with-resources e AutoCloseable*
17. [T18 --- Interfacce Funzionali, Espressioni Lambda e Streams API](#capitolo-17) — *Predicate, Function, Consumer, Supplier, Method Reference (::) e Pipeline Stream*
18. [T19 --- Documentazione con Javadoc e Unit Testing con JUnit 5](#capitolo-18) — *Convenzioni Javadoc, Architettura JUnit 5, Annotazioni di Ciclo di Vita ed Asserzioni*
19. [T20 --- Java I/O, Streams, File, NIO.2 e Serializzazione](#capitolo-19) — *Byte Streams vs Character Streams, Bufferizzazione, Decorator Pattern I/O e Serializzazione*

---


# Capitolo 1: T01 --- Course Introduction & Metodologia del Corso

*Obiettivi Formativi, Modalità d'Esame al Calcolatore, Toolchain e Syllabus*

Benvenuto in questa revisione completa e metodica di **Programmazione II** (Prof. Michele Pasqua, UniVR 2025/2026).
Seguiremo fedelmente le regole stabilite: **nessuna omissione**, analisi minuziosa di ogni concetto teorico, confronto riga per riga del codice, evidenziazione delle finezze d'esame e stop interattivo a ogni blocco.

## Teoria:  Concetti Teorici dalle Slide ([T01 - Course Introduction.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T01%20-%20Course%20Introduction.pdf))

La slide introduttiva definisce il perimetro accademico, gli obiettivi formativi e le modalità d'esame:

1. **Docente e Background Scientifico**:
   - **Prof. Michele Pasqua** (Dipartimento di Informatica, Cà Vignal 2, 2° piano, Stanza 24 — `michele.pasqua@univr.it`).
   - Aree di ricerca: *Program verification and validation*, *Programming language design and implementation*, *Code protection and software security*.
   - Laboratori e progetti: co-fondatore del laboratorio **UNIVERSE** (*University of Verona Software Engineering Lab*, diretto dal Prof. Mariano Ceccato) e co-fondatore dello spin-off universitario **KonTrust Srl** (tracciamento IoT su blockchain e infrastrutture anti-manomissione); referente per Verona del programma nazionale di formazione e gare su cybersecurity (*CyberChallenge.IT*).

2. **Organizzazione della Didattica**:
   - **Modulo di Teoria (40+ ore)**: Lunedì (16:30) e Martedì (13:30) in Aula A (2 ore ciascuna).
   - **Modulo di Laboratorio (12+ ore)**: Martedì (10:30) in Aula Delta (2 ore).
   - **Materiale didattico di riferimento**:
     - Paul J. Deitel & Harvey M. Deitel, *Java – How to Program*, Pearson (11/e – 2018).
     - Claudio De Sio Cesari, *Il nuovo Java – Guida alla programmazione moderna*, Hoepli (1/e – 2020).
     - Moodle UniVR: slide, esercizi di laboratorio e soluzioni, simulazioni.

3. **Modalità d'Esame e Valutazione**:
   - **Formato**: Prova pratica al calcolatore in **Aula Delta** (ambiente Linux/IDE).
   - **Contenuto**: Risoluzione di una serie di esercizi di programmazione in linguaggio Java (sviluppo classi, gerarchie a oggetti, implementazione interfacce, algoritmi su collezioni, gestione eccezioni, test con asserzioni/JUnit).
   - **Voto finale**: Somma algebrica dei punti ottenuti nei singoli esercizi.
   - È prevista una **simulazione d'esame** ufficiale a fine corso.

4. **Syllabus del Corso (Mappa degli argomenti da T01 a T20)**:
   - *Object-Orientation Principles* (T02)
   - *Building, Running, and Deployment* (T03)
   - *Types, Classes, and Objects* (T04)
   - *Java Syntax and Semantics* (T05)
   - *Java Classes and Objects* (T06)
   - *Libraries and String Class* (T07)
   - *Class Constructors and Encapsulation* (T08)
   - *Arrays and Enumerative Types* (T09)
   - *Java Variables and Call Stack* (T10)
   - *Class and Package Visibility* (T11)
   - *Inheritance and Polymorphism* (T12)
   - *Abstract Classes and Interfaces* (T13)
   - *Nested and Anonymous Classes* (T14)
   - *Generic Types* (T15)
   - *Collections* (T16)
   - *Error Handling with Exceptions* (T17)
   - *Functional Interfaces and Streams* (T18)
   - *Documentation and Unit Testing* (T19)
   - *Java IO* (T20)

---

## Codice:  Analisi del Codice della Lezione 1

- Nella cartella ufficiale delle lezioni [`Codice-20260902`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902):
  - **Non sono presenti file di codice per le Lezioni 01, 02 e 03**.
  - Il primo codice sorgente ufficiale del docente compare a partire dalla **Lezione 04** con [`Example.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione04/Example.java) (dedicato a tipi primitivi, reference, casting e operatori), mentre il progetto a oggetti incrementale vero e proprio parte dal blocco **Lezioni 05-06** con il progetto `SimpleDate` (`Date.java` e `MainDate.java`).
- Nel tuo workspace [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26):
  - La cartella [`es01`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es01) è già predisposta come modulo Maven con la prima incarnazione di `Date` e `MainDate`, sincronizzata con la struttura multi-modulo orchestrata dal [`pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/pom.xml) di root e dallo script [`esercizi.sh`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/esercizi.sh).

---

## Setup:  Configurazione Operativa dell'Ambiente

Per garantire che tutti i passaggi da qui in avanti siano riproducibili su IntelliJ IDEA e da CLI:
1. Verifica che la JDK attiva sia Java 17 o superiore:
   ```bash
   java -version
   mvn -v
   ```
2. Il file di root [`pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/pom.xml) gestisce l'aggregazione di tutti i sottomoduli. Per ogni blocco successivo, quando andremo ad analizzare le classi introdotte a lezione, verificheremo che compilino ed eseguano pulitamente sia tramite:
   ```bash
   ./esercizi.sh run <numero_modulo>
   ```
   sia all'interno di IntelliJ IDEA.

---

> [!NOTE]
> La **Lezione 1 / T01** esaurisce qui la parte introduttiva/organizzativa.
> Il prossimo blocco è la **Lezione 2 / Slide T02: *Object-Orientation and UML***, dove entreremo nel vivo con:
> - Storia e tassonomia dei paradigmi: *Imperativo/Procedurale*, *Dichiarativo/Funzionale*, *Object-Oriented*.
> - I 4 pilastri dell'OOP: *Astrazione, Incapsulamento, Ereditarietà, Polimorfismo*.
> - Concetto di *Classe* vs *Oggetto* (stato, comportamento, identità).
> - Notazione UML per classi e associazioni (*Visibility markers*, cardinalità, tipi di relazione).

**Dammi conferma quando sei pronto per passare a T02 (procederemo analizzando il blocco concettuale un po' alla volta)!**

---


# Capitolo 2: T02 --- Paradigma ad Oggetti e Modellazione UML

*Astrazione, Incapsulamento, Modularità, Gerarchia e Sintassi dei Class Diagram*

In questo blocco analizziamo la transizione teorico-metodologica dal paradigma procedurale a quello ad oggetti, i concetti cardine dell'OOP e la modellazione grafica tramite **UML** ([T02 - Object-Orientations and UML.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T02%20-%20Object-Orientations%20and%20UML.pdf)).

## Teoria:  Concetti Teorici dalle Slide

### La Tassonomia dei Linguaggi e il Bisogno di Astrazione (Slide 1–13)
- **Nessun linguaggio universale**: citando Edsger W. Dijkstra (*«Computer Science is no more about computers than Astronomy is about telescopes»*), il docente introduce il principio del **Golden Hammer** (*«If all you have is a hammer, everything looks like a nail»*): non esiste un linguaggio perfetto per tutto.
- **Evoluzione storica degli obiettivi**:
  - *Anni '50/'60*: focus sull'**efficienza del codice macchina**. L'hardware costava milioni e i programmatori poco: l'obiettivo era "tenere occupata la macchina" con linguaggi vicini al silicio.
  - *Oggi*: focus sull'**efficienza dello sviluppo del software**. L'hardware costa poco e i programmatori costano molto: l'obiettivo è "tenere produttivo il programmatore", abbattendo complessità, bug e costi di manutenzione tramite l'**astrazione**.
- **I Tre Paradigmi Fondamentali**:
  1. **Imperativo / Procedurale** (C, Pascal, Fortran, COBOL):
     - Basato sul concetto di **stato** (celle di memoria che memorizzano valori) e **comandi sequenziali** che mutano tale stato (assegnamenti).
     - Riuso del codice tramite procedure/funzioni che operano su dati esterni.
  2. **Dichiarativo**:
     - *Funzionale* (Haskell, Lisp): il programma è la valutazione di un'espressione matematica pura, basata su applicazione di funzioni e ricorsione (es. `add x y = x + y`). Assenza o minimizzazione degli effetti collaterali (*side effects*).
     - *Logico* (Prolog): il programma definisce relazioni, fatti e regole di deduzione logica; l'esecuzione è una risoluzione/unificazione guidata da query (es. `playsAirGuitar(sam) :- listens2Music(sam).`).
  3. **Object-Oriented (OOP)** (Smalltalk, Java, C++):
     - Unisce il nucleo imperativo (gli oggetti contengono uno stato interno) a tratti dichiarativi (gli oggetti espongono comportamenti invocabili senza conoscerne l'algoritmo interno).
     - Basato su **istanze** che comunicano tramite **passaggio di messaggi**.
- **Lo Spettro dell'Astrazione e il Trade-off di Overhead**:
  $$\text{Machine Code} \longrightarrow \text{Assembly} \longrightarrow \text{Procedurale} \longrightarrow \text{Object-Oriented} \longrightarrow \text{Funzionale}$$
  - Più si sale nell'astrazione:
    - **Programmer Overhead $\searrow$ (minimo)**: meno tempo perso a gestire registri, puntatori e memoria manuale.
    - **Compiler/Runtime Overhead $\nearrow$ (massimo)**: il compilatore/JVM deve effettuare controlli di tipo a runtime, garbage collection e risoluzione dinamica delle chiamate (*dynamic dispatch*).
- **Linea temporale**: dal 1949 (Assembly), Fortran (1957), C (1972), C++ (1983) fino all'avvento di **Java (1995)**, C# (2000) e linguaggi moderni multiparadigma (Swift 2014).

---

### La Crisi del Procedurale e la Nascita degli Oggetti (Slide 14–23)
Il prof. Pasqua presenta il caso di studio di un programma in C che manipola un vettore globale:
```c
int vect[20];
void sort() { /* ordina vect */ }
int search(int n) { /* cerca in vect */ }
void init() { /* inizializza vect */ }
int i;

void main() {
    init();
    sort();
    search(13);
}
```
**I 4 Difetti Letali dell'Approccio Procedurale evidenziati a lezione**:
1. **Relazione Implicita Dati-Funzioni**: `vect` e le funzioni `sort()`, `search()` sono entità slegate a livello di linguaggio. Non esiste un tipo autonomo "Vettore" che protegga se stesso.
2. **Nessun Controllo dei Confini (Out-of-Bounds)**: un ciclo come `for (i=0; i<=21; i++) vect[i]=0;` scrive in memoria oltre i 20 elementi, corrompendo altre variabili o lo stack senza alcun errore del compilatore (*buffer overflow*).
3. **Nessuna Garanzia sull'Inizializzazione**: se il programmatore dimentica di invocare `init()`, le funzioni `sort()` e `search()` lavorano su memoria sporca non inizializzata.
4. **Perdita di Confidenzialità e Integrità**: `vect` è accessibile in lettura/scrittura da *qualsiasi* funzione del programma. Su sistemi reali questo genera il cosiddetto **Spaghetti Code**.
- **La Regola delle Linee di Codice (LoC)**:
  - Per script < 30 LoC: lo stile procedurale è rapido e facile da mantenere.
  - Per progetti > 1000 LoC con team concorrenti: lo stile procedurale collassa; solo l'OOP permette di modularizzare garantendo la manutenibilità.
- **La Soluzione a Oggetti**:
  - Unire nello stesso modulo sia i dati (**attributi/campi**) sia le operazioni su di essi (**metodi**).
  - L'oggetto diventa l'unico responsabile della consistenza del proprio stato.

---

### Modellazione UML e Concetti Fondamentali di OOP (Slide 24–36)
- **UML (*Unified Modeling Language*)**: linguaggio grafico standard per specificare e documentare sistemi ad oggetti.
- **Differenza Ontologica tra Classe e Oggetto**:
  - **Classe**: è il *tipo* (blueprint / modello astratto). Definisce gli attributi e i metodi. Non occupa memoria nello heap per i dati dell'istanza finché non viene istanziata.
  - **Oggetto**: è l'**istanza concreta** nello **Heap**. Possiede:
    1. **Stato**: i valori correnti associati ai suoi attributi.
    2. **Comportamento**: i metodi che può eseguire.
    3. **Identità**: indirizzo di memoria univoco che lo distingue da tutti gli altri oggetti, anche se aventi lo stesso identico stato!
- **Rappresentazione grafica UML**:
  - **Classe (Rettangolo a 3 sezioni)**:
    1. Nome della classe (es. `Car`).
    2. Attributi con tipo (es. `manufacturer : string`, `model : string`).
    3. Metodi con segnatura (es. `canFly() : boolean`, `setFrameNumber(num : uint)`).
  - **Oggetto / Istanza (Rettangolo con nome sottolineato)**:
    - Es. `Car1: Car` con `manufacturer = DeLorean`, `model = DMC-12`.
- **Interazione a Passaggio di Messaggi (*Message Passing*)**:
  - Gli oggetti non leggono né modificano la memoria altrui direttamente: inviano richieste di servizio (*messaggi*).
  - L'**interfaccia** dell'oggetto è l'insieme di messaggi che esso accetta. Se invio un messaggio non previsto, si genera un errore di compilazione.
- **Visibilità**:
  - `+` (`public`): accessibile da qualsiasi classe.
  - `-` (`private`): accessibile esclusivamente dall'interno della classe stessa.
- **Incapsulamento vs Information Hiding**:
  - **Incapsulamento**: impacchettare dati e codice in una singola unità logica (la classe).
  - **Information Hiding**: nascondere i dettagli implementativi (rendendo i campi `private`) ed esporre solo un'interfaccia controllata (metodi `public`).
  - *Vantaggio chiave*: se cambiamo la struttura dati interna (es. da array a tabella hash), il codice esterno che usa i metodi pubblici non subisce alcun impatto (*zero refactoring esterno*).
- **Associazioni UML**:
  - **Associazione standard**: linea continua con cardinalità (es. `1` a `0..n` tra `Insurance` e `Vehicle`).
  - **Ereditarietà (Generalizzazione)**: freccia con punta triangolare vuota orientata verso la superclasse (`Car` estende `Vehicle`, `Truck` estende `Vehicle`).
- **I 4 Pilastri dell'OOP**:
  1. **Incapsulamento** (*Encapsulation*): bundling e protezione dello stato interno.
  2. **Astrazione** (*Abstraction*): separazione netta tra cosa un componente fa (interfaccia pubblica) e come lo fa (implementazione privata).
  3. **Ereditarietà** (*Inheritance*): meccanismo di riuso e specializzazione gerarchica di proprietà e comportamenti.
  4. **Polimorfismo** (*Polymorphism*): capacità di trattare istanze di classi diverse in modo uniforme attraverso un tipo o interfaccia comune.

---

## Codice:  Esempio Comparativo: Dal Vettore C all'Oggetto Java

Per apprezzare concretamente i concetti di T02, confrontiamo il frammento C difettoso mostrato dal docente con la sua trasposizione nativa ad oggetti in Java.

### Il Problema in C (Codice procedurale insicuro)
```c
// C procedurale: il dato è nudo e vulnerabile
int vect[20];
void init() { /* ... */ }

int main() {
    vect[25] = 999; // Corruzione di memoria silenziosa! Nessun errore a runtime.
    return 0;
}
```

### La Soluzione ad Oggetti in Java (Incapsulamento, Information Hiding, Costruttore)
In Java, l'oggetto controlla se stesso. Non esiste memoria non inizializzata e l'accesso fuori limite lancia un'eccezione esplicita a runtime:

```java
public class SafeVector {
    // 1. Information Hiding: il dato interno è inaccessibile all'esterno
    private final int[] elements;

    // 2. Garanzia di Inizializzazione: il costruttore viene eseguito all'atto del 'new'
    public SafeVector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("La dimensione deve essere positiva");
        }
        this.elements = new int[size]; // Nello Heap, azzerato di default a 0
    }

    // 3. Controllo dei confini e integrità: interfaccia controllata
    public void set(int index, int value) {
        // La JVM effettua l'ArrayBoundsCheck automatico, impedendo corruzioni di memoria
        this.elements[index] = value;
    }

    public int get(int index) {
        return this.elements[index];
    }

    public int size() {
        return this.elements.length;
    }
}
```

---

> [!IMPORTANT]
> **Takeaway per l'esame**:
> - Una classe non alloca memoria per lo stato fino alla chiamata a `new` (che alloca l'oggetto nello **Heap**).
> - L'Information Hiding si realizza marcando i campi di istanza come `private`.
> - I 4 pilastri dell'OOP (*Encapsulation*, *Abstraction*, *Inheritance*, *Polymorphism*) sono il filo conduttore dell'intero corso.

---

> [!NOTE]
> Il prossimo blocco è la **Lezione 3 / Slide T03: *Building, Running and Deployment in Java***, in cui studieremo:
> - Il modello di esecuzione Java: **Sorgente (.java) $\rightarrow$ Bytecode (.class) $\rightarrow$ JVM / JIT**.
> - I comandi CLI fondamentali: `javac`, `java`, `jar`, `javadoc`.
> - I concetti di **Classpath** (`-cp`) e gestione delle dipendenze.
> - **Apache Maven**: cicli di vita (*compile, test, package, install*), struttura directory standard (`src/main/java`, `src/test/java`) e il `pom.xml`.

**Dimmi quando sei pronto per passare a T03!**

---


# Capitolo 3: T03 --- Compilazione, Esecuzione e Deployment

*JVM, Bytecode, JDK vs JRE, Strumenti CLI (javac, java, jar) e Apache Maven*

In questo blocco analizziamo l'ecosistema tecnologico di Java, l'architettura della **Java Virtual Machine (JVM)**, i meccanismi di compilazione, il **Dynamic Class Loading**, la gestione del **Classpath** e le strategie di impacchettamento con file **JAR** ed eseguibili ([T03 - Building, Running and Deployment in Java.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T03%20-%20Building,%20Running%20and%20Deployment%20in%20Java.pdf)).

## Teoria:  Concetti Teorici dalle Slide

### Il Linguaggio Java e le sue Proprietà Fondamentali (Slide 1–11)
- **Cenni Storici**:
  - Creato da **James Gosling** presso Sun Microsystems (progetto *Oak* nel 1991, rilasciato ufficialmente come Java nel **1995**, poi acquisito da Oracle).
  - Motto: *"Write Once, Run Everywhere"* (WORA).
- **Le Caratteristiche Chiave del Linguaggio**:
  1. **Robustezza**:
     - *Tipizzazione forte e statica (Strongly Typed)*: ogni variabile ed espressione ha un tipo noto a tempo di compilazione; i vincoli di tipo sono verificati dal compilatore prima dell'esecuzione.
     - *Nessuna manipolazione esplicita di puntatori*: in Java non esistono l'operatore di indirizzo `&`, l'aritmetica dei puntatori né la deallocazione manuale (`free()`). Questo elimina alla radice *dangling pointers*, *segmentation fault* e *buffer overflow*.
     - *Controlli a runtime*: la JVM esegue verifiche automatiche su ogni accesso ad array (`ArrayIndexOutOfBoundsException`) e sui riferimenti (`NullPointerException`).
     - *Garbage Collection (GC) automatica*: un thread demone a bassa priorità della JVM individua ed elimina gli oggetti non più raggiungibili nello Heap, riducendo drasticamente i *memory leak*.
     - *Gestione strutturata degli errori*: gestione degli stati anomali tramite eccezioni controllate e non controllate (`try-catch-finally`).
  2. **Dinamicità**:
     - *Caricamento e linking dinamico (Dynamic Linking)*: le classi non vengono collegate in un unico binario monolitico a compile-time, ma sono caricate in memoria dalla JVM *on-demand*, solo quando effettivamente referenziate dal codice in esecuzione.
     - *Allocazione dinamica*: la dimensione delle strutture dati e degli array può essere determinata a runtime (`new int[size]`).
  3. **Portabilità e Architettura a Bytecode**:
     - Nei linguaggi puramente compilati (C/C++), il compilatore genera direttamente codice macchina specifico per l'architettura target (x86, x64, ARM) e per il sistema operativo (Linux, Windows, macOS). Il programmatore deve ricompilare o mantenere build cross-platform separate.
     - In Java, il compilatore (`javac`) traduce il sorgente `.java` in un formato intermedio indipendente dall'hardware: il **Bytecode** (`.class`).
     - È la **JVM** a farsi carico della traduzione del bytecode in istruzioni macchina della CPU ospitante. La portabilità cessa di essere un onere del programmatore e diventa un servizio fornito dal runtime.
  4. **Prestazioni e Compilatore JIT (*Just-In-Time*)**:
     - Java non è puramente interpretato. La JVM include un compilatore **JIT** che monitora a runtime le porzioni di bytecode eseguite più frequentemente (*hot spots*) e le compila al volo in codice macchina nativo ottimizzato, memorizzandole nella cache del codice.
- **Java vs JavaScript**:
  - Citazione di Christian Heilmann: *«Java is to JavaScript what Car is to Carpet»* (hanno in comune solo le prime quattro lettere). JavaScript nacque da Netscape con quel nome per motivi puramente commerciali; i due linguaggi non condividono né modello dei tipi, né macchina virtuale, né filosofia di design.

---

### Ecosistema Java: JDK vs JRE (Slide 11)
La distinzione tra ambiente di sviluppo e ambiente di esecuzione:
- **JDK (*Java Development Kit*)**: ambiente per programmatori:
  - `javac`: il compilatore che traduce sorgenti `.java` in bytecode `.class`.
  - `java`: il launcher applicativo che avvia la JVM.
  - `javadoc`: generatore di documentazione HTML a partire dai commenti speciali `/** ... */`.
  - `javap`: disassemblatore di bytecode (permette di ispezionare il bytecode generato).
  - `jdb`: debugger da riga di comando.
- **JRE (*Java Runtime Environment*)**: ambiente minimale per l'utente finale:
  - **JVM (*Java Virtual Machine*)**: il motore di esecuzione.
  - Librerie standard delle API Java (il modulo base `java.base` contenente `java.lang`, `java.util`, `java.io`, ecc.).
  - Compilatore JIT integrato.

---

### Compilazione, Esecuzione e Dynamic Class Loading (Slide 12–16)
1. **La Struttura del Programma Minimo**:
   ```java
   // Salvato obbligatoriamente in MyClass.java (stesso nome della classe pubblica)
   public class MyClass {
       public static void main(String[] args) {
           System.out.println("Hello World!");
       }
   }
   ```
   - *Regola aurea*: In un file `.java` può essere presente al massimo **una sola classe pubblica**, e il nome del file deve coincidere esattamente (incluso il maiuscolo/minuscolo) con il nome di tale classe.
   - *Firma del metodo `main`*:
     - `public`: deve essere accessibile dall'esterno da parte del launcher della JVM.
     - `static`: la JVM lo invoca direttamente sulla classe, senza dover prima istanziare un oggetto (`MyClass obj = new MyClass()`).
     - `void`: non restituisce un codice numerico di ritorno (l'uscita anomala si gestisce con `System.exit(code)`).
     - `String[] args`: array di stringhe contenente i parametri passati da riga di comando.

2. **Pipeline di Esecuzione della JVM**:
   $$\text{Sorgente } (.java) \xrightarrow{\texttt{javac}} \text{Bytecode } (.class) \xrightarrow{\text{Loader}} \text{Bytecode Verifier} \xrightarrow{\text{Interpreter / JIT}} \text{OS / Hardware}$$
   - **Bytecode Verifier**: componente di sicurezza fondamentale della JVM. Prima di eseguire qualsiasi file `.class`, scansiona le istruzioni per verificare che non violino i limiti dello stack, non convertano puntatori illegalmente e rispettino le regole di visibilità.

3. **Dynamic Class Loading e Classpath (`-cp`)**:
   - La JVM non cerca i file nel filesystem a caso: utilizza il **Classpath** (una lista ordinata di directory e archivi `.jar`).
   - Quando durante l'esecuzione il codice fa riferimento per la prima volta a una classe `X`:
     1. Il `ClassLoader` cerca `X.class` nella prima cartella specificata nel Classpath.
     2. Se non la trova, passa alla successiva.
     3. Se la trova, la carica in memoria e ne inizializza le strutture statiche.
     4. Se non la trova in nessuna cartella del Classpath, solleva `ClassNotFoundException` o `NoClassDefFoundError`.
   - Esempio di esecuzione esplicita:
     ```bash
     java -cp . MyClass
     ```
     Il parametro `-cp .` istruisce la JVM a cercare le classi compilate nella directory corrente (`.`). Le classi standard di sistema (`System`, `String`) vengono invece caricate automaticamente dal bootstrap classloader della JDK.

---

### Deployment e Gestione dei File JAR (Slide 17–18)
- **Anatomia di un file JAR (*Java Archive*)**:
  - Un file `.jar` è fisicamente un **archivio compresso in formato standard ZIP**.
  - Raggruppa decine o centinaia di file `.class`, risorse (immagini, file di configurazione) e metadati.
- **Creazione manuale da CLI**:
  ```bash
  jar cvf MyJar.jar MyClass.class
  ```
  - `c`: *create* (crea nuovo archivio).
  - `v`: *verbose* (mostra i file aggiunti).
  - `f`: *file* (il parametro successivo è il nome del file `.jar` da produrre).
- **Esecuzione tramite Classpath**:
  ```bash
  java -cp MyJar.jar MyClass
  ```
- **JAR Auto-Eseguibile (`java -jar`)**:
  - Per consentire all'utente di lanciare l'archivio direttamente con `java -jar MyJar.jar`, il JAR deve specificare quale classe ospita il metodo `main`.
  - Questa informazione risiede nel file `META-INF/MANIFEST.MF` sotto la direttiva:
    ```text
    Main-Class: MyClass
    ```
  - Creazione con file manifest esterno:
    ```bash
    jar cvfm MyClass.jar manifest.txt MyClass.class
    ```
  - Creazione con sintassi moderna senza file di testo intermedio (flag `e` per entrypoint):
    ```bash
    jar cfe MyClass.jar MyClass MyClass.class
    ```

---

### Strumenti di Sviluppo: Da Editor a IntelliJ IDEA (Slide 19–26)
- **CLI vs IDE**: per progetti complessi, l'uso del terminale e di un editor di testo semplice diventa poco scalabile.
- **Vantaggi dell'IDE (*Integrated Development Environment*)**:
  - *Syntax highlighting* e *live code inspection/linting* (segnalazione immediata degli errori di tipo e code smell prima ancora di compilare).
  - *Debugger integrato* con breakpoint, ispezione dello stack dei frame e monitoraggio variabili.
  - *Integrazione con Version Control (Git)* e *Build Automation Tools (Maven / Gradle)*.
  - *Monito del docente*: l'auto-completamento o la generazione automatica di codice da parte dell'IDE è utile in ambito professionale, ma va limitata durante la fase di apprendimento per comprendere a fondo le regole sintattiche e semantiche del linguaggio.
- **Scelta del corso**: **IntelliJ IDEA** (gratuito in versione Community o con licenza Education per studenti universitari).

---

## Codice:  Collegamento Pratico con il Tuo Progetto: Maven e `guida-jar.md`

Nel tuo workspace [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26), hai formalizzato questi esatti concetti in modo eccellente in [`guida-jar.md`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/guida-jar.md) e nei file di configurazione Maven:

1. **Il Fully Qualified Name e il Filesystem**:
   - Come visto a lezione, se una classe appartiene al package `es01`, il bytecode generato deve risiedere fisicamente nel percorso `es01/Date.class`.
   - Quando si invoca la JVM, il nome della classe da passare deve essere il FQN (`es01.MainDate`).
2. **Automazione del Packaging con Maven**:
   - Invece di lanciare manualmente `jar cfe`, nei singoli moduli (es. [`es01/pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es01/pom.xml)) usi il plugin **`maven-assembly-plugin`**:
   ```xml
   <plugin>
       <groupId>org.apache.maven.plugins</groupId>
       <artifactId>maven-assembly-plugin</artifactId>
       <version>3.7.1</version>
       <configuration>
           <archive>
               <manifest>
                   <mainClass>es01.MainDate</mainClass>
               </manifest>
           </archive>
           <descriptorRefs>
               <descriptorRef>jar-with-dependencies</descriptorRef>
           </descriptorRefs>
       </configuration>
       <executions>
           <execution>
               <id>make-assembly</id>
               <phase>package</phase>
               <goals>
                   <goal>single</goal>
               </goals>
           </execution>
       </executions>
   </plugin>
   ```
   Questo genera automaticamente nella cartella `target/` il cosiddetto *Fat JAR* contenente sia il bytecode dell'applicazione sia il file `META-INF/MANIFEST.MF` precompilato.

---

## [Test]  Verifica dei Comandi da Terminale

Puoi verificare l'intero ciclo di build ed esecuzione da riga di comando testando il modulo `es01` tramite lo script:
```bash
./esercizi.sh package es01
```
Lo script esegue internamente:
1. `mvn clean package -pl es01`
2. Individua il file JAR autoprodotto in `es01/target/es01-*-jar-with-dependencies.jar`
3. Esegue `java -jar ...` verificando che l'entrypoint `es01.MainDate` risponda correttamente.

---

> [!NOTE]
> Con T03 abbiamo concluso l'intera panoramica propedeutica (Introduzione, Paradigmi/UML e Tooling/JVM).
> 
> A partire dal prossimo blocco entriamo nel codice sorgente vero e proprio con la **Lezione 4 / Slide T04: *Types and Objects*** e il file ufficiale del docente [`Example.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione04/Example.java):
> - Tipi primitivi (dimensioni, range, valori di default) vs Reference Types.
> - Rappresentazione dei caratteri (`char` come intero senza segno a 16 bit, codifica ASCII e Unicode `\u0056`).
> - Regole di inizializzazione: variabili di istanza/statiche (default zero/null) vs variabili locali dello stack (nessun default $\rightarrow$ errore a compile-time!).
> - Operatori logici standard (`&`, `|`) vs operatori a corto circuito (*short-circuit* `&&`, `||`) e relativi effetti collaterali (`k++`).
> - Scope dei blocchi di codice annidati (`{ ... }`) e shadowing/visibilità delle variabili.

**Dammi conferma per aprire la Lezione 4 / T04 e analizzare teoria e codice di `Example.java`!**

---


# Capitolo 4: T04 --- Sistema di Tipi, Primitive e Reference

*Tipi Primitivi vs Reference, Casting, Wrapper, Operatori e Analisi di Example.java*

Con questo blocco entriamo nel vivo della semantica del linguaggio: analizziamo come la JVM gestisce i tipi, la memoria (Stack vs Heap), i puntatori/reference, gli operatori logici e lo scope, confrontando la teoria di [T04 - Types and Objects.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T04%20-%20Types%20and%20Objects.pdf) con il primo file di codice ufficiale del docente: [`Example.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione04/Example.java).

## Teoria:  Concetti Teorici dalle Slide

### Tipizzazione dei Linguaggi e il "Contratto" di Tipo (Slide 1–7)
- **Definizione formale informale di Tipo**: Un tipo è una coppia formata da un **insieme di valori ammissibili** e da un **insieme di operazioni consentite** su di essi.
  - Es. `int`: valori da $-2^{31}$ a $2^{31}-1$, operazioni `+`, `-`, `*`, `/`, `%`.
  - Il tipo definisce un **contratto**: vincola cosa una variabile può contenere e in quali espressioni può comparire.
- **Weakly Typed (es. Python, JavaScript) vs Strongly Typed (Java)**:
  - Nei linguaggi *weakly typed*, le variabili sono contenitori generici slegati dal tipo: una variabile `x` può contenere un intero, poi una stringa, poi una tupla.
  - Nei linguaggi *strongly typed* come Java, ogni variabile richiede una dichiarazione esplicita e immutabile di tipo a tempo di compilazione (`int x;`). Assegnare un tipo incompatibile genera un **Compile-Time Error**.
  - *Meme di JavaScript a lezione*:
    - `"11" + 1` $\implies$ `"111"` (coercizione implicita a stringa e concatenazione).
    - `"11" - 1` $\implies$ `10` (coercizione implicita a numero e sottrazione numerica).
    - In Java queste ambiguità ed errori silenziosi sono impossibili: il compilatore blocca ogni operazione non conforme prima dell'esecuzione.

---

### I Tipi Primitivi in Java e le Conversioni (Slide 8–13)
Java dispone di **8 tipi primitivi** (allocati direttamente per valore nello Stack o inline negli oggetti, non sono oggetti):

| Tipo Primitivo | Dimensione | Range di Valori | Default (campi) |
| :--- | :--- | :--- | :--- |
| `byte` | 8 bit (1 byte) | da $-128$ a $+127$ ($-2^7 \dots 2^7-1$) | `0` |
| `short` | 16 bit (2 byte) | da $-32.768$ a $+32.767$ ($-2^{15} \dots 2^{15}-1$) | `0` |
| **`int`** | 32 bit (4 byte) | da $-2.147.483.648$ a $+2.147.483.647$ ($-2^{31} \dots 2^{31}-1$) | `0` |
| `long` | 64 bit (8 byte) | da $-2^{63}$ a $+2^{63}-1$ (suffisso `L` o `l`) | `0L` |
| `float` | 32 bit IEEE 754 | Precisione singola (suffisso obbligatorio `f` o `F`) | `0.0f` |
| **`double`** | 64 bit IEEE 754 | Precisione doppia (default per numeri con la virgola) | `0.0d` |
| **`char`** | 16 bit (2 byte) | da `0` a `65.535` (Unicode UTF-16, **unsigned**) | `'\u0000'` (NUL) |
| **`boolean`**| 1 bit logico | `true` oppure `false` | `false` |

- **Aritmetica Modulare e Overflow degli `int`**:
  - In Java non viene lanciata alcuna eccezione se un calcolo intero supera il limite massimo: avviene il **wrap-around** secondo l'aritmetica del complemento a due a 32 bit.
  - Se `a = 2147483647` ($2^{31}-1$), l'operazione `a + 1` restituisce $-2147483648$ ($-2^{31}$).
- **Conversioni di Tipo (Casting)**:
  - **Widening (Allargamento / Implicito)**: da un tipo più stretto a uno più ampio (nessuna perdita d'ordine di grandezza):
    $$\text{byte} \longrightarrow \text{short} \longrightarrow \text{int} \longrightarrow \text{long} \longrightarrow \text{float} \longrightarrow \text{double}$$
    Es: `float f = 3;` converte automaticamente `int 3` in `3.0f`.
  - **Narrowing (Restringimento / Esplicito obbligatorio)**: da un tipo più ampio a uno più stretto, richiede il cast sintattico `(tipo)` perché comporta potenziale troncamento o perdita di informazione:
    Es: `int i = (int) 3.2;` scarta la parte decimale e memorizza `3`.
- **I Caratteri sono Numeri Interi Unsigned a 16 bit**:
  - Un `char` memorizza il codice numerico Unicode (UTF-16 code unit).
  - `'V'`, `(char) 86` e `'\u0056'` sono tre rappresentazioni letterali dello **stesso identico dato binario** (valore decimale 86).
- **Tipi Non-Primitivi (Reference Types) e la Classe `String`**:
  - Tutto ciò che non è un tipo primitivo è un **oggetto**.
  - `String` è una classe immutabile. L'operatore `+` tra una stringa e qualsiasi altro tipo (primitivo o oggetto) applica automaticamente l'overloading di concatenazione, invocando internamente la conversione a stringa.

---

### Modello di Memoria, Puntatori e Garbage Collection (Slide 14–21)
- **Assenza di Variabili Globali**: In Java non esiste lo scope globale in stile C. Ogni dato o funzione appartiene a una classe o a un'istanza.
- **La Verità sui Puntatori in Java**:
  - *«Java does have pointers, but there is no pointer arithmetic»*: ogni variabile di tipo non primitivo è tecnicamente un **puntatore/riferimento** (*reference*) a un blocco di memoria nello **Heap**.
  - La JVM protegge la memoria: il programmatore non può vedere l'indirizzo fisico, né fare `ptr++` o dereferenziare offset arbitrari.
  - Il passaggio dei parametri ai metodi in Java è **sempre rigorosamente per valore** (*pass-by-value*): per gli oggetti, viene copiato per valore il **riferimento** (l'indirizzo logico).
- **Rappresentazione di un Reference**:
  - Una variabile d'istanza non inizializzata contiene `null` (es. `Vehicle@null`).
  - Quando viene invocato `new Vehicle()`, la JVM alloca l'oggetto nello Heap e restituisce l'indirizzo: `myCar` conterrà un valore del tipo `Vehicle@25c7f37d`.
- **Errori di Memoria e `NullPointerException` (NPE)**:
  - Se si tenta di invocare un metodo o accedere a un campo su una reference che vale `null` (es. `myCar2.setFrameNumber(5)`), la JVM solleva una **`NullPointerException`** a runtime, interrompendo l'esecuzione.
- **Perché i programmatori scrivono `myCar = null;`?**:
  - L'assegnamento a `null` rimuove il puntatore verso l'oggetto nello Heap. Se nessun'altra reference punta a quell'area di memoria, l'oggetto diventa **irraggiungibile** (*unreachable*) ed eleggibile per la **Garbage Collection (GC)**, consentendo alla JVM di bonificare la memoria.

---

## Codice:  Analisi Dettagliata del Codice: [`Example.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione04/Example.java)

Analizziamo riga per riga il sorgente della Lezione 04, evidenziando tutte le trappole e i dettagli d'esame:

```java
public class Example {
    static float f1;
    static float f2 = 3.4f;
    static String s1;
    static final double PI = 3.14; 
    
    public static void main(String[] args) {
        int i1 = 6;
        int i2;
        char c1 = 'V';
        char c2 = 86;
        char c3 = '\u0056';
        String s2;
            
        System.out.println("i1: " + i1);
        // System.out.println("i2: " + i2); // compile-time error
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("c1: " + c1 + " c2: " + c2 + " c3: " + c3);
        System.out.println("s1: " + s1);
        /*
         System.out.println("s2: " + s2); // compile-time error
         System.out.println(s1.toString()); // run-time error
         PI = 3.0; // compile-time error
        */
        int k = 0;
        System.out.println(true | k++ == 0);
        System.out.println("k (standard eval): " + k);
        k = 0;
        System.out.println(true || k++ == 0);
        System.out.println("k (short-circuit eval): " + k);
        //
        int n = 4;
        n ++;
        // int n = 8; // compile-time error
        {
            int m = 7;
            m ++;
        }
        {
            int m = 8;
            m --;
        }
        System.out.println("n: " + n);
        // System.out.println("m: " + m); // compile-time error
    }
}
```

### [Approfondimento]  Le Finezze Implementative Spiegate Riga per Riga:

1. **Variabili Statiche/Campi vs Variabili Locali (*Definite Assignment Analysis*)**:
   - `static float f1;` e `static String s1;`: sono campi a livello di classe. **La JVM li inizializza SEMPRE automaticamente al loro default**: `f1` diventa `0.0f` e `s1` diventa `null`.
   - `int i2;` e `String s2;`: sono variabili locali allocate nel frame dello **Stack**. **Le variabili locali NON hanno valori di default**.
   - Se tentiamo di leggere `i2` o `s2` prima di aver assegnato loro un valore (`System.out.println(i2)`), il compilatore Java blocca la compilazione con l'errore:
     `variable i2 might not have been initialized`.
2. **Suffisso dei Floating Point (`3.4f`)**:
   - `static float f2 = 3.4f;`: il letterale `3.4` senza suffissi è un `double` a 64 bit. Scrivere `float f = 3.4;` genera errore di compilazione (*loss of precision*). Il suffisso `f` forza il letterale a 32 bit.
3. **Costanti con `final`**:
   - `static final double PI = 3.14;`: la keyword `final` rende la variabile a sola lettura dopo l'inizializzazione. Il tentativo di riassegnamento `PI = 3.0;` viene respinto dal compilatore (`cannot assign a value to final variable PI`). Per convenzione Java, le costanti `static final` si scrivono in `MAIUSCOLO_SNAKE_CASE`.
4. **I 3 modi di rappresentare un `char`**:
   - `c1 = 'V'`: letterale carattere.
   - `c2 = 86`: valore intero decimale ASCII/Unicode per la 'V'.
   - `c3 = '\u0056'`: sequenza di escape Unicode a 16 bit in esadecimale ($5 \times 16 + 6 = 86$).
   - Stampati a video, producono tutti e tre il carattere `V`.
5. **Concatenazione di `null` vs `NullPointerException`**:
   - `System.out.println("s1: " + s1);` stampa `"s1: null"`. L'operatore `+` converte in sicurezza il riferimento nullo nella stringa letterale `"null"`.
   - `System.out.println(s1.toString());` genera invece un **Run-Time Error** (`NullPointerException`): non è possibile dereferenziare un puntatore nullo per invocarvi un metodo d'istanza.
6. **Operatori Logici Standard (`|`, `&`) vs Corto-Circuito (*Short-Circuit* `||`, `&&`) e Side Effects**:
   - Caso `true | k++ == 0`:
     - L'operatore singolo `|` (non a corto circuito) **valuta SEMPRE entrambi gli operandi**.
     - Anche se la parte sinistra è già `true`, la parte destra `k++ == 0` viene valutata: `k` viene confrontato con `0` (dando `true`) e poi incrementato di $1$.
     - Stampa a video: `true`, seguito da `k (standard eval): 1`.
   - Caso `true || k++ == 0`:
     - L'operatore doppio `||` (a corto circuito) verifica la parte sinistra: poiché è `true`, il risultato globale dell'or logico è già matematicamente certo (`true`).
     - La parte destra viene **completamente ignorata e mai valutata**!
     - Di conseguenza, `k++` **non viene eseguito**.
     - Stampa a video: `true`, seguito da `k (short-circuit eval): 0`.
   - *Importanza pratica*: lo short-circuit `&&` è l'idioma fondamentale per evitare crash su `null`:
     ```java
     if (s != null && s.length() > 0) { ... } // Se s è null, non chiama mai s.length()!
     ```
7. **Scope delle Variabili e Divieto di Shadowing Locale**:
   - In Java, il ciclo di vita e la visibilità delle variabili sono delimitati dalle graffe `{ ... }`.
   - `int n = 4; n++;` dichiara `n` nello scope del metodo. Scrivere `int n = 8;` nello stesso scope o in un sottoblocco interno genera l'errore: `Variable 'n' is already defined in the scope`. In Java le variabili locali non possono oscurare altre variabili locali omonime.
   - Blocchi anonimi indipendenti:
     ```java
     { int m = 7; m++; }
     { int m = 8; m--; }
     ```
     La variabile `m` del primo blocco viene distrutta alla chiusura della prima graffa. La seconda `m` è una nuova variabile in uno scope disgiunto. All'esterno dei blocchi, `m` non esiste (`cannot find symbol variable m`).

---

## [Test]  Output Esatto di Esecuzione

Eseguendo `Example.java` da terminale o IntelliJ:
```text
i1: 6
f1: 0.0
f2: 3.4
c1: V c2: V c3: V
s1: null
true
k (standard eval): 1
true
k (short-circuit eval): 0
n: 5
```

---

> [!NOTE]
> Con la **Lezione 4 / T04** abbiamo chiarito le basi di tipo, stack/heap e operatori.
> 
> Il prossimo blocco raggruppa le **Lezioni 05-06 / Slide T05 (*Java Basic Syntax*) e T06 (*Java Classes and Objects*)**, dove nasce il progetto incrementale centrale del corso:
> - Struttura della prima classe ad oggetti: [`SimpleDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/SimpleDate) (`Date.java` e `MainDate.java`).
> - La classe sperimentale [`StringPlayground.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/StringPlayground.java).
> - La prima validazione delle date: algoritmo dei giorni del mese e calcolo degli anni bisestili secondo il calendario Gregoriano.
> - Sintassi Java: costrutti di controllo (`if-else`, `switch`, `for`, `while`, `do-while`), etichette (*labeled break/continue*).
> - Metodi, parametri, ritorno e la keyword `this`.
> - La classe `MainDate`: test delle istanze, instanziazione con `new` e stampa dello stato.

**Dammi conferma per aprire le Lezioni 05-06 / T05-T06 e analizzare la prima versione di `SimpleDate` e `StringPlayground`!**

---


# Capitolo 5: T05–T06 --- Sintassi Java, Strutture di Controllo e Classi Base

*Costrutti Condizionali e Iterativi, Definizione di Classe e Nascita del Progetto SimpleDate*

In questo blocco analizziamo in dettaglio la sintassi fondamentale di Java ([T05 - Java Basic Syntax.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T05%20-%20Java%20Basic%20Syntax.pdf)), la struttura delle classi e degli oggetti ([T06 - Java Classes and Objects.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T06%20-%20Java%20Classes%20and%20Objects.pdf)) e il codice sorgente di debutto del corso: il progetto [`SimpleDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/SimpleDate) e il file di laboratorio [`StringPlayground.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/StringPlayground.java).

## Teoria:  Concetti Teorici dalle Slide

### Sintassi di Base e Costrutti Semplici (Slide T05, 1–19)
- **Variabili e Inizializzazione Automatica**:
  - Una variabile associa un nome e un tipo a una locazione di memoria.
  - **Regola cruciale**: Solo i campi di classe/istanza (*fields*) vengono inizializzati automaticamente al default (`0`, `0.0`, `false`, `'\u0000'`, `null`). Le variabili locali nello Stack richiedono l'assegnamento esplicito prima dell'uso.
- **Costanti (`static final`)**:
  - `final static int I = 5;`: la variabile è a sola lettura; deve essere inizializzata contestualmente o nel costruttore e non può più essere riassegnata.
- **Identificatori e Convenzioni di Naming**:
  - Regola sintattica: sequenza arbitraria di caratteri `[a-z]`, `[A-Z]`, `[0-9]`, `_` e `$`, che non inizi con una cifra e non coincida con una delle **50 parole chiave riservate** (`class`, `static`, `new`, `this`, `super`, `switch`, `goto`, `const`, ecc.).
  - Convenzioni ufficiali Java:
    - **Classi**: `UpperCamelCase` (es. `SimpleDate`, `MainDate`).
    - **Metodi, variabili locali, campi e parametri**: `lowerCamelCase` (es. `daysPerMonth`, `myCar`).
    - **Costanti**: `UPPER_SNAKE_CASE` (es. `FORMAT`, `PI_CONST`).
- **Caratteri di Escape Speciali**:
  - `\n` (LF linefeed, `\u000a`), `\r` (CR carriage return, `\u000d`), `\t` (tab orizzontale, `\u0009`), `\b` (backspace, `\u0008`), `\f` (form feed, `\u000c`), `\"` (doppio apice), `\'` (singolo apice), `\\` (backslash).
- **Commenti e Documentazione**:
  - `// ...` (singola riga).
  - `/* ... */` (multi-riga).
  - `/** ... */` (**Javadoc**): elaborato dal tool `javadoc` per generare automaticamente la documentazione HTML delle API.
- **Espressioni, Valutazione Sinistra-Destra e Side Effects**:
  - In Java le sotto-espressioni sono valutate **rigorosamente da sinistra a destra**:
    - `int i = 1; int j = (i = 2) * i;` $\implies$ `i` diventa `2`, poi moltiplicato per `i` (`2`) $\implies$ `j = 4`.
    - `int t = 3; eval(t + (t = 2))` $\implies$ prima si valuta `t` (`3`), poi `(t = 2)` (`2`) $\implies 3 + 2 = 5$.
- **Operatori Aritmetici Unari: Pre-incremento vs Post-incremento**:
  - `x++` (post-incremento): restituisce il valore attuale di `x` e *successivamente* incrementa `x` di 1.
  - `++x` (pre-incremento): incrementa *subito* `x` di 1 e restituisce il nuovo valore.
  - **L'esercizio tranello delle slide**:
    ```java
    int t = 3;
    t = -t++ - ++t; // Quanto vale t?
    ```
    - Valutazione da sinistra a destra:
      1. `-t++`: valuta $-3$, e incrementa $t$ a $4$.
      2. `++t`: incrementa subito $t$ da $4$ a $5$, e valuta $5$.
      3. Operazione: $(-3) - 5 = -8$. Assegnato a $t$, il valore finale è **`-8`**.
- **Operatore Ternario**: `condizione ? expr1 : expr2`.
- **Operatori Logici e Corto-Circuito**:
  - `&`, `|`: valutano sempre entrambi i rami.
  - `&&`, `||`: valutazione a corto circuito (*short-circuit*). Se il primo operando determina già il risultato, il secondo non viene nemmeno eseguito (essenziale per prevenire crash su puntatori nulli).
- **Assegnamenti Composti**: `x += expr` equivale a `x = x + (expr)`. Se $x=4$, l'espressione $x += x - 7$ assegna $x = 4 + (4 - 7) = 1$.

---

### Costrutti di Controllo di Flusso (Slide T05, 20–29)
- **Blocchi `{ ... }`**: delimitano lo scope di vita delle variabili locali.
- **Condizionali**: `if (Bexpr) ... else ...`.
- **Costrutto `switch-case` e il Fall-Through**:
  - Seleziona il ramo da eseguire in base al valore di un'espressione (`byte`, `short`, `char`, `int`, `String`, `enum`).
  - Se non si inserisce l'istruzione `break`, l'esecuzione **continua nei rami successivi** (*fall-through*). Questo meccanismo, se usato volontariamente, permette di raggruppare casi che condividono la stessa logica (come vedremo in `daysPerMonth`).
- **Cicli**:
  - `while (cond) { ... }`: test preliminare (può eseguire 0 volte).
  - `do { ... } while (cond);`: test posticipato (esegue almeno 1 volta).
  - `for (init; cond; step) { ... }`: ciclo controllato. Supporta inizializzazioni e passi multipli separati da virgola:
    ```java
    for (int i = 0, j = 9; i <= 9 && j >= 0; i++, j--) { ... }
    ```
- **Salto di Controllo**:
  - `break`: interrompe il ciclo o lo switch ed esce dal blocco.
  - `continue`: salta immediatamente alla successiva iterazione del ciclo.
  - `return`: esce dal metodo corrente restituendo eventualmente un valore.

---

### Classi, Oggetti, `this` e `toString` (Slide T06, 1–28)
- **Perché modellare una data? (La vignetta a lezione, Slide 7)**:
  - Lo slide show mostra il fumetto geek: *«Imagine an object much like a thing in the real world, like... A DATE?»*. È da qui che nasce la classe `Date` come filo conduttore del corso.
- **Anatomia di una Classe**:
  - **Campi d'istanza (*Fields*)**: variabili che memorizzano lo stato di ciascun oggetto.
  - **Metodi d'istanza (*Methods*)**: funzioni che definiscono il comportamento e i messaggi accettati dall'oggetto.
  - **Firma del metodo**: `tipoRitorno nomeMetodo(tipoParametro nomeParametro, ...)`. Se non restituisce nulla si usa `void`.
  - **Overloading**: possibilità di definire più metodi con lo stesso nome purché differiscano per numero, tipo o ordine dei parametri.
- **Entrypoint `main` e Metodi Statici (`static`)**:
  - `public static void main(String[] args)`: il launcher della JVM non passa il nome del programma in `args[0]` (a differenza del C). `args[0]` è già il primo parametro utente.
  - **Metodi Statici**: appartengono alla classe e non alle singole istanze. Si invocano con `NomeClasse.metodo()`. Non possono accedere allo stato d'istanza né usare `this`.
- **Creazione dell'Oggetto (`new`) e Costruttore**:
  - L'istruzione `new Date(...)`:
    1. Alloca memoria nello Heap per l'oggetto.
    2. Inizializza i campi ai valori di default.
    3. Invoca il **costruttore** (metodo speciale con lo stesso nome della classe e senza tipo di ritorno) per valorizzare lo stato.
    4. Restituisce il riferimento all'oggetto appena creato.
- **Aliasing e Garbage Collection**:
  - Se scriviamo `Date d2 = d1;`, le due variabili puntano allo stesso identico oggetto nello Heap (*aliasing*).
  - Quando una reference viene azzerata (`d1 = null; d2 = null;`), l'oggetto diventa orfano e il Garbage Collector può bonificarlo.
- **La Parola Chiave `this`**:
  - È il riferimento implicito all'oggetto corrente su cui è stato invocato il metodo.
  - È **obbligatoria** quando i parametri del costruttore/metodo hanno lo stesso identico nome dei campi d'istanza (*shadowing dei parametri*):
    ```java
    public Date(int day, int month, int year) {
        this.day = day;     // this.day è il campo dell'oggetto nello Heap
        this.month = month; // day è il parametro locale nello Stack
        this.year = year;
    }
    ```
- **Rappresentazione a Stringa e `toString()`**:
  - Tutte le classi Java ereditano dalla superclasse universale `java.lang.Object` il metodo `public String toString()`.
  - Il default di `Object.toString()` stampa `NomeClasse@IndirizzoHashcode` (es. `Date@5acf9800`).
  - La JVM invoca **implicitamente** `toString()` ogni volta che un oggetto viene concatenato a una stringa (`"Oggi: " + today`).
  - Sovrascrivendo (*overriding*) `public String toString()` nella classe, possiamo personalizzare la stampa dell'oggetto.

---

## Codice:  Analisi del Codice Ufficiale del Docente

### [`SimpleDate/src/Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/SimpleDate/src/Date.java)
```java
public class Date {
    // 1. Stato dell'oggetto: campi di istanza (visibilità default di package per ora)
    int day;
    int month;
    int year;

    // 2. Costante di classe condivisa da tutte le istanze
    static final String FORMAT = "dd/mm/yyyy";

    // 3. Costruttore: usa 'this' per distinguere campi da parametri
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify(); // Chiamata al metodo di validazione interna
    }

    // 4. Metodo di validazione dello stato
    void verify() {
        if (year < 0 || month < 1 || month > 12)
            System.out.println("Illegal date!");
        else
            if (day < 1 || day > daysPerMonth(month))
                System.out.println("Illegal date!");
    }

    String print() {
        return day + "/" + month + "/" + year + " [" + FORMAT + "]";
    }

    // 5. Override di toString(): delega al metodo print()
    public String toString() {
        return print();
    }
    
    // 6. Metodo statico: calcolo puro senza bisogno di istanziare Date
    static int daysPerMonth(int month) {
        int days;
        switch(month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30; // Fall-through controllato per i mesi da 30 giorni
                break;
            case 2:
                days = 28; // Febbraio fisso a 28 (il bisestile arriverà a Lezione 07!)
                break;
            default:
                days = 31;
                break;
        }
        return days;
    }
}
```

### [Approfondimento]  Dettagli Tecnici e Scelte del Docente:
1. **Perché `daysPerMonth(month)` è `static`?**
   Non ha bisogno di leggere `this.day` o `this.year`: riceve un mese intero e restituisce i giorni. Essendo una funzione pura di utilità, appartiene alla classe e può essere chiamata anche prima di creare oggetti (come fa il `main`).
2. **Lo `switch` con fall-through**:
   I `case 4: case 6: case 9: case 11:` sono privi di istruzione `break` intermedia; l'esecuzione scorre intenzionalmente fino a `days = 30; break;`.
3. **Validazione con `verify()`**:
   In questa prima versione didattica, se la data è errata viene stampato a video `"Illegal date!"`. Notare che l'oggetto non valido viene comunque creato in memoria! Solo più avanti (in Lezione 17 con le eccezioni) il docente mostrerà come impedire l'istanziazione lanciando un'eccezione.

---

### [`SimpleDate/src/MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/SimpleDate/src/MainDate.java)
```java
import java.util.Scanner;

public class MainDate {
    public static void main(String[] args) {
        // Chiamata a metodo statico direttamente da classe
        System.out.println(Date.daysPerMonth(4));

        // Allocazione istanze nello Heap
        Date today = new Date(14, 10, 2025);
        Date tomorrow = new Date(15, 10, 2025);

        System.out.println(today.print());
        System.out.println(tomorrow.print());
        System.out.println(today.toString());

        String str = new String("ciao");
        System.out.println(str.toString());

        // Acquisizione input utente con java.util.Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the day: ");
        int day = sc.nextInt();
        System.out.println("Enter the month: ");
        int month = sc.nextInt();
        System.out.println("Enter the year: ");
        int year = sc.nextInt();
        sc.close(); // Chiusura dello stream di input

        Date date = new Date(day, month, year);
        System.out.println(date.toString());
    }
}
```

---

### [`StringPlayground.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezioni05-06/StringPlayground.java)
Questo file illustra 3 concetti cardine sulle stringhe e l'ottimizzazione della memoria:
```java
public class StringPlayground {
    public static void main(String[] args) {
        String empty = new String();
        String str = "str";
        System.out.println("len(empty): " + empty.length());
        System.out.println("len(\"str\"): " + str.length());
        System.out.println(str.charAt(1)); // Restituisce 't'

        // str.charAt(1) = 'c'; // COMPILE-TIME ERROR: Le String in Java sono IMMUTABILI!

        String same = new String("str");
        System.out.println("str: " + str + " same: " + same);

        // Confronto di puntatori (identità di memoria) vs contenuto semantico
        System.out.println("str ?= same: " + (str == same));           // false! Oggetti diversi nello Heap
        String verySame = str;
        System.out.println("str ?= verySame: " + (str == verySame));   // true! Puntano alla stessa cella
        System.out.println("str ?= same: " + str.equals(same));        // true! Stessi caratteri

        // StringBuilder e Fluent Interface (Chaining)
        int n = 5;
        int sum = n * (n + 1) / 2;
        StringBuilder sb = new StringBuilder();
        sb.append("sum(").append(sum).append(")["); // Notazione a catena (fluent)
        for (int i = 0; i < n; i++)
            sb.append(" ").append(i);
        sb.append(" ]");
        System.out.println(sb.toString()); // sum(15)[ 0 1 2 3 4 ]
    }
}
```

### [Approfondimento]  Le Finezze di `StringPlayground`:
1. **Immutabilità**: in Java l'oggetto `String` non può essere modificato dopo la creazione. Non esiste un metodo `setCharAt()`.
2. **`==` vs `.equals()`**:
   - `str == same` confronta se le due variabili contengono lo **stesso indirizzo di memoria**. Restituisce `false` perché `same` è stato creato con `new String(...)` forzando una nuova allocazione nello Heap.
   - `str.equals(same)` confronta i caratteri uno a uno e restituisce `true`.
   - **Regola d'esame assoluta**: per confrontare gli oggetti e le stringhe si usa **sempre `.equals()`**, mai `==`!
3. **`StringBuilder` e Fluent Notation**:
   - Ogni concatenazione con `+` su stringhe ordinarie crea un nuovo oggetto `String` temporaneo. Nei cicli questo genera un enorme sovraccarico di memoria per il Garbage Collector.
   - `StringBuilder` alloca un buffer mutabile ridimensionabile internamente.
   - Il metodo `.append()` restituisce un riferimento a `this` (l'istanza corrente del builder stesso), permettendo di concatenare le chiamate in cascata: `sb.append(...).append(...)` (**Fluent API / Method Chaining**).

---

## 🔄 Confronto con il tuo modulo `es01`

Nel tuo file [`es01/src/main/java/es01/Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es01/src/main/java/es01/Date.java):
1. **Switch Moderno vs Tradizionale**:
   Avevi già applicato la sintassi Java 14+ con la *Switch Expression*:
   ```java
   static int daysPerMonth(int month) {
       return switch (month) {
           case 4, 6, 9, 11 -> 30;
           case 2 -> 28;
           default -> 31;
       };
   }
   ```
   Questa forma è sintatticamente pulitissima e idiomatica in Java moderno.
2. **Allineamento con la Lezione 05-06**:
   Per essere al 100% fedeli alla versione del docente:
   - Aggiungere la chiamata a `verify()` nel costruttore per il controllo di validità.
   - Correggere il refuso nella costante di formato: `"dd/mm/yyyy"` invece di `"dd/hh/yyyy"`.

---

> [!NOTE]
> Con le **Lezioni 05-06** abbiamo stabilito l'architettura iniziale di `Date`, lo scope, i metodi statici, le stringhe e `StringBuilder`.
> 
> Il prossimo blocco è la **Lezione 07 / Slide T07: *Libraries and String Class***:
> - Evoluzione di `SimpleDate`: introduzione dell'algoritmo completo del **calendario Gregoriano per gli anni bisestili** (*leap year*).
> - Analisi della classe statica ausiliaria di calcolo matematico `java.lang.Math`.
> - Metodi avanzati della classe `String` (`substring`, `indexOf`, `split`, `trim`, `replace`).
> - Wrapper classes per i primitivi (`Integer`, `Double`, `Character`), *Autoboxing* e *Unboxing*.

**Dammi conferma per procedere alla Lezione 07 / T07!**

---


# Capitolo 6: T07 --- Librerie Standard e Manipolazione delle Stringhe

*Java Class Library, Immutabilità della Classe String, Metodi Fondamentali e SimpleDate v2*

In questo blocco analizziamo la gestione delle librerie standard e la classe `String` ([T07 - Libraries and String Class.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T07%20-%20Libraries%20and%20String%20Class.pdf)), insieme all'evoluzione del codice nella cartella [`Lezione07`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione07/SimpleDate), dove il docente introduce **incapsulamento (`private`)**, **costruttori sovraccaricati con delega `this(...)`**, **copy constructor**, formattazione internazionalizzata e il primo test con **asserzioni (`assert` e flag `-ea`)**.

## Teoria:  Concetti Teorici dalle Slide (Slide T07)

### Librerie Standard e Meccanismo di Import (Slide 1–9)
- **Librerie Standard della JDK**:
  - `java.lang`: classi fondamentali del runtime (oggetti base, tipi primitivi wrapper, stringhe, thread, sistema). **È l'unico package importato automaticamente e implicitamente in ogni file sorgente Java**.
  - `java.util`: strutture dati (collezioni), utilità temporali, parser e scanner.
  - `java.io`: gestione di stream di input/output e filesystem.
  - `java.math`: calcolo a precisione arbitraria (`BigInteger`, `BigDecimal`).
- **Sintassi di Importazione**:
  - Selettiva: `import java.util.Scanner;` (consigliata per chiarezza e pulizia).
  - Wildcard su package: `import java.util.*;` (rende visibili tutte le classi pubbliche del package).
  - *Regola del Classpath*: le classi definite dall'utente che risiedono nello stesso package e nella stessa cartella del Classpath non necessitano di alcuna direttiva `import`.
- **Classi di Sistema Notevoli**:
  - `java.lang.System`:
    - Tre stream predefiniti: `System.in` (standard input, byte stream da tastiera), `System.out` (standard output a video), `System.err` (standard error).
    - `System.currentTimeMillis()`: restituisce un `long` con il timestamp **Unix Epoch** (millisecondi trascorsi dalle ore 00:00:00 UTC del 1° Gennaio 1970).
  - `java.util.Scanner`:
    - Parser per estrarre tipi primitivi e stringhe da flussi di testo:
      - `sc.nextLine()`: legge un'intera riga fino al terminatore `\n` e restituisce una `String`.
      - `sc.nextInt()`, `sc.nextFloat()`, `sc.nextDouble()`: leggono il token successivo effettuando il parsing del tipo. Se l'utente inserisce caratteri incompatibili, lancia un'eccezione (`InputMismatchException`).
    - Buona norma: invocare `sc.close()` per rilasciare il descrittore del file o dello stream ed evitare *resource leak*.

---

### La Classe `String` e le sue Operazioni (Slide 10–26)
- **Immutabilità**:
  - Le istanze di `String` sono immutabili. Nessun metodo della classe altera i caratteri dell'oggetto esistente: qualunque operazione (es. `replace`, `substring`) restituisce **una nuova istanza di `String`** nello Heap.
  - Tentare `str.charAt(1) = 'c';` produce un **Compile-Time Error**.
- **Operazioni Fondamentali**:
  - `str.length()`: numero di caratteri (nota: è un metodo con parentesi tonde, a differenza di `arr.length` per gli array).
  - `str.charAt(int index)`: carattere in posizione `index` (0-indexed). Indici negativi o $\ge$ `length()` lanciano `StringIndexOutOfBoundsException`.
  - `str.indexOf(char c)`: prima occorrenza del carattere (restituisce `-1` se non presente).
  - `str.substring(int start, int end)`: estrae la sottostringa nell'intervallo semi-aperto $[start, end)$, ovvero il carattere all'indice `end` è **escluso**. Se `end` è omesso (`str.substring(start)`), estrae fino al termine della stringa.
  - `str.replace(CharSequence target, CharSequence replacement)`: sostituisce tutte le occorrenze da sinistra a destra.
  - `String.format("Format: %s, %d", str, num)`: formattazione con sintassi analoga alla `printf` del C.
- **Confronto di Stringhe: `==` vs `.equals()`**:
  - `s == t`: confronta l'**identità dei puntatori** (indirizzi nello Heap). È `true` solo se `s` e `t` puntano allo stesso identico oggetto.
  - `s.equals(t)`: confronta l'**equivalenza semantica** dei contenuti carattere per carattere.
  - **Lo String Constant Pool e l'ottimizzazione del compilatore**:
    ```java
    String s = "hello";
    String t = "hello";
    System.out.println(s == t); // Stampa TRUE!
    ```
    *Perché?* Le costanti letterali vengono inserite nel *String Constant Pool*. Se due variabili dichiarano lo stesso letterale, la JVM riusa lo stesso identico oggetto in memoria per risparmiare RAM (*interning*).
    Tuttavia, se scriviamo `String r = new String("hello");`, costringiamo la JVM a creare un nuovo oggetto nello Heap: `s == r` sarà `false`! **Regola d'oro: usare SEMPRE `.equals()`**.

---

### Stringhe Mutabili con `StringBuilder` (Slide 27–29)
- **Il problema delle prestazioni con `String`**:
  - L'operatore `+` tra stringhe invoca internamente `String.valueOf()`. Se usato in un ciclo di $N$ iterazioni, alloca $O(N)$ oggetti temporanei che intasano la memoria del Garbage Collector.
- **La soluzione: `StringBuilder`**:
  - Mantiene un buffer interno ridimensionabile mutabile.
  - Metodi principali: `.append(...)`, `.delete(start, end)`, `.insert(index, str)`, `.reverse()`.
  - Supporta la **Fluent Notation (Method Chaining)** perché restituisce `this`.

---

## Codice:  Evoluzione del Codice: `SimpleDate` (Lezione 07)

Nel passaggio da `Lezioni05-06` a `Lezione07`, il docente trasforma radicalmente la classe [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione07/SimpleDate/src/Date.java) applicando i principi di Information Hiding e aggiunge per la prima volta una classe di test dedicata: [`TestDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione07/SimpleDate/src/TestDate.java).

### [Approfondimento]  Il Diff Concettuale di `Date.java`:
```diff
 public class Date {
-    int day;
-    int month;
-    int year;
-    static final String FORMAT = "dd/mm/yyyy";
+    private int day;
+    private int month;
+    private int year;
+    static final String FORMAT_IT = "dd/mm/yyyy";
+    static final String FORMAT_US = "mm/dd/yyyy";
+    private byte lang; // 0: IT, 1: US

     // Costruttore principale
     public Date(int day, int month, int year) {
         this.day = day;
         this.month = month;
         this.year = year;
         verify();
+        lang = 0;
     }

+    // Costruttore sovraccaricato: delega tramite this(...)
+    public Date(int day, int month) {
+        this(day, month, 2025); // default year
+    }

+    // Copy Constructor: clona lo stato da un'altra istanza
+    public Date(Date other) {
+        this.day = other.day;
+        this.month = other.month;
+        this.year = other.year;
+        verify();
+        lang = other.lang;
+    }

+    // Getters
+    public int getDay() { return day; }
+    public int getMonth() { return day; } // [Attenzione]  Attenzione al refuso del prof!
+    public int getYear() { return day; }  // [Attenzione]  Ritorna 'day' anziché 'year'!
+    public byte getlang() { return lang; }

+    // Setters con validazione dell'invariante
+    public void setDay(int day) {
+        this.day = day;
+        verify();
+    }
+    public void setMonth(int month) {
+        this.month = month;
+        verify();
+    }
+    public void setYear(int year) {
+        this.year = year;
+        verify();
+    }
+    public void setLang(byte lang) {
+        if (lang == 1) this.lang = 1;
+        else this.lang = 0;
+    }
+
+    public String printFormat() {
+        if (lang == 0) return FORMAT_IT;
+        else return FORMAT_US;
+    }

     public String toString() {
-        return print();
+        if (lang == 0) return day + "/" + month + "/" + year;
+        else return month + "/" + day + "/" + year;
     }
```

### [Idea]  Le Novità e le Finezze Implementative da Notare:

1. **Incapsulamento e Protezione dello Stato (`private`)**:
   - I campi non sono più accessibili direttamente dall'esterno (`d.day = -7;` genera ora un **Compile-Time Error** in `MainDate`).
2. **Delega tra Costruttori con `this(...)`**:
   - Il costruttore `Date(int day, int month)` invoca `this(day, month, 2025);`.
   - **Regola tassativa per l'esame**: la chiamata `this(...)` verso un altro costruttore deve essere **la prima istruzione assoluta** del costruttore, pena errore di compilazione (*«Call to 'this()' must be first statement in constructor body»*).
3. **Copy Constructor**:
   - `public Date(Date other)` permette di creare una nuova istanza duplicando i valori di un oggetto esistente, evitando l'aliasing accidentale dei puntatori.
4. **Validazione Continua dell'Invariante nei Setter**:
   - Ogni volta che un setter muta lo stato (`setDay`, `setMonth`, `setYear`), invoca subito `verify()`. Lo stato dell'oggetto viene così monitorato costantemente.
5. **Il Refuso di Copia-Incolla del Docente nei Getter**:
   - Nei getter di `Date.java` (righe 38–39 del codice ufficiale), il prof ha inavvertitamente scritto:
     ```java
     public int getMonth() { return day; }
     public int getYear() { return day; }
     ```
     Sia `getMonth()` che `getYear()` restituiscono il campo `day` anziché `month` e `year`! Nel tuo codice assicurati di restituire i campi corretti (`return month;` e `return year;`).
6. **Testing con Asserzioni e Flag `-ea` ([`TestDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione07/SimpleDate/src/TestDate.java))**:
   ```java
   public class TestDate {
       private static Date date = new Date(1, 1, 1970);

       private static void printFormatTest() {
           date.setLang((byte) 1);
           assert date.printFormat().equals(Date.FORMAT_US);
       }

       public static void main(String[] args) {
           printFormatTest();
       }
   }
   ```
   - **Concetto Chiave d'Esame**: La keyword `assert` verifica che una condizione booleana sia vera; se è falsa, solleva un `AssertionError`.
   - **Attenzione**: Nella JVM le asserzioni sono **disabilitate di default**. Se lanci semplicemente `java TestDate`, l'istruzione `assert` viene ignorata. Per attivarle, è obbligatorio passare il flag `-ea` (*Enable Assertions*):
     ```bash
     java -ea TestDate
     ```
   - Nel tuo script [`esercizi.sh`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/esercizi.sh), infatti, il comando `./esercizi.sh test` usa proprio `-ea`!

---

## 🔄 Corrispondenza con la Struttura del tuo Workspace

Nel tuo repository [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26), hai modularizzato perfettamente questi argomenti:
- **`es02`**: [`MainScanner.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es02/src/main/java/es02/MainScanner.java) copre l'uso di `java.util.Scanner` introdotto in T07.
- **`es04`**: [`MainString.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es04/src/main/java/es04/MainString.java) testa tutti i metodi di `String` (`length`, `charAt`, `indexOf`, `substring`, `replace`, constant pool `==` vs `.equals()`) e le mutazioni con `StringBuilder` (`append`, `delete`, `insert`, `reverse`).
- **`es05`**: [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es05/src/main/java/es05/Date.java) implementa l'overloading dei costruttori, il constructor chaining con `this(...)` e il copy constructor.

---

> [!NOTE]
> Con la **Lezione 07** abbiamo completato le librerie standard, le stringhe, i costruttori multipli e le asserzioni.
> 
> Il prossimo blocco è la **Lezione 08 / Slide T08: *Class Constructors and Encapsulation***:
> - Studio approfondito della teoria su costruttori (default constructor, costruttore falso, copy constructor, overloading).
> - Analisi dettagliata dell'Information Hiding e dei **modificatori di accesso** (`public`, `protected`, package-private di default, `private`).
> - Evoluzione del codice in `Lezione08`: sostituzione del `byte lang` con un tipo enumerato ad hoc: **`Language.java`** (`enum Language { IT, US }`)!
> - Array costanti per i nomi dei mesi (`MONTHS_IT`, `MONTHS_US`) e nuovo metodo `getMonthAsString()`.

**Dammi conferma quando vuoi procedere alla Lezione 08 / T08!**

---


# Capitolo 7: T08 --- Costruttori, Inizializzazione ed Incapsulamento

*Ciclo di Inizializzazione, Overloading dei Costruttori, Modificatori e SimpleDate v3*

In questo blocco analizziamo in dettaglio la teoria dei costruttori, dell'incapsulamento e dell'information hiding ([T08 - Class Constructors and Encapsulation.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T08%20-%20Class%20Constructors%20and%20Encapsulation.pdf)), confrontandola con il codice ufficiale in [`Lezione08`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione08/SimpleDate/src), dove nasce l'enum **`Language.java`**, vengono aggiunti gli array dei mesi per la stampa estesa (`prettyPrint()`) e si introduce l'**Enhanced For (for-each)**.

## Teoria:  Concetti Teorici dalle Slide (Slide T08)

### Il Ciclo di Vita e i Meccanismi dei Costruttori (Slide 1–12)
- **Cosa avviene esattamente dietro le quinte con `new Clazz()`**:
  1. La JVM calcola l'ingombro in byte di tutti i campi e alloca un blocco contiguo di memoria nello **Heap**.
  2. Genera un riferimento (*reference*) univoco che punta a quell'area di memoria.
  3. Inizializza tutti i campi ai rispettivi valori di default (`0`, `false`, `null`).
  4. Invoca il **costruttore** designato passando implicitamente il puntatore `this`.
  5. Restituisce l'indirizzo dell'oggetto alla variabile a sinistra dell'assegnamento.
- **Caratteristiche Tassative di un Costruttore**:
  - Deve avere lo **stesso identico nome della classe**.
  - **Non ha alcun tipo di ritorno** (nemmeno `void`!).
  - Viene eseguito una sola volta, all'atto della creazione dell'istanza.
- **Default Constructor (Costruttore di Default)**:
  - Se il programmatore **non dichiara alcun costruttore**, il compilatore Java inserisce automaticamente un costruttore vuoto senza argomenti (`public Clazz() { }`).
  - [Attenzione]  **Regola aurea d'esame**: se il programmatore dichiara *anche un solo* costruttore con parametri (es. `public Car(String color)`), il compilatore **non genera più il costruttore di default**! Invocare `new Car()` senza argomenti provocherà un **Compile-Time Error**.
- **False Constructor (Il Falso Costruttore — Trabocchetto d'Esame)**:
  - Se si inserisce un tipo di ritorno (ad esempio `void Car(String color)`):
    ```java
    public class Car {
        void Car(String color) { ... } // [Attenzione]  NON È UN COSTRUTTORE!
    }
    ```
  - Per il compilatore questo è un **normale metodo d'istanza** (avente incidentalmente lo stesso nome della classe). Il compilatore aggiungerà comunque il costruttore di default `Car()`, e il metodo `void Car(...)` non verrà mai invocato al momento del `new`!
- **Copy Constructor**:
  - Costruttore che accetta un'altra istanza della medesima classe per clonarne lo stato (`Car(Car other)`). In Java non esiste la copia automatica bit-a-bit del C++: deve essere scritta esplicitamente dal programmatore.
- **Constructor Overloading e Chaining con `this(...)`**:
  - Più costruttori con firme distinte.
  - La chiamata `this(...)` verso un costruttore fratello serve a evitare duplicazione di logica di validazione e **deve essere tassativamente la prima riga di codice nel corpo del costruttore**.
  - *Meme delle slide (p. 11)*: Il matematico in lacrime che grida *"Abuse of notation"* vs il Chad Programmer che usa l'overloading per semplificare il codice.
- **Distruttori e il Metodo `finalize()`**:
  - In Java non esiste la deallocazione manuale: non esistono distruttori (`~Car()`).
  - Esisteva il metodo protetto `protected void finalize()` invocato prima della rimozione da parte del Garbage Collector.
  - [Attenzione]  **Attenzione**: `finalize()` è ufficialmente **deprecato da Java 9** in poi (e rimosso/reso no-op nelle versioni moderne) per l'imprevedibilità temporale dell'esecuzione del GC e rischi di deadlock. Non va mai utilizzato.

---

### Incapsulamento, Information Hiding e Modificatori di Accesso (Slide 13–24)
- **Incapsulamento**: aggregazione fisica nello stesso file sorgente di dati (campi) e procedure (metodi).
- **Information Hiding**: occultamento della rappresentazione interna dello stato.
  - *Meme della Cipolla (p. 18)*: *«Most software is written like an onion: The more layers you peel back, the more you want to cry»*. L'Information Hiding crea confini netti per proteggere il codice dal disfacimento.
  - *Meme di Gandalf (p. 24)*: *«YOU SHALL NOT ACCESS MY MEMBERS»*.
- **I 4 Livelli di Visibilità in Java**:
  1. `private`: visibile esclusivamente all'interno della stessa classe.
  2. *Default (Package-Private)*: nessun modificatore; visibile all'interno della classe e a tutte le classi residenti nello stesso package.
  3. `protected`: visibile nel package e a tutte le sottoclassi derivate (anche in package diversi).
  4. `public`: visibile ovunque, da qualsiasi package del Classpath.
- **Vantaggi Architetturali di Getter e Setter**:
  - *Nei Setter*: possibilità di intercettare valori anomali, applicare regole di business e loggare le modifiche prima di mutare lo stato.
  - *Nei Getter*: possibilità di alterare la rappresentazione interna della memoria senza rompere il codice dei client (**Retro-compatibilità / Loose Coupling**). Ad esempio, cambiare il campo interno da `int age` a `short age` per dimezzare l'occupazione di RAM, mantenendo il getter `public int getAge() { return age; }` (promozione implicita di tipo) senza che il mondo esterno debba ricompilare o cambiare una sola riga di codice.

---

### Asserzioni e Testing (Slide 25–26)
- La parola chiave `assert`:
  ```java
  assert person.getAge() != 0 : "Age cannot be 0";
  ```
  - Se l'espressione a sinistra valuta `false`, la JVM interrompe l'esecuzione e lancia un `AssertionError` mostrando il messaggio a destra dei due punti.
  - Richiede obbligatoriamente l'attivazione a runtime con il flag JVM **`-ea`** (*Enable Assertions*):
    ```bash
    java -ea TestPerson
    ```

---

## Codice:  Evoluzione del Codice: [`Lezione08`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione08/SimpleDate/src)

In `Lezione08` il docente applica un refactoring strutturale a `SimpleDate`:

### Introduzione del Tipo Enumerato [`Language.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione08/SimpleDate/src/Language.java)
Viene abbandonato il primitivo `byte lang` (dove `0` era IT e `1` era US, fragile e poco leggibile) a favore di un tipo enum fortemente tipizzato:
```java
public enum Language {
    IT, US;

    public String toString() {
        switch (this) {
            case IT: return "italiano";
            case US: return "american";
            default: return null;
        }
    }
}
```
*Finezza*: Anche gli enum in Java sono tipi reference completi e possono sovrascrivere `toString()` per restituire una descrizione testuale appropriata.

---

### Refactoring di [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione08/SimpleDate/src/Date.java)
```diff
 public class Date {
-    private byte lang; // 0: IT, 1: US
+    private Language lang;
+    private static final String[] MONTHS_IT = { "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "setembre", "ottobre", "novembre", "dicembre" };
+    private static final String[] MONTHS_US = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

     public Date(int day, int month, int year) {
         this.day = day;
         this.month = month;
         this.year = year;
         verify();
-        lang = 0;
+        lang = Language.IT;
     }

-    public void setLang(byte lang) { ... }
+    public void setAmerican() { lang = Language.US; }
+    public void setItalian() { lang = Language.IT; }

+    public String getMonthAsString() {
+        if (lang == Language.IT) return MONTHS_IT[month-1];
+        else return MONTHS_US[month-1];
+    }

+    public String prettyPrint() {
+        if (lang == Language.IT) return day + " " + MONTHS_IT[month-1] + " " + year;
+        else return MONTHS_US[month-1] + " " + day + ", " + year;
+    }
```

### [Approfondimento]  Dettagli Tecnici e Trabocchetti nel Codice di `Date`:
1. **Separazione Semantica dei Metodi di Configurazione**:
   Invece di un setter generico che accetta valori arbitrari, il prof definisce due metodi espliciti auto-esplicativi: `setItalian()` e `setAmerican()`.
2. **Array di Costanti di Classe (`private static final String[]`)**:
   Gli elenchi dei nomi dei mesi sono `static final` (condivisi da tutte le istanze senza duplicare memoria nello Heap) e `private` (inaccessibili all'esterno).
   *Curiosità nel codice del prof*: nell'array `MONTHS_IT` c'è un piccolo refuso: `"setembre"` con una sola 't'.
3. **Persistenza del Refuso del Prof nei Getter**:
   Anche in questa lezione, alle righe 43–44 di `Date.java`:
   ```java
   public int getDay() { return day; }
   public int getMonth() { return day; } // Ritorna day anziché month!
   public int getYear() { return day; }  // Ritorna day anziché year!
   ```
   Un chiaro refuso di copia-incolla che non è stato corretto dal docente nel rilascio ufficiale. Nel proprio codice personale è doveroso restituire i rispettivi campi `month` e `year`.
4. **`prettyPrint()` e Formattazione Culturale**:
   - In italiano: giorno, mese per esteso, anno (es. `7 gennaio 2025`).
   - In inglese/americano: mese per esteso, giorno, virgola, anno (es. `February 20, 2025`).

---

### Novità in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione08/SimpleDate/src/MainDate.java): Array di Oggetti ed Enhanced For
```java
// Inizializzazione rapida di un array di oggetti nello Heap
Date[] dates = { d1, d2, d3, new Date(14, 2, 2024) };

// 1. Scansione all'indietro classica tramite indice
for (int i = dates.length - 1; i >= 0; i--)
    System.out.println(dates[i].toString() + ": " + dates[i].getMonthAsString());

// 2. Scansione in avanti con Enhanced For (For-Each)
for (Date date : dates)
    System.out.println(date.toString() + ": " + date.getMonthAsString());
```
- Il costrutto **`for (Tipo elemento : collezione)`** evita di manipolare manualmente indici di scorrimento, rendendo il codice più leggibile ed eliminando il rischio di errori di off-by-one o out-of-bounds.

---

## 🔄 Corrispondenza con i Tuoi Moduli Workspace

Nel tuo repository [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26):
- **`es06`**: [`Person.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es06/src/main/java/es06/Person.java) implementa l'esempio accademico della persona con i metodi di validazione `verifyAge` e `verifyName`, incapsulamento rigoroso e gestione dei setter/getter.
- **`es07`**: [`Language.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es07/src/main/java/es07/Language.java) definisce l'enum `Language` sfruttando modernamente la *Switch Expression* di Java 14+ (`case IT -> "italiano";`).

---

> [!NOTE]
> Con la **Lezione 08** abbiamo completato l'intero ciclo di vita dei costruttori, l'incapsulamento dei dati, gli enum base e la gestione dei formati estesi.
> 
> Il prossimo blocco è la **Lezione 09 / Slide T09: *Arrays and Enumerative Types***:
> - Approfondimento teorico sistematico sugli **Array in Java** (dichiarazione, allocazione nello Heap, proprietà immutabile `.length`, array multidimensionali, copie superficiali vs profonde).
> - Analisi rigorosa degli **Enumerative Types (`enum`)**: costruttori di enum, campi interni, metodi `values()` e `ordinal()`.
> - Evoluzione del codice in `Lezione09`:
>   - Potenziamento di `Language.java` con campi interni (`format`, `description`) e costruttore privato.
>   - Riscrittura ed espansione di `Date.java`.

**Dammi conferma per aprire la Lezione 09 / T09 e continuare!**

---


# Capitolo 8: T09 --- Array, Matrici e Tipi Enumerativi (enum)

*Array Mono e Multidimensionali, Enum Tipizzati, Immutabilità e Singleton in SimpleDate v4*

In questo blocco approfondiamo la gestione a basso livello degli array nello Heap, i tipi enumerati (`enum`) ([T09 - Arrays and Enumerative Types.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T09%20-%20Arrays%20and%20Enumerative%20Types.pdf)) e analizziamo il codice di [`Lezione09`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione09/SimpleDate/src), dove `Date` diventa una **classe immutabile** (campi `final` e rimozione dei setter) e compare per la prima volta un design pattern fondamentale: il **Singleton Pattern** implementato in [`BirthDay.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione09/SimpleDate/src/BirthDay.java).

## Teoria:  Concetti Teorici dalle Slide (Slide T09)

### Gli Array in Java (Slide 1–13)
- **Natura degli Array**:
  - Un array è una sequenza contigua e ordinata di variabili omogenee (dello stesso tipo), accessibili tramite indice numerico intero che parte da `0`.
  - In Java gli array **non sono tipi primitivi**: sono **oggetti speciali allocati nello Heap**.
  - Possono memorizzare valori primitivi oppure **riferimenti/puntatori a oggetti**, mai oggetti per valore diretto.
  - La dimensione di un array può essere stabilita dinamicamente a runtime all'atto dell'allocazione (`new int[size]`), ma **è immutabile una volta creata**.
- **Dichiarazione vs Creazione**:
  - Sintassi raccomandata: `int[] arr;` (la notazione `int arr[];` è ammessa per retrocompatibilità col C, ma sconsigliata).
  - La dichiarazione `int[] arr;` alloca solo una variabile reference nello Stack (inizializzata a `null`), **senza riservare spazio per gli elementi nello Heap**.
  - Allocazione:
    - Tramite `new`: `float[] arr = new float[10];` (gli elementi assumono il valore di default del tipo, es. `0.0f`).
    - Tramite inizializzazione statica: `int[] primes = {2, 3, 5, 7};` (la dimensione viene inferita automaticamente dal compilatore).
- **Il Pseudo-Campo `.length`**:
  - Ogni array possiede la proprietà `public final int length`.
  - [Attenzione]  **Distinzione d'esame**: per gli array si scrive `arr.length` (**senza parentesi**, è una variabile `final`), mentre per le stringhe si invoca il metodo `str.length()` (**con le parentesi**).
  - Se si tenta di leggere `arr.length` su un array nullo (`arr = null;`), la JVM lancia una `NullPointerException`.
- **Confronto e Stampa degli Array (I Trabocchetti Classici)**:
  1. `arr1 == arr2`: confronta solo gli indirizzi nello Heap. Se due array contengono gli stessi identici elementi ma risiedono in aree diverse, restituisce `false`.
  2. `arr1.equals(arr2)`: **NON funziona**. Gli array non sovrascrivono il metodo `.equals()` di `Object`, quindi `equals` si comporta esattamente come `==`.
  3. **Soluzione standard**: per confrontare il contenuto si usa il metodo statico **`java.util.Arrays.equals(arr1, arr2)`**.
  4. `arr.toString()`: stampa la firma bytecode della reference (es. `[I@6ce253f1`, dove `[` indica un array e `I` indica il tipo `int`).
  5. Per visualizzare gli elementi a video in formato leggibile: **`java.util.Arrays.toString(arr)`**.
- **Enhanced For Loop (For-Each, Java 5+)**:
  ```java
  for (String arg : args) {
      System.out.println(arg);
  }
  ```
  Sostituisce il for contatore eliminando il rischio di errori di *off-by-one* e *ArrayIndexOutOfBoundsException*.
- **Array Multidimensionali e Matrici Frastagliate (*Jagged Arrays*)**:
  - In Java non esistono matrici bidimensionali a blocco contiguo in stile Fortran/C: **un array multidimensionale è un array di riferimenti ad altri array**.
  - *Conseguenze pratiche*:
    1. **Scambio di righe in tempo $O(1)$**: per invertire la prima e l'ultima riga di una matrice non serve copiare gli elementi uno per uno, basta scambiare i loro puntatori:
       ```java
       int[] temp = matrix[0];
       matrix[0] = matrix[matrix.length - 1];
       matrix[matrix.length - 1] = temp;
       ```
    2. **Righe a lunghezza eterogenea (*Jagged/Pyramid Arrays*)**:
       ```java
       int[][] pyramid = new int[3][];
       pyramid[0] = new int[1]; // Riga 0 ha 1 elemento
       pyramid[1] = new int[2]; // Riga 1 ha 2 elementi
       pyramid[2] = new int[3]; // Riga 2 ha 3 elementi
       ```
    3. Per stampare matrici annidate, `Arrays.toString(matrix)` stampa gli indirizzi delle singole righe. Si deve iterare sulle righe o usare **`java.util.Arrays.deepToString(matrix)`**.

---

### Tipi Enumerati (`enum`) (Slide 14–19)
- Introdotti in Java 5 con la keyword `enum` per gestire insiemi chiusi e prefissati di valori costanti (es. giorni della settimana, punti cardinali, lingue).
- **Regole e Caratteristiche**:
  - Possono essere dichiarati in un file `.java` dedicato (come classe autonoma) o all'interno di una classe come membro statico, ma **mai all'interno di un metodo**.
  - Non sono semplici interi o stringhe: sono classi speciali che estendono implicitamente `java.lang.Enum`. Il loro costruttore è privato e non può essere invocato con `new`.
  - **Metodi Predefiniti Fondamentali**:
    - `e.name()`: restituisce il nome letterale della costante come `String` (es. `"WEST"`).
    - `e.ordinal()`: restituisce la posizione ordinale intera partendo da 0 (es. `3`).
    - `EnumClass.values()`: restituisce un array contenente tutte le costanti dichiarate nell'enum, comodo per cicli for-each.
- **Confronto tra Enum: Perché usare `==` invece di `.equals()`**:
  - La JVM garantisce che in memoria esista **una e una sola istanza** per ciascuna costante di un enum (*garanzia di unicità singleton*).
  - Pertanto, il confronto con **`==`** è perfettamente sicuro ed è **più robusto di `.equals()`**: se una variabile vale `null`, l'espressione `move == Direction.WEST` restituisce `false` senza errori, mentre `move.equals(...)` causerebbe un crash con `NullPointerException`!
- **Uso di Enum negli `switch`**:
  - All'interno dei blocchi `case`, **non si qualifica** il tipo: si scrive `case IT:` e non `case Language.IT:`.

---

## Codice:  Evoluzione del Codice: `SimpleDate` (Lezione 09)

In [`Lezione09`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione09/SimpleDate/src), il docente introduce due cambiamenti strutturali fondamentali:

### Immutabilità di [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione09/SimpleDate/src/Date.java)
```diff
 public class Date {
-    private int day;
-    private int month;
-    private int year;
+    private final int day;
+    private final int month;
+    private final int year;

     // Costruttori...

-    public void setDay(int day) { ... }
-    public void setMonth(int month) { ... }
-    public void setYear(int year) { ... }
```
- **Campi `final`**: Una volta inizializzati nel costruttore, `day`, `month` e `year` non possono più essere riassegnati.
- **Rimozione dei Setter**: I metodi mutatori `setDay`, `setMonth` e `setYear` vengono eliminati.
- **Pattern Immutabile**: Un oggetto `Date` è ora a prova di manomissione. Se un programma vuole calcolare "il giorno successivo", non può mutare l'oggetto esistente, ma **deve instanziare un nuovo oggetto `Date`** con le coordinate aggiornate (esattamente come avviene per le `String`).

---

### Il Design Pattern Singleton: [`BirthDay.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione09/SimpleDate/src/BirthDay.java)
```java
public class BirthDay {
    private static Date date = new Date(1, 1, 1970);
    private static BirthDay instance; // Riferimento all'unica istanza

    // 1. Costruttore privato: impedisce istanziazioni esterne con 'new BirthDay()'
    private BirthDay() { }

    // 2. Metodo statico di fabbrica con Lazy Initialization
    public static BirthDay getInstance() {
        if (instance == null) 
            instance = new BirthDay();
        return instance;
    }

    public Date getDate() { 
        return date; 
    }
}
```

### [Approfondimento]  Analisi Architetturale del Singleton:
- **Scopo del Pattern**: Garantire che per tutta la durata dell'applicazione esista **una e una sola istanza** di una classe nello Heap e fornire un punto di accesso globale ad essa.
- **I Tre Pilastri del Singleton in Java**:
  1. **Costruttore `private`**: blocca l'accesso a `new BirthDay()` da qualsiasi altra classe (tentare di chiamarlo genera un errore a compile-time).
  2. **Campo statico privato (`instance`)**: contiene l'unico riferimento all'oggetto.
  3. **Metodo factory pubblico statico (`getInstance()`)**: implementa la *Lazy Initialization* (crea l'oggetto solo alla prima richiesta, riusandolo per tutte le successive).

---

### Verifica in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione09/SimpleDate/src/MainDate.java) e il Bug dei Getter
```java
BirthDay bDay = BirthDay.getInstance();
// BirthDay day1 = new BirthDay(); // COMPILE-TIME ERROR!
BirthDay day1 = BirthDay.getInstance();
System.out.println("bDay ?= day1: " + (bDay == day1)); // STAMPA TRUE!

Date today = new Date(27, 10, 2025);
// today.setDay(today.getDay() + 1); // COMPILE-TIME ERROR: l'oggetto è immutabile!
Date tomorrow = new Date(today.getDay() + 1, today.getMonth(), today.getYear());
```

> [!WARNING]
> **Il Bug Persistente dei Getter e l'Effetto a Runtime**:
> Anche in `Lezione09`, `Date.java` ha ancora il refuso di copia-incolla alle righe 43–44:
> ```java
> public int getMonth() { return day; } // Restituisce il campo day!
> public int getYear() { return day; }  // Restituisce il campo day!
> ```
> Quando `MainDate` crea `tomorrow` invocando `today.getMonth()` su una data con `day = 27`, ottiene `27` come mese! Di conseguenza, il costruttore riceve `(28, 27, 27)` e `verify()` stampa:
> `Illegal date!`
> `tomorrow: 28/27/27`
> Nel tuo codice è opportuno correggere questi getter (`return month;` e `return year;`).

---

## 🔄 Corrispondenza con i Tuoi Moduli Workspace

Nel tuo repository [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26):
- Nel modulo **`es09`**: hai formalizzato questo esatto pattern creando [`SingletonPattern.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es09/src/main/java/es09/SingletonPattern.java) con costruttore privato e metodo factory `getInstance()`.

---

> [!NOTE]
> Con la **Lezione 09** abbiamo consolidato la manipolazione avanzata degli array, le proprietà degli enum, l'immutabilità e il pattern Singleton.
> 
> Il prossimo blocco è la **Lezione 10 / Slide T10: *Java Variables and Call Stack***:
> - Modello formale della memoria JVM: **Call Stack (Stack Frames)** vs **Heap (Objects & Class Data)**.
> - Variabili d'istanza, variabili di classe (`static`), variabili locali e parametri di metodo.
> - Il passaggio dei parametri per valore (*pass-by-value*) per tipi primitivi vs reference types.
> - Il blocco di inizializzazione statica (`static { ... }`).
> - **Il grande spartiacque del corso**: il debutto del progetto **`MavenDate`**, con l'adozione ufficiale di Apache Maven, `pom.xml`, layout directory standard e primo packaging!

**Dammi conferma per aprire la Lezione 10 / T10 e analizzare Call Stack e MavenDate!**

---


# Capitolo 9: T10 --- Variabili, Scope, Call Stack e Memoria Heap

*Stack Frame, Passaggio dei Parametri per Valore, Garbage Collection e Debutto di MavenDate*

In questo blocco analizziamo in profondità il modello di memoria della JVM (Stack vs Heap), il passaggio dei parametri per valore, gli oggetti immutabili e i tipi wrapper ([T10 - Java Variables and Call Stack.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T10%20-%20Java%20Variables%20and%20Call%20Stack.pdf)).
Sul fronte pratico analizziamo il **grande spartiacque architetturale del corso**: il passaggio dal progetto manuale a pacchetti [`SimpleDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/SimpleDate) al progetto ufficiale **[`MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate)** con Apache Maven, file [`pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/pom.xml), layout `src/main/java` e collisione di nomi tra package diversi.

## Teoria:  Concetti Teorici dalle Slide (Slide T10)

### Il Modello di Memoria della JVM: Stack vs Heap (Slide 1–11)
La memoria a disposizione di un processo Java è partizionata in tre aree principali:
1. **Call Stack (Stack dei Thread)**:
   - Memoria estremamente veloce, gestita a politica LIFO (Push/Pop).
   - È suddivisa in **Stack Frame** (o record di attivazione): ogni invocazione di metodo crea un nuovo frame nello stack contenente:
     - La tabella delle variabili locali.
     - I parametri formali passati al metodo.
     - Lo stack degli operandi (per i calcoli intermedi della CPU/bytecode).
     - I riferimenti alla costante del metodo e l'indirizzo di ritorno.
   - Quando il metodo termina (con `return` o eccezione), il frame viene rimosso istantaneamente dallo Stack e tutte le sue variabili locali vengono distrutte.
2. **Heap (Memoria Dinamica degli Oggetti)**:
   - Memoria globale condivisa da tutti i thread dell'applicazione.
   - Ospita tutti gli **oggetti** istanziati con `new`, inclusi gli **array**.
   - I dati nello Heap non si deallocano all'uscita dal metodo: sopravvivono finché esiste almeno un riferimento attivo nello Stack o in altri oggetti che punta ad essi. Quando diventano irraggiungibili (*unreachable*), vengono eliminati dal Garbage Collector.
3. **Method Area / Metaspace (Memoria di Classe)**:
   - Ospita il bytecode compilato delle classi caricate dal ClassLoader, i metadati di tipo e le **variabili statiche** (`static`).
- **Blocco di Inizializzazione Statica (`static { ... }`)**:
  - Blocco speciale eseguito **una sola volta** nel ciclo di vita dell'applicazione, al momento in cui la classe viene caricata in memoria dalla JVM:
    ```java
    static int[] arr;
    static {
        arr = new int[3];
        arr[0] = 1; arr[1] = 2; arr[2] = 0;
    }
    ```
  - Si usa per inizializzare strutture statiche complesse che richiedono cicli o controlli prima dell'uso.

---

### Immutabilità e Passaggio Parametri: Pass-by-Value (Slide 15–25)
- **Oggetti Immutabili (*Immutable Objects*)**:
  - Un oggetto il cui stato interno non può essere modificato dopo la costruzione (es. `String`, `Integer`, `Date` da Lezione 09).
  - *Regole per creare una classe immutabile*:
    1. Rendere tutti i campi `private final`.
    2. Non fornire metodi mutatori (nessun setter).
    3. Dichiarare la classe `final` (per impedire che le sottoclassi violino l'immutabilità con override malevoli).
    4. Se l'oggetto contiene riferimenti a strutture mutabili (es. un array o un'altra data mutabile), eseguire copie difensive (*defensive copy*) nel costruttore e nei getter.
  - *Vantaggi*: Immuni da side-effects da aliasing, intrinsecamente *thread-safe* (possono essere condivisi tra thread concorrenti senza sincronizzazione o lock).
- **Come Java passa i parametri ai metodi: SEMPRE Strictly Pass-by-Value**:
  - In Java **non esiste il passaggio per riferimento del C++ (`int& x`)**.
  - **Per i tipi primitivi (`int`, `double`)**: il metodo riceve una copia del valore binario. Qualsiasi modifica locale sul parametro non ha alcun effetto sulla variabile del chiamante.
  - **Per i tipi reference (oggetti/array)**: il metodo riceve **una copia per valore del riferimento** (dell'indirizzo puntato):
    - *Caso 1 (Mutazione dell'oggetto)*: se usiamo il riferimento ricevuto per chiamare un metodo mutatore (`p.setAge(25)`), l'oggetto puntato nello Heap viene effettivamente modificato per il chiamante!
    - *Caso 2 (Riassegnamento del puntatore — Il tranello d'esame)*:
      ```java
      void reset(Person p) {
          p = new Person("Bob"); // Assegna un nuovo oggetto al puntatore locale!
      }
      ```
      All'esterno, la variabile del chiamante **non cambia affatto**! Ha semplicemente mutato la copia locale del puntatore nel proprio stack frame.

---

### Classi Wrapper, Autoboxing e i loro Trabocchetti (Slide 26–35)
- Per ciascuno degli 8 tipi primitivi, Java mette a disposizione una corrispondente **Wrapper Class** nel package `java.lang`:
  - `byte` $\rightarrow$ `Byte`
  - `short` $\rightarrow$ `Short`
  - `int` $\rightarrow$ `Integer`
  - `long` $\rightarrow$ `Long`
  - `float` $\rightarrow$ `Float`
  - `double` $\rightarrow$ `Double`
  - `char` $\rightarrow$ `Character`
  - `boolean` $\rightarrow$ `Boolean`
- Tutte le classi wrapper sono **immutabili**.
- **Autoboxing e Unboxing (Java 5+)**:
  - *Autoboxing*: conversione automatica da primitivo a wrapper (`Integer x = 5;` $\implies$ compilato come `Integer.valueOf(5)`).
  - *Unboxing*: estrazione automatica del valore primitivo dal wrapper (`int y = x;` $\implies$ compilato come `x.intValue()`).
- [Attenzione]  **I Due Grandi Pericoli delle Wrapper Classes**:
  1. **Il Trabocchetto dell'Integer Cache ($-128 \dots +127$)**:
     ```java
     Integer a = 100, b = 100;
     System.out.println(a == b); // TRUE! (La JVM ricicla lo stesso oggetto cacheato)

     Integer c = 200, d = 200;
     System.out.println(c == d); // FALSE! (Fuori range [-128, 127], alloca 2 oggetti distinti nello Heap!)
     ```
     Conclusione: **Mai usare `==` per confrontare i wrapper**, usare sempre `.equals()`!
  2. **Crash da Unboxing su `null`**:
     ```java
     Integer obj = null;
     int val = obj; // RUNTIME ERROR: NullPointerException!
     ```
     La JVM tenta di invocare `obj.intValue()`, fallendo rovinosamente se `obj` è nullo.

---

## Codice:  Evoluzione del Codice: Il Passaggio a `MavenDate`

In [`Lezione10`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10), il docente archivia il vecchio progetto non strutturato e adotta lo standard industriale **Apache Maven**.

### Riorganizzazione dei Package
Il progetto viene suddiviso in due package distinti:
- **`it.oop.core`**: il dominio applicativo (le classi di modello: [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/core/Date.java), [`Language.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/core/Language.java), [`BirthDay.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/core/BirthDay.java)).
- **`it.oop.ui`**: l'interfaccia utente contenente il `main` ([`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/ui/MainDate.java)).

### Il Test Didattico sulla Collisione dei Nomi di Package
Nel package `it.oop.ui`, il docente aggiunge appositamente una seconda classe:
[`it/oop/ui/Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/ui/Date.java):
```java
package it.oop.ui;

class Date { // Visibilità package-private
    public int time;
    private int start = 0;

    public Date(int time) { this.time = time; }
}
```
E in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/src/main/java/it/oop/ui/MainDate.java) mostra come la JVM risolve l'ambiguità:
```java
package it.oop.ui;

import it.oop.core.Date; // 1. L'import esplicito ha la precedenza!

public class MainDate {
    public static void main(String[] args) {
        Date d1 = new Date(7, 1, 2025); // Istanzia it.oop.core.Date!

        // 2. Per istanziare la classe Date del package it.oop.ui,
        // è obbligatorio usare il Fully Qualified Name (FQN):
        it.oop.ui.Date d = new it.oop.ui.Date(12345);
        System.out.println(d.time);      // OK: 'time' è public
        // System.out.println(d.start);  // COMPILE-TIME ERROR: 'start' è private!
    }
}
```

### Anatomia del [`pom.xml`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione10/MavenDate/pom.xml) di `MavenDate`
```xml
<project ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>it.oop</groupId>
    <artifactId>MavenDate</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <build>
        <plugins>
            <!-- Plugin per creare il JAR eseguibile con dipendenze -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.7.1</version>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <!-- Entrypoint del JAR -->
                            <mainClass>it.oop.ui.MainDate</mainClass>
                        </manifest>
                    </archive>
                </configuration>
                <executions>
                    <execution>
                        <id>assemble-all</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```
Questo file è il prototipo esatto che hai esteso in tutti i moduli del tuo workspace `esercizi-wally-25-26`:
- `compile`: compila da `src/main/java` verso `target/classes`.
- `test`: compila ed esegue i test da `src/test/java` verso `target/test-classes`.
- `package`: genera il JAR auto-eseguibile con `META-INF/MANIFEST.MF` configurato con `Main-Class: it.oop.ui.MainDate`.

---

## 🔄 Corrispondenza con i Tuoi Moduli Workspace

Nel tuo repository [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26):
- **`es08`**: [`Memory.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es08/src/main/java/es08/Memory.java) implementa l'allocazione Stack vs Heap e il blocco `static { ... }`.
- **`es10`**: [`ImmutablePerson.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es10/src/main/java/es10/ImmutablePerson.java) applica formalmente tutte le regole di immutabilità di T10 (`final class`, campi `final`, validazione e assenza di setter).

---

> [!NOTE]
> Con la **Lezione 10** abbiamo completato l'intero quadro su memoria, call stack, tipi wrapper e la transizione a Maven.
> 
> Il prossimo blocco è la **Lezione 11 / Slide T11: *Packages and Class Visibility***:
> - Tassonomia gerarchica dei package e convenzioni DNS invertite (`it.univr...`).
> - Regole di visibilità e accessibilità inter-package: membri `public`, `protected`, package-private e `private`.
> - Evoluzione di `MavenDate`:
>   - Refactoring dell'algoritmo Gregoriano: introduzione definitiva del **calcolo dell'anno bisestile (`isLeapYear`)** in `Date.java`!
>   - Integrazione di `isLeapYear(year)` in `daysPerMonth(month, year)` e fine dei mesi errati per Febbraio!

**Dammi conferma per procedere alla Lezione 11 / T11!**

---


# Capitolo 10: T11 --- Package, Moduli e Regole di Visibilità

*Struttura Cartelle, Modificatori public/protected/default/private e MavenDate v2 con equals()*

In questo blocco analizziamo la modularità avanzata offerta dai package, le regole di risoluzione dei nomi e i livelli di visibilità dei membri ([T11 - Packages and Class Visibility.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T11%20-%20Packages%20and%20Class%20Visibility.pdf)).
Sul piano pratico, in [`Lezione11/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate) assistiamo a una grande svolta architetturale:
1. Nascono le sottoclassi specializzate **[`ItalianDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/ItalianDate.java)** e **[`AmericanDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/AmericanDate.java)** tramite estensione (`extends Date`).
2. Viene introdotto il modificatore **`protected`**.
3. Viene implementato l'algoritmo canonico per l'overriding del metodo **`equals(Object)`**.
4. Viene risolto il bug storico dei getter `getMonth()` e `getYear()`.

## Teoria:  Concetti Teorici dalle Slide (Slide T11)

### Modularità, Gerarchia e Convenzioni dei Package (Slide 1–11)
- **Definizione di Package**:
  - Un package è un raggruppamento logico di classi correlate che scala il concetto di incapsulamento a livello di libreria.
  - Definisce un **namespace isolato**: classi con lo stesso nome possono coesistere senza conflitti se collocate in package differenti (es. `it.oop.ui.Date` vs `it.oop.core.Date`).
- **Convenzione di Naming Standard**:
  - Si usa il nome di dominio Internet invertito in caratteri minuscoli: `it.univr.mypackage`, `it.oop.core`.
- **Dichiarazione e Corrispondenza col Filesystem**:
  - La direttiva `package nomepkg;` deve essere **la prima istruzione non di commento** all'inizio del file `.java`.
  - Java impone una corrispondenza 1-a-1 tra la gerarchia dei package e la struttura delle cartelle su disco: la classe `it.oop.core.Date` deve trovarsi nel percorso `it/oop/core/Date.java`.
- **Sotto-Package e Wildcard**:
  - I package possono essere annidati (es. `java.awt.event` è un sottopackage di `java.awt`).
  - [Attenzione]  **Regola d'esame**: la direttiva `import pkg.*;` importa solo le classi direttamente contenute in `pkg`. **Non importa le classi contenute nei suoi sotto-package** (per importare `java.awt.event` è obbligatorio scrivere `import java.awt.event.*;`).
- **Il Default Package (Unnamed Package)**:
  - Se un file `.java` omette la dichiarazione `package`, la classe appartiene al package predefinito senza nome.
  - **Limitazione critica**: Le classi nel default package **non possono essere importate né utilizzate** da classi situate in package con nome. Nel software professionale e agli esami il suo uso è fortemente scoraggiato.
- **Compilazione e Packaging con Strumenti Standard e Maven**:
  - `javac -d bin/ src/pkg/MyClass.java`: il flag `-d` crea automaticamente l'albero delle sottocartelle nella directory di destinazione `bin/`.
  - Con Maven: il layout `src/main/java` e `src/test/java` unito al `pom.xml` automatizza compilazione, test surefire e packaging in Fat JAR.

---

### Visibilità di Classe e Matrice di Accesso dei Membri (Slide 12–19)
- **Visibilità a Livello di Classe (Top-Level Classes)**:
  - `public class Clazz`: accessibile e istanziabile da qualsiasi package del Classpath.
  - `class Clazz` (*Package-Private* / default): visibile e utilizzabile **esclusivamente all'interno dello stesso package**. Non può essere usata all'esterno, anche se i suoi metodi interni sono dichiarati `public`.
  - *Nota*: le classi di primo livello non possono essere dichiarate `private` né `protected` (questi modificatori sono ammessi solo per classi annidate/interne).
- **La Matrice dei Modificatori di Accesso (Fields e Methods)**:

| Modificatore | Stessa Classe | Stesso Package | Sottoclasse (Altro Package) | Mondo Esterno |
| :--- | :---: | :---: | :---: | :---: |
| **`private`** | [OK]  | ❌ | ❌ | ❌ |
| **Default** *(package-private)* | [OK]  | [OK]  | ❌ | ❌ |
| **`protected`** | [OK]  | [OK]  | [OK]  | ❌ |
| **`public`** | [OK]  | [OK]  | [OK]  | [OK]  |

- **Risoluzione dei Nomi**:
  - Se una classe importa due tipi omonimi o usa una classe locale avente lo stesso nome di una classe importata, per disambiguare è obbligatorio usare il **Fully Qualified Name (FQN)**:
    `it.oop.ui.Date d = new it.oop.ui.Date(12345);`

---

## Codice:  Evoluzione del Codice: [`Lezione11/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate)

In `Lezione11`, il codice di `MavenDate` compie un balzo in avanti con l'introduzione di gerarchie di classi e l'overriding:

### Generalizzazione in [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/Date.java)
```java
package it.oop.core;

public class Date {
    // 1. Campo 'protected': accessibile direttamente dalle sottoclassi
    protected final int day;
    // 2. Campi 'private': incapsulati e accessibili solo tramite getter
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        verify();
    }

    // 3. I GETTER SONO STATI CORRETTI!
    public int getDay() { return day; }
    public int getMonth() { return month; } // Non restituisce più day!
    public int getYear() { return year; }   // Non restituisce più day!

    // 4. Implementazione canonica di equals(Object)
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;              // Controllo null-safety
        if (this == other) return true;               // Controllo identità (stesso indirizzo)
        if (!(other instanceof Date)) return false;   // Controllo di tipo/ereditarietà
        Date otherAsDate = (Date) other;              // Downcast sicuro
        return day == otherAsDate.getDay()            // Confronto dei campi
                && month == otherAsDate.getMonth()
                && year == otherAsDate.getYear();
    }
}
```

### [Approfondimento]  I 5 Passi Fondamentali dell'Algoritmo `equals(Object)`:
1. `if (other == null) return false;`: garantisce che `d.equals(null)` ritorni `false` senza lanciare `NullPointerException`.
2. `if (this == other) return true;`: ottimizzazione immediata (riflessività). Se sono lo stesso oggetto nello Heap, sono identici.
3. `if (!(other instanceof Date)) return false;`: verifica se l'oggetto passato è compatibile con la gerarchia `Date`.
4. `Date otherAsDate = (Date) other;`: downcast necessario perché la firma di `equals` accetta un generico `Object`.
5. Confronto logico dei campi che definiscono lo stato: `day`, `month`, `year`.

---

### Le Nuove Sottoclassi: [`ItalianDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/ItalianDate.java) e [`AmericanDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/AmericanDate.java)

```java
package it.oop.core;

public class ItalianDate extends Date {
    private static final String FORMAT = "dd/mm/yyyy";
    private static final String[] MONTHS = { "gennaio", "febbraio", ... };

    // Invocazione del costruttore genitore con 'super'
    public ItalianDate(int day, int month, int year) {
        super(day, month, year);
    }

    public String printFormat() { return FORMAT; }

    public String prettyPrint() {
        // 'day' è accessibile direttamente perché 'protected'!
        // 'getYear()' è invocato tramite metodo perché 'year' è 'private' in Date!
        return day + " " + getMonthAsString() + " " + getYear();
    }

    @Override
    public String toString() {
        return day + "/" + getMonth() + "/" + getYear();
    }
}
```

E simmetricamente per `AmericanDate`:
```java
public class AmericanDate extends Date {
    private static final String FORMAT = "mm/dd/yyyy";

    public AmericanDate(int day, int month, int year) {
        super(day, month, year);
    }

    @Override
    public String toString() {
        // Mese prima del giorno!
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
}
```

---

### Polimorfismo, Upcasting e Downcasting in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/ui/MainDate.java)

Analizziamo i comportamenti a runtime testati dal docente:
```java
Date date = new Date(3, 11, 2025);
ItalianDate itDate = new ItalianDate(3, 11, 2025);
AmericanDate usDate = new AmericanDate(3, 11, 2025);

// 1. Confronti con equals():
System.out.println("date ?= itDate: " + date.equals(itDate));     // Stampa TRUE!
System.out.println("itDate ?= usDate: " + itDate.equals(usDate)); // Stampa TRUE!
```
*Perché stampano `true`?*
Perché sia `itDate` che `usDate` estendono `Date`: l'operatore `instanceof Date` è soddisfatto, e i campi (giorno 3, mese 11, anno 2025) coincidono perfettamente!

```java
// 2. Upcasting (Polimorfismo di Inclusione):
Date d = new ItalianDate(1, 1, 1970); // LECITO: ItalianDate È UN Date!

// 3. Tipi Incompatibili tra rami fratelli:
// AmericanDate ad = new ItalianDate(1, 1, 1970); // COMPILE-TIME ERROR!

// 4. Downcasting esplicito lecito:
ItalianDate id = (ItalianDate) d; // LECITO a runtime: l'oggetto nello Heap è davvero ItalianDate!
System.out.println(id.printFormat()); // Stampa dd/mm/yyyy

// 5. Downcasting illegale a runtime:
// ItalianDate idFalso = (ItalianDate) date; // CRASH RUNTIME: ClassCastException!
// (perché 'date' è un Date generico, non contiene la specializzazione ItalianDate)
```

---

## 🔄 Corrispondenza con i Tuoi Moduli Workspace

Nel tuo repository [`esercizi-wally-25-26`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26):
- **`es13`**: [`Calculator.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es13/src/main/java/es13/model/Calculator.java) e [`TestCalculator.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es13/src/test/java/es13/TestCalculator.java) applicano la separazione `es13.model` e `es13` illustrata a lezione (Slide T11, pp. 3–14).
- **`es14`**: implementa esattamente questa architettura a oggetti multi-package (`it.oop.core` e `it.oop.ui`) con [`ItalianDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es14/src/main/java/it/oop/core/ItalianDate.java), [`AmericanDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es14/src/main/java/it/oop/core/AmericanDate.java), [`Date`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es14/src/main/java/it/oop/core/Date.java) e i relativi test in [`src/test/java/it/oop/core/TestItalianDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/esercizi-wally-25-26/es14/src/test/java/it/oop/core/TestItalianDate.java).

---

> [!NOTE]
> Con la **Lezione 11** abbiamo visto l'introduzione dell'ereditarietà (`extends`), la visibilità `protected`, l'overriding di `equals()` e le regole di cast tra classi.
> 
> Il prossimo blocco è la **Lezione 12 / Slide T12: *Inheritance and Polymorphism***:
> - Teoria approfondita sull'ereditarietà: riuso, estensione e specializzazione.
> - La classe radice universale **`java.lang.Object`** e i suoi metodi (`toString`, `equals`, `hashCode`, `getClass`, `clone`).
> - Il costrutto `super`: invocazione di costruttori (`super(...)`) e invocazione di metodi della superclasse (`super.metodo()`).
> - **Polimorfismo e Dynamic Method Dispatch (Late Binding)**: come la JVM decide a runtime quale metodo eseguire tramite la *vtable*.
> - Regole di overriding vs overloading e l'annotazione `@Override`.
> - Evoluzione del codice in `Lezione12`:
>   - La classe `Date` diventa la superclasse polimorfica di riferimento.
>   - Aggiunta del metodo `isLeapYear(int year)` per la validazione completa dei bisestili gregoriani!

**Dammi conferma per aprire la Lezione 12 / T12 e proseguire!**

---


# Capitolo 11: T12 --- Ereditarietà, Dynamic Binding e Polimorfismo

*Estensione di Classi, super, Overriding vs Overloading, Polimorfismo e MavenDate v3*

In questo blocco analizziamo in modo esaustivo i due pilastri più importanti dell'OOP in Java: l'**Ereditarietà** e il **Polimorfismo** ([T12 - Inheritance and Polymorphism.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T12%20-%20Inheritance%20and%20Polymorphism.pdf)).
Nel codice di [`Lezione12/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate), la gerarchia evolve introducendo la classe astratta intermedia **[`FormattedDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/core/FormattedDate.java)**, l'interfaccia **[`Time`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/core/Time.java)**, la classe estesa **[`TimeStamp`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/core/TimeStamp.java)** e l'interfaccia standard **`Comparable`** per l'ordinamento naturale degli array.

## Teoria:  Concetti Teorici dalle Slide (Slide T12)

### Ereditarietà di Classe (`extends`) e Riuso (Slide 1–17)
- **Relazione "IS-A" vs "HAS-A"**:
  - *Ereditarietà ("IS-A")*: un'auto *è un* veicolo (`Car extends Vehicle`); una data italiana *è una* data (`ItalianDate extends Date`).
  - *Composizione ("HAS-A")*: un'auto *ha un* motore (`Car` ha un campo `Engine`); una persona *ha una* data di nascita (`Person` ha un campo `Date`).
- **Ereditarietà Singola in Java**:
  - In Java **non esiste l'ereditarietà multipla tra classi** (a differenza del C++). Una classe può estendere al massimo **una sola classe genitore diretta** (`extends SuperClass`). Questo previene il cosiddetto *Diamond Problem*.
- **Overriding vs Overloading**:
  - *Method Overloading*: metodi nella stessa classe con lo stesso nome ma parametri diversi (risolto staticamente a compile-time).
  - *Method Overriding*: una sottoclasse riscrive l'implementazione di un metodo ereditato mantenendo **la stessa identica segnatura** (nome, tipi dei parametri, ordine) e un tipo di ritorno identico o covariante.
  - **L'Annotazione `@Override`**:
    Non è sintatticamente obbligatoria per far funzionare l'overriding, ma è una best practice fondamentale: dice al compilatore di verificare che quel metodo esista davvero nella superclasse, intercettando errori di battitura (es. scrivere per sbaglio `tostring()` con la 's' minuscola verrebbe segnalato come errore).
- **Costruttori ed Ereditarietà: La Parola Chiave `super`**:
  - [Attenzione]  **I costruttori NON vengono mai ereditati dalle sottoclassi**.
  - All'interno del costruttore di una sottoclasse, la prima istruzione deve essere una chiamata a `super(...)` oppure a un altro costruttore con `this(...)`.
  - Se il programmatore non scrive nulla, il compilatore inserisce automaticamente **`super();`** (invocazione del costruttore vuoto della superclasse).
  - [Attenzione]  **Trappola d'esame**: Se la superclasse non possiede un costruttore senza parametri (perché ne ha definito uno con parametri e non ha aggiunto quello di default), omettere `super(...)` genera un **Compile-Time Error**!
  - `super.metodo()` permette inoltre di invocare l'implementazione originaria della superclasse, bypassando l'override locale.
- **Classi e Metodi `final`**:
  - `final class`: non può essere estesa da nessun'altra classe (es. `String`, `Integer`).
  - `final method`: non può essere sovrascritto (*overridden*) da nessuna sottoclasse.

---

### La Classe Radice Universale: `java.lang.Object` (Slide 18–31)
- *«The One Ring»*: in Java qualsiasi classe estende implicitamente `java.lang.Object`. Se una classe non specifica `extends`, estende direttamente `Object`.
- **I Metodi Universali di `Object`**:
  - `public String toString()`: rappresentazione testuale (`NomeClasse@hashcode`).
  - `public boolean equals(Object obj)`: confronto semantico (di default confronta l'identità con `==`).
  - `public int hashCode()`: valore hash associato all'oggetto.
  - `public final Class<?> getClass()`: restituisce il descrittore a runtime del tipo della classe.
- **Il Contratto Formale di `equals`**:
  Ogni implementazione di `equals` deve rispettare 5 proprietà matematiche:
  1. *Riflessiva*: `x.equals(x)` è sempre `true`.
  2. *Simmetrica*: `x.equals(y)` ritorna `true` se e solo se `y.equals(x)` ritorna `true`.
  3. *Transitiva*: se `x.equals(y)` è `true` e `y.equals(z)` è `true`, allora `x.equals(z)` è `true`.
  4. *Consistente*: invocazioni multiple producono lo stesso risultato finché lo stato non muta.
  5. *Non-Nullità*: per qualsiasi `x != null`, la chiamata `x.equals(null)` **deve restituire `false`** senza lanciare eccezioni.

---

### Polimorfismo e Dynamic Method Dispatch (Late Binding) (Slide 32–50)
- **Principio di Sostituzione di Liskov (LSP)**:
  Se $S$ è sottotipo di $T$, qualsiasi porzione di codice scritta per interagire con $T$ deve poter operare in modo trasparente e corretto con un'istanza di $S$.
- **Tipo Statico vs Tipo Dinamico**:
  ```java
  Date d = new ItalianDate(1, 1, 1970);
  ```
  - **Tipo Statico (a Compile-Time)**: è il tipo dichiarato della variabile reference (`Date`). Il compilatore accetta solo invocazioni a metodi e accessi a campi definiti nella classe `Date`.
  - **Tipo Dinamico (a Runtime)**: è il tipo effettivo dell'oggetto allocato nello Heap (`ItalianDate`).
- **Dynamic Method Dispatch (Late Binding)**:
  Quando a runtime viene eseguita una chiamata a un metodo d'istanza (es. `d.toString()`), la JVM consulta la **Virtual Method Table (vtable)** dell'oggetto concreto nello Heap e seleziona **la versione del metodo definita dal Tipo Dinamico**!
  Non importa che `d` sia dichiarata come `Date`: verrà eseguito il `toString()` specializzato di `ItalianDate`.
- **Regole di Conversione di Tipo (Casting tra Oggetti)**:
  - **Upcasting (verso la superclasse)**:
    `Date d = new ItalianDate(...);` $\implies$ **Implicito, automatico e sempre sicuro al 100%**.
  - **Downcasting (verso la sottoclasse)**:
    `ItalianDate id = (ItalianDate) d;` $\implies$ **Esplicito obbligatorio**.
    - Se l'oggetto concreto nello Heap è effettivamente un'istanza compatibile, il cast ha successo.
    - Se l'oggetto concreto nello Heap è di tipo diverso (es. un `Date` generico o un `AmericanDate`), la JVM interrompe l'esecuzione e lancia una **`ClassCastException`**!
  - **Downcasting Sicuro con `instanceof`**:
    Per evitare crash a runtime si verifica preventivamente la compatibilità:
    ```java
    if (d instanceof ItalianDate) {
        ItalianDate id = (ItalianDate) d;
    }
    ```

---

## Codice:  Evoluzione del Codice: [`Lezione12/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate)

In `Lezione12` la gerarchia del progetto diventa ricca e completa:

```text
classDiagram
    class Object {
        +toString()
        +equals(Object)
    }
    class Comparable {
        <<interface>>
        +compareTo(Object)
    }
    class Time {
        <<interface>>
        +getSeconds()
        +getMinutes()
        +getHours()
    }
    class Date {
        #day: int
        -month: int
        -year: int
        +toString()
        +equals(Object)
        +compareTo(Object)
    }
    class FormattedDate {
        <<abstract>>
        #format: String
        #months: String[]
        +printFormat() final
        +getMonthAsString() final
        +prettyPrint()* String
    }
    class ItalianDate {
        +prettyPrint()
        +toString()
    }
    class AmericanDate {
        +prettyPrint()
        +toString()
    }
    class TimeStamp {
        #seconds: int
        #minutes: int
        #hours: int
        +toString()
        +equals(Object)
    }

    Object <|-- Date
    Comparable <|.. Date
    Date <|-- FormattedDate
    FormattedDate <|-- ItalianDate
    FormattedDate <|-- AmericanDate
    Date <|-- TimeStamp
    Time <|.. TimeStamp
```

### L'Interfaccia `Comparable` in [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/core/Date.java)
`Date` implementa l'interfaccia standard `java.lang.Comparable` per consentire l'ordinamento naturale:
```java
public class Date implements Comparable {
    ...
    @Override
    public int compareTo(Object other) {
        Date otherAsDate = (Date) other;
        int diff = this.year - otherAsDate.getYear();
        if (diff != 0) return diff;
        diff = this.month - otherAsDate.getMonth();
        if (diff != 0) return diff;
        return this.day - otherAsDate.getDay();
    }
}
```
*Logica di confronto*: confronta prima gli anni, se uguali confronta i mesi, se uguali confronta i giorni. Restituisce un intero negativo se `this < other`, zero se uguali, positivo se `this > other`.

---

### L'Astrazione con Classe Astratta: [`FormattedDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/core/FormattedDate.java)
Centralizza i dati di formattazione evitando duplicazioni tra `ItalianDate` e `AmericanDate`:
```java
public abstract class FormattedDate extends Date {
    protected final String format;
    protected final String[] months;

    public FormattedDate(int day, int month, int year, String format, String[] months) {
        super(day, month, year);
        this.format = format;
        this.months = months;
    }

    // Metodi final: le sottoclassi non possono sovrascriverli (Template Method Pattern)
    public final String printFormat() { return format; }
    public final String getMonthAsString() { return months[getMonth() - 1]; }

    // Metodo astratto: DEVE essere implementato dalle sottoclassi concrete
    public abstract String prettyPrint();
}
```

---

### Ereditarietà Multipla di Tipo: [`TimeStamp.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/core/TimeStamp.java)
Mostra come combinare l'estensione di una classe concreta con l'implementazione di un'interfaccia:
```java
public class TimeStamp extends Date implements Time {
    protected final int seconds;
    protected final int minutes;
    protected final int hours;

    public TimeStamp(int seconds, int minutes, int hours, int day, int month, int year) {
        super(day, month, year);
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    @Override
    public String toString() {
        // Riusa il toString() della superclasse aggiungendo l'orario con zero-padding a due cifre:
        return String.format("%s[%02d:%02d:%02d]", super.toString(), hours, minutes, seconds);
    }

    @Override
    public boolean equals(Object other) {
        // 1. Verifica prima l'uguaglianza della data con super.equals():
        if (super.equals(other) == false) return false;
        if (!(other instanceof TimeStamp)) return false;
        TimeStamp otherAsTimeStamp = (TimeStamp) other;
        // 2. Poi verifica l'orario:
        return hours == otherAsTimeStamp.getHours() &&
               minutes == otherAsTimeStamp.getMinutes() &&
               seconds == otherAsTimeStamp.getSeconds();
    }
}
```

---

### Dimostrazione Pratica in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione12/MavenDate/src/main/java/it/oop/ui/MainDate.java)
```java
Time ts1 = new TimeStamp(0, 0, 10, 10, 11, 2025);
System.out.println(ts1.toString()); // Esegue TimeStamp.toString() tramite Late Binding!

// ts1.getDay(); // COMPILE-TIME ERROR: il tipo statico Time non possiede il metodo getDay()!
System.out.println(((Date) ts1).getDay()); // OK: cast esplicito a Date!

Date[] arr = { ts2, itDate, new Date(9, 9, 2025) };
Arrays.sort(arr); // Ordina l'array eterogeneo grazie a compareTo()!
System.out.println(Arrays.toString(arr));
```
**Output a video prodotto dall'ordinamento polimorfico**:
```text
[y2025m9d9, 3/11/2025, y2025m11d10[10:00:00]]
```
- L'ordinamento colloca correttamente prima il 9 settembre, poi il 3 novembre (`itDate`) e infine il 10 novembre (`TimeStamp`).
- In fase di stampa, ciascun elemento viene formattato dal **proprio** metodo `toString()` dinamico.

---

> [!NOTE]
> Con la **Lezione 12** abbiamo analizzato la gerarchia completa di ereditarietà, l'overriding con `super`, il late binding, la classe astratta `FormattedDate` e l'ordinamento con `Comparable`.
> 
> Il prossimo blocco è la **Lezione 13 / Slide T13: *Abstract Classes and Interfaces***:
> - Differenze ontologiche e strutturali tra **Classi Astratte** e **Interfacce**.
> - Metodi `default` e metodi `static` nelle interfacce (Java 8+).
> - Ereditarietà multipla tramite interfacce e risoluzione dei conflitti (*Diamond Problem* sui metodi default).
> - Evoluzione di `MavenDate` in `Lezione13`:
>   - La classe `Date` viene ripensata per gestire il calendario completo.
>   - Analisi delle nuove interfacce e classi di supporto.

**Dammi conferma per aprire la Lezione 13 / T13 e analizzare a fondo Classi Astratte e Interfacce!**

---


# Capitolo 12: T13 --- Classi Astratte ed Interfacce

*Contratti Comportamentali, Metodi Astratti, Default e Static Methods, Builder Pattern e Lambda*

In questo blocco analizziamo a fondo i meccanismi di astrazione pura di Java: le **Classi Astratte**, le **Interfacce**, il design pattern **Template Method** e le interfacce cardine della libreria standard (`Comparable`, `Iterable`, `Iterator`) ([T13 - Abstract Classes and Interfaces.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T13%20-%20Abstract%20Classes%20and%20Interfaces.pdf)).
Nel codice di [`Lezione13/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate), il docente compie un'evoluzione straordinaria introducendo:
1. La classe statica annidata **[`Date.Builder`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate/src/main/java/it/oop/core/Date.java)** per la costruzione controllata degli oggetti.
2. L'interfaccia funzionale **[`FormattedDateConverter`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate/src/main/java/it/oop/core/FormattedDateConverter.java)**.
3. L'uso congiunto in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate/src/main/java/it/oop/ui/MainDate.java) di **Classi Anonime** (`new Time() { ... }`) e **Espressioni Lambda** (`d -> new AmericanDate(...)`).

## Teoria:  Concetti Teorici dalle Slide (Slide T13)

### Classi Astratte e Template Method Pattern (Slide 1–10)
- **Metodo Astratto**:
  - Un metodo dichiarato con la parola chiave `abstract` e **privo di corpo** (termina con il punto e virgola `;` anziché con le parentesi graffe `{ ... }`):
    ```java
    public abstract String prettyPrint();
    ```
  - Definisce una "firma obbligatoria": impone alle sottoclassi concrete il compito di implementarne la logica.
- **Classe Astratta (`abstract class`)**:
  - Se una classe contiene anche un solo metodo astratto, **deve obbligatoriamente essere dichiarata `abstract`**.
  - [Attenzione]  **Regola aurea d'esame**: Una classe astratta **non può MAI essere istanziata direttamente** (`new FormattedDate(...)` genera un **Compile-Time Error**!).
  - Può contenere costruttori (invocabili dalle sottoclassi tramite `super(...)`), campi di istanza (`protected`/`private`), metodi concreti e metodi astratti.
  - Una sottoclasse che estende una classe astratta deve:
    - O implementare **tutti** i metodi astratti ereditati.
    - Oppure essere dichiarata essa stessa `abstract`.
- **Il Template Method Pattern**:
  - Pattern comportamentale in cui la superclasse definisce lo scheletro immutabile di un algoritmo all'interno di un metodo concreto marcato **`final`** (il template), mentre delega i singoli passi variabili o dipendenti dal contesto a metodi `abstract` implementati dalle sottoclassi.
  - Nel nostro progetto: `printFormat()` e `getMonthAsString()` sono `final` in `FormattedDate`, mentre `prettyPrint()` è `abstract`.

---

### Le Interfacce in Java (`interface`) (Slide 11–17)
- **Definizione e Filosofia**:
  - Un'interfaccia è un **contratto puro di comportamento**. Rappresenta ciò che una classe *sa fare* (*can-do*), non la sua identità ontologica.
  - **Membri di un'interfaccia standard**:
    - **Campi**: sono implicitamente ed esclusivamente **`public static final`** (costanti di classe). Non possono esistere variabili d'istanza o stato mutabile.
    - **Metodi**: sono implicitamente **`public abstract`** (non serve specificarlo).
- **Ereditarietà Multipla di Tipo (`implements`)**:
  - Una classe può estendere al massimo una sola superclasse, ma può implementare **un numero arbitrario di interfacce separate da virgola**:
    ```java
    public class TimeStamp extends Date implements Time, Serializable, Cloneable
    ```
  - Questo realizza in Java l'ereditarietà multipla dei tipi senza incorrere nei problemi di ambiguità di memoria del C++.
- **Ereditarietà tra Interfacce**:
  - Un'interfaccia può estendere altre interfacce tramite `extends` (anche multiple contemporaneamente: `interface C extends A, B`).

---

### Confronto Sistematico: Classe Astratta vs Interfaccia

| Proprietà | Classe Astratta (`abstract class`) | Interfaccia (`interface`) |
| :--- | :--- | :--- |
| **Istanziabilità** | ❌ No (`new` vietato) | ❌ No (`new` vietato) |
| **Stato d'istanza (campi)** | [OK]  Sì (qualsiasi visibilità) | ❌ No (solo costanti `public static final`) |
| **Costruttori** | [OK]  Sì (invocabili con `super(...)`) | ❌ No |
| **Ereditarietà** | Singola (`extends` una sola classe) | Multipla (`implements` $N$ interfacce) |
| **Relazione concettuale** | Identità ontologica forte (*IS-A*) | Capacità / Contratto comportamentale (*CAN-DO*) |

---

### Interfacce Standard Fondamentali della JDK (Slide 18–22)
1. **`java.lang.Comparable<T>`**:
   - Definisce il metodo `int compareTo(T other)`.
   - Permette agli algoritmi di ordinamento (`Arrays.sort()`, `Collections.sort()`) e agli insiemi ordinati (`TreeSet`, `TreeMap`) di ordinare gli oggetti secondo il loro "ordine naturale".
2. **`java.lang.Iterable<T>` e `java.util.Iterator<T>`**:
   - **`Iterable<T>`**: espone il metodo `Iterator<T> iterator()`.
   - **Regola cruciale**: Qualsiasi classe che implementi `Iterable` può essere utilizzata come sorgente nel **ciclo For-Each (`for (T elem : collection)`)**!
   - **`Iterator<T>`**: l'oggetto cursore che scorre la sequenza:
     - `boolean hasNext()`: verifica se vi sono ulteriori elementi.
     - `T next()`: restituisce il prossimo elemento avanzando il cursore.
     - `default void remove()`: rimuove l'ultimo elemento restituito.

---

## Codice:  Evoluzione del Codice: [`Lezione13/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate)

### Il Design Pattern Builder con Classe Statica Annidata ([`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate/src/main/java/it/oop/core/Date.java))
All'interno di `Date.java`, il docente definisce una **Static Nested Class** per costruire date in modo protetto:
```java
public class Date implements Comparable {
    ...
    public static class Builder {
        private final int year;

        public Builder(int year) {
            if (year > 0)
                this.year = year;
            else
                this.year = 1970; // Anno di default sicuro
        }

        public Date build(int day, int month) {
            // Se i parametri sono illegali, ricade sulla data sicura 1/1/year!
            if (month < 1 || month > 12 || day < 1 || day > daysPerMonth(month))
                return new Date(1, 1, year);
            return new Date(day, month, year);
        }
    }
}
```
*Vantaggio del Builder*: Incapsula e pre-configura l'anno; se l'utente fornisce parametri non validi (`month = -1`), il costruttore non fallisce a video ma restituisce una data valida di fallback (`01/01/year`).

---

### L'Interfaccia Funzionale: [`FormattedDateConverter.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate/src/main/java/it/oop/core/FormattedDateConverter.java)
```java
package it.oop.core;

public interface FormattedDateConverter {
    FormattedDate convert(FormattedDate date);
}
```
Questa interfaccia dichiara **un solo metodo astratto** (SAM: *Single Abstract Method*). In Java è a tutti gli effetti un'**Interfaccia Funzionale**, target ideale per le espressioni Lambda!

---

### Sintesi Pratica in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione13/MavenDate/src/main/java/it/oop/ui/MainDate.java)
Questo file è una miniera di concetti d'esame avanzati:
```java
package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;

public class MainDate {
    public static void main(String[] args) {
        // 1. Uso della Static Nested Class Builder:
        Date.Builder dateBuilder = new Date.Builder(2025);
        Date d1 = dateBuilder.build(10, 9);  // Giorno 10, Mese 9 -> Valida!
        Date d2 = dateBuilder.build(10, -1); // Mese -1 illegale -> Fallback su 1/1/2025!
        System.out.println(d1.toString());   // y2025m9d10
        System.out.println(d2.toString());   // y2025m1d1

        // 2. Classe Anonima (Anonymous Inner Class):
        // Implementa al volo l'interfaccia Time senza creare un file .java separato!
        Time init = new Time() {
            @Override
            public int getHours() { return 0; }
            @Override
            public int getMinutes() { return 0; }
            @Override
            public int getSeconds() { return 0; }
            @Override
            public String toString() {
                return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
            }
        };
        System.out.println(init.toString()); // Stampa 00:00:00

        // 3. Espressione Lambda (Sintassi compatta per Interfaccia Funzionale):
        FormattedDateConverter toAmerican =
                d -> new AmericanDate(d.getDay(), d.getMonth(), d.getYear());

        // Test di conversione polimorfica:
        System.out.println(toAmerican.convert(new ItalianDate(11, 11, 2025)) instanceof AmericanDate);
        // Stampa TRUE!
    }
}
```

---

## [Test]  Output di Esecuzione Verificato con Maven

Eseguendo `mvn exec:java -Dexec.mainClass="it.oop.ui.MainDate"`:
```text
y2025m9d10
y2025m1d1
00:00:00
true
```

---

> [!NOTE]
> Con la **Lezione 13** abbiamo chiuso il cerchio su Classi Astratte, Interfacce, Template Method e abbiamo anticipato le classi annidate e le lambda.
> 
> Il prossimo blocco è la **Lezione 14 / Slide T14: *Nested and Anonymous Classes***:
> - Tassonomia completa delle classi interne: **Static Nested Classes**, **Inner Member Classes** (non statiche), **Local Classes** e **Anonymous Classes**.
> - Accesso allo stato della classe contenitore (*Enclosing instance*) e la sintassi speciale `EnclosingClass.this`.
> - Cattura delle variabili locali nelle classi locali/anonime e il vincolo di essere **`effectively final`**.
> - Evoluzione del codice in `Lezione14`: consolidamento delle classi interne e preparativi per i Generics.

**Dammi conferma per aprire la Lezione 14 / T14 e continuare la revisione!**

---


# Capitolo 13: T14 --- Classi Annidate, Interne, Locali ed Anonime

*Static Nested vs Inner Classes, Enclosing Pointer, Shadowing, Effectively Final e Classi Anonime*

## Analisi Teorica Approfondita (Slide T14)

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

### Static Nested Classes (`static class Nested`)
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

### Member Inner Classes (`class Inner` non-statica)
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

### Local Classes (Classi Locali a un Metodo)
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

### Il Meme della Slide 10: *Objects inside objects*
Nella Slide 10, il prof. Pasqua inserisce il celebre meme di Xzibit (*Pimp My Ride*):
> *"YO DAWG, I HEAR YOU LIKE OBJECT ORIENTED PROGRAMMING SO I NESTED A CLASS INSIDE YOUR CLASS SO YOU CAN CREATE OBJECTS WHILE YOU CREATE OBJECTS"*

A sottolineare con ironia la tentazione (e il potere) di creare gerarchie di classi dentro classi per incapsulare comportamenti strettamente accoppiati.

---

### Motivazioni Architetturali & Il Caso di Studio *Iterator Pattern* (Slide 11-12)
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

### Anonymous Classes (Classi Anonime, Slide 13-16)
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

### Lambda Expressions (Slide 17-19)
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

### Varargs (`type... args`, Slide 20-21)
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

## Analisi Dettagliata del Codice (`Lezione14/MavenDate`)

Nella Lezione 14 il progetto [MavenDate](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate) introduce il primo ponte fondamentale verso i **Tipi Generici** (anticipando la teoria formale di Slide T15) e sfrutta le classi annidate, le classi anonime e le lambda viste nella Lezione 13.

### Diff di [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/Date.java#L1-L80) (Lezione 13 vs Lezione 14)
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

### La Nuova Classe Generica [Pair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/Pair.java)
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

### La Classe Generica con Bounded Type [OrderedPair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/OrderedPair.java)
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

### Le Sottoclassi Specializzate [DatePair.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/DatePair.java) e [DateInterval.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/core/DateInterval.java)

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

### [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione14/MavenDate/src/main/java/it/oop/ui/MainDate.java)
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

## Risultato di Compilazione ed Esecuzione Reale

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

---


# Capitolo 14: T15 --- Tipi Generici, Wildcard e Type Erasure

*Polimorfismo Parametrico, Bounded Type Parameters, Invarianza, Wildcard (PECS) e Type Erasure*

## Analisi Teorica Approfondita (Slide T15)

La lezione 15 introduce formalmente i **Tipi Generici** (*Generics*), introdotti in Java 5 per abilitare il **polimorfismo parametrico**, eliminare la fragilità dei cast a `Object` e garantire la **Type Safety** a tempo di compilazione.

---

### L'Idea Guida & La Tazza `Cup<T>` (Slide 2-3)
Nella Slide 3 campeggia l'immagine di una tazza con la scritta:
$$\mathbf{Cup\langle T\rangle}$$
accompagnata dal motto: **"Same container, different content"**.
Un contenitore (una tazza, una coppia, una lista, un albero) possiede una logica strutturale identica a prescindere dal tipo di dato che custodisce (caffè, tè, stringhe, interi, date). Prima di Java 5, per ottenere contenitori riusabili si usava `Object`, con conseguenze disastrose sull'affidabilità del software.

---

### Polimorfismo Parametrico vs Approccio Basato su `Object` (Slide 4-7)
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

### Classi e Metodi Generici (Slide 8-10)
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

### Interfacce della Libreria Standard Riscritte con i Generics (Slide 11-13)
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

### Il Diamond Operator `<>` (Slide 14)
Introdotto in Java 7, evita la ridondanza tra la dichiarazione del tipo di riferimento e l'istanziazione:
```java
// Java 5 e 6:
Pair<Integer> intPair = new Pair<Integer>(2, 4);

// Java 7+:
Pair<Integer> intPair = new Pair<>(2, 4); // Il compilatore inferisce il tipo Integer dai membri a sinistra
```

---

### Bounded Type Parameters: Vincolare i Parametri di Tipo (Slide 15-17)

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

### Ereditarietà e Generics: La Trappola dell'Invarianza (Slide 18-20)

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

### Wildcards: `<?>`, `<? extends T>`, `<? super T>` (Slide 21-23)
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

## Analisi Dettagliata del Codice (`Lezione15/MavenDate`)

Tra la Lezione 14 e la Lezione 15, il prof. Pasqua compie due modifiche sostanziali:
1. Implementa `hashCode()` in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/core/Date.java#L102-L105).
2. Riscrive ed espande [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java) per integrare la libreria delle **Java Collections** (`List`, `Set`, `Map`), il contratto `equals`/`hashCode`, e i meccanismi di ordinamento con `Comparable` e `Comparator` (usando classi anonime e lambdas).

---

### Il Contratto `equals` / `hashCode` in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/core/Date.java#L102-L105)

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

### `List` vs `Set`: Accettazione vs Rifiuto dei Duplicati in [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java#L43-L55)

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

### `Map<K, V>` e Lambdas Registrate Dinamicamente in [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java#L61-L69)

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

### Ordinamento: `Comparable` vs `Comparator` (Slide 11 & [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java#L70-L88))

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

## Risultato di Compilazione ed Esecuzione Reale

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

---


# Capitolo 15: T16 --- Java Collections Framework (JCF)

*Gerarchia Collection, List, Set, Map, Queue; Prestazioni e Scelta delle Strutture Dati*

## Analisi Teorica Approfondita (Slide T16)

La lezione 16 è dedicata al **Java Collections Framework (JCF)** (`java.util`), una delle architetture cardine del linguaggio Java: un insieme unificato e standardizzato di interfacce, implementazioni concrete e algoritmi polimorfici per la gestione di collezioni di oggetti.

---

### Architettura e Gerarchia delle Collezioni (Slide 3-4)

Tutte le collezioni di elementi singoli discendono dall'interfaccia radice `Iterable<E>`:

```
┌───────────────────┐
│    Iterable<E>    │
└─────────▲─────────┘
          │
┌─────────┴─────────┐
│   Collection<E>   │
└─────────▲─────────┘
          │
┌─────────┴───────────────┬─────────────────────────┐
│                         │                         │
┌─────────┴─────────┐     ┌─────────┴─────────┐     ┌─────────┴─────────┐
│      List<E>      │     │      Set<E>       │     │     Queue<E>      │
└─────────▲─────────┘     └─────────▲─────────┘     └─────────▲─────────┘
          │                         │                         │
   ┌──────┴──────┐           ┌──────┴──────┐           ┌──────┴──────┐
   │             │           │             │           │             │
┌──┴────┐   ┌────┴────┐ ┌────┴────┐   ┌────┴────┐ ┌────┴────┐   ┌────┴────┐
│Array- │   │ Linked- │ │ HashSet │   │ TreeSet │ │Priority-│   │  Deque  │
│ List  │   │  List   │ │         │   │(Sorted) │ │  Queue  │   │(Double) │
└───────┘   └────┬────┘ └─────────┘   └─────────┘ └─────────┘   └────┬────┘
                 │                                                   │
                 └───────────────────┬───────────────────────────────┘
                                     │ (LinkedList implementa
                                     ▼  sia List che Deque/Queue)
```

> [!NOTE]
> L'interfaccia `Map<K, V>` (dizionari chiave-valore) **NON estende `Collection<E>`**, poiché memorizza coppie $(K, V)$ anziché singoli elementi. Tuttavia, fa parte integrante a pieno titolo del *Java Collections Framework*.

---

### L'Interfaccia Radice `Collection<E>` (Slide 6-7)

Definisce il contratto comune a tutti i contenitori di elementi:
```java
public interface Collection<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);                    // Ricerca basata su equals()
    boolean containsAll(Collection<?> c);
    boolean add(E e);                              // Aggiunge un elemento (restituisce false se rifiutato)
    boolean addAll(Collection<? extends E> c);     // Wildcard covariante!
    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    void clear();
    Object[] toArray();
    <T> T[] toArray(T[] a);                        // es. set.toArray(new Person[0])
    Iterator<E> iterator();                        // Ereditato da Iterable<E>
}
```

#### Interscambiabilità tra Collezioni (Slide 7)
Tutte le implementazioni forniscono per convenzione un costruttore che accetta un'altra `Collection<? extends E>`, permettendo conversioni istantanee:
```java
Collection<Person> list = new LinkedList<>();
list.add(new Person("Joe"));
list.add(new Person("Sam"));

// Conversione da List a Set (elimina al volo eventuali duplicati):
Collection<Person> set = new HashSet<>(list);

// Esportazione in Array tipizzato:
Person[] arrayP = set.toArray(new Person[0]); // Idioma standard Java
```

---

### L'Interfaccia `List<E>` e le sue Implementazioni (Slide 8-9)

Una **Lista** è una sequenza ordinata di elementi che:
1. **Preserva l'ordine di inserimento**.
2. **Accetta elementi duplicati** (possono esistere più elementi $e_1, e_2$ tali che `e1.equals(e2)` sia vero).
3. **Fornisce accesso posizionale indicizzato** tramite indice intero $[0 \dots \text{size}-1]$:
   * `E get(int index)`: legge l'elemento all'indice specificato.
   * `E set(int index, E element)`: rimpiazza l'elemento alla posizione data.
   * `void add(int index, E element)`: inserisce shiftando a destra gli elementi successivi.
   * `E remove(int index)`: elimina shiftando a sinistra.
   * `int indexOf(Object o)`: restituisce l'indice della prima occorrenza (o $-1$).
   * `List<E> subList(int fromIndex, int toIndex)`: vista sulla porzione $[fromIndex, toIndex)$.

#### Confronto delle Implementazioni: `ArrayList` vs `LinkedList` (Slide 5 e 9)

| Operazione | `ArrayList<E>` (Array ridimensionabile) | `LinkedList<E>` (Lista doppiamente concatenata) |
| :--- | :--- | :--- |
| **Accesso per indice (`get(i)`)** | **$O(1)$** (accesso diretto in memoria contigua) | **$O(n)$** (deve scorrere i nodi dal capo più vicino) |
| **Inserimento in coda (`add(e)`)** | **$O(1)$** ammortizzato | **$O(1)$** |
| **Inserimento in testa (`add(0, e)`)** | **$O(n)$** (deve copiare e shiftare l'array) | **$O(1)$** (cambio puntatori dei nodi) |
| **Cancellazione (`remove(i)`)** | **$O(n)$** (shift dei successivi) | **$O(1)$** se si ha il riferimento al nodo, $O(n)$ per cercarlo |
| **Overhead di memoria** | Minimo (array contiguo con eventuale *capacity* vuota) | Alto (ogni nodo crea un oggetto con puntatori `prev` e `next`) |
| **Funzionalità extra** | `ensureCapacity(int minCapacity)` | Implementa anche `Queue` e `Deque`: `addFirst()`, `addLast()`, `pop()`, `push()` |

---

### L'Interfaccia `Set<E>` e le sue Implementazioni (Slide 10-16)

Un **Insieme (Set)** modella il concetto matematico di insieme:
1. **Nessun duplicato consentito**: non possono mai coesistere due elementi tali che `e1.equals(e2)` sia vero.
2. **Nessun accesso posizionale**: non esistono indici, non si può fare `get(i)`.
3. L'interfaccia `Set<E>` non aggiunge nuovi metodi rispetto a `Collection<E>`, ma ne restringe il contratto semantico.

#### `HashSet<E>` (Slide 11-14)
* **Struttura interna**: Mantiene internamente una tabella hash (`HashMap<E, Object>`).
* **Complessità**: Ricerca (`contains`), inserimento (`add`) e rimozione (`remove`) avvengono in **tempo costante medio $O(1)$**.
* **Ordine**: **Nessun ordine garantito**; l'ordine di scansione dell'iteratore può cambiare nel tempo se la tabella viene riallocata (*rehash*).
* **Vincolo Fondamentale (Slide 12-14)**: L'univocità si basa su **`equals()` e `hashCode()`**.
  * **La Regola Aurea**: *"Se fai l'override di `equals()`, DEVI fare l'override anche di `hashCode()`, e viceversa"*.
  * Proprietà vincolante: `a.equals(b)` $\implies$ `a.hashCode() == b.hashCode()`.
  * Proprietà desiderabile (riduzione collisioni): `!a.equals(b)` $\implies$ preferibilmente `a.hashCode() != b.hashCode()`.
  * Da Java 7 si usa l'utility di sistema: `Objects.hash(campo1, campo2, ...)`.

#### `TreeSet<E>` (Slide 15-16)
* **Struttura interna**: Albero binario di ricerca auto-bilanciante (**Red-Black Tree**).
* **Complessità**: `add`, `remove`, `contains` richiedono tempo logaritmico **$O(\log n)$**.
* **Ordinamento garantito**: Gli elementi sono **costantemente mantenuti ordinati**:
  * Ordinamento naturale: richiede che gli elementi implementino `Comparable<E>`.
  * Ordinamento esplicito: passando un `Comparator<E>` al costruttore: `new TreeSet<>(comparator)`.
* **Metodi speciali per insiemi ordinati**:
  * `E first()`: elemento minimo.
  * `E last()`: elemento massimo.
  * `TreeSet<E> subSet(E fromElement, E toElement)`: sottoinsieme nell'intervallo $[fromElement, toElement)$.

---

### Mappe Associative: `Map<K, V>` (Slide 17-19)

Una mappa modella una funzione matematica $K \to V$ (tabella di associazioni chiave-valore):
* Le **chiavi ($K$) sono univoche** (formano un `Set<K>`).
* A ogni chiave è associato esattamente un valore ($V$). I valori possono ripetersi.
* Metodi cardine:
  * `V put(K key, V value)`: inserisce o rimpiazza l'associazione.
  * `V get(Object key)`: restituisce il valore (o `null` se la chiave non esiste).
  * `boolean containsKey(Object key)` / `boolean containsValue(Object value)`
  * `Set<K> keySet()`: restituisce la vista dell'insieme delle chiavi.
  * `Collection<V> values()`: restituisce la collezione dei valori.
  * `Set<Map.Entry<K, V>> entrySet()`: restituisce le coppie chiave-valore.
* **`HashMap<K, V>`**: implementazione standard basata su hashing delle chiavi, con operazioni `put` e `get` in **$O(1)$**.

---

### Iteratori e l'Errore `ConcurrentModificationException` (Slide 21-23)

Tutte le collezioni forniscono un `Iterator<E>` (`hasNext()`, `next()`, `remove()`).
Il ciclo `for-each` di Java è uno zucchero sintattico compilato tramite `Iterator`:
```java
for (Integer i : list) {
    System.out.println(i);
}
```

#### La Trappola della Modifica Concorrente (*Fail-Fast Iterator*, Slide 23)
```java
// CODICE ERRATO:
int count = 0;
for (Integer i : list) {
    System.out.println(i);
    if (count == 2)
        list.remove(count); // RUNTIME ERROR: java.util.ConcurrentModificationException!
    count++;
}
```
* **Perché crasha?**: Le collezioni Java mantengono internamente un contatore delle modifiche strutturali (`modCount`). Quando si invoca `list.remove()`, `modCount` viene incrementato. Al ciclo successivo, la chiamata implicita a `it.next()` scopre che la collezione è cambiata alle sue spalle (*fail-fast*) e lancia immediatamente `ConcurrentModificationException` per prevenire stati incoerenti.
* **La Soluzione Corretta (Slide 23)**: Usare esplicitamente l'iteratore e invocare il **suo** metodo `remove()`, che aggiorna coerentemente lo stato interno dell'iteratore:
  ```java
  for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
      Integer i = it.next();
      if (count == 2)
          it.remove(); // PERFETTAMENTE LEGALE E SICURO!
      count++;
  }
  ```

---

### Algoritmi di Ordinamento: `Comparable` vs `Comparator` (Slide 24-29)

La classe di utilità `Collections` (`java.util.Collections`) fornisce due varianti sovraccaricate del metodo statico `sort`:

#### Variante 1: Ordinamento Naturale
```java
public static <T extends Comparable<? super T>> void sort(List<T> list)
```
* **Perché `<? super T>` nella firma? (Slide 26 - Domanda Classica d'Esame)**:
  Supponiamo di avere `class Student extends Person`.
  Se solo `Person` implementa `Comparable<Person>`, allora `Student` eredita il confronto basato su `Person`.
  Se la firma fosse `<T extends Comparable<T>>`, allora `Student` dovrebbe implementare tassativamente `Comparable<Student>`. Con `Comparable<? super T>`, una lista di `Student` può essere ordinata legalmente usando il `compareTo` della superclasse `Person` (`Comparable<Person>`), garantendo il massimo riuso polimorfico!

#### Variante 2: Ordinamento On-Demand con `Comparator`
```java
public static <T> void sort(List<T> list, Comparator<? super T> cmp)
```
* Permette di definire criteri di ordinamento arbitrari senza toccare la classe sorgente, passando:
  1. Una classe dedicata (`class StudentComparator implements Comparator<Student>`).
  2. Una **classe anonima** (`new Comparator<Student>() { ... }`).
  3. Un'**espressione Lambda** (`(s1, s2) -> s2.getMatricola() - s1.getMatricola()`).

---

## Riscontro Pratico nel Codice (`Lezione15`/`Lezione16`)

Come osservato durante l'ispezione dei sorgenti:
1. Nella Lezione 15 il docente ha introdotto tutte le strutture viste nella Slide T16 all'interno di [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione15/MavenDate/src/main/java/it/oop/ui/MainDate.java):
   * `List<Date> dateList = new ArrayList<>();` (con duplicato `AmericanDate(7,11,2025)` $\implies$ dimensione 4).
   * `Set<Date> dateSet = new HashSet<>();` (duplicato scartato $\implies$ dimensione 3).
   * `Map<String, FormattedDateConverter> converter = new HashMap<>();`
   * Ordinamento naturale: `Collections.sort(dateList);`
   * Ordinamento con `Comparator` via classe anonima e lambda su `DateInterval`.
2. Nella Lezione 16 il docente compie il passo architetturale successivo: separa la gestione degli errori creando il package `it.oop.exception` con eccezioni personalizzate (`IllegalDateException` e `OrderdPairException`), preparando il terreno per la teoria della Slide T17.

---

Dimmi **"vai"** per procedere con il **Blocco 16** (Lezione 17 / Slide T17 — *Error Handling with Exceptions*, gerarchia `Throwable`/`Exception`/`RuntimeException`, eccezioni controllate vs non controllate, costrutto `try-catch-finally`, `try-with-resources` e il codice di `Lezione16/MavenDate`).

---


# Capitolo 16: T17 --- Gestione degli Errori ed Architettura delle Eccezioni

*Gerarchia Throwable, Checked vs Unchecked, try-catch-finally, Try-with-resources e AutoCloseable*

## Analisi Teorica Approfondita (Slide T17)

La lezione 17 affronta la gestione degli errori e delle anomalie a runtime attraverso il meccanismo delle **Eccezioni** in Java.

---

### Limiti della Gestione Tradizionale degli Errori (Slide 3-6)
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

### La Filosofia delle Eccezioni in Java: `try-catch-throw` (Slide 7-10)
Java disaccoppia la **logica di business** (*cosa deve fare il programma quando tutto va bene*) dalla **logica di gestione degli errori** (*cosa fare quando accade un'anomalia*):
* **`try`**: racchiude il blocco di codice a rischio di eccezione.
* **`throw`**: solleva attivamente un'istanza di eccezione nel punto in cui l'anomalia viene riscontrata.
* **`catch`**: cattura l'eccezione ed esegue il codice di ripristino/notifica.
* **Interruzione immediata**: quando viene eseguito `throw`, il metodo **interrompe immediatamente la propria esecuzione**, svuota lo stack frame corrente e risale lungo la catena di chiamate (*call stack*) fino al primo blocco `catch` compatibile.

---

### La Gerarchia delle Eccezioni in Java (Slide 20-21)

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

### Checked vs Unchecked Exceptions (Slide 22-24)

| Caratteristica | Checked Exceptions (`extends Exception`) | Unchecked Exceptions (`extends RuntimeException`) |
| :--- | :--- | :--- |
| **Natura dell'errore** | Situazioni anomale **prevedibili** ma esterne (es. `FileNotFoundException`, rete disconnessa). | **Errori del programmatore** (bug logici, precondizioni violate, puntatori nulli). |
| **Controllo del compilatore** | **Obbligatorio** (*Catch or Declare rule*). Il codice non compila se non gestite con `try-catch` o dichiarate con `throws`. | **Opzionale**. Il compilatore non richiede alcuna dichiarazione o cattura. |
| **Firma del metodo** | Modificata: `public void foo() throws MyCheckedException` | Invariata: nessun `throws` richiesto. |
| **Diffusione (*Propagazione*)** | *"Si propagano come un virus"* (Slide 24): costringono tutti i chiamanti intermedi a dichiarare `throws` o gestire. | Risalgono naturalmente lo stack fino al `main` o al gestore globale. |
| **Raccomandazione moderna (Slide 24)** | Definirle solo se l'utente del metodo **può ragionevolmente intraprendere un'azione di recupero**. | **Preferite** per errori di validazione dello stato o degli argomenti. |

---

### "Exception Dirty Tricks": Trasformare Checked in Unchecked (Slide 25-26)
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

### Eccezioni nei Cicli (*Exceptions and Loops*, Slide 27-28)
* **Errore sulla singola iterazione (Slide 27)**: il blocco `try-catch` è **all'interno** del ciclo. Se l'iterazione fallisce, viene intercettata e il ciclo prosegue con la successiva (es. lettura da input utente fino a valore corretto).
* **Errore fatale per l'intero ciclo (Slide 28)**: il blocco `try-catch` **avvolge** il ciclo. Se si verifica un'anomalia, il ciclo viene interrotto definitivamente e l'esecuzione salta direttamente al `catch` esterno.

---

## Analisi Dettagliata del Codice (`Lezione16/MavenDate`)

In `Lezione16/MavenDate` il prof. Pasqua applica i principi della Slide T17 rimuovendo i vecchi `System.out.println("Illegal date!")` e introducendo la gestione strutturata degli errori tramite il package `it.oop.exception`.

### Le Nuove Eccezioni: [IllegalDateException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/IllegalDateException.java) e [OrderdPairException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/OrderdPairException.java)

#### [IllegalDateException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/IllegalDateException.java) (Unchecked)
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

#### [OrderdPairException.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/exception/OrderdPairException.java) (Checked)
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

### Refactoring del Metodo `verify()` in [Date.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/core/Date.java#L28-L35)
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

### [MainDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione16/MavenDate/src/main/java/it/oop/ui/MainDate.java) e l'Applicazione di Tutti i Pattern della Slide T17

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

## Risultato di Esecuzione Reale da Terminale

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

---


# Capitolo 17: T18 --- Interfacce Funzionali, Espressioni Lambda e Streams API

*Predicate, Function, Consumer, Supplier, Method Reference (::) e Pipeline Stream*

## Analisi Teorica Approfondita (Slide T18)

La lezione 18 introduce il paradigma di **programmazione funzionale e dichiarativa** in Java (introdotto in Java 8), imperniato su due pilastri:
1. **Interfacce Funzionali** e **Method Reference** (`::`).
2. **Stream API** (`java.util.stream`), per l'elaborazione fluente e parallela di flussi di dati.

---

### Cos'è una Functional Interface? (Slide 3)
Un'interfaccia si dice **funzionale** se dichiara **esattamente un unico metodo astratto** (pattern noto come **SAM** — *Single Abstract Method*).
* **Semantica**: Puramente funzionale; l'esito della chiamata dipende esclusivamente dagli argomenti ricevuti (nessun effetto collaterale occulto).
* **L'annotazione `@FunctionalInterface`**:
  * Non è obbligatoria per far funzionare una lambda, ma è una best practice fondamentale: istruisce il compilatore Java a verificare che l'interfaccia contenga un solo metodo astratto. Se qualcuno tenta di aggiungere un secondo metodo astratto, il compilatore rigetta il codice con errore.
* **Metodi esclusi dal conteggio SAM**:
  * Metodi con implementazione predefinita (`default`).
  * Metodi statici (`static`).
  * Metodi pubblici astratti che fanno override di metodi di `java.lang.Object` (es. `boolean equals(Object obj)`).

---

### Le 4 Interfacce Funzionali Fondamentali (`java.util.function`) (Slide 4-12)

Il package `java.util.function` standardizza i contratti funzionali più frequenti:

| Interfaccia | Firma Metodo SAM | Semantica Funzionale | Esempio d'Uso Tipico |
| :--- | :--- | :--- | :--- |
| `Predicate<T>` | `boolean test(T t)` | Filtro / Condizione booleana | `n -> n % 2 == 0` |
| `Function<T, R>` | `R apply(T t)` | Trasformazione $T \to R$ | `str -> str.length()` |
| `Consumer<T>` | `void accept(T t)` | Azione con effetto collaterale | `str -> System.out.println(str)` |
| `Supplier<T>` | `T get()` | Generatore / Factory | `() -> Math.random()` |

#### Varianti e Specializzazioni (Slide 6-12)
1. **Versioni Primitive**: Per evitare l'overhead di boxing/unboxing, Java fornisce interfacce specializzate per `int`, `long`, `double`:
   * `IntPredicate` (`boolean test(int v)`), `LongPredicate`, `DoublePredicate`.
   * `IntFunction<R>`, `ToIntFunction<T>`, `IntConsumer`, `IntSupplier`.
2. **Varianti a Due Argomenti**:
   * `BiPredicate<T, U>`: `boolean test(T t, U u)` (es. `(a, b) -> a > b`).
   * `BiFunction<T, U, R>`: `R apply(T t, U u)` (es. `(a, b) -> a + b`).
   * `BiConsumer<T, U>`: `void accept(T t, U u)`.
3. **Operatori (Input e Output dello stesso tipo)**:
   * `UnaryOperator<T> extends Function<T, T>`: riceve un $T$ e restituisce un $T$.
   * `BinaryOperator<T> extends BiFunction<T, T, T>`: riceve due $T$ e restituisce un $T$.

---

### I Quattro Tipi di Method Reference (`::`) (Slide 13-15)

Il *Method Reference* è uno zucchero sintattico introdotto in Java 8 per rendere le espressioni lambda ancora più concise quando queste si limitano a inoltrare direttamente i propri parametri a un metodo esistente:

| Categoria | Sintassi Method Reference | Equivalente Lambda Esplicita |
| :--- | :--- | :--- |
| **1. Metodo Statico** | `Math::random`<br>`Integer::parseInt` | `() -> Math.random()`<br>`str -> Integer.parseInt(str)` |
| **2. Metodo d'Istanza su Oggetto Esistente** (*Bound*) | `System.out::println`<br>`hexDigits::charAt` | `x -> System.out.println(x)`<br>`i -> hexDigits.charAt(i)` |
| **3. Metodo d'Istanza su Tipo Arbitrario** (*Unbound*) | `String::toUpperCase`<br>`String::length` | `str -> str.toUpperCase()`<br>`str -> str.length()` |
| **4. Costruttore** | `Person::new`<br>`Integer[]::new` | `str -> new Person(str)`<br>`size -> new Integer[size]` |

---

### La Stream API (`java.util.stream`) (Slide 16-18)

Uno `Stream<T>` è una **sequenza di elementi generata da una sorgente** che supporta operazioni aggregate di calcolo.

#### Le Tre Proprietà Chiave di uno Stream:
1. **Pipelining**: Le operazioni intermedie restituiscono un nuovo stream, permettendo la concatenazione fluente (*method chaining*).
2. **Internal Iteration**: A differenza delle collezioni dove lo sviluppatore controlla l'iterazione tramite `for`/`while` (*iterazione esterna*), lo stream gestisce il ciclo internamente. Ciò consente alla JVM di ottimizzare l'esecuzione e abilitare il parallelismo trasparente (`parallelStream()`).
3. **Lazy Evaluation (Valutazione Pigra)**: Le operazioni intermedie non vengono eseguite quando vengono dichiarate; restano "in attesa". L'intera pipeline viene elaborata in un unico passaggio solo quando viene invocata un'operazione terminale!

---

### Ciclo di Vita di una Pipeline Stream (Slide 18-24)

Una pipeline si compone tassativamente di 3 fasi:

$$\text{Sorgente (Source)} \longrightarrow \text{Zero o più Operazioni Intermedie} \longrightarrow \text{Una Operazione Terminale}$$

```
┌───────────────┐     ┌─────────────┐     ┌───────────┐     ┌───────────────┐
│ Stream.of(...) ├──► │ .filter(...) ├──► │ .map(...) ├──►  │ .forEach(...) │
└───────────────┘     └─────────────┘     └───────────┘     └───────────────┘
   [Sorgente]          [Intermedia]        [Intermedia]        [Terminale]
```

#### Creazione della Sorgente (Slide 19, 21-22)
* Da array: `Arrays.stream(arr)` o `Stream.of(v1, v2, v3)`.
* Da collezione: `list.stream()` o `set.stream()`.
* **Generazione infinita**:
  * `Stream.iterate(seed, UnaryOperator)`: applica iterativamente l'operatore a partire dal seme. Es: `Stream.iterate(0, i -> i + 1)` genera $0, 1, 2, 3, \dots$
  * `Stream.generate(Supplier)`: invoca continuamente il fornitore. Es: `Stream.generate(Math::random)`.
  * Per evitare loop infiniti, si arresta la generazione con l'operazione intermedia `.limit(n)`.

#### Operazioni Intermedie (Slide 23, 25-29, 34-36)
Restituiscono un nuovo `Stream<R>` e sono pigre (*lazy*):
* `filter(Predicate<T>)`: trattiene solo gli elementi per cui il predicato è `true`.
* `map(Function<T, R>)`: trasforma ciascun elemento $T \to R$ (mappatura $1 \to 1$).
* `flatMap(Function<T, Stream<R>>)`: appiattisce strutture annidate (es. matrici `Integer[][]` o liste di liste) in un unico stream monodimensionale.
* `distinct()`: elimina i duplicati (in base a `equals` e `hashCode`).
* `sorted()` / `sorted(Comparator)`: ordina gli elementi.
* `limit(n)`: tronca lo stream ai primi $n$ elementi.
* `skip(n)`: scarta i primi $n$ elementi.

#### Operazioni Terminali (Slide 20, 23, 30-33)
Consumano lo stream e producono un risultato o un effetto collaterale:
* **Chiusura su Collezioni / Array (Slide 20)**:
  * `stream.toList()`: raccoglie gli elementi in una `List` immutabile (Java 16+).
  * `stream.collect(Collectors.toSet())`: raccoglie in un `Set`.
  * `stream.toArray(Integer[]::new)`: esporta in array tipizzato.
* **Iterazione / Consumo**: `stream.forEach(Consumer<T>)`.
* **Conteggio / Riduzione**: `stream.count()`, `stream.reduce(...)`.
* **Matching**: `anyMatch(Predicate)`, `allMatch(Predicate)`, `noneMatch(Predicate)`.
* **Ricerca & `Optional<T>` (Slide 31-32)**:
  * `findFirst()`, `findAny()`: restituiscono un `Optional<T>`, contenitore sicuro introdotto per debellare le `NullPointerException`.
  * Metodi di `Optional`: `isPresent()`, `get()`, `orElse(valoreDefault)`.

> [!WARNING]
> **Regola Aurea degli Stream (Slide 24 — Domanda d'Esame):**
> **Uno Stream può essere consumato UNA SOLA VOLTA!**
> Se si tenta di invocare una seconda operazione terminale sullo stesso oggetto `Stream`, la JVM solleva a runtime:
> `java.lang.IllegalStateException: stream has already been operated upon or closed`.

---

## Analisi Dettagliata del Codice (`Lezione17/MavenDate`)

In `Lezione17/MavenDate`, il prof. Pasqua mantiene l'intera architettura pregressa e aggiunge il file [MainStream.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione17/MavenDate/src/main/java/it/oop/ui/MainStream.java), che esemplifica in modo magistrale tutte le funzionalità degli Stream appena studiate.

### Analisi Riga per Riga di [MainStream.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione17/MavenDate/src/main/java/it/oop/ui/MainStream.java)

```java
package it.oop.ui;

import it.oop.core.AmericanDate;
import it.oop.core.FormattedDate;
import it.oop.core.ItalianDate;

import java.util.List;
import java.util.stream.Stream;
import it.oop.core.Date;
import static java.util.stream.Stream.generate;

public class MainStream {
    public static void main(String[] args) {
        // ESEMPIO 1: Generazione con iterate, filtro e limit
        // Sequenza generata: "a", "aa", "aaa", "aaaa", ...
        Stream<String> stream = Stream.iterate("a", s -> s + "a")
                .filter(s -> s.length() % 2 == 1) // Tiene solo stringhe di lunghezza DISPARI
                .limit(10);                       // Si arresta dopo le prime 10 stringhe dispari
        List<String> list = stream.toList();      // Operazione terminale: unwrap a List
        System.out.println(list.toString());

        // ESEMPIO 2: Generazione con generate, Supplier e test di primalità
        List<Integer> list2 = Stream.generate(() -> (int) (Math.random() * 20)) // Generatore infinito [0..19]
                .filter(i -> isPrime(i))                                        // Filtra numeri primi
                .limit(10)                                                      // Ne estrae esattamente 10
                .toList();                                                      // Operazione terminale
        System.out.println(list2.toString());

        // ESEMPIO 3: Pipeline su oggetti di dominio del progetto (Date)
        Stream.of(new ItalianDate(15,1,2025), new Date(16,1,2025), new ItalianDate(2,2,2025))
                .filter(d -> d instanceof ItalianDate) // Filtra escludendo le Date generiche
                .map(d -> new AmericanDate(d.getDay(), d.getMonth(), d.getYear())) // Converte in AmericanDate
                .forEach(System.out::println); // Method reference per stampa su stdout
    }

    // Algoritmo di primalità implementato interamente con Stream!
    private static boolean isPrime(int n) {
        return n == 0 ? false : Stream.iterate(1, i -> i + 1)
                .limit(n)              // Genera i numeri da 1 a n
                .map(i -> n % i)       // Calcola il resto della divisione (0 indica divisore esatto)
                .filter(i -> i == 0)   // Mantiene solo i resti nulli (i divisori)
                .count() <= 2;         // Se i divisori sono <= 2 (cioè 1 e se stesso), è primo!
    }
}
```

---

## Risultato di Compilazione ed Esecuzione Reale

Comando eseguito nel progetto [Lezione17/MavenDate](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione17/MavenDate):
```bash
mvn compile exec:java -Dexec.mainClass="it.oop.ui.MainStream"
```

Output ottenuto:
```text
[a, aaa, aaaaa, aaaaaaa, aaaaaaaaa, aaaaaaaaaaa, aaaaaaaaaaaaa, aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaa]
[7, 11, 13, 19, 3, 13, 17, 5, 19, 1]
1/15/2025
2/2/2025
```

### Decodifica dell'Output:
1. `[a, aaa, aaaaa, ..., aaaaaaaaaaaaaaaaaaa]` $\rightarrow$ Lista delle prime 10 stringhe a lunghezza dispari (1, 3, 5, 7, 9, 11, 13, 15, 17, 19 caratteri).
2. `[7, 11, 13, 19, 3, 13, 17, 5, 19, 1]` $\rightarrow$ Dieci numeri primi casuali estratti nell'intervallo $[0, 20)$ e validati dalla pipeline stream di `isPrime(int n)`.
3. `1/15/2025` e `2/2/2025` $\rightarrow$ Le due istanze di `ItalianDate` (15/1/2025 e 2/2/2025) superano il `filter(instanceof ItalianDate)`, vengono convertite tramite `map` in `AmericanDate` (formato `M/D/Y`) e stampate a video tramite `System.out::println`. L'istanza generica `new Date(16,1,2025)` viene invece scartata dal filtro.

---

Dimmi **"vai"** per procedere con il **Blocco 18** (Lezione 18 / Slide T19 — *Documentation and Unit Testing*, Javadoc, JUnit 3 vs JUnit 4 vs JUnit 5, asserzioni, ciclo di vita dei test `@BeforeEach`/`@AfterEach`, e l'analisi di `TestDate.java` e `TestItalianDate.java` in `Lezione18/MavenDate`).

---


# Capitolo 18: T19 --- Documentazione con Javadoc e Unit Testing con JUnit 5

*Convenzioni Javadoc, Architettura JUnit 5, Annotazioni di Ciclo di Vita ed Asserzioni*

## Analisi Teorica Approfondita (Slide T19)

La lezione 19 approfondisce due pratiche ingegneristiche irrinunciabili nello sviluppo professionale in Java:
1. **Documentazione automatizzata del codice** tramite lo standard **Javadoc**.
2. **Collaudo e Unit Testing automatizzato** tramite il framework **JUnit 5 (Jupiter)** e il plugin Maven **Surefire**.

---

### Documentazione con Javadoc (Slide 3-11)
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

### Unit Testing con JUnit (Slide 13-16)
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

### Asserzioni in JUnit 5 (`org.junit.jupiter.api.Assertions`, Slide 17-21)

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

### Il Ciclo di Vita del Test e le Annotazioni JUnit 5 (Slide 22)

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

### Organizzazione del Progetto e Convenzioni Maven (Slide 23-24)

Maven e i moderni build tool impongono una struttura standard di cartelle:
* **`src/main/java`**: Contiene il codice sorgente dell'applicazione (es. `it.oop.core.Date`).
* **`src/test/java`**: Contiene esclusivamente le classi di collaudo.
* **Allineamento dei Package (Regola Fondamentale)**:
  Una classe di test che verifica `it.oop.core.Date` **deve risiedere nello stesso identico package `it.oop.core`** (all'interno di `src/test/java`). In questo modo la classe di test ha accesso non solo ai membri `public`, ma anche a tutti i metodi e campi con visibilità di **package (`package-private`)**, facilitando il testing interno senza forzare l'apertura a `public` di dettagli architetturali riservati!

---

## Analisi Dettagliata del Codice (`Lezione18/MavenDate`)

In `Lezione18/MavenDate` troviamo la configurazione completa del plugin Maven Surefire e due classi di test che collaudano la gerarchia di `Date`.

### Configurazione in [pom.xml](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate/pom.xml#L44-L68)
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

### [TestDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate/src/test/java/it/oop/core/TestDate.java)
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

### [TestItalianDate.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione18/MavenDate/src/test/java/it/oop/core/TestItalianDate.java)
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

## Risultato di Esecuzione Reale da Terminale

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

---


# Capitolo 19: T20 --- Java I/O, Streams, File, NIO.2 e Serializzazione

*Byte Streams vs Character Streams, Bufferizzazione, Decorator Pattern I/O e Serializzazione*

## Analisi Teorica Approfondita (Slide T20)

La lezione 20 conclude il percorso teorico del corso esplorando il sottosistema di **Input/Output (I/O)** di Java (`java.io` e `java.net`), la persistenza su disco, la comunicazione di rete, e la gestione di formati dati strutturati moderni (**CSV** e **JSON**) tramite librerie terze gestite con Maven.

---

### L'Astrazione di I/O Stream (Slide 3-4)
In Java, qualsiasi trasferimento di dati da o verso l'esterno è modellato tramite l'astrazione di **I/O Stream** (*flusso sequenziale unidirezionale di dati*):
* **Differenza tassonomica cruciale**: Gli **I/O Streams** (`java.io`) non vanno confusi con gli **Stream funzionali** di Java 8 (`java.util.stream.Stream`). Gli I/O Stream trasportano byte o caratteri fisici verso periferiche o file; gli Stream di Java 8 elaborano pipeline di trasformazione di oggetti in memoria.
* Un I/O Stream può essere agganciato a:
  * File su disco.
  * Flussi standard di processo: `System.in` (standard input), `System.out` (standard output), `System.err` (standard error).
  * Connessioni di rete (*socket* TCP/IP o endpoint HTTP).
  * Buffer di memoria (array di byte o stringhe).

---

### Il Dualismo dell'I/O in Java: Byte Streams vs Character Streams (Slide 4-9)

L'architettura di `java.io` è rigorosamente bipartita in due gerarchie parallele:

```
                      ┌─────────────────────────┐
                      │ java.io Stream Classes  │
                      └────────────┬────────────┘
                                   │
             ┌─────────────────────┴─────────────────────┐
             ▼                                           ▼
  ┌─────────────────────┐                     ┌─────────────────────┐
  │    Byte Streams     │                     │  Character Streams  │
  │  (8-bit dati grezzi)│                     │ (16-bit Unicode UTF)│
  └──────────┬──────────┘                     └──────────┬──────────┘
             │                                           │
  ┌──────────┴──────────┐                     ┌──────────┴──────────┐
  ▼                     ▼                     ▼                     ▼
┌─────────────┐ ┌──────────────┐       ┌─────────────┐ ┌─────────────┐
│ InputStream │ │ OutputStream │       │   Reader    │ │   Writer    │
└──────┬──────┘ └──────┬───────┘       └──────┬──────┘ └──────┬──────┘
       │               │                      │               │
┌──────┴──────┐ ┌──────┴───────┐       ┌──────┴──────┐ ┌──────┴──────┐
│FileInput-   │ │FileOutput-   │       │ FileReader  │ │ FileWriter  │
│Stream       │ │Stream        │       └──────┬──────┘ └──────┬──────┘
└──────┬──────┘ └──────┬───────┘              │               │
       │               │               ┌──────┴──────┐ ┌──────┴──────┐
┌──────┴──────┐ ┌──────┴───────┐       │Buffered-    │ │Buffered-    │
│Buffered-    │ │Buffered-     │       │Reader       │ │Writer       │
│InputStream  │ │OutputStream  │       └─────────────┘ └─────────────┘
└─────────────┘ └──────────────┘
```

#### Byte Streams (`InputStream` e `OutputStream`, Slide 5-7)
* **Unità di dato**: Singolo byte grezzo (8 bit, intervallo $[0, 255]$ restituito come `int`, dove il valore $-1$ segnala la fine dello stream — *End Of File, EOF*).
* **Destinazione d'uso**: Immagini, file multimediali, bytecode compilato (`.class`), file compressi (`.zip`), comunicazioni binarie di rete.
* **Metodi cardine**:
  * `int read()`: legge il prossimo byte (o $-1$ a fine stream).
  * `int read(byte[] b)`: riempie il buffer di byte.
  * `void write(int b)`: scrive un byte.
  * `void write(byte[] b)`: scrive un intero array di byte.
  * `void close()`: rilascia il descrittore del file del sistema operativo.
* **Implementazioni notevoli**:
  * `FileInputStream` / `FileOutputStream`: lettura/scrittura diretta su disco.
  * `BufferedInputStream` / `BufferedOutputStream`: aggiunge un buffer in memoria per minimizzare le costose chiamate di sistema del kernel del SO.
  * `DataInputStream` / `DataOutputStream`: serializzazione di primitivi Java (`readInt()`, `writeDouble()`).

#### Character Streams (`Reader` e `Writer`, Slide 8-10)
* **Unità di dato**: Caratteri Unicode (16 bit UTF-16).
* **Destinazione d'uso**: Esclusivamente file di testo, file sorgente, documenti testuali.
* **Le classi ponte (*Bridge Adapters*)**:
  * `InputStreamReader`: converte un `InputStream` di byte in un `Reader` di caratteri applicando una specifica codifica (es. UTF-8).
  * `OutputStreamWriter`: converte caratteri in byte da inviare a un `OutputStream`.
* **Implementazioni notevoli**:
  * `FileReader` / `FileWriter`: lettura/scrittura di file di testo.
  * `BufferedReader`: legge blocchi di testo bufferizzati e fornisce il comodissimo metodo `String readLine()` (restituisce un'intera riga o `null` a fine file).
  * `BufferedWriter`: scrittura testuale con supporto al metodo `newLine()`.

---

### Gestione delle Risorse: Da `try-finally` a `try-with-resources` (Slide 7, 10-11)

#### Il Vecchio Approccio (Pre-Java 7, Slide 10):
```java
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("i.txt"));
    // lettura...
} catch (IOException e) {
    // gestione errore...
} finally {
    if (br != null) {
        try {
            br.close(); // Ulteriore try-catch obbligatorio perché close() lancia IOException!
        } catch (IOException e) { ... }
    }
}
```
Questo pattern era verbose, faticoso da manutenere e fonte continua di *resource leaks* (descrittori di file aperti non chiusi se si verificavano eccezioni nel `finally`).

#### L'Approccio Moderno: `try-with-resources` (Java 7+, Slide 11)
Tutte le classi che implementano l'interfaccia standard `java.lang.AutoCloseable` possono essere dichiarate all'interno delle parentesi tonde del blocco `try`:
```java
try (BufferedReader br = new BufferedReader(new FileReader("i.txt"));
     BufferedWriter bw = new BufferedWriter(new FileWriter("o.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
    }
} catch (FileNotFoundException fnfe) {
    System.out.println("File not found...");
} catch (IOException ioe) {
    System.out.println("I/O Error...");
}
```
* **Garanzie della JVM**:
  1. Le risorse vengono chiuse **automaticamente** non appena il blocco `try` termina, sia in caso di completamento regolare sia in caso di eccezione o `return` anticipato.
  2. Vengono chiuse in **ordine inverso** rispetto alla loro dichiarazione (prima `bw`, poi `br`).
  3. Se sia il corpo del `try` che la chiamata a `close()` sollevano eccezioni, l'eccezione del corpo è quella principale propagata, mentre l'eccezione di chiusura viene salvata come **Suppressed Exception** (recuperabile con `e.getSuppressed()`).

---

### Gestione di File e Risorse di Rete (URL/URI) (Slide 13-17)
* **La classe `java.io.File` (Slide 13-14)**: Rappresenta il percorso astratto di un file o di una directory. Non legge né scrive dati direttamente, ma permette di interrogare e modificare il filesystem:
  * `exists()`, `isFile()`, `isDirectory()`, `length()`, `getAbsolutePath()`.
  * `mkdir()`, `delete()`, `renameTo(File dest)`, `listFiles()`.
* **URL e URI (`java.net`, Slide 15-17)**:
  * `URI` modella l'identificatore formale (*RFC 2396*).
  * `URL` modella la locazione fisica e il protocollo per accedere alla risorsa web.
  * *Avvertenza contemporanea (Slide 16)*: Il costruttore `new URL("...")` è **deprecato** da Java 20. La prassi moderna impone di creare un'istanza di `URI` e convertirla:
    ```java
    URL url = new URI("https://info.cern.ch/index.html").toURL();
    InputStream in = url.openStream(); // Apre una connessione HTTP e scarica i dati
    ```

---

### Dati Strutturati: CSV e JSON (Slide 18-26)

Java non possiede parser nativi integrati nel runtime per file CSV e JSON. Per questi formati si ricorre a librerie esterne integrate tramite dipendenze Maven.

#### File CSV con OpenCSV (Slide 19-22)
* Un file CSV (*Comma-Separated Values*) memorizza tabelle in formato testuale, separando le colonne con virgole o punti e virgola.
* **Dipendenza Maven**: `com.opencsv:opencsv:5.12.0`.
* **Scrittura**: `CSVWriter` scrive array di stringhe `String[]` gestendo automaticamente apici ed escape:
  ```java
  CSVWriter csvw = new CSVWriter(new FileWriter("data.csv"));
  csvw.writeNext(new String[]{ "id", "name", "address" });
  ```
* **Lettura**: `CSVReader` con `readNext()` riga per riga o `readAll()`.

#### File JSON con Google Gson (Slide 23-26)
* JSON (*JavaScript Object Notation*) è lo standard dominante per lo scambio dati basato su mappe chiave-valore `{}` e liste ordinate `[]`.
* **Dipendenza Maven**: `com.google.code.gson:gson:2.13.2`.
* **Serializzazione e Deserializzazione Automatica (Data Binding)**:
  ```java
  Gson gson = new Gson();

  // 1. Oggetto Java -> Stringa JSON (Serializzazione)
  Date date = new Date(1, 1, 1970);
  String json = gson.toJson(date); // Restituisce '{"day":1,"month":1,"year":1970}'

  // 2. Stringa JSON -> Oggetto Java (Deserializzazione)
  Date d = gson.fromJson(json, Date.class); // Ricostruisce l'istanza valorizzando i campi!
  ```
  Gson accede ai campi (anche `private` e `final`) tramite **Reflection**, senza richiedere getter/setter pubblici o costruttori senza argomenti!
* **Pretty Printing**: `new GsonBuilder().setPrettyPrinting().create()` formatta il JSON con ritorni a capo e indentazione a 2 spazi.

---

## Analisi Dettagliata del Codice (`Lezione19/MavenDate`)

In `Lezione19/MavenDate` il prof. Pasqua integra tutti i concetti della Slide T20 all'interno della classe dimostrativa [MainIO.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione19/MavenDate/src/main/java/it/oop/ui/MainIO.java).

### Configurazione delle Dipendenze in [pom.xml](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione19/MavenDate/pom.xml#L68-L78)
```xml
        <!-- OpenCSV per parsing e generazione CSV (Slide 20) -->
        <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>5.12.0</version>
        </dependency>
        <!-- Google Gson per serializzazione/deserializzazione JSON (Slide 24) -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.13.2</version>
        </dependency>
```

---

### Analisi Riga per Riga di [MainIO.java](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione19/MavenDate/src/main/java/it/oop/ui/MainIO.java)

#### Lettura Binaria di Bytecode con `FileInputStream` e `FileChannel` (Righe 18-41)
```java
        FileInputStream fis = null;
        try {
            // Apertura dello stream di byte su un file binario compilato (.class)
            fis = new FileInputStream("src/main/resources/Date.class");
            FileChannel fc = fis.getChannel();
            int b;
            // Lettura byte a byte
            while ((b = fis.read()) != -1) {
                System.out.println((char) b);
            }
            // Rewind dello stream riportando la posizione a 0 tramite FileChannel
            fc.position(0);
            StringBuilder sb = new StringBuilder();
            // Lettura dell'intero contenuto in un colpo solo con readAllBytes() (Java 9+)
            for (byte bb : fis.readAllBytes()) {
                sb.append((char) bb);
            }
            System.out.println("-----");
            System.out.println(sb.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            // Chiusura classica pre-Java 7 con try-catch protetto
            try {
                if (fis != null) fis.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
```

#### Scrittura di Testo con `FileWriter` e `try-with-resources` (Righe 42-50)
```java
        // Blocco try-with-resources: fw viene chiuso automaticamente
        try (FileWriter fw = new FileWriter("src/main/resources/file.txt")) {
            StringBuilder sb = new StringBuilder();
            // Genera stringhe di 'a' crescenti usando Stream di Java 8
            Stream.iterate("a", s -> s + "a")
                    .limit(15)
                    .forEach(s -> sb.append(s).append("\n"));
            fw.write(sb.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
```

#### Generazione di Tabella CSV con OpenCSV (Righe 52-65)
```java
        try (CSVWriter csvw = new CSVWriter(new FileWriter("src/main/resources/data.csv"))) {
            String[] row = { "id", "name", "address" };
            csvw.writeNext(row); // Scrive l'intestazione delle colonne

            row[0] = "3";
            row[1] = "Paul";
            row[2] = "Strada le Grazie, 15";
            csvw.writeNext(row);

            row[0] = "6";
            row[1] = "Sam";
            row[2] = "Strada le Grazie, 18";
            csvw.writeNext(row);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
```

#### Serializzazione e Deserializzazione con Gson (Righe 66-80)
```java
        Gson gson = new Gson();
        Date date = new Date(1, 1, 1970);

        // Serializzazione dell'oggetto Date in formato JSON
        String json = gson.toJson(date);
        System.out.println(json); // Stampa: {"day":1,"month":1,"year":1970}

        // Deserializzazione da stringa JSON a nuova istanza Date
        Date date1 = gson.fromJson("{\"day\":1,\"month\":1,\"year\":1971}", Date.class);
        System.out.println(date1.toString()); // Stampa: y1971m1d1

        // Scrittura su file con Pretty Printing abilitato
        try (FileWriter fw = new FileWriter("src/main/resources/file.json")) {
            new GsonBuilder().setPrettyPrinting().create().toJson(date, fw);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
```

---

## Risultato di Compilazione ed Esecuzione Reale

Comando eseguito nel progetto [Lezione19/MavenDate](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione19/MavenDate):
```bash
mvn compile exec:java -Dexec.mainClass="it.oop.ui.MainIO"
```

Output ottenuto a video:
```text
[Dumping del bytecode del file Date.class con header CAFEBABE e constant pool]
-----
{"day":1,"month":1,"year":1970}
y1971m1d1
[INFO] BUILD SUCCESS
```

### Ispezione dei file generati su disco:
1. `src/main/resources/file.txt`:
   ```text
   a
   aa
   aaa
   ...
   aaaaaaaaaaaaaaa
   ```
2. `src/main/resources/data.csv`:
   ```csv
   "id","name","address"
   "3","Paul","Strada le Grazie, 15"
   "6","Sam","Strada le Grazie, 18"
   ```
3. `src/main/resources/file.json`:
   ```json
   {
     "day": 1,
     "month": 1,
     "year": 1970
   }
   ```

---

## Traguardo Raggiunto: Revisione Integrale del Corso Completata!

Abbiamo completato con successo e senza tralasciare alcun dettaglio:
* Tutte le **20 slide teoriche** (da `T01` a `T20`).
* Tutti i **progetti e le lezioni pratiche** (da `Lezione04` a `Lezione19`).
* Tutti i diagrammi, meme, pattern architetturali, finezze di linguaggio, bug del docente, test Maven e logiche di compilazione ed esecuzione.

Fammi sapere se desideri approfondire specifici temi per l'esame, affrontare vecchi temi d'esame scritti/pratici, o dedicarti agli esercizi del tuo workspace (`esercizi-wally-25-26`)!

---
