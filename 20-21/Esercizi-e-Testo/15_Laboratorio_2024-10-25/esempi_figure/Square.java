package it.univr.figures;

public class Square extends Rectangle {

	public Square(double side, Color color) {
		super(side, side, color);
	}

	public String toString() {
		return "Square, a " + super.toString();
	}
}
