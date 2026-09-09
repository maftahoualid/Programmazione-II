package es20.pkg1;

import java.util.function.UnaryOperator;

public class MyInterfaceImplementation implements MyInterface {
	// per essere concreta deve implementare tutti i metodi dell'interfaccia
	// altrimenti deve essere etichettata a sua volta abstract
	
	@Override
	public void metodo(String param) { // qui public devo scriverlo
		System.out.printf("Hello %s\n",param);
	}

	// può contenere anche altri metodi
	protected void print() { System.out.println("Altri Metodi"); }
	
}
