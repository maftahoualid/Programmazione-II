package es20.pkg1;

public class Main {
	public static void main(String[] args) {
		MyInterfaceImplementation m = new MyInterfaceImplementation(); // MyClass -> MyClass
		System.out.println(MyInterfaceImplementation.intero); // implicitamente static e public
		// m.intero = 4; // errore: implicitamente final
		m.metodo("Wally");
		
		// posso usare nome interfaccia come tipo per oggetti che la implementano
		MyInterface w = new MyInterfaceImplementation(); // MyInterface -> MyClass
		w.metodo("Wally"); // ok
		// w.print(); // MyInterface -> MyClass.print()
		((MyInterfaceImplementation) w).print(); // ok
		
	}
}
