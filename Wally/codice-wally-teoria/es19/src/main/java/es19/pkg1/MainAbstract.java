package es19.pkg1;

public class MainAbstract {

	public static void main(String[] args) {
		// Shape shape = new Shape(); 
		// errore: classe astratta non posso istanziare un oggetto

		Shape shape = new Circle(); // shape -> circle
		Circle circle = new Circle(); // circle -> circle
		shape.draw(); // shape -> circle.draw()
		circle.draw(); // circle -> circle.draw()
	}

}
