package es06;

public class Person {
    final String ID = "X"; // la visibilità di default è package: visibile all'esterno della classe
    private String name; // visibilità private : visibile solo all'interno della classe
    private int age = -1;
    public String indirizzo;

    public Person(String name) {
        setName(name);
    }

    // metodi getter

    // di default tutti i metodi sono public
    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    // metodi setter

    private void setName(String name) {
        this.name = name;
    };

    void setAge(int age) {
        if (age < 0 || age > 120)
            this.age = age;
        else
            System.out.println("Invalid age");
    }

    // check sull'età ma non blocca l'assegnamento di età non valide
    void setAge() {
        this.age = 18;
        /* default */ } // overloading dei setter

}
