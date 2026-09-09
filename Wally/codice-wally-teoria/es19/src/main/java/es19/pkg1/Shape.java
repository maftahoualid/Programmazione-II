package es19.pkg1;

public abstract class Shape {

	private int color;
	
	public Shape() { };
	// metodo concreto
	public void setColor(int color) { this.color = color; }
	// metodo abstract
	public abstract void draw();
	
}
