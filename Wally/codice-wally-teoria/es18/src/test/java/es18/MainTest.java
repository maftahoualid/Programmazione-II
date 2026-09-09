package es18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * Test Slide 34: Subtype polymorphism
     * Un reference di tipo superclasse (Person) può puntare sia a un'istanza
     * della superclasse stessa che a una sua sottoclasse (Student).
     */
    @Test
    void testSubtypePolymorphismSlide34() {
        Person person;

        person = new Person("Paul");
        assertEquals("Paul", person.getName());
        assertEquals(Person.class, person.getClass());

        person = new Student("Sam", 123);
        assertEquals("Sam", person.getName());
        assertEquals(Student.class, person.getClass());
    }

    /**
     * Test Slide 35: Substitution principle (LSP)
     * Oggetti di tipo T possono essere sostituiti da oggetti del sottotipo S.
     */
    @Test
    void testSubstitutionPrincipleSlide35() {
        Person person = new Person("Paul");
        Student student = new Student("Sam", 123);

        person = student; // ok -- subtype substitution
        assertEquals("Sam", person.getName());
        assertTrue(person instanceof Student);
    }

    /**
     * Test Slide 36-37: Risoluzione sul tipo statico e downcast
     * Il tipo statico determina i metodi visibili (getName()).
     * Con downcast esplicito è possibile accedere ai metodi del sottotipo (getMatricola()).
     */
    @Test
    void testStaticTypeAndDowncastingSlide36() {
        Person ref = new Student("Sam", 123);

        // Chiamata lecita su tipo statico Person:
        assertEquals("Sam", ref.getName());

        // Con downcast si accede ai metodi specifici di Student:
        assertTrue(ref instanceof Student);
        Student s = (Student) ref;
        assertEquals(123, s.getMatricola());
    }

    /**
     * Test esecuzione del metodo main senza eccezioni.
     */
    @Test
    void testMainExecution() {
        Assertions.assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
