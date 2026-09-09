package es21;

public class OuterClass {

	private static int var1 = 5;
	private int var4 = 10;
	
	static class NestedClass { 
		// accede solo a campi statici di Outer (anche se private)
		// non può accedere ai campi di istanza non statici
		// può essere istanziata indipendentemente dalla classe Outer
		
		public int var2 = var1; // assegna campo statico private di Outer a var2
		private static int var3;
		public void instancePrint(String s) { System.out.println("Hello " + s); }
		private static void staticPrint(String s) { System.out.println("Hello " + s); }
	}

	class InnerClass { // nessun modificatore di accesso
		// accede a campi di istanza e statici di Outer (anche se private)
		// non può essere istanziata senza un oggetto di Outer
		
		int inc() { return var4 + 1; }
	}
	
	
	public void name1() {
		NestedClass nestedObj = new NestedClass();
		var1 = nestedObj.var2; // accede a campo istanza private di Nested
		var1 = NestedClass.var3; // legge campo statico private di Nested
	}	

}

