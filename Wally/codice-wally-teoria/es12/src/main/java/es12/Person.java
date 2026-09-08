package es12;

public class Person {
    final String ID = "X"; // la visibilità di default è package: visibile all'esterno della classe
    String name; // visibilità private : visibile solo all'interno della classe
    int age = -1;
    public String indirizzo = "Default";

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

    public void setName(String name) {
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
