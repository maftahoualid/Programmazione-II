package es22.pkg1;

public class MainAnonClass {
    public static void main(String[] args) {
        // Istanza standard di Person
        Person standardPerson = new Person("Mario");
        System.out.println("Standard Person: " + standardPerson.toString());

        // Creiamo un'istanza di una classe anonima che estende Person, assegnandola alla variabile 'sam'
        Person sam = new Person("Sam") {
            @Override
            public String toString() { 
                return "It's Sam!"; 
            }
        }; // punto e virgola finale necessario

        System.out.println(sam.toString());

        // Verifiche didattiche
        System.out.println("sam.getName(): " + sam.getName());
        System.out.println("Classe effettiva a runtime: " + sam.getClass().getName());
        System.out.println("sam è istanza di Person? " + (sam instanceof Person));
    }
}
