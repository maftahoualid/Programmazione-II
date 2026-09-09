package es17;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Paul");
        Student student = new Student("Sam", 123);

        System.out.println("Person name: " + person.getName());
        System.out.println("Student name: " + student.getName());
    }

}
