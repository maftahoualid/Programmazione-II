package es06;

public class MainPerson {
    public static void main(String[] args) {
        Person p = new Person("Wally");
        p.setAge(50);
        p.setAge(-10);
        // assert (p.getAge() != -10) : "Invalid date is set" ; // java -ea

        // p.ID = "ID123"; // errore: campo final
        // p.age = 50 ; // errore: campo privato
        System.out.println(p.getAge()); // -10
        p.setAge(); // 18

    }
}
