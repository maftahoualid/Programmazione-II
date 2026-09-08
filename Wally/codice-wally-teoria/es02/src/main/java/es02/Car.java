package es02;

public class Car {
    // CAMPI DI CLASSE

    // campi privati
    private String mainColor, topColor, model;
    // costante final
    private static final String saluto = "Hello World";
    // campi pubblici (posso accedervi da altre classi)
    public boolean turnedOn;

    // METODI DI CLASSE

    boolean isTurnedOn() {
        return turnedOn;
    }

    // metodo statico (posso chiamarlo senza istanziare un oggetto, può chiamare
    // solo altri metodi statici)
    public static void hello() {
        System.out.println(saluto); // println metodo statico, saluto campo statico
        // paint("marrone"); // errore: chiamo un metodo non statico
    }

    // metodi di istanza
    // overloading dei metodi : stesso metodo, parametri diversi, comportnamento
    // diverso
    void paint(String newColor) {
        // uso this per riferirmi all'oggetto che ha fatto la chiamata al metodo
        this.mainColor = newColor;
        this.topColor = newColor;
    }

    void paint(String newMainColor, String newTopColor) {
        // da un metodo
        mainColor = newMainColor;
        topColor = newTopColor;
    }

    public void printColor() {
        System.out.printf("color: %s / %s", mainColor, topColor);
    }

    public void setModel(String model) {
        this.model = model; // uso di this obbligatorio per distinguere il parametro dal campo di classe
    }

}
