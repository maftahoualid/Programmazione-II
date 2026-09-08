package es05;

public class Car {

    private String color;

    // void Car() {} // NON è un costruttore valido : non deve avere tipo di ritorno

    // overloading di costruttori : posso creare oggetti in modi diversi
    Car() {} // costruttore di default, senza parametri
    Car(String s) { paint(s); } // costruttore parametrizzato : inizializza color
    Car(Car c) { this(c.color); } // costruttore di copia : posso clonare un oggetto



    void paint(String newColor) {
        this.color = newColor;
    } 

}
