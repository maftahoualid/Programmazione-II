package es16;

public class Person /* extends Object */ {
    final String ID = "X"; // la visibilità di default è package: visibile all'interno del package
    String name; // visibilità package-private : visibile solo all'interno del package
    int age = -1;
    public String indirizzo = "Default";

    public Person() { // costruttore default
        // viene creato in automatico se non dichiaro un costruttore
        // devo dichiararlo io se ho già dichiarato un costruttore diverso
    }

    public Person(String name) {
        setName(name);
    }
    // slide 28/51

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

    void printPerson() {
        System.out.println(this.toString()); // "Sam"
        System.out.println(super.toString()); // "es16.Person@hash"
    }

    // Override metodi Object
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        // sempre prima verifica se i due oggetti sono lo stesso
        if (obj == this)
            return true;
        // se l'oggetto passato è nullo o di classe diversa non è uguale
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        // cast esplicito a tipo Person
        Person person = (Person) obj;
        // confronto dei campi: == per i tipi primitivi e equals() per gli String
        return age == person.age && name.equals(person.name);
    }

    /*
     * 1. x.equals(x) => true
     * 2. x.equals(null) => false
     * 3. x.equals(y) == y.equals(x)
     * 4. if (x.equals(y) && y.equals(z)) => x.equals(z)
     */

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age);
    }

}
