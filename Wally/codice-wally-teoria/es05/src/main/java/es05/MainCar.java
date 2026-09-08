package es05;

public class MainCar {
    public static void main(String[] args) {
        Car c1 = new Car(); // usa il costruttore di default
        Car c2 = new Car("Red"); // usa il costruttore parametrizzato
        Car c3 = new Car(c2); // usa il costruttore di copia

    }
}