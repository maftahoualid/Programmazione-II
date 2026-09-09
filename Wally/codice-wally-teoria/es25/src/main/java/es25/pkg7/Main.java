package es25.pkg7;

import java.util.ArrayList;
import java.util.List;

/**
 * Esercizio 25 - Package 7: Principio PECS
 *
 * PECS è l'acronimo introdotto da Joshua Bloch (Effective Java):
 * "Producer Extends, Consumer Super"
 *
 * - PRODUCER EXTENDS (<? extends T>):
 *   Se una collezione "produce" dati per il nostro metodo (cioè dobbiamo LEGGERE elementi da essa),
 *   usiamo <? extends T>. Il compilatore garantisce che ogni elemento estratto è di tipo T (o sottotipo).
 *   NON è consentito aggiungere elementi alla collezione (tranne null).
 *
 * - CONSUMER SUPER (<? super T>):
 *   Se una collezione "consuma" dati forniti dal nostro metodo (cioè dobbiamo SCRIVERE elementi in essa),
 *   usiamo <? super T>. Il compilatore garantisce che possiamo aggiungere in sicurezza elementi di tipo T
 *   (o di sue sottoclassi). In lettura, la collezione restituisce soltanto Object.
 */
public class Main {

    /**
     * 1. ESEMPIO PRODUCER CON 'extends':
     *
     * Questo metodo riceve una lista che "produce" studenti da stampare.
     * Accetta List<Studente>, List<StudenteLavoratore>, o qualsiasi sottoclasse di Studente.
     */
    public static void stampaStudenti(List<? extends Studente> producer) {
        System.out.println("Lettura dal Producer (? extends Studente):");
        for (Studente s : producer) {
            // Possiamo leggere in sicurezza: ogni elemento è almeno uno Studente!
            System.out.println("  - " + s.getNome() + " (matricola: " + s.getMatricola() + ")");
        }

        // NON POSSIAMO SCRIVERE NEL PRODUCER:
        // producer.add(new Studente("Nuovo", 999));
        // ❌ COMPILE-TIME ERROR: capture# of ? extends Studente non può accettare l'inserimento di oggetti!
    }

    /**
     * 2. ESEMPIO CONSUMER CON 'super':
     *
     * Questo metodo riceve una lista che "consuma" studenti (vi scrive dentro).
     * Accetta List<Studente>, List<Persona>, o List<Object>.
     */
    public static void aggiungiStudentiDiDefault(List<? super Studente> consumer) {
        System.out.println("Scrittura nel Consumer (? super Studente):");
        // Possiamo scrivere in sicurezza: inseriamo Studente o sue sottoclassi (StudenteLavoratore)
        consumer.add(new Studente("Alice", 101));
        consumer.add(new StudenteLavoratore("Bob", 102, "Google"));
        System.out.println("  - Aggiunti con successo Alice e Bob!");

        // NON POSSIAMO LEGGERE TIPI SPECIFICI DAL CONSUMER:
        // Studente s = consumer.get(0);
        // ❌ COMPILE-TIME ERROR: il compilatore sa solo che è una superclasse di Studente,
        // quindi in lettura il tipo garantito è solo 'Object'.
        Object obj = consumer.get(0); // OK, ma solo come Object
    }

    /**
     * 3. PECS COMPLETO: METODO DI COPIA (ispirato a Collections.copy)
     *
     * - 'src' è il PRODUCER da cui leggiamo: usiamo <? extends T>
     * - 'dest' è il CONSUMER in cui scriviamo: usiamo <? super T>
     */
    public static <T> void copia(List<? super T> dest, List<? extends T> src) {
        for (T elemento : src) {
            dest.add(elemento); // 'src' produce l'elemento, 'dest' lo consuma
        }
    }

    public static void main(String[] args) {
        System.out.println("=== es25.pkg7: Principio PECS (Producer Extends, Consumer Super) ===");

        // -------------------------------------------------------------------------
        // 1. Dimostrazione Producer Extends
        // -------------------------------------------------------------------------
        System.out.println("\n--- 1. Dimostrazione Producer Extends ---");
        List<StudenteLavoratore> listaLavoratori = new ArrayList<>();
        listaLavoratori.add(new StudenteLavoratore("Mario", 12345, "Meta"));
        listaLavoratori.add(new StudenteLavoratore("Paolo", 67890, "Amazon"));

        // List<StudenteLavoratore> è un sottotipo compatibile con List<? extends Studente>
        stampaStudenti(listaLavoratori);

        // -------------------------------------------------------------------------
        // 2. Dimostrazione Consumer Super
        // -------------------------------------------------------------------------
        System.out.println("\n--- 2. Dimostrazione Consumer Super ---");
        List<Persona> listaPersone = new ArrayList<>();
        listaPersone.add(new Persona("Giovanni (docente)"));

        // List<Persona> è un supertipo compatibile con List<? super Studente>
        aggiungiStudentiDiDefault(listaPersone);
        System.out.println("Contenuto di listaPersone dopo l'aggiunta:");
        for (Persona p : listaPersone) {
            System.out.println("  - " + p);
        }

        // -------------------------------------------------------------------------
        // 3. Dimostrazione PECS Completo: copia da List<StudenteLavoratore> a List<Persona>
        // -------------------------------------------------------------------------
        System.out.println("\n--- 3. PECS Completo: copia(dest, src) ---");
        List<Persona> archivioGenerale = new ArrayList<>();
        archivioGenerale.add(new Persona("Rettore"));

        System.out.println("Prima della copia, archivioGenerale contiene:");
        for (Persona p : archivioGenerale) {
            System.out.println("  - " + p);
        }

        // Copiamo dalla lista di StudenteLavoratore (Producer) alla lista di Persona (Consumer)
        // Il compilatore deduce T = Studente (o Persona) e valida sia il Producer che il Consumer!
        copia(archivioGenerale, listaLavoratori);

        System.out.println("Dopo la copia da listaLavoratori (Producer) ad archivioGenerale (Consumer):");
        for (Persona p : archivioGenerale) {
            System.out.println("  - " + p);
        }
    }
}
