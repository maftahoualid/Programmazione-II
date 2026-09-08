package es02;

public class MainCar {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = car1;
        Car car3 = null;
        // int i = null; // non posso assegnare null ai tipi primitivi, solo agli oggetti
        String modello = "Audi";

        System.out.println(modello); // viene implicitamente chiamato modello.toString()

        // assegnamento a variabile public
        car1.turnedOn = true;   
        // car1.mainColor = "green"; // errore: campo private non accessibile fuori dalla classe
        
        // chiamata a metodo di istanza
        car1.paint("yellow"); 
        // chiamata a metodo overloaded
        car2.paint("red", "blue");
        car1.printColor();
        car1.setModel("Audi");

        // chiamata a metodo statico
        Car.hello();

        System.out.println(car1); // Car@7ad041f3

        
        
    
    }
}
