package it.univr;

public class MainInteger {

	public static void main(String[] args) {
		// costruttore: deprecato
		Integer i1 = new Integer(42);
		Integer i2 = new Integer(42);
		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1.compareTo(i2): " + (i1.compareTo(i2)));
		
		// boxing
		Integer i3 = Integer.valueOf(42); // usa una cache
		Integer i4 = Integer.valueOf(42); // usa una cache
		System.out.println("i3 == i4: " + (i3 == i4));
		
		// auto-boxing
		Integer i5 = 42; // abbreviazione per Integer.valueOf(42)
		Integer i6 = 42; // abbreviazione per Integer.valueOf(42)
		System.out.println("i5 == i6: " + (i5 == i6));

		// unboxing
		int ii1 = i5.intValue();
		System.out.println("ii1 = " + ii1);
		
		// auto-unboxing
		int ii2 = i5; // abbreviazione di i5.intValue();
		System.out.println("ii2 = " + ii2);
	}

}
