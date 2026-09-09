package es16;

import es16.pkg.Student;

public class MainPerson {
    public static void main(String[] args) {
        Person p1 = new Person("Wally");
        Student s1 = new Student("John", 123);
        Student s2 = new Student("John", 123);

        p1.printPerson();

        System.out.println("p1 instanceof Person: " + (p1 instanceof Person)); // true
        System.out.println("p1 instanceof Student: " + (p1 instanceof Student)); // false
        System.out.println("s1 instanceof Person: " + (s1 instanceof Person)); // true
        System.out.println("s1 instanceof Student: " + (s1 instanceof Student)); // true
        System.out.println("s1 instanceof Object: " + (s1 instanceof Object)); // sempre true

        System.out.println(s1.equals(s2)); // override : true
        System.out.println(s1 == s2); // false : i due oggetti sono diversi

    }
}
