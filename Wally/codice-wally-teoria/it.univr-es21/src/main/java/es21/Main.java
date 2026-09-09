package es21;

public class Main {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		// NestedClass nestedClass = new NestedClass(); // import es21.OuterClass.NestedClass;
		OuterClass.NestedClass nestedObj = new OuterClass.NestedClass();
		
	}
}
