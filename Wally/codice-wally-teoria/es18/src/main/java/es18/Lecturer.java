package es18;

import java.util.Objects;

public class Lecturer extends Person {
	private String course;

	public Lecturer(String name, String course) {
		super(name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return String.format("Lecturer [course=%s, name=%s]", course, name);
	}

}
