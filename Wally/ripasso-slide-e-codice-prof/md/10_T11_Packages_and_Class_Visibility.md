# 📌 Blocco 10: Lezione 11 / Slide T11 — *Packages and Class Visibility* & Il Progetto `MavenDate` (v2 con Ereditarietà e `equals`)

In questo blocco analizziamo la modularità avanzata offerta dai package, le regole di risoluzione dei nomi e i livelli di visibilità dei membri ([T11 - Packages and Class Visibility.pdf](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Slides-20260902/T11%20-%20Packages%20and%20Class%20Visibility.pdf)).
Sul piano pratico, in [`Lezione11/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate) assistiamo a una grande svolta architetturale:
1. Nascono le sottoclassi specializzate **[`ItalianDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/ItalianDate.java)** e **[`AmericanDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/AmericanDate.java)** tramite estensione (`extends Date`).
2. Viene introdotto il modificatore **`protected`**.
3. Viene implementato l'algoritmo canonico per l'overriding del metodo **`equals(Object)`**.
4. Viene risolto il bug storico dei getter `getMonth()` e `getYear()`.

---

### 1. 📖 Concetti Teorici dalle Slide (Slide T11)

#### A. Modularità, Gerarchia e Convenzioni dei Package (Slide 1–11)
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
  - ⚠️ **Regola d'esame**: la direttiva `import pkg.*;` importa solo le classi direttamente contenute in `pkg`. **Non importa le classi contenute nei suoi sotto-package** (per importare `java.awt.event` è obbligatorio scrivere `import java.awt.event.*;`).
- **Il Default Package (Unnamed Package)**:
  - Se un file `.java` omette la dichiarazione `package`, la classe appartiene al package predefinito senza nome.
  - **Limitazione critica**: Le classi nel default package **non possono essere importate né utilizzate** da classi situate in package con nome. Nel software professionale e agli esami il suo uso è fortemente scoraggiato.
- **Compilazione e Packaging con Strumenti Standard e Maven**:
  - `javac -d bin/ src/pkg/MyClass.java`: il flag `-d` crea automaticamente l'albero delle sottocartelle nella directory di destinazione `bin/`.
  - Con Maven: il layout `src/main/java` e `src/test/java` unito al `pom.xml` automatizza compilazione, test surefire e packaging in Fat JAR.

---

#### B. Visibilità di Classe e Matrice di Accesso dei Membri (Slide 12–19)
- **Visibilità a Livello di Classe (Top-Level Classes)**:
  - `public class Clazz`: accessibile e istanziabile da qualsiasi package del Classpath.
  - `class Clazz` (*Package-Private* / default): visibile e utilizzabile **esclusivamente all'interno dello stesso package**. Non può essere usata all'esterno, anche se i suoi metodi interni sono dichiarati `public`.
  - *Nota*: le classi di primo livello non possono essere dichiarate `private` né `protected` (questi modificatori sono ammessi solo per classi annidate/interne).
- **La Matrice dei Modificatori di Accesso (Fields e Methods)**:

| Modificatore | Stessa Classe | Stesso Package | Sottoclasse (Altro Package) | Mondo Esterno |
| :--- | :---: | :---: | :---: | :---: |
| **`private`** | ✅ | ❌ | ❌ | ❌ |
| **Default** *(package-private)* | ✅ | ✅ | ❌ | ❌ |
| **`protected`** | ✅ | ✅ | ✅ | ❌ |
| **`public`** | ✅ | ✅ | ✅ | ✅ |

- **Risoluzione dei Nomi**:
  - Se una classe importa due tipi omonimi o usa una classe locale avente lo stesso nome di una classe importata, per disambiguare è obbligatorio usare il **Fully Qualified Name (FQN)**:
    `it.oop.ui.Date d = new it.oop.ui.Date(12345);`

---

### 2. 💻 Evoluzione del Codice: [`Lezione11/MavenDate`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate)

In `Lezione11`, il codice di `MavenDate` compie un balzo in avanti con l'introduzione di gerarchie di classi e l'overriding:

#### 1. Generalizzazione in [`Date.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/Date.java)
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

#### 🔍 I 5 Passi Fondamentali dell'Algoritmo `equals(Object)`:
1. `if (other == null) return false;`: garantisce che `d.equals(null)` ritorni `false` senza lanciare `NullPointerException`.
2. `if (this == other) return true;`: ottimizzazione immediata (riflessività). Se sono lo stesso oggetto nello Heap, sono identici.
3. `if (!(other instanceof Date)) return false;`: verifica se l'oggetto passato è compatibile con la gerarchia `Date`.
4. `Date otherAsDate = (Date) other;`: downcast necessario perché la firma di `equals` accetta un generico `Object`.
5. Confronto logico dei campi che definiscono lo stato: `day`, `month`, `year`.

---

#### 2. Le Nuove Sottoclassi: [`ItalianDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/ItalianDate.java) e [`AmericanDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/core/AmericanDate.java)

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

#### 3. Polimorfismo, Upcasting e Downcasting in [`MainDate.java`](file:///home/wally/Documenti/GitHub/Programmazione-II/25-26/Teoria-e-Esercitazioni/Codice-20260902/Lezione11/MavenDate/src/main/java/it/oop/ui/MainDate.java)

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

### 3. 🔄 Corrispondenza con i Tuoi Moduli Workspace

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
