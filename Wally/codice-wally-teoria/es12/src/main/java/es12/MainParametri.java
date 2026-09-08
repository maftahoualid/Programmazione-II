package es12;

public class MainParametri {

    public static Person shorten(Person p) {
        p.name = p.name.substring(0, 3); // sovrascrivo il campo name dell'oggetto passato con la sottostringa
        return new Person(p.name);
        // ritorna persona con nome troncato alle prime 3 lettere
    }

    public static Person shortenCorretto(Person p) {
        p = new Person(p.name);
        p.name = p.name.substring(0, 3); // sovrascrivo il campo name dell'oggetto passato con la sottostringa
        return p;
        // ritorna persona con nome troncato alle prime 3 lettere
    }

    public static void main(String[] args) {
        Person p1 = new Person("Marco"); // creo persona nome:"Marco"
        Person p2 = MainParametri.shorten(p1); // creo persona con nome "Mar"

        System.out.println(p1.getName()); // anche "Marco" viene cambiato in "Mar"
        System.out.println(p2.getName()); // "Mar"

        p1 = p2 = MainParametri.shortenCorretto(p1); // creo persona con nome "Mar"

        System.out.println(p1.getName()); // "Marco"
        System.out.println(p2.getName()); // "Mar"

    }
}
