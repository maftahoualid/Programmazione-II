package it.univr.figures;

public class Figure {
	private final Color color;

	public Figure(Color color) {
		this.color = color;
	}

	public double perimeter() {
		return 0.0;
	}

	public double area() {
		return 0.0;
	}

	public String toString() {
		return "area: " + area() + ", perimeter: " + perimeter() + ", color: " + color;
	}

	protected Color getColor() {
		return color;
	}
}
