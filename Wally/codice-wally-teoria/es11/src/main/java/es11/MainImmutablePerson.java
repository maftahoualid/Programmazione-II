package es11;

import es06.Person; // classe Person normale

public class MainImmutablePerson {
    public static void main(String[] args) {

        String name = "Luca"; // oggetto string immutabile
        // non posso modificare la stringa, ma posso modificare a cosa punta "name"

        Person p1 = new Person("nome1");
        p1.indirizzo = "Via Milano 30";
        Person p2 = p1; // p2 punta allo stesso oggetto creato e puntato da p1
        p2.indirizzo = "Via Roma 10"; // se modifico un campo di p2, l'oggetto puntato da entrambi cambia
        System.out.println(p1.indirizzo); // "Via Roma 10"

        final Person luca = new Person("Luca"); // puntatore final
        // luca = new es06.Person("Anna"); // non posso modificare il puntatore
        luca.indirizzo = "Corso Mazzini 1"; // ma posso modificare l'oggetto puntato

        ImmutablePerson ip1 = new ImmutablePerson("name1");
        ImmutablePerson ip2 = ip1;
        // ip2.indirizzo = "Via Verona 14"; // non posso modificare
        // il campo final di ip2 che è lo stesso inizializzato da ip1

        // campi name e age in ImmutablePerson sono private e final
        // posso solo inizializzarli alla creazione
        final ImmutablePerson sam = new ImmutablePerson("Sam");
        // non posso modificare il puntatore nè lo stato interno dell'oggetto
        System.out.println("sam: " + sam);
        final ImmutablePerson marco = new ImmutablePerson("Marco", 25);
        System.out.println("marco: " + marco);

    }
}
