package es25.pkg4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Esempio con 'super' e 1 tipo: Lower-Bounded Wildcard (Pair<? super Student>)
     *
     * REGOLA FONDAMENTALE DI JAVA:
     * La parola chiave 'super' NON è permessa nella dichiarazione di una classe generica
     * (es. 'class Pair<T super Student>' è un ERRORE DI SINTASSI in Java!).
     * 'super' è invece utilizzata nelle WILDCARDS: <? super Tipo> (Slide 22-23 T15).
     *
     * Principio PECS (Producer Extends, Consumer Super):
     * Quando la struttura generica funge da CONSUMER (dobbiamo scrivervi dentro un oggetto di tipo Student),
     * si usa <? super Student>.
     *
     * In questo modo possiamo passare un Pair<Student>, Pair<Person> oppure Pair<Object>!
     */
    public static void setFirstStudent(Pair<? super Student> pair, Student student) {
        // Scrittura consentita: sappiamo che il Pair conterrà un tipo che è Student o un suo supertipo,
        // quindi assegnare uno Student è sempre type-safe!
        pair.setFirst(student);
    }

    /**
     * Esempio analogo con List<? super Student> (Consumer Super):
     * Possiamo aggiungere uno Student sia a una List<Student>, sia a una List<Person>, sia a una List<Object>.
     */
    public static void addStudent(List<? super Student> list, Student student) {
        list.add(student); // OK!
    }

    public static void main(String[] args) {
        System.out.println("=== es25.pkg4: Lower-Bounded Wildcard con super 1 tipo (PECS) ===");

        Student s = new Student("Sam", 123);

        // 1. Pair<Student> (stesso tipo)
        Pair<Student> pairStudent = new Pair<>(new Student("Paul", 456), new Student("Anna", 789));
        setFirstStudent(pairStudent, s);
        System.out.println("Dopo setFirstStudent su Pair<Student>: " + pairStudent);

        // 2. Pair<Person> (supertipo di Student)
        // Grazie a <? super Student>, possiamo passare Pair<Person>!

        // (Senza wildcard, Java vieta questo passaggio per via dell'invarianza dei Generics: Pair<Person> != Pair<Student>)
        // Student s1 = new Student("Sam",123) ;
        // Person p = s1 ; // ok
        // Pair<Student> pairS = new Pair<>( s, new Student(" Paul ",456) ) ;
        // Pair <Person> pairP = pairS ; // compiler error

        Pair<Person> pairPerson = new Pair<>(new Person("Mario"), new Person("Luigi"));
        setFirstStudent(pairPerson, s);
        System.out.println("Dopo setFirstStudent su Pair<Person>: " + pairPerson);

        // CON GLI ARRAY INVECE : students[] sottotipo di persons[]
        Student[] arrS = { new Student("Sam", 123) }; // ref Student[] -> obj Student[]
        Person[] arrP = arrS; // COMPILA PERFETTAMENTE! // ref Person[] -> obj Student[]
        // arrP[0] = new Professor("Mario", 999); // A runtime genera: java.lang.ArrayStoreExceptio

        // 3. Pair<Object> (supertipo universale)
        Pair<Object> pairObject = new Pair<>("Generico1", "Generico2");
        setFirstStudent(pairObject, s);
        System.out.println("Dopo setFirstStudent su Pair<Object>: " + pairObject);

        // 4. Test con List<? super Student>
        List<Person> personList = new ArrayList<>();
        addStudent(personList, new Student("Bob", 999));
        System.out.println("Lista di Person con Student aggiunto via super: " + personList);
    }
}
