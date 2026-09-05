package it.univr;

import it.univr.figures.Circle;
import it.univr.figures.Color;
import it.univr.figures.Crown;
import it.univr.figures.Figure;
import it.univr.figures.GreenDot;
import it.univr.figures.Square;

public class MainFigures {

	public static void main(String[] args) {
		//Figure f1 = new Figure(Color.RED);
		Figure f2 = new Square(12.3, Color.BLACK);
		Figure f3 = new Circle(3.45, Color.YELLOW);
		Figure f4 = new GreenDot();
		Figure f5 = new Crown(8.34, 5.06, Color.RED);
		//System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(f5);
	}
}