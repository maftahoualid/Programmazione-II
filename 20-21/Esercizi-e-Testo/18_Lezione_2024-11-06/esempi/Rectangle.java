package it.univr.figures;

public class Rectangle extends Figure {
	private final double base;
	private final double height;

	public Rectangle(double base, double height, Color color) {
		super(color);

		this.base = base;
		this.height = height;
	}

	public double area() {
		return base * height;
	}

	public double perimeter() {
		return 2 * (base + height);
	}

	public boolean isConvex() {
		return true;
	}

	public String toString() {
		return "Rectangle of " + super.toString();
	}
}
