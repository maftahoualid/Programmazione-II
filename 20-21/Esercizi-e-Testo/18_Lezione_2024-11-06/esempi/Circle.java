package it.univr.figures;

public class Circle extends Figure {
	private final double radius;

	public Circle(double radius, Color color) {
		super(color);
		
		this.radius = radius;
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double perimeter() {
		return 2 * radius * Math.PI;
	}

	public boolean isConvex() {
		return true;
	}

	public String toString() {
		return "Circle of " + super.toString();
	}
}
