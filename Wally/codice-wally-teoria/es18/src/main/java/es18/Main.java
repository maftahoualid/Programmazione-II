package es18;

public class Main {
    public static void main(String[] args) {

        Person person;        
        person = new Person("Paul"); // OK: obj Person to ref Person
        person = new Student("Sam", 123); // OK: obj Student to ref Person

        Person p = new Person("Paul"); 
        Student student = new Student("Sam", 123);
        p = student; // OK: obj Student to ref Person
        
        // Student s = new Person("Sam"); // ERROR: obj Person to ref Student
        // student = p; // ERROR : obj Person to ref Student
        // se potessi, poi potrei chiamare student.getMatricola() e avrei runtime error
        
        Person ref = new Student("Sam", 123); // obj Student to ref Person
        System.out.println(ref.getName()); // obj Student to ref Person (Person method)
        // in questo caso ref punta a obj Student, quindi getName userà l'implementazione di Student

        // System.out.println(ref.getMatricola()); // obj Student to ref Person (Student method)
        // COMPILE ERROR : chiamo metodo Student su puntatore Person a oggetto student
        
        // SE SONO SICURO CHE ref punti a obj Student posso fare il Downcast esplicito
        System.out.println(((Student) ref).getMatricola());
        // Se non è così: Runtime Error (SEMPRE MEGLIO CONTROLLARE)
        
        // p = new Person("Marco");
        // System.out.println( ((Student) p).getMatricola() ); // RUNTIME ERROR
        // System.out.println( ((String) p).getMatricola() ); // COMPILE TIME ERROR
        // System.out.println( p.getMatricola ); // COMPILE TIME ERROR
        
        // Downcasting con check instanceof
        if (ref instanceof Student) {
        	// System.out.println(ref.getClass()); // class es18.Student
        	// System.out.println(ref.getClass().getSimpleName()); // Student
            Student sDowncast = (Student) ref; // Downcast esplicito
            System.out.println(sDowncast.getMatricola()); // obj Student to ref Student (Student method) 
        }
        
        Person[] persone = {
        		new Person("Mario"),
        		new Person("Luigi"),
        		new Student("Anna", 321) // Upcasting implicito da Student a Person
        		};
        for (Person persona : persone) { System.out.println(persona.toString()); }
        // Student s1 = (Student) persone[0]; // ERRORE : ClassCastException
    
    }
    
    
}