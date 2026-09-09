package es20.pkg2;

import java.util.Iterator;

public class ClassRoom implements Iterable {
	private Student[] students;
	
	public ClassRoom(Student[] array) {
		this.students = array;
	}

	@Override
	public Iterator iterator() { // used in enhanced for loops
		// Ritorna una nuova classe anonima Iterator
		return new Iterator() {
			private int next = 0;
			// hasNext a true finchè non finisce l'array
			@Override public boolean hasNext() { return next < students.length; }
			// next restituisce un nuovo studente uguale al next-esimo studente dell'array
			// quindi ritorna uno per uno tutti gli elementi di students
			@Override public Object next() { return new Student(students[next++]); }
		};
	}
}
