package es24.pkg2;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ClassRoom con Generics (Slide T15 slide 13).
 * Implementa Iterable<Student>.
 * NOTA DIDATTICA SULLE LAMBDA:
 * L'interfaccia java.util.Iterator<E> dichiara 2 metodi astratti (hasNext() e next()),
 * pertanto NON è una SAM (Single Abstract Method) e non può essere implementata
 * direttamente da una singola lambda senza usare Stream API.
 * Per evitare la Inner Class nominata (CRIterator), usiamo:
 * 1. Una classe anonima nel metodo iterator();
 * 2. Una Lambda classica (param -> corpo) nel metodo forEach() tramite Consumer<Student>.
 */
public class ClassRoom implements Iterable<Student> {
    private final Student[] students;

    public ClassRoom(Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < students.length;
            }

            @Override
            public Student next() {
                return new Student(students[next++]);
            }
        };
    }
}
